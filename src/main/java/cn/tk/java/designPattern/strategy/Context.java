package cn.tk.java.designPattern.strategy;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/5/18
 * Description: 环境角色
 * 策略模式： 抽象流程，封装策略（策略用来在流程中解决具体问题，不同的策略解决不同的问题，不同情况下选用不同的策略）
 */
@SuppressWarnings("Duplicates")
public class Context {

    /**
     * Description: 环境角色聚合策略模式
     * algorithm 抽象流程，封装策略
     */
    private Strategy strategy;

    public Context(){

    }

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Description: 抽象流程，可以在策略执行的前后引入监控报警，方便同一控制
     */
    public void algorithm(){
        long startTime = System.currentTimeMillis();

        // 使用策略解决流程问题
        strategy.doBusiness();

        long endTime = System.currentTimeMillis();
        long elapseTime = (endTime - startTime) / 1000;
        if (elapseTime > 2)
            System.out.println("超时！");
        System.out.println("一切正常！");
    }

    public void algorithm(StrategyEnum strategyEnum)
    {
        long startTime = System.currentTimeMillis();

        // 使用策略解决流程问题
        strategyEnum.doBusiness();

        long endTime = System.currentTimeMillis();
        long elapseTime = (endTime - startTime) / 1000;
        if (elapseTime > 2)
            System.out.println("超时！");
        System.out.println("一切正常！");
    }

}
