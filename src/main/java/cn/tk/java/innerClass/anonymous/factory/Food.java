package cn.tk.java.innerClass.anonymous.factory;

public class Food implements Product{

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
				public Product getProduct() {
					return new Food();
				}
			};

}
