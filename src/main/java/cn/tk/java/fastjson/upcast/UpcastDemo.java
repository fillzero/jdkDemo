package cn.tk.java.fastjson.upcast;

import com.alibaba.fastjson.JSON;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/21
* @description: 
*
**/
public class UpcastDemo {
    /*
    * @description: 向上强转为父类的时候，子类的信息没有丢失，转换成 JSON 的时候会全部返回
    */
    public static void main(String[] args) {
        UpcastDemo upcastDemo = new UpcastDemo();
        Animal animal = upcastDemo.getBird();
        String s = JSON.toJSONString(animal);
        System.out.println(s);
    }

    /*
    * @description: 获取一只鸟儿，向上转型为一个动物，看看鸟儿的数据（翅膀）是否会丢失
    */
    public Animal getBird()
    {
        Bird bird = new Bird();
        bird.setWing("wing");
        bird.setFoot("foot");
        bird.setMouse("mouse");
        return bird;
    }
}
