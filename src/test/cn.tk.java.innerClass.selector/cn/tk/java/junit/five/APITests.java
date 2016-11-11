package cn.tk.java.junit.five;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import cn.tk.java.junit.five.extension.APIEnvResolver;
import cn.tk.java.junit.five.extension.DisableAPITests;
import cn.tk.java.junit.five.extension.IgnoreNullPointerException;
import cn.tk.java.junit.five.extension.InjectAPIEnv;
import cn.tk.java.junit.five.extension.Timing;

@ExtendWith(DisableAPITests.class)
@ExtendWith(InjectAPIEnv.class)
@ExtendWith(APIEnvResolver.class)
@ExtendWith(Timing.class)
@ExtendWith(IgnoreNullPointerException.class)
public class APITests {
	private String env;

	public void setEnv(final String env) {
		this.env = env;
	}

	@Test
	@Tag("api")
	public void simpleAPITest() {
		System.out.println("simple API test");
	}

	@Test
	public void showInjected() {
		assertEquals("DEV", this.env);
	}

	@Test
	public void showResolved(final String env) {
		assertEquals("DEV", env);
	}

	@SuppressWarnings("null")
	@Test
	public void nullValue() {
		final String str = null;
		System.out.println(str.substring(0));
	}
}
