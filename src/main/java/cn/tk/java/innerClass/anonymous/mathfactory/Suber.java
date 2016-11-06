package cn.tk.java.innerClass.anonymous.mathfactory;


public class Suber implements CalBuilder<Integer>{
	
	private Suber()
	{
		
	}
	
	public static CalFactory<Integer> subFactory = new CalFactory<Integer>() {
		@Override
		public CalBuilder<Integer> getBuilder() {
			return new Suber();
		}
	}; 
	
	@Override
	public Integer calculate(Integer a, Integer b) {
		return a - b;
	}
}
