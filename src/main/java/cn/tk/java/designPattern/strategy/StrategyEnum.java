package cn.tk.java.designPattern.strategy;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/10/24
 * Description: 策略枚举类，方便客户端使用
 */
public enum StrategyEnum {
    FIRST {
        @Override
        void doBusiness() {
            System.out.println("Do Business With FirstStrategy!");
        }
    },
    SECOND {
        @Override
        void doBusiness() {
            System.out.println("Do Business With SecondStrategy!");
        }
    };

    abstract void doBusiness();
}
