package cn.tk.java.fastjson.putData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	//姓名
	private String name;
	//手机号码
	private String mobile;
	//证件类型
	private String identifyType;
	//证件号码
	private String identifyNo;
}
