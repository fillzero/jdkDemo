package cn.tk.java.innerClass.anonymous.mathfactory2;


public class Suber implements CalFactory<Integer>{

	private Suber() {
		
	}
	
	private static Suber suber;
	
	public static CalFactory<Integer> getInstance()
	{
		if(suber == null)
			suber = new Suber();
		return suber;
	}
	
	@Override
	public Integer calculate(Integer a, Integer b) {
		return a - b;
	}
}
