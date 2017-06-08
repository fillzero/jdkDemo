package cn.tk.java.algorithm.limiter.tokenBucket;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MICROSECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * 普通版令牌桶实现
 * 令牌没有了进入阻塞，而不是让程序直接崩溃。
 */
public class SmoothTokenBucketLimiter extends AbstractTokenBucketLimiter {

    /**
     * 领取令牌
     * 领取令牌之前都要先生成一批令牌，tokens = (now - old) / interval，令牌的生成并不是通过定时器不停的生成的，
     * 只是生成的平均速率为 rate 值，而不是按照 rate 值匀速的去生成。
     * @param  requiredToken [description]
     * @return               [description]
     */
    @Override
    public double getToken(double requiredToken) {
        long waitMicros;
        long sleepTime;
        long oldNextGenTokenMicros;
        long nowMicros = duration();
        synchronized (mutex){
            syncAvailableToken(nowMicros);
            oldNextGenTokenMicros = nextGenTokenMicros;
            double tokenPermitted = Math.min(requiredToken, availableTokens);
            double needNewToken = requiredToken - tokenPermitted;
            waitMicros = (long) (needNewToken * stableIntervalTokenMicros);
            nextGenTokenMicros =  nextGenTokenMicros + waitMicros;
            availableTokens -= tokenPermitted;
        }
        sleepTime = Math.max(oldNextGenTokenMicros - nowMicros, 0);
        uninterruptibleSleep(sleepTime,MICROSECONDS);
        return sleepTime;
    }


    private void uninterruptibleSleep(long sleepTime,TimeUnit unit){
        boolean interrupted = false;
        try {
            long remainingNanos = unit.toNanos(sleepTime);
            long end = System.nanoTime() + remainingNanos;
            while (true){
                try {
                    NANOSECONDS.sleep(remainingNanos);
                    return;
                } catch (InterruptedException e) {
                    interrupted = true;
                    remainingNanos = end - System.nanoTime();
                }
            }
        } finally {
            if (interrupted){
                Thread.currentThread().interrupt();
            }
        }
    }
}
