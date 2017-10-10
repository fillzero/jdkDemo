package cn.tk.java.util;

import com.alibaba.fastjson.JSONObject;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/10/10
 * Description: 子方法里面传入一个 Long 类型，子方法里面的修改并不会主方法中的 Long 值
 */
public class LongForMethod {

    /**
     * Description: String 类型和包装类型作为参数传递的时候传入的都是引用，但是因为它们都是 final 类型的，
     * 所以子方法没有办法对其作出修改，只能新建一个副本完成运算赋值操作，所以原始值不会发生改变。
     */
    public static void main(String[] args) {
        Long value = 0L;
        String string = "mac";
        JSONObject data = new JSONObject();

        updateValue(value, string, data);//子方法里面修改主方法变量

        System.out.println("value in main method: " + value);
        System.out.println("string in main method: " + string);
        System.out.println("data in main method: " + data);
    }

    private static void updateValue(Long value, String string, JSONObject data) {
        value = 100L;
        System.out.println("value in sub method: " + value);

        string = "IPhone";
        System.out.println("string in sub method: " + string);

        data.put("name", "lijinlong");
        data.put("age", 18);
        System.out.println("data in sub method: " + data);
    }
}
