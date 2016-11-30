package cn.tk.java.reflect.proxy;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;

/*
* @date: 2016/11/30
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description:
* 
*/
public class FieldDemo {
    public static final String MOBILE = "13800000000";
    public static String EMAIL = "123456789@qq.com";

    public static void main(String[] args) throws IllegalAccessException {
        Field[] fields = FieldDemo.class.getFields();
        for (Field field : fields){
            System.out.println("\n*************** 可爱的分割线 ********************");
            System.out.println(field.getName());//获取域名
            System.out.println(field.get(field.getName())); //根据域名获取域的取值

            if ("EMAIL".equals(field.getName()))
                field.set(field.getName(), "13900000000");//设置域的取值: 注意 final 变量不可以设置
            System.out.println(field.get(field.getName()));
        }
    }
}
