package cn.tk.java.innerClass.anonymous.mathfactory;


public class Adder implements CalBuilder<Integer> {
	
	private Adder()
	{
		
	}
	
	public static CalFactory<Integer> addFactory = new CalFactory<Integer>() {
		@Override
		public CalBuilder<Integer> getBuilder() {
			return new Adder();
		}
	}; 
	
	@Override
	public Integer calculate(Integer a, Integer b) {
		return a + b;
	}
}
