package cn.tk.java.util.queue;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import com.alibaba.fastjson.JSON;

/**
 * @description:存放红包的队列
 */
@SuppressWarnings("unchecked")
public class StatisticsQueue<T extends StatisticsAvaliable> implements Queue<T>, Serializable{
	
	private static final long serialVersionUID = -1419457143819185612L;
	
	private final Queue<T> queue ;
	private final Map<String,AtomicInteger> statisticsMap = new ConcurrentHashMap<String,AtomicInteger>();

	
	public StatisticsQueue(Class<? extends Queue> clazz) throws InstantiationException, IllegalAccessException {
		queue = (Queue<T>) clazz.newInstance();
	}
	
	public StatisticsQueue(Queue<? extends T> queue) {
		this.queue = (Queue<T>) queue;
	}
	
	public StatisticsQueue(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clazz = Class.forName(className);
		if(clazz.isAssignableFrom(Queue.class)) {
			queue = (Queue<T>) clazz.newInstance();
		}else
			throw new InstantiationException();
	}
	
	
	public StatisticsQueue() {
		queue = new LinkedBlockingQueue<>();
	}

	@Override
	public boolean add(T element) {
		boolean b = queue.add(element);
		increaseOne(element);
		return b;
	}

	@Override
	public boolean addAll(Collection<? extends T> elements) {
		boolean b = queue.addAll(elements);
		for(T e:elements) {
			increaseOne(e);
		}
		return b;
	}
	
	@Override
	public void clear() {
		queue.clear();
		statisticsMap.clear();
	}
	
	public Map<String,AtomicInteger> getStatisticsMap() {
		return statisticsMap;
	}

	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public boolean contains(Object obj) {
		return queue.contains(obj);
	}

	@Override
	public Iterator<T> iterator() {
		return queue.iterator();
	}
	
	@Override
	public Object[] toArray() {
		return queue.toArray();
	}

	@Override
	public boolean remove(Object obj) {
		boolean b = queue.remove(obj);
		T e = (T) obj;
		decreaseOne(e);
		return b;
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		return queue.containsAll(collection);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		boolean b = queue.removeAll(collection);
		for(Object e:collection) {
			decreaseOne((T) e);
		}
		return b;
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		boolean b = queue.retainAll(collection);
		statisticsMap.clear();
		for(Object e:collection) {
			increaseOne((T) e);
		}
		return b;
	}

	@SuppressWarnings("hiding")
	public <T> T[] toArray(T[] a) {
		return queue.toArray(a);
	}

	@Override
	public T element() {
		return queue.element();
	}

	@Override
	public boolean offer(T e) {
		boolean b = queue.offer(e);
		if(b) {
			increaseOne(e);
		}
		return b;
	}

	@Override
	public T remove() {
		T t = queue.remove();
		decreaseOne(t);
		return t;
	}

	@Override
	public T poll() {
		T t = queue.poll();
		if(t != null) {
			decreaseOne(t);
		}
		return t;
	}

	@Override
	public T peek() {
		return queue.peek();
	}

	private void increaseOne(T key) {
		try {
		String realkey = key.getStatisticalAttribute();
		if(realkey == null) {
			System.out.println(JSON.toJSONString(key));
		}
		AtomicInteger i = statisticsMap.get(realkey);
		if(i == null) {
			synchronized(statisticsMap) {
				AtomicInteger j = statisticsMap.get(realkey);
				if(j == null) {
					statisticsMap.put(realkey, new AtomicInteger(1));
				}else 
					j.incrementAndGet();
			}
		}else {
			i.incrementAndGet();
		}}
		catch(Exception e) {
			System.out.println(queue.size());
			System.out.println();
		}
		
	}
	
	private void decreaseOne(T key) {
		if(key == null) return;
		String realkey = key.getStatisticalAttribute();
		AtomicInteger i = statisticsMap.get(realkey);
		if(i == null) {
			synchronized (statisticsMap) {
				AtomicInteger j = statisticsMap.get(realkey);
				if(j == null) {
					statisticsMap.put(realkey, new AtomicInteger(-1));
				}else 
					j.decrementAndGet();
			}
		}else
			i.decrementAndGet();
	}
}
