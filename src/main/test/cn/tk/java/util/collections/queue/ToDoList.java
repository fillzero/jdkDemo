package cn.tk.java.util.collections.queue;

import java.util.PriorityQueue;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: lijl85
 * @date：2016年11月13日下午5:16:03
 * @description:ToDoList: 列表元素, 按照 PriorityQueue 进行排序, 定制传入比较器
 *
 * 实现定制版优先队列.
 */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
	private static final long serialVersionUID = 4380419054774307560L;

	/**
	 * @author: lijl85
	 * @date：2016年11月13日下午5:14:48
	 * @description: ToDoList中待比较元素
	 */
	class ToDoItem implements Comparable<ToDoItem>{
		@Getter @Setter private char primary;
		@Getter @Setter private int secondary;
		@Getter @Setter private String item;

		public ToDoItem(String item, char primary, int secondary) {
			super();
			this.primary = primary;
			this.secondary = secondary;
			this.item = item;
		}

		/**
		 * 定制比较器
		 */
		@Override
		public int compareTo(ToDoItem item) {
			if(primary > item.primary)
				return +1;
			if(primary == item.primary)
				if(secondary > item.secondary)
					return +1;
				else if(secondary == item.secondary)
					return 0;
			return -1;
		}

		@Override
		public String toString()
		{
			return Character.toString(primary) +
					secondary + ": " + item;
		}
	}

	public void add(String item, char primary, int secondary)
	{
		super.add(new ToDoItem(item, primary, secondary));
	}
}
