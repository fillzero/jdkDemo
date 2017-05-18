package cn.tk.java.designPattern.strategy;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/5/18
 * Description: 第二种具体策略角色, 封装策略
 */
public class SecondStrategy implements Strategy {

    @Override
    public void doBusiness() {
        System.out.println("Do Business With SecondStrategy!");
    }
}
