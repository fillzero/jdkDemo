package cn.tk.java.junit.five.extension;

import java.util.Set;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ContainerExecutionCondition;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;

public class DisableAPITests implements ContainerExecutionCondition, TestExecutionCondition {
	@Override
	public ConditionEvaluationResult evaluate(final ContainerExtensionContext context) {
		return checkTags(context.getTags());
	}

	@Override
	public ConditionEvaluationResult evaluate(final TestExtensionContext context) {
		return checkTags(context.getTags());
	}

	private ConditionEvaluationResult checkTags(final Set<String> tags) {
		if (tags.contains("api")) {
			return ConditionEvaluationResult.disabled("No API tests!");
		}
		return ConditionEvaluationResult.enabled("");
	}
}
