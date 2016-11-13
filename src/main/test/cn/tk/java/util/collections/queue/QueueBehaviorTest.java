package cn.tk.java.util.collections.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;

import org.junit.Test;

import cn.tk.java.util.collections.queue.QueueBehavior.Generator;

/**
 * @author: lijl85
 * @date：2016年11月13日下午5:08:21
 * @description:优先队列出队顺序与入队顺序不一致
 */
public class QueueBehaviorTest {

	@Test
	public void testFill() {
		QueueBehavior.fill(new LinkedList<String>(), new Generator<String>());
		QueueBehavior.fill(new PriorityQueue<String>(), new Generator<String>());
		QueueBehavior.fill(new ArrayBlockingQueue<String>(10), new Generator<String>());
		QueueBehavior.fill(new ConcurrentLinkedQueue<String>(), new Generator<String>());
		QueueBehavior.fill(new LinkedBlockingDeque<String>(), new Generator<String>());
		QueueBehavior.fill(new PriorityBlockingQueue<String>(), new Generator<String>());
	}
}
