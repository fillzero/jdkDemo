package newProperty.functional.lambda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by lijl85 on 2016/11/24.
 */
public class LambdaDemoTest {
    @Test
    public void runThreadUseLambda() throws Exception {
        LambdaDemo.runThreadUseLambda();
    }

    @Test
    public void runThreadUseInnerClass() throws Exception {
        LambdaDemo.runThreadUseInnerClass();
    }

    @Test
    public void loopLambda() throws Exception {
        LambdaDemo.loopLambda();
    }
    @Test
    public void loopCommon() throws Exception {
        LambdaDemo.loopCommon();
    }
}