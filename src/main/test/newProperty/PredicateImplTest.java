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
        PredicateImpl.Student student1 = handler.getStudent("Ashok", "Kumar", 9.5);
        PredicateImpl.Student student2 = handler.getStudent("Rajat","Verma", 8.0);

        student1 = handler.updateStudentFee(student1,
                student -> student.grade > 8.5,//Lambda expression for Predicate interface
                student -> student.feeDiscount = 30.0);//Lambda expression for Consumer interface
        student1.printFee();

        student2 = updateStudentFee(student2,
                student -> student.grade >= 8,
                student -> student.feeDiscount = 20.0);
        student2.printFee();
    }
}