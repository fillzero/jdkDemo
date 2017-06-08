package cn.tk.java.algorithm.limiter.tokenBucket;

/**
 * 快速失败令牌桶限流器
 */
public class FailFastTokenBucketLimiter extends AbstractTokenBucketLimiter {

    /**
     * 令牌获取：加悲观锁，同一时刻只有一个线程可以获取令牌
     * @param  requiredToken 请求令牌数
     * @return               获取到的令牌数
     */
    @Override
    public double getToken(double requiredToken) {
        long nowMicros = duration();
        double tokenPermitted = 0;
        try{
            synchronized (mutex){
                syncAvailableToken(nowMicros);
                tokenPermitted = Math.min(requiredToken, availableTokens);
                double needNewToken = requiredToken - tokenPermitted;
                if (needNewToken > 0){
                    //令牌不够跑出异常，程序会被中断
                    throw new LimitedException("no token.needNewToken: " + needNewToken + ", tokenPermitted: " + tokenPermitted+", availableToken: " + availableTokens);
                }
                availableTokens -= tokenPermitted;
            }
        }catch (LimitedException e){
            e.printStackTrace();
        }
        return tokenPermitted;
    }
}
