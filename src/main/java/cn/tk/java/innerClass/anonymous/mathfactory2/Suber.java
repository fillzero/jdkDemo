package cn.tk.java.innerClass.anonymous.mathfactory2;


public class Suber implements CalFactory<Integer>{

	public Suber() {
		
	}
	
	private static Suber suber;
	
	public CalFactory<Integer> getInstance()
	{
		if(suber == null)
			suber = new Suber();
		return suber;
	}
	
	@Override
	public Integer calculate(Integer a, Integer b, CalFactory<Integer> factory) {
		return a - b;
	}
}
