package cn.tk.java.junit.five.extension;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class APIEnvResolver implements ParameterResolver {
	@Override
	public boolean supports(final ParameterContext parameterContext, final ExtensionContext extensionContext) throws ParameterResolutionException {
		return parameterContext.getParameter().getType() == String.class
				&& parameterContext.getIndex() == 0;
	}

	@Override
	public Object resolve(final ParameterContext parameterContext, final ExtensionContext extensionContext) throws ParameterResolutionException {
		return "DEV";
	}
}
