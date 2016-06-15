package cn.tk.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description:用 AtomicReference 创建栈安全的堆栈
 */
public class LinkedStack<T> {
	private AtomicReference<Node<T>> stacks = new AtomicReference<Node<T>>();

	public T push(T e)
	{
		Node<T> oldNode, newNode;
		while(true)//必须这样处理
		{
			oldNode = stacks.get();
			newNode = new Node<T>(e, oldNode);
			if(stacks.compareAndSet(oldNode, newNode))
			{
				return e;
			}
		}
	}
	
	public T pop()
	{
		Node<T> oldNode, newNode;
		while(true)
		{
			oldNode = stacks.get();
			newNode = oldNode.next;
			if(stacks.compareAndSet(oldNode, newNode))
			{
				return oldNode.object;
			}
		}
	}
	
	private static final class Node<T>{
		private T object;
		private Node<T> next;
		private Node(T object, Node<T> next){
			this.object = object;
			this.next = next;
		}
	}
}
