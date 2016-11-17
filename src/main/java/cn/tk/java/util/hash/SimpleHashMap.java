package cn.tk.java.util.hash;

import java.util.*;

/*
*@date: 2016/11/16
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 简化版 HashMap
*/
public class SimpleHashMap<K, V> extends AbstractMap<K, V>{

    public static final int SIZE = 997;
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    /*
    * @description: 用迭代器迭代列表, 也可以用 foreach
    */
    @Override
    public V get(Object key)
    {
        int index = key.hashCode() % SIZE;
        final LinkedList<MapEntry<K, V>> bucket = buckets[index];
        if (bucket == null) return null;

        final Iterator<MapEntry<K, V>> iterator = bucket.iterator();
        while (iterator.hasNext())
        {
            final MapEntry<K, V> entry = iterator.next();
            if (key.equals(entry.getKey()))
                return entry.getValue();
        }
        return null;
    }

    /*
    * @description: 简化版 HashMap: 数组 + 链表 实现
    * 1. 哈希算法求数组下标索引
    * 2. 判断索引处桶位是否为空
    * 3. 空桶: 创建桶位, 非空桶: 遍历查找
    * 4. 存在相同 value 直接覆盖节点
    * 5. 没有相同 value, 新建节点然后将节点放到桶位链表最后
    * 迭代列表可以使用 foreach
    */
    public V put(K key, V value)
    {
        V oldValue = null;
        int index = key.hashCode() % SIZE;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        final Iterator<MapEntry<K, V>> iterator = bucket.iterator();
        boolean found = false;
        while (iterator.hasNext())
        {
            MapEntry<K, V> entry = iterator.next();
            if(key.equals(entry.getKey()))//比较key值, 桶位相同, key值也相同, 必须覆盖, 桶位相同, key 值可能不相同
            {
                found = true;//找到相同取值节点
                oldValue = entry.getValue();//oldValue取出返回
                entry.setValue(value);//value覆盖
                break;
            }
        }
        if (!found)//未找到相同取值节点
            bucket.add(new MapEntry<K, V>(key, value));
        return oldValue;
    }

    /*
    * @description: 所有元素的打印, 将所有元素 MapEntry 放入一个集合
    */
    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets)
        {
            if (bucket == null) {
                continue;
            }
            for (MapEntry<K, V> mpair : bucket) {
                set.add(mpair);
            }
        }
        return set;
    }
}
