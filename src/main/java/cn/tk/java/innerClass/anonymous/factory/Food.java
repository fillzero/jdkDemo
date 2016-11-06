package cn.tk.java.innerClass.anonymous.factory;

public class Food implements ProductBuilder{

	private Food() {

	}
	
	@Override
	public String create() {
		System.out.println("I am food");
		return "I am food";
	}
	
	public static Factory foodFactory =
			new Factory() {
				@Override
				public ProductBuilder getProduct() {
					return new Food();
				}
			};

}
