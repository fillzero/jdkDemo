package cn.tk.java.algorithm.limiter.tokenBucket;


import static java.util.concurrent.TimeUnit.SECONDS;

/**
 *
 */
public abstract class AbstractTokenBucketLimiter extends RateLimiter {

    /**
     * 生成令牌：令牌桶大小为 Interger.MAX_VALUE
     * @param tokenPerSecond : 令牌生成速率，1 / rate ==> 每个令牌生成的时间间隔（用微秒表示，可以避免因为精度问题损失令牌）
     */
    @Override
    protected void doSetRate(double tokenPerSecond) {
        syncAvailableToken(duration());
        this.maxTokens = Integer.MAX_VALUE;
        this.stableIntervalTokenMicros = SECONDS.toMicros(1L) / tokenPerSecond;
    }

    /**
     * 生成令牌
     * @param nowMicros : 当前时间的微秒值
     */
    @Override
    public void syncAvailableToken(long nowMicros) {
        if (nowMicros > nextGenTokenMicros){
            double newTokens = (nowMicros - nextGenTokenMicros) / stableIntervalTokenMicros;
            availableTokens = Math.min(maxTokens, availableTokens + newTokens);//可用令牌数不能超过 maxTokens
            nextGenTokenMicros = nowMicros;
        }
    }
}
