package cn.tk.java.innerClass.anonymous.factory;

/**
 * @author: lijl85
 * @date：2016年11月4日上午8:13:21
 * @description:水厂, 生产水
 */
public class Water implements ProductBuilder{
	/**
	 * @Description private 构造器, 构造器写到匿名类里面, 不对外开放
	 */
	private Water() {
		
	}

	@Override
	public String create() {
		System.out.println("I am water!");
		return "I am water!";
	}
	
	/**
	 * @description: 制造一个水工厂
	 */
	public static Factory waterFactory = 
			new Factory() {
				@Override
				public ProductBuilder getProduct() {
					return new Water();
				}
			};

}
