package newProperty.functional.lambda;

import static java.util.Arrays.asList;
import java.util.List;

/*
*@date: 2016/11/24
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: lambda表达式基础测试
*
* lambda 语法: 参数 + 箭头 + 表达式/代码块
* (parameters) -> expression 或者 (parameters) -> { statements; }
*
* @FunctionalInterface: 函数式接口: 只包含一个方法的接口: Runnable Comparator
*/
public class LambdaDemo {

    /*
    * @description: lambda 表达式实现闭包, 实现 Runnable 接口的 run() 方法
    *
    */
    public static void runThreadUseLambda()
    {
        new Thread(() -> System.out.println("lambda 实现的线程")).start();
    }

    /*
    * @description: 内部类实现多线程
    *
    */
    public static void runThreadUseInnerClass(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("InnerClass 实现的线程");
            }
        }).start();
    }

    public static void loopLambda(){
        List<String> persons = asList("Joe", "Jim", "John");
        persons.forEach(person -> person.toString());
    }

    public static void loopCommon(){
        List<String> persons = asList("Joe", "Jim", "John");
        for (String person : persons)
        {
            person = person + " Doe";
            persons.add(person);
        }
        System.out.println(persons.toString());
    }
}
