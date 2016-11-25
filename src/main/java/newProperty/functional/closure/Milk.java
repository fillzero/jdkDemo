package newProperty.functional.closure;

/*
*@date: 2016/11/24
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 内部类 + 接口实现闭包: 内部类是面向对象的闭包
* 闭包: 可调用的对象, 记录了一些信息, 这些信息来自于创建它的作用域.
* 内部类: 由外部类创建, 并且有指向外部类的引用, 这个引用可以操作所有外部类成员
*/
public class Milk {
    private int num = 3;

    public Milk(){
        System.out.println("总共 3 瓶牛奶!");
    }

    public Person getPerson()
    {
        return new Person() {
            @Override
            public void haveMilk() {
                if (num == 0)
                    System.out.println("牛奶喝光了!");
                else
                    num --;
            }
        };
    }

    public void haveMilk(){
        if (num == 0)
            System.out.println("牛奶喝光了!");
        else
            num --;
    }

    public void currentNum(){
        System.out.println("还有: " + num + " 瓶牛奶!");
    }
}
