package cn.tk.java.algorithm.limiter.tokenBucket;

import static java.util.concurrent.TimeUnit.MICROSECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * 限流器
 * 令牌的生成：初始化的时候生成一批，领取的时候再生成一批，最多生成 maxTokens = Integer.MAX_VALUE 个
 * 生成的平均速率是 rate，而不是按照 rate 的速率匀速生成。
 */
public abstract class RateLimiter {

    // 令牌桶内：最大令牌数
    protected double maxTokens;

    // 当前可领取令牌数
    protected double availableTokens;

    // 开始时间
    protected long startNanos;

    // 下一个令牌生成时间
    protected long nextGenTokenMicros;

    // 令牌生成时间间隔： stableIntervalTokenMicros = (1 / rate) * 1000 * 1000 微秒
    protected double stableIntervalTokenMicros;

    // 同步锁，保证速率一致
    protected final Object mutex = new Object();

    /**
     * 设置令牌生成速率
     * @param tokenPerSecond ：r/s 每秒生成令牌数
     */
    public void setRate(double tokenPerSecond){
        if (tokenPerSecond < 0 ){
            throw new IllegalArgumentException("tokenPerSecond must be positive.");
        }
        synchronized (mutex){
            doSetRate(tokenPerSecond);
        }
    }

    // 执行：设置令牌生成速率
    protected abstract void doSetRate(double tokenPerSecond);

    // 同步可用的令牌？
    public abstract void syncAvailableToken(long nowMicros);

    /**
     * 获取指定的令牌数
     * @param  requiredToken : 请求令牌数
     * @return  返回获取到的令牌数
     */
    public abstract double getToken(double requiredToken);

    public long duration(){
        return MICROSECONDS.convert(System.nanoTime() - startNanos,NANOSECONDS);
    }

    // 返回限流器构造器
    public static Builder builder(){
        return new Builder();
    }

    /**
     * 限流器构造器
     * 用内部类编写可以自定义生成的限流器：
     * 1. 令牌生成速率
     * 2. 限流器的类型
     */
    public static class Builder<T extends RateLimiter> {

        // r/s 令牌生成速率
        private double tokenPerSecond;

        // 限流器类型
        private RateLimiterType type;

        // 设置限流器类型
        public Builder withType(RateLimiterType type){
            this.type = type;
            return this;
        }

        // 设置令牌生成速率
        public Builder withTokenPerSecond(double tokenPerSecond){
            this.tokenPerSecond = tokenPerSecond;
            return this;
        }

        // 根据限流器类型构造指定限流器
        public T build(){
            switch (type){
                case TB:
                    return (T)buildSmoothTokenBucketLimiter();
                case LB:
                    return null;//TODO 编写一个漏桶限流器
                case FFTB:
                    return (T)buildFailFastTokenBucketLimiter();
                default:
                    return (T)buildSmoothTokenBucketLimiter();
            }
        }


        private SmoothTokenBucketLimiter buildSmoothTokenBucketLimiter(){
            SmoothTokenBucketLimiter limiter = new SmoothTokenBucketLimiter();
            limiter.startNanos = System.nanoTime();
            limiter.setRate(tokenPerSecond);
            return limiter;
        }

        private FailFastTokenBucketLimiter buildFailFastTokenBucketLimiter(){
            FailFastTokenBucketLimiter limiter = new FailFastTokenBucketLimiter();
            limiter.startNanos = System.nanoTime();
            limiter.setRate(tokenPerSecond);
            return limiter;
        }
    }

    /**
     * 限流器类型
     * TB：令牌桶
     * LB：漏桶
     * FFTB：快速失败的令牌桶（通过抛异常快速失败）
     */
    public static enum RateLimiterType {

        /**
         * token bucket
         */
        TB,


        /**
         * leaky bucket
         */
        LB,


        /**
         * 没有可用token 抛出异常的token bucket
         */
        FFTB;
    }


}
