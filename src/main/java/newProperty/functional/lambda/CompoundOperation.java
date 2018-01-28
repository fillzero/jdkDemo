package newProperty.functional.lambda;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
*@date: 2016/12/4
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: Lambda 表达式的复合运算
*/
public class CompoundOperation {
    /*
    * @description: Function<T, R> 复合运算 f(g(x)), g(f(x))
    */
    public static class Letter{
        /*
        * @description: 添加新建头部
        */
        public static String addHeader(String text)
        {
            return "From lijinlong " + text;
        }

        /*
        * @description: 添加新建尾部
        */
        public static String addFooter(String text)
        {
            return text + " Kind regards!";
        }

        /*
        * @description: 信件语法检查
        */
        public static String checkSpelling(String text)
        {
            return text.replaceAll("labda", "lambda");
        }
    }

    /*
    * @description: Function 复合运算, 一个函数的结果作为另一个函数的输入
    */
    @Test
    public void testFunction()
    {
        Function<String, String> addFunction = Letter :: addHeader;
        Function<String, String> pipeLine = addFunction
                .andThen(Letter :: checkSpelling)
                .andThen(Letter :: addFooter);
        System.out.println(pipeLine.apply("I'am labda"));
    }

    /*
   * @description: 两个函数: f(x) --> x = x + 1, g(x) --> x = x * 2
   */
    @Test
    public void testCompoundFunction()
    {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h1 = f.andThen(g); //g(f(x)), 先算完 f(x) 再计算 g(x)
        Function<Integer, Integer> h2 = f.compose(g); //f(g(x)), 先算完 g(x) 再计算 f(x)
        int resultAndThen = h1.apply(1);
        int resultCompose = h2.apply(1);
        System.out.println(resultAndThen);//4
        System.out.println(resultCompose);//3
    }

    /*
    * @description: 找出年龄大于 18, 小于 30, 性别是男的 Animal, 打印出来对应邮箱
    */
    @Test
    public void testCompoundPredicate()
    {
        List<Person> roster = Person.createRoster();

        Predicate<Person> agePredicate = person -> person.getAge() >= 18;
        Predicate predicate = agePredicate
                .and(person -> person.getAge() <= 50)
                .and(person -> person.getGender() == Person.Sex.MALE);
        Function<Person, String> emailFunction = person -> person.getEmailAddress();
        Consumer<String> consumer = email -> System.out.println(email);

        roster
                .stream()
                .filter(predicate::test)
                .forEach(person ->
                {
                    final String emails = emailFunction.apply(person);
                    consumer.accept(emails);
                });// forEach: 循环操作筛选出来的数据项, T -> void
    }
}
