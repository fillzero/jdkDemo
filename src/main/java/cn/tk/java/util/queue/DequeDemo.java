package cn.tk.java.util.queue;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

/**
 * @Description:Deque： double ended queue: 双端队列
 * 可以作为队列（FIFO） 使用， 也可以作为栈（FILO） 使用
 * 12 种方法：两个维度（3 * 4）
 * insert  remove  examine
 * first: throwsException, Special Value; last: throwsException, Special Value
 */
public class DequeDemo {
	private static final Deque<String> deque = new ArrayDeque<String>();
	
	static{
		deque.add("小李");
		deque.add("小王");
		deque.add("小张");
	}
	
	/**
	 * @Description:添加元素， add, offer 
	 * 左边是队列的头， addFirst 添加到左边第一个， add 默认添加到队尾
	 */
	@Test
	public void testInsert()
	{
		System.out.println("初始队列: " + deque.toString());
		deque.addFirst("小顺子");
		System.out.println("addFirst小顺子: " + deque.toString());
		deque.add("小德子");
		System.out.println("add小德子: " + deque.toString());
		deque.offerFirst("小桌子");
		System.out.println("offerFirst小桌子: " + deque.toString());
		deque.addLast("小邓子");
		System.out.println("addLast小邓子: " + deque.toString());
	}
	
	/**
	 * @Description:删除元素， remove, poll
	 */
	@Test
	public void testRemove()
	{
		System.out.println("初始队列: " + deque.toString());
		deque.removeFirst();
		System.out.println("removeFirst(): " + deque.toString());//NoSUchElementException
		deque.pollFirst();
		System.out.println("pollFirst(): " + deque.toString());//弹出队首元素， 没有不会报异常
	}
	
	/**
	 * @Description:查看队首元素， 只做查看，不删除
	 */
	@Test
	public void testExamine()
	{
		System.out.println("初始队列: " + deque.toString());
		System.out.println("deque.getFirst(): " + deque.getFirst());
		System.out.println("deque.getFirst()后: " + deque.toString());
		System.out.println("deque.peekFirst(): " + deque.peekFirst());
		System.out.println("deque.peekFirst()后: " + deque.toString());
	}
}
