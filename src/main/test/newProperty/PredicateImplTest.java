package newProperty;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static newProperty.PredicateImpl.updateStudentFee;
import static org.junit.Assert.*;

/**
 * Created by lijl85 on 2016/11/25.
 */
public class PredicateImplTest {

    @Test
    public void testPredicate(){
        PredicateImpl handler = new PredicateImpl();
        PredicateImpl.Customer customer1 = handler.getStudent("Jack", 9.5);
        PredicateImpl.Customer customer2 = handler.getStudent("Lili", 8.0);

        customer1 = handler.updateStudentFee(customer1,
                customer -> customer.grade > 8.5,//Lambda expression for Predicate interface
                consumer -> consumer.feeDiscount = 0.3);//Lambda expression for Consumer interface
        customer1.printFee();

        customer2 = updateStudentFee(customer2,
                customer -> customer.grade >= 8,
                consumer -> consumer.feeDiscount = 0.2);
        customer2.printFee();
    }
}