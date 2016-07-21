package cn.tk.java.lang.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description: Animal 类， 不重写 hashCode() 和 equals()
 */
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
	@Getter @Setter private String name;
}
