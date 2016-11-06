package cn.tk.java.innerClass.anonymous.mathfactory2;


public interface CalFactory<T> {
	public CalFactory<T> getInstance();
	public T calculate(T a, T b, CalFactory<T> factory);
}
