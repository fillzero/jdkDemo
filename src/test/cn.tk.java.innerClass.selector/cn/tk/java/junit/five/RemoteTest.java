package cn.tk.java.junit.five;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Remote test")
public class RemoteTest {
	
	@Test
	@Remote
	public void testGetUser() {
		System.out.println("Get user");
	}
}
