package cn.tk.java.algorithm.limiter.tokenBucket;

public class TestRateLimiter {
    public static void main(String[] args) throws InterruptedException {
        double rate=1.0;
        RateLimiter limiter = RateLimiter.builder().
                withTokenPerSecond(rate).
                withType(RateLimiter.RateLimiterType.TB).
                build();
        Thread.sleep(5000);
        //      if  res>1.0
        //消耗一个令牌
        double res = limiter.getToken(1);
        System.out.println("可用令牌数" + limiter.availableTokens);
        if(res>0){
            //dosomething
            System.out.println("有令牌资源");
        }else{
            // 没有令牌  返回----
        }
    }
}
