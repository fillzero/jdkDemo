package cn.tk.java.util.collections;

import java.util.Map;

import lombok.Setter;

/**
 * @Author: lijl85
 * @Title: SimpleTreeMap.java
 * @Package: cn.tk.java.util.collections
 * @Time: 2016年10月24日下午2:45:01
 *
 * @description:编写简略版红黑树
 * 基本性质：
 * 1. 所有结点只能是黑色或是红色
 * 2. 根节点是黑色的
 * 3. 叶节点（Nil节点）是黑色的 
 * 4. 红色节点的两个子节点都是黑色的（红色节点不连续）
 * 5. 任何节点黑高度不变（黑高度： 任何节点到其子树叶节点的所有路径包含相同数量黑色节点）
 * 
 * 实现：
 * 1. 基本操作：
 * 		构造红黑树（插入，调整）
 * 		前序遍历
 * 		中序遍历
 * 		后序遍历
 * 		查找元素
 * 		最大元素
 * 		最小元素
 * 2. 左旋，右旋
 * 3. 插入 --> 插入调整
 * 4. 删除 --> 删除调整
 * 
 * 问题： 
 * 1. 为什么新插入的结点涂成红色：为了不违反第五条性质，新插入节点保持黑高度不变，调整颜色维护 RBTree
 * 2. 最短路径： 全黑节点路径; 最长路径：黑红交替路径; Bh(x) >= Rh(x)， 
 * 		min = Bh(x), max = Bh(x) + Rh(x)， 最长路径不会超出最短路径两倍， 保证红黑树最坏操作时间复杂度不会太差，可以保持稳定。
 * 3. 红黑树调整过程： 旋转 --> 重新着色
 * 4. 关联知识点： 2-3-4 树， B树 --> 关系型数据库
 * 5. 二叉排序树（包含 BRTree）的基本操作时间复杂度取决于树的高度， 所以计算树高的过程其实就是一个求解基本操作时间复杂度的过程。
 */
public class RBTree {
	@Setter
	private transient Entry<String,String> root;
	
    /**
     * @description:左旋，传入旋转中心
     * 
     * 左旋只有两个结点位置变化了： p， r（p 变成了 r 的左子树）
     * 两个结点： 四条链接变换
     */
    public void rotateLeft(Entry<String,String> p) {
        if (p != null) {
            Entry<String,String> r = p.right;
            p.right = r.left;
            if (r.left != null)
                r.left.parent = p;
            r.parent = p.parent;
            if (p.parent == null)
                root = r;
            else if (p.parent.left == p)
                p.parent.left = r;
            else
                p.parent.right = r;
            r.left = p;
            p.parent = r;
        }
    }

    /**
     * @description:右旋，传入旋转中心， 父子位置互换
     */
    public void rotateRight(Entry<String, String> p) {
        if (p != null) {
            Entry<String,String> l = p.left;
            p.left = l.right;
            if (l.right != null) l.right.parent = p;
            l.parent = p.parent;
            if (p.parent == null)
                root = l;
            else if (p.parent.right == p)
                p.parent.right = l;
            else p.parent.left = l;
            l.right = p;
            p.parent = l;
        }
    }
	
	private static final boolean RED   = false;
	private static final boolean BLACK = true;
	
	/**
	 * @Author: lijl85
	 * @description: Entry 类， TreeMap 中的结点类
	 */
	static final class Entry<K, V> implements Map.Entry<K, V> {
		K key;
		V value;
		Entry<K, V> left;
		Entry<K, V> right;
		Entry<K, V> parent;
		boolean color = BLACK;
		
		Entry(K key, V value, Entry<K, V> parent) {
			this.key = key;
			this.value = value;
			this.parent = parent;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}

		public boolean equals(Object o) {
			if (!(o instanceof Map.Entry))
				return false;
			Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;

			return valEquals(key, e.getKey()) && valEquals(value, e.getValue());
		}

		public int hashCode() {
			int keyHash = (key == null ? 0 : key.hashCode());
			int valueHash = (value == null ? 0 : value.hashCode());
			return keyHash ^ valueHash;
		}

		public String toString() {
			return key + "=" + value;
		}
	}
	
    /**
     * @description:比较两个对象
     */
    static final boolean valEquals(Object o1, Object o2) {
        return (o1==null ? o2==null : o1.equals(o2));
    }
}
