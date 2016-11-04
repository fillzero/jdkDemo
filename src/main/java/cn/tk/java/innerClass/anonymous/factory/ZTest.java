package cn.tk.java.innerClass.anonymous.factory;

public class ZTest {
	
	/**
	 * @description:工厂模式用匿名内部类实现
	 */
	public static void clientFactory(Factory factory)
	{
		Product productFactory = factory.getProduct();
		productFactory.create();
	}
	
	public static void main(String[] args) {
		clientFactory(Food.foodFactory);
		clientFactory(Water.waterFactory);
	}
}
