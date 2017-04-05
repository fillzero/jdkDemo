package cn.tk.java.lang.wait.restaurant;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/4
* @description: 
*
**/
public class Meal {
    private final int orderNum;//订单数

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "orderNum=" + orderNum +
                '}';
    }
}
