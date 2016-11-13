package cn.tk.java.junit.five;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

@DisplayName("dynamic tests")
public class DynamicTests {
	@TestFactory
	public Collection<DynamicTest> simpleDynamicTest() {
		return Collections.singleton(dynamicTest("simple dynamic test", () -> assertTrue(2 > 1)));
	}

	@TestFactory
	public Stream<DynamicTest> streamDynamicTest() {
		return stream(
				Stream.of("Hello", "World").iterator(),
				(word) -> String.format("Test - %s", word),
				(word) -> assertTrue(word.length() > 4)
		);
	}
}
