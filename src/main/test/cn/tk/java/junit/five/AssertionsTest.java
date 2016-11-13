package cn.tk.java.junit.five;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Assertions")
public class AssertionsTest {
	@Test
	@DisplayName("simple assertion")
	public void simple() {
		assertEquals(3, 1 + 2, "simple math");
		assertNotEquals(3, 1 + 1);

		assertNotSame(new Object(), new Object());
		Object obj = new Object();
		assertSame(obj, obj);

		assertFalse(1 > 2);
		assertTrue(1 < 2);

		assertNull(null);
		assertNotNull(new Object());
	}

	@Test
	@DisplayName("array assertion")
	public void array() {
		assertArrayEquals(new int[]{1, 2}, new int[] {1, 2});
	}

	@Test
	@DisplayName("fail")
	@Disabled
	public void shouldFail() {
		fail("This should fail");
	}

	@Test
	@DisplayName("assert all")
	public void all() {
		assertAll("Math",
			() -> assertEquals(2, 1 + 1),
			() -> assertTrue(1 > 0)
		);
	}

	@Test
	@DisplayName("throws exception")
	public void exception() {
		assertThrows(ArithmeticException.class, () -> System.out.println(1 / 0));
	}
}
