package cn.tk.java.innerClass.anonymous.mathfactory2;


public class Muler implements CalFactory<Integer> {
	
	private Muler(){
		
	}
	
	private static Muler muler;
	
	public static CalFactory<Integer> getInstance() {
		if (muler == null) {
			muler = new Muler();
		}
		return muler;
	}
	
	@Override
	public Integer calculate(Integer a, Integer b) {
		return a * b;
	}

}
