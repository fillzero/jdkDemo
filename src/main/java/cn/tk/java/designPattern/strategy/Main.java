package cn.tk.java.designPattern.strategy;

import org.junit.Test;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/5/18
 * Description: 策略模式： 抽象流程，封装策略（完美体现开闭原则，但是需要客户端了解熟悉不同的策略之间的区别，具体问题使用对应的策略）
 */
public class Main {
    private static Strategy secondStrategy = null;
    private static Strategy firstStrategy = null;
    static {
        secondStrategy = new SecondStrategy();
        firstStrategy = new FirstStrategy();
    }

    public static void main(String[] args) {
        Context firstContext = new Context(firstStrategy);
        firstContext.algorithm();
        Context secondContext = new Context(secondStrategy);
        secondContext.algorithm();
    }

    @Test
    public void testStrategyEnum()
    {
        Context context = new Context();
        context.algorithm(StrategyEnum.FIRST);
        context.algorithm(StrategyEnum.SECOND);
    }
}

