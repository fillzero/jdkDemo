package cn.tk.java.util.collections.queue;

import org.junit.Test;

public class ToDoListTest {
	@Test
	public void testAddStringCharInt() {
		ToDoList toDoList = new ToDoList();
		toDoList.add("Empty trash", 'C', 4);
		toDoList.add("Feed dog", 'A', 2);
		toDoList.add("Feed bird", 'B', 7);
		toDoList.add("Mow lawn", 'C' , 3);
		toDoList. add("Water lawn", 'A', 1);
		toDoList.add("Feed cat", 'B', 1);
		while(!toDoList.isEmpty())
			System.out.println(toDoList.remove()) ;
	}
}
