package newProperty;

/**
 * @Description:1. 接口默认方法
 * 接口里面方法可以用 default 修饰， 表示方法默认实现， 
 * 接口里面可以写非抽象方法，也叫扩展方法
 */
public interface IFormula {
	double calculate(int a);
	default double sqrt(int a)
	{
		return Math.sqrt(a);
	}
}
