package cn.tk.java.algorithm.leetcode.array;

import org.junit.Test;

/**
 * @description:这种算法与人类计算两个数相加的过程是一样的, 都是从低位到高位逐步运算, 超过 10 进位,进位保存在 carry 中
 * 所以链表逆序反而对于计算两个十进数相加更有益, 使用尾插法可以让逆序保持不变.
 * 整个过程所有链表一直保持逆序状态, 并没有进行顺序转换
 * 
 * 如果给出的两个链表是顺序的,反而需要进行两次逆序转换
 */
public class AddTwoNumbers {
	/**
	 * @description:关键问题要记录最后一个节点, 链表插入使用尾插法, 不使用头插法
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		int carry = 0;
		ListNode prev = head;
		for (ListNode pa = l1, pb = l2; 
				pa != null || pb != null; 
				pa = pa == null ? null : pa.next, 
				pb = pb == null ? null : pb.next, 
				prev = prev.next) {
			int ai = pa == null ? 0 : pa.value;
			int bi = pb == null ? 0 : pb.value;
			int value = (ai + bi + carry) % 10; //模 10 可以算出新链表的值
			carry = (ai + bi + carry) / 10;//除 10 可以算出每次的进位, 和小于 10 不产生进位
			prev.next = new ListNode(value);
		}
		if (carry > 0) {
			prev.next = new ListNode(carry);
		}
		return head.next;
	}

	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
	       int carry =0;
	 
	        ListNode head = new ListNode(0);
	        ListNode p1 = l1, p2 = l2, prev=head;
	 
	        while(p1 != null || p2 != null){
	            if(p1 != null){
	                carry += p1.value;
	                p1 = p1.next;
	            }
	 
	            if(p2 != null){
	                carry += p2.value;
	                p2 = p2.next;
	            }
	 
	            prev.next = new ListNode(carry%10);
	            prev = prev.next;
	            carry /= 10;
	        }
	 
	        if(carry > 0) 
	            prev.next=new ListNode(carry);
	 
	        return head.next;
	    }

	/**
	 * @description: 尾插法创建链表, 关键要维护一个尾结点
	 */
	public ListNode tailAdd(int ... value) {
		ListNode head = new ListNode(-1);//头结点
		ListNode prev = head;//尾结点
		for (int i = 0; i < value.length; i++) {
			prev.next = new ListNode(value[i]);
			prev = prev.next;
		}
		return head.next;
	}
	
	/**
	 * @description:头插法创建链表
	 */
	public ListNode headAdd(int ... value)
	{
		ListNode head = new ListNode(-1);
		for(int i=0; i<value.length; i++)
		{
			ListNode newNode = new ListNode(value[i]);
			newNode.next = head.next;
			head.next = newNode;
		}
		return head.next;
	}
	
	/**
	 * @description:打印列表
	 */
	private void printList(ListNode list) {
		while (list.next != null) {
			System.out.print(list.value + " ");
			list = list.next;
		}
		System.out.print(list.value + " ");
	}

	/**
	 * 内部节点类
	 */
	public class ListNode {
		int value;
		ListNode next;
		ListNode(int value) {
			this.value = value;
		}
	}

	// (2 -> 4 -> 3) + (5 -> 6 -> 4) --> (7, 0, 8)
	@Test
	public void testAddTwoNumbers(){
		ListNode l1 = tailAdd(2, 4, 3);
		ListNode l2 = tailAdd(5, 6, 4);
		ListNode list = addTwoNumbers(l1, l2);
		ListNode list2 = addTwoNumbers1(l1, l2);
		printList(list);
		System.out.println();
		printList(list2);
	}
	
	/**
	 * @description:测试头插法和尾插法
	 */
	@Test
	public void testAdd()
	{
		ListNode headList = headAdd(2, 4, 3);
		printList(headList);
		System.out.println();
		ListNode tailList = tailAdd(2, 4, 3);
		printList(tailList);
	}
}
