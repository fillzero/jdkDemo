package cn.tk.java.fastjson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	private String name;
	private String sex;
	private String cidNo;
	private String mobile;
}
