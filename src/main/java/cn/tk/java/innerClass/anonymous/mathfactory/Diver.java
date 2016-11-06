package cn.tk.java.innerClass.anonymous.mathfactory;


public class Diver implements CalBuilder<Integer>{
	
	private Diver()
	{
		
	}
	
	public static CalFactory<Integer> divFactory = new CalFactory<Integer>() {
		@Override
		public CalBuilder<Integer> getBuilder() {
			return new Diver();
		}
	}; 
	
	@Override
	public Integer calculate(Integer a, Integer b) {
		return a / b;
	}
}
