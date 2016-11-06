package cn.tk.java.innerClass.anonymous.mathfactory2;


public class Adder implements CalFactory<Integer> {
	
	private Adder(){
		
	}
	
	private static Adder adder;
	
	public static Adder getInstance()
	{
		if (adder == null) {
			adder = new Adder(); 
		}
		return adder;
	}
	
	@Override
	public Integer calculate(Integer a, Integer b) {
		return a + b;
	}
}
