package cn.tk.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @description:用 AtomicReference 创建栈安全的堆栈
 */
public class LinkedStack<T> {
	
	/**
	 * @description:栈结构， 包含一组 Node, stacks 是一个对象类型， 所以用 AtomicReference 修饰， 保证更新的原子性
	 * 入栈出栈都是对于该栈对象的更新， 多线程环境下可能引发线程安全问题， 所以要用原子类实现非阻塞算法
	 */
	private AtomicReference<Node<T>> stacks = new AtomicReference<Node<T>>();

	/**
	 * @description:入栈
	 */
	public T push(T e)
	{
		Node<T> oldNode, newNode;
		while(true)//必须这样处理， 不停的 push 直到成功为止
		{
			oldNode = stacks.get();//栈顶节点作为 oldNode
			newNode = new Node<T>(e, oldNode);//新建一个节点作为 newNode, 并且指向 oldNode
			if(stacks.compareAndSet(oldNode, newNode))//更新成功， 返回新节点作为当前节点
			{
				return e;
			}
		}
	}
	
	/**
	 * @description:出栈
	 */
	public T pop()
	{
		Node<T> oldNode, newNode;
		while(true)
		{
			oldNode = stacks.get();
			newNode = oldNode.next;
			if(stacks.compareAndSet(oldNode, newNode))//??
			{
				return oldNode.object;//出栈返回弹出的数值
			}
		}
	}
	
	/**
	 * @description:Node 数据结构，
	 * object 数据属性
	 * next 指向下一个节点的指针
	 */
	private static final class Node<T>{
		private T object;
		private Node<T> next;
		private Node(T object, Node<T> next){
			this.object = object;
			this.next = next;
		}
	}
}
