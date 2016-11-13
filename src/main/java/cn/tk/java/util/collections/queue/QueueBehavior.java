package cn.tk.java.util.collections.queue;

import java.util.Queue;


/**
 * @author: lijl85
 * @date：2016年11月13日下午4:46:53
 * @description: 实现队列填充器, 用于填充不同队列, 然后依次打印队列元素
 * add(E): 插入元素,失败会抛异常
 * offer(E): 插入元素,失败不会抛异常
 * remove(): 删除元素,失败会抛异常
 * poll():删除元素,失败不会抛异常
 * element():获取对头元素,失败抛异常
 * peek():获取队头元素,但不会删除,失败不会抛异常
 *
 * 入队, 出队, 获取队头元素
 */
public class QueueBehavior {

	private static final int count = 10;

	/**
	 * @description:入队出队
	 */
	static void fill(Queue<String> queue, Generator<String> generator)
	{
		for(int i=0; i<count; i++)
		{
			queue.offer(generator.next());
		}
		while (queue.peek()!=null){
			System.out.print(queue.remove() + " ");
		}
		System.out.println();
	}

	static class Generator<T>
	{
		int i=0;
		String[] str = "one two three four five six seven eight nine ten".split(" ");
		public String next()
		{
			return str[i++];
		}
	}
}
