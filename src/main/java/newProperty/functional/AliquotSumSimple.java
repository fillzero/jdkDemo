package newProperty.functional;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/*
*@date: 2016/11/22
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 求完美数
* 约数: 可以整除目标数的数
* 真约数: 目标数除去其本身之外所有正约数的和
* 完美数: 真约数和 = 本身
*/
public class AliquotSumSimple {

    @Setter @Getter public int number;

    private Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public AliquotSumSimple(int number)
    {
        this.number = number;
    }

    /*
    * @description: 判断是否是 number 的约数
    */
    public boolean isFactor(int candidate)
    {
        return number % candidate == 0 ? true : false;
    }

    /*
    * @description: 获取 number 的所有约数, 约数可能会有重复, 去掉重复的
    */
    public Set<Integer> getFactors()
    {
        Set<Integer> aliquots = new HashSet<Integer>();
        aliquots.add(1);
        aliquots.add(number);
        for (int i=2; i<=Math.sqrt(number); i++)
        {
            if (isFactor(i))
            {
                aliquots.add(i);
                aliquots.add(number / i);
            }
        }
        return aliquots;
    }

    /*
    * @description: 求真约数和
    */
    public int aliquotSum()
    {
        if (cache.get(number)==null){
            int sum = 0;
            for (Integer aliquot : getFactors())
                sum += aliquot;
            cache.put(number, sum-number);
        }
        return cache.get(number);
    }

    /*
    * @description: 完美数
    */
    public boolean isPerfect()
    {
        return aliquotSum() == number;
    }

    /*
    * @description: 过剩数
    */
    public boolean isAbundant()
    {
        return aliquotSum() > number;
    }

    /*
    * @description: 不足数
    */
    public boolean isDeficient()
    {
        return aliquotSum() < number;
    }
}
