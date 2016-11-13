package cn.tk.java.junit.four.properties;

public class MessageUtil {

	private String message;

	public MessageUtil(String message) {
		this.message = message;
	}

	public String printMessage() {
		return message;
	}

	public Object salutationMessage() {
		return null;
	}
}
