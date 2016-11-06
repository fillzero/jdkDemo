package cn.tk.java.innerClass.anonymous.mathfactory2;


public class Adder implements CalFactory<Integer> {
	
	public Adder(){
		
	}
	
	private static Adder adder;
	
	public Adder getInstance()
	{
		if (adder == null) {
			adder = new Adder(); 
		}
		return adder;
	}
	
	@Override
	public Integer calculate(Integer a, Integer b, CalFactory<Integer> factory) {
		return a + b;
	}
}
