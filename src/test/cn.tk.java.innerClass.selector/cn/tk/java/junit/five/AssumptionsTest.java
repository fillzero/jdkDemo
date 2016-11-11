package cn.tk.java.junit.five;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.Objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Assumptions")
public class AssumptionsTest {
	private final String environment = "DEV";

	@Test
	@DisplayName("simple")
	public void simpleAssume() {
		assumeTrue(Objects.equals(this.environment, "DEV"));
		assumeFalse(() -> Objects.equals(this.environment, "PROD"));
	}

	@Test
	@DisplayName("assume then do")
	public void assumeThenDo() {
		assumingThat(
			Objects.equals(this.environment, "DEV"),
			() -> System.out.println("In DEV")
		);
	}
}
