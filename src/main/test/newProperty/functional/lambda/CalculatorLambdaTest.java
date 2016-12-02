package newProperty.functional.lambda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by lijl85 on 2016/12/2.
 */
public class CalculatorLambdaTest {
    @Test
    public void operationBinary() throws Exception {
        CalculatorLambda calculator = new CalculatorLambda();
        CalculatorLambda.IntegerMath addition = (a, b) -> a + b;
        CalculatorLambda.IntegerMath subtraction = (a, b) -> a - b;
        assertEquals(130, calculator.operationBinary(100, 30, addition));
        assertEquals(70, calculator.operationBinary(100, 30, subtraction));
    }
}