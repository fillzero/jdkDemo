package newProperty.functional.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
* @date: 2016/12/1
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description: JDK8 lambda 官方文档
* Lambda表达式 --> 更简洁的编写只有一个方法的类
* 场景: social networking application
* 函数式变成三步走: processPersonsFunction
* Filters: Predicate<T> 给出过滤条件
* Maps: Function<T, R> 给出映射
* Actions: Consumer<T> 给出执行行为
*
* 演化过程:
* 1. 接口 + 内部实现类
* 2. 接口 + 匿名实现类
* 3. 接口 + Lambda表达式
*
* 注意这里的接口只能有一个方法, 称为功能性接口, 这样给出的 lambda 表达式就是该方法的具体实现.
*/
public class LambdaDocument {

    /*
    * @description: 1. 按一个条件查询: 找年龄大于 18 岁的打印
    */
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person person : roster) {
            if (person.getAge() > age) {
                person.printPerson();
            }
        }
    }

    /*
    * @description: 2. 增加查询条件: 需要修改代码
    */
    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person person : roster) {
            if (low < person.getAge() && person.getAge() < high) {
                person.printPerson();
            }
        }
    }

    /*
    * @description: 3. 增加条件需要不断修改原始代码 --> 增加本地类, 专门负责编写查询条件
    */
    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person person : roster) {
            if (tester.test(person))//打印满足条件的 person
            {
                person.printPerson();
            }
        }
    }

    /*
    * @description: 4. 使用匿名类实现 CheckPerson 接口, 编写查询条件
    */

    public static void printPersonsAnonymous(List<Person> roster) {
        printPersons(roster,  new CheckPerson() {
            @Override
            public boolean test(Person person) {
                return person.getGender() == Person.Sex.MALE
                        && person.getAge() >= 30
                        && person.getAge() <= 50;
            }
        });
    }

    /*
    * @description: 5. 功能性接口可以使用 Lambda 表达式代替匿名类实现
    */
    public static void printPersonsLambda(List<Person> roster) {
        printPersons(roster,
                person -> person.getGender() == Person.Sex.MALE
                        && person.getAge() >= 30
                        && person.getAge() <= 40
        );
    }

    /*
    * @description: 使用 JDK 默认功能性接口 Predicate, 返回一个 boolean 值作为条件判断结果, 实现类实现 Predicate 接口完成条件录入
    */
    public static void printPersonsPredicate(List<Person> persons, Predicate<Person> tester) {
        for (Person person : persons) {
            if (tester.test(person)) {
                person.printPerson();
            }
        }
    }

    /*
    * @description: 6. 使用 匿名类/Lambda 表达式实现 JDK 原生接口
    */
    public static void printPersonsAnonymousPredicate(List<Person> roster) {
        printPersonsPredicate(roster, new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getGender() == Person.Sex.MALE
                        && person.getAge() >= 30
                        && person.getAge() <= 50;
            }
        });
    }

    public static void printPersonsLambdaPredicate(List<Person> roster) {
        printPersonsPredicate(roster, person ->
                person.getGender() == Person.Sex.MALE
                        && person.getAge() > 30
                        && person.getAge() <= 50);
    }

    /*
    * @description: 7. 充分利用 Lambda 表达式
    * eg: person.printPerson() 也使用 Lambda 表达式实现, person 为入参, 动作为打印
    *
    * 增加 Consumer 参数: 用于执行打印动作
    * 增加 Function<T, R> mapper: 用于处理 Animal 的数据
    *
    * Predicate: 给出执行条件
    * Consumer: 给出执行操作
    * Function: 给出数据映射, 可以获取到操作的数据
    */
    //定义类
    public static void printPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
        for (Person person : roster) {
            if (tester.test(person)) {
                block.accept(person);//Consumer 接受一个对象, 直接对对象进行处理
            }
        }
    }

    public static void printPersons(
            List<Person> roster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block//Consumer 接受从 Function 映射获取到的数据, 对单个字段作出处理
    ) {
        for (Person person : roster) {
            if (tester.test(person)) {
                String data = mapper.apply(person);//根据 person 获取 value
                block.accept(data);
            }
        }
    }

    //实现类
    public static void processPersons(List<Person> roster) {
        printPersons(
                roster,
                person -> person.getGender() == Person.Sex.MALE
                        && person.getAge() > 30
                        && person.getAge() <= 50,
                person -> person.printPerson());
    }

    public static void processPersonsFunction(List<Person> roster) {
        printPersons(
                roster,
                person -> person.getGender() == Person.Sex.MALE
                        && person.getAge() > 30
                        && person.getAge() <= 50,
                p -> p.getEmailAddress(),// Function 获取邮箱
                email -> System.out.println(email)//打印邮箱地址
        );
    }

    /*
    * @description: 8. 引入聚合操作:  Aggregate Operations,不需要实现接口, 直接操作数据源
    * Stream<T> filter(Predicate<? super T> predicate);
    * <R> Stream<R> map(Function<? super T, ? extends R> mapper);
    * void forEach(Consumer<? super T> action);
    *
    * 聚合操作本质上也是提供 Predicate, Function, Consumer 的实现类
    */
    public static void printPersonsByAggregate(List<Person> roster) {
        roster.stream()
                .filter(
                    p -> p.getGender() == Person.Sex.MALE
                         && p.getAge() >= 18
                         && p.getAge() <= 25
                )
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));
    }
}
