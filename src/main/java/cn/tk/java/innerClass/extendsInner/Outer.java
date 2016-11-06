package cn.tk.java.innerClass.extendsInner;

public class Outer {
	public Outer() {
		System.out.println("Constructor Outer");
	}
	
	protected class Inner{
		public Inner() {
			System.out.println("Constructor Inner");
		}
	}
}
