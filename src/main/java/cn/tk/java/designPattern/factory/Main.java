package cn.tk.java.designPattern.factory;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/12/15
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        print(AnimalFactory.eat("bird"));
        print(AnimalFactory.eat("fish"));
    }

    public static void print(Animal animal)
    {
        System.out.println(animal);
    }
}
