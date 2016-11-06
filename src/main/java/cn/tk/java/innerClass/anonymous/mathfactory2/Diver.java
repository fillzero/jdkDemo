package cn.tk.java.innerClass.anonymous.mathfactory2;

public class Diver implements CalFactory<Integer>{
	
	private Diver(){
		
	}
	
	private static Diver diver;
	
	public static Diver getInstance()
	{
		if (diver == null) {
			diver = new Diver(); 
		}
		return diver;
	}
	
	@Override
	public Integer calculate(Integer a, Integer b) {
		return a / b;
	}
}
