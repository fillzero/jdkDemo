package newProperty;

import java.util.function.Consumer;
import java.util.function.Predicate;

/*
* @date: 2016/11/25
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description: Predicate 实现类, 用于参数校验, 判断输入对象是否满足某个条件
* 参考: http://ifeve.com/predicate-and-consumer-interface-in-java-util-function-package-in-java-8/
*/
public class PredicateImpl {

    /*
    * @description: 使用 Predicate + Consumer 做验证处理
    * predicate: 决定是否打折
    * consumer: 决定打几折
    */
    public static Customer updateStudentFee(Customer student, Predicate<Customer> predicate, Consumer<Customer> consumer){
        if ( predicate.test(student)){
            consumer.accept(student);
        }
        return student;
    }

    public Customer getStudent(String name, Double grade)
    {
        return new Customer(name, grade);
    }

    public class Customer {
        String name;
        Double grade;
        Double feeDiscount = 0.0;
        Double baseFee = 20000.0;

        public Customer(String name, Double grade) {
            this.name = name;
            this.grade = grade;
        }

        public void printFee() {
            Double newFee = baseFee - (baseFee * feeDiscount);
            System.out.println("The discount for " + name + " is "+ newFee);
        }
    }
}
