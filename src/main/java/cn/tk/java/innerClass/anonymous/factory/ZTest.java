package cn.tk.java.innerClass.anonymous.factory;

/**
 * @author: lijl85
 * @date：2016年11月6日上午10:57:28
 * @description:Factory --> Builder --> Product
 * 工厂制造工具, 工具生产产品
 */
public class ZTest {
	
	/**
	 * @description:工厂模式用匿名内部类实现
	 */
	public static void clientFactory(Factory factory)
	{
		ProductBuilder productFactory = factory.getProduct();
		productFactory.create();
	}
	
	public static void main(String[] args) {
		clientFactory(Food.foodFactory);
		clientFactory(Water.waterFactory);
	}
}
