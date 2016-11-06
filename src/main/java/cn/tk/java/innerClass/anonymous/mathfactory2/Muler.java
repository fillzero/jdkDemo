package cn.tk.java.innerClass.anonymous.mathfactory2;


public class Muler implements CalFactory<Integer> {
	
	public Muler(){
		
	}
	
	private static Muler muler;
	
	@Override
	public CalFactory<Integer> getInstance() {
		if (muler == null) {
			muler = new Muler();
		}
		return muler;
	}
	
	@Override
	public Integer calculate(Integer a, Integer b, CalFactory<Integer> factory) {
		return a * b;
	}

}
