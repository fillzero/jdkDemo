package cn.tk.java.callback;

public class Ask implements ICallback{
	
	private Answer answer;
	
	public Ask(Answer answer){
		this.answer = answer;
	}
	
	/**
	 * @Description:请求调用主调方法
	 */
	public Integer askQuestion(char operator, Integer a, Integer b) throws InstantiationException, IllegalAccessException
	{
		return answer.calculate(this, operator, a, b);
	}
	
	/**
	 * @Author: 李晋龙
	 * @Description:回调方法
	 */
	@Override
	public Integer solve(char operator, Integer a, Integer b) {
		switch (operator) {
		case '+':
			return add(a, b);
		case '-':
			return  sub(a, b);
		case '*':
			return mul(a, b);
		default:
			return div(a, b);
		}
	}
	
	public Integer add(Integer a, Integer b) {
		return a + b;
	}

	public Integer sub(Integer a, Integer b) {
		return a - b;
	}

	public Integer mul(Integer a, Integer b) {
		return a * b;
	}

	public Integer div(Integer a, Integer b) {
		if (b == 0) {
			return 0;
		}
		return a / b;
	}
}
