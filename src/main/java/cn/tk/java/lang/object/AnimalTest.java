package cn.tk.java.lang.object;

import java.util.HashSet;

import org.junit.Test;

public class AnimalTest {
	/**
	 * @Description:不重写 hashCode() 和 equals()
	 */
	@Test
	public void testEquals()
	{
		HashSet<Animal> animals = new HashSet<Animal>();
		animals.add(new Animal("dog"));
		animals.add(new Animal("fish"));
		animals.add(new Animal("bird"));
		System.out.println("animals numbers: " + animals.size());
		System.out.println("animals contains dog? " + animals.contains(new Animal("dog")));
		System.out.println("kill dog from animals? " + animals.remove(new Animal("dog")));
		System.out.println("animals numbers: " + animals.size());
		
		System.out.println("dog == dog? " + new Animal("dog").equals(new Animal("dog")) );
		
		System.out.println("************* Hashcode *************");
		for (int i = 0; i < 10; i++) {
			System.out.println(new Animal("dog").hashCode());
		}
	}
}
