package cn.tk.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @description:非阻塞链表
 */
public class LinkedQueue<E>{
	/**
	 * @description:头结点
	 */
	private AtomicReference<Node<E>> head = 
			new AtomicReference<Node<E>>(new Node<E>(null, null));
	
	/**
	 * @description:头结点等于尾节点
	 */
	private AtomicReference<Node<E>> tail = head;
	
	/**
	 * @description:将 item 放入链表
	 */
	public boolean put(E item)
	{
		Node<E> newNode = new Node<E>(item, null);
		 while (true) {
            Node<E> curTail = tail.get();
            Node<E> residue = curTail.next.get();
            if (curTail == tail.get()) {
                if (residue == null) /* A */ {
                    if (curTail.next.compareAndSet(null, newNode)) /* C */ {
                        tail.compareAndSet(curTail, newNode) /* D */ ;
                        return true;
                    }
                } else {
                    tail.compareAndSet(curTail, residue) /* B */;
                }
            }
       }
	}
	
	/**
	 * @description:数据结构
	 * item: 节点存放的数据
	 * next: 指针
	 */
	private static class Node<E>{
		final E item;
		final AtomicReference<Node<E>> next;
		Node(E item, Node<E> next)
		{
			this.item = item;
			this.next = new AtomicReference<Node<E>>(next);
		}
	}
}
