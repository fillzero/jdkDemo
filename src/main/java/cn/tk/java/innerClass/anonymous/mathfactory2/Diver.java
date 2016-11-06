package cn.tk.java.innerClass.anonymous.mathfactory2;

public class Diver implements CalFactory<Integer>{
	
	public Diver(){
		
	}
	
	private static Diver diver;
	
	public Diver getInstance()
	{
		if (diver == null) {
			diver = new Diver(); 
		}
		return diver;
	}
	
	@Override
	public Integer calculate(Integer a, Integer b, CalFactory<Integer> factory) {
		return a / b;
	}
}
