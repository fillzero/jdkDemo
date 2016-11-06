package cn.tk.java.innerClass.callback.answer;

public class Answer {
	public Integer calculate(ICallback callback, char operator, Integer a, Integer b)
	{
		return callback.solve(operator, a,  b);
	}
}
