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
}
