package cn.tk.java.designPattern.factory;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/12/15
 * Description:
 */
public class AnimalFactory {
    public static Animal eat(String type)
    {
        switch (type) {
            case "bird":
                return new Bird().build();
            case "fish":
                return new Fish().build();
            default:
                return null;
        }
    }
}
