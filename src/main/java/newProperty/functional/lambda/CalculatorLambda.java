package newProperty.functional.lambda;

/*
* @date: 2016/12/2
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description: 多参数 Lambda 表达式
*/
public class CalculatorLambda {

    /*
    * @description: 计算接口
    */
    interface IntegerMath{
        int operation(int a, int b);
    }

    public int operationBinary(int a, int b, IntegerMath op)
    {
        return op.operation(a, b);
    }
}
