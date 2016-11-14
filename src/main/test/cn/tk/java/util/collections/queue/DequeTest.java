package cn.tk.java.util.collections.queue;

import cn.tk.java.util.collections.queue.Deque;

public class DequeTest {
	/**
	 * @description: First -- Last
	 */
	static void fill(Deque<Integer> deque) {
		for(int i = 20; i < 27; i++)
			deque.addFirst(i);
		for(int i = 50; i < 55; i++)
			deque.addLast(i);
	}
	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>();
		fill(deque) ;
		while(deque.size()!= 0)
			System.out.print(deque.removeFirst() + " ");
		fill(deque) ;
		System.out.println();
		while(deque.size() != 0)
			System.out.print(deque.removeLast() + " " );
	}
}