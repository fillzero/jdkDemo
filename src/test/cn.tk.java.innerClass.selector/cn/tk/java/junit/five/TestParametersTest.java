package cn.tk.java.junit.five;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

public class TestParametersTest {
	@Test
	@DisplayName("test info")
	public void testInfo(final TestInfo testInfo) {
		System.out.println(testInfo.getDisplayName());
	}

	@Test
	@DisplayName("test reporter")
	public void testReporter(final TestReporter testReporter) {
		testReporter.publishEntry("name", "Alex");
	}
}
