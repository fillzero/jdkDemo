package cn.tk.java.util.hash;

import java.util.*;

/*
*@date: 2016/11/14
*@author: Michael_Li
*@mail: ljldeepinit@163.com
*@description: 简化版的
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

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<Entry<K, V>>();
        Iterator<K> kIterator = keys.iterator();
        Iterator<V> vIterator = values.iterator();
        while (kIterator.hasNext())
            set.add(new MapEntry<K, V>(kIterator.next(), vIterator.next()));
        return set;
    }
}























