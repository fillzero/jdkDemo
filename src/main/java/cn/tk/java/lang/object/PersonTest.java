package cn.tk.java.lang.object;

import java.util.HashSet;

import org.junit.Test;

public class PersonTest {
	@Test
	public void testHashcode()
	{
		Person person = new Person();
		System.out.println(person.hashCode());
		System.out.println(System.identityHashCode(person));
	}
	
	/**
	 * @Description:重写 hashCode() 和 equals()
	 */
	@Test
	public void testEquals()
	{
		HashSet<Person> persons = new HashSet<Person>();
		persons.add(new Person("zhangsan"));
		persons.add(new Person("wangwu"));
		persons.add(new Person("lisi"));
		
		System.out.println("persons numbers: " + persons.size());
		System.out.println("persons contains zhangsan? " + persons.contains(new Person("zhangsan")));
		System.out.println("kill zhangsan from persons? " + persons.remove(new Person("zhangsan")));
		System.out.println("persons numbers: " + persons.size());
		
		System.out.println("zhangsan == zhangsan? " + new Person("zhangsan").equals(new Person("zhangsan")) );
		
		System.out.println("************* Hashcode *************");
		for (int i = 0; i < 10; i++) {
			System.out.println(new Person("zhangsan").hashCode());
		}
	}
	
	/**
	 * @Description:equals 方法必须满足的四个特性
	 */
	@Test
	public void testEqualsFeatures()
	{
		Person student1 = new Person("Jack");
		Person student2 = new Person("Jack");
		Person student3 = new Person("Jack");
		System.out.println("1. 对称性");
		System.out.println(student1.equals(student2) + "," + student2.equals(student1));
		System.out.println("2. 自反性");
		System.out.println(student1.equals(student1));
		System.out.println("3. 传递性");
		System.out.println(student1.equals(student2));
		System.out.println(student2.equals(student3));
		System.out.println(student1.equals(student3));
		System.out.println("4. 一致性");
		for (int i = 0; i < 10; i++) {
			System.out.println(student1.equals(student2));
		}
		System.out.println("5. 与 Null 比较");
		System.out.println(student1.equals(null));
	}
}
