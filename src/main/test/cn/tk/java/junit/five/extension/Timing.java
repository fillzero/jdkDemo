package cn.tk.java.junit.five.extension;

import java.lang.reflect.Method;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.TestExtensionContext;

import com.google.common.collect.ImmutableMap;

public class Timing implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
	@Override
	public void beforeTestExecution(final TestExtensionContext context) throws Exception {
		getStore(context).put(context.getTestMethod().get(), System.currentTimeMillis());
	}

	@Override
	public void afterTestExecution(final TestExtensionContext context) throws Exception {
		final Method testMethod = context.getTestMethod().get();
		final long start = getStore(context).remove(testMethod, long.class);
		final long duration = System.currentTimeMillis() - start;
		context.publishReportEntry(ImmutableMap.of(testMethod.getName(), Long.toString(duration)));
	}

	private Store getStore(TestExtensionContext context) {
		return context.getStore(Namespace.create(getClass(), context));
	}
}
