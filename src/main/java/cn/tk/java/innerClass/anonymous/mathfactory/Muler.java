package cn.tk.java.innerClass.anonymous.mathfactory;


public class Muler implements CalBuilder<Integer> {
	
	private Muler()
	{
		
	}
	
	public static CalFactory<Integer> mulFactory = new CalFactory<Integer>() {
		@Override
		public CalBuilder<Integer> getBuilder() {
			return new Muler();
		}
	}; 
	
	@Override
	public Integer calculate(Integer a, Integer b) {
		return a * b;
	}
}
