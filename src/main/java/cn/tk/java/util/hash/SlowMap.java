package cn.tk.java.util.hash;

import java.util.*;

/*
*@date: 2016/11/14
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 简化版的
* keys: 相当于 key 的容器
* values: 相当于 value 的容器, value 根据 key 在 keys 中的下标存储
* value 在 values 中的下标与 key 在 keys 中的下标一致
*/
public class SlowMap<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();

    /*
    * @description: 插入 Map
    *
    */
    public V put(K key, V value)
    {
        V oldValue = get(key);
        if (!keys.contains(key))
        {
            keys.add(key);
            values.add(value);
        }else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    public V get(Object key)
    {
        if (!keys.contains(key))
        {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
        Iterator<K> kIterator = keys.iterator();
        Iterator<V> vIterator = values.iterator();
        while (kIterator.hasNext())
            set.add(new MapEntry<K, V>(kIterator.next(), vIterator.next()));
        return set;
    }
}
