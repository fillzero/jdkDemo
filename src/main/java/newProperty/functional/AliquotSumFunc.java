package newProperty.functional;

import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

/*
*@date: 2016/11/22
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: java8 实现完美数问题, 利用函数式编程
* 1. 判断当前数是否是目标数约数
* 2. 获取目标数所有约数
* 3. 算出真约数和
* 4. 真约数和与目标数进行比较
*/
public class AliquotSumFunc {
    /*
    * @description: 获取所有正约数
    * filter 中引入占位参数 potential
    */
    public static IntStream factorOf(int number)
    {
        return range(1, number+1)
                .filter(potential -> number % potential == 0);
    }

    /*
    * @description: 求真约数和
    */
    public int aliquotSum(int number)
    {
        return factorOf(number).sum() - number;
    }

    /*
    * @description: 完美数
    */
    public boolean isPerfect(int number)
    {
        return aliquotSum(number) == number;
    }

    /*
    * @description: 过剩数
    */
    public boolean isAbundant(int number)
    {
        return aliquotSum(number) > number;
    }

    /*
    * @description: 不足数
    */
    public boolean isDeficient(int number)
    {
        return aliquotSum(number) < number;
    }
}
