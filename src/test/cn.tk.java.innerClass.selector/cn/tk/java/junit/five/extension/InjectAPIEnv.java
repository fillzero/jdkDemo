package cn.tk.java.junit.five.extension;

import org.apache.commons.lang3.reflect.MethodUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

public class InjectAPIEnv implements TestInstancePostProcessor {
	@Override
	public void postProcessTestInstance(final Object testInstance, final ExtensionContext context) throws Exception {
		MethodUtils.invokeMethod(testInstance, "setEnv", "DEV");
	}
}
