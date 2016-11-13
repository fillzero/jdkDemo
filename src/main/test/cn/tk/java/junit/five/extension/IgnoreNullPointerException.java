package cn.tk.java.junit.five.extension;

import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.TestExtensionContext;

public class IgnoreNullPointerException implements TestExecutionExceptionHandler {
	@Override
	public void handleTestExecutionException(final TestExtensionContext context, final Throwable throwable) throws Throwable {
		if (throwable instanceof NullPointerException) {
			return;
		}
		throw throwable;
	}
}
