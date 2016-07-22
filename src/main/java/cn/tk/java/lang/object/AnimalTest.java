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
	
	/**
	 * @Description:equals 方法必须满足的四个特性
	 */
	@Test
	public void testEqualsFeatures()
	{
		Animal dog1 = new Animal("dog");
		Animal dog2 = new Animal("dog");
		Animal dog3 = new Animal("dog");
		System.out.println("1. 对称性");
		System.out.println(dog1.equals(dog2) + "," + dog2.equals(dog1));
		System.out.println("2. 自反性");
		System.out.println(dog1.equals(dog1));
		System.out.println("3. 传递性");
		System.out.println(dog1.equals(dog2));
		System.out.println(dog2.equals(dog3));
		System.out.println(dog1.equals(dog3));
		System.out.println("4. 一致性");
		for (int i = 0; i < 10; i++) {
			System.out.println(dog1.equals(dog2));
		}
		System.out.println("5. 与 Null 比较");
		System.out.println(dog1.equals(null));
	}
}
