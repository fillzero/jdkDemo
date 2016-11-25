package cn.tk.java.util.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import com.google.common.base.Preconditions;

/**
 * @description:Collections 集合类
 */
public class CollectionsDemo {
	/**
	 * @description:排序
	 */
	@Test
	public void testSort() {
		List<Double> list = new ArrayList<Double>();
		double array[] = { 112, 111, 23, 456, 231 };
		for (int i = 0; i < array.length; i++) {
			list.add(new Double(array[i]));
		}
		Collections.sort(list);
		for (int i = 0; i < array.length; i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * @description:混排
	 */
	@Test
	public void testShuffle() {
		List<Double> list = new ArrayList<Double>();
		double array[] = { 112, 111, 23, 456, 231 };
		for (int i = 0; i < array.length; i++) {
			list.add(new Double(array[i]));
		}
		Collections.shuffle(list);
		for (int i = 0; i < array.length; i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * @description:反转
	 */
	@Test
	public void testReverse() {
		List<Double> list = new ArrayList<Double>();
		double array[] = { 112, 111, 23, 456, 231 };
		for (int i = 0; i < array.length; i++) {
			list.add(new Double(array[i]));
		}
		Collections.reverse(list);
		for (int i = 0; i < array.length; i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * @description:替换， 用指定元素替换容器中所有元素
	 */
	@Test
	public void testFill() {
		List<String> list = new ArrayList<String>();
		String str[] = { "dd", "aa", "bb", "cc", "ee" };
		for (int j = 0; j < str.length; j++) {
			list.add(new String(str[j]));
		}
		Collections.fill(list, "aaa");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list[" + i + "]=" + list.get(i));
		}
	}

	/**
	 * @description:copy(List dest, List src): src > dest 越界异常
	 * copy 就是用小集合数据替换大集合数据前面的一部分
	 */
	@Test
	public void testCopy() {
		double array1[] = { 112, 111, 23, 456, 231 };
		List<Double> list1 = new ArrayList<Double>();
		List<Double> list2 = new ArrayList<Double>();
		for (int i = 0; i < array1.length; i++) {
			list1.add(new Double(array1[i]));
		}
		double array2[] = { 1131, 333 };
		for (int j = 0; j < array2.length; j++) {
			list2.add(new Double(array2[j]));
		}
		Collections.copy(list1, list2);
		for (int i = 0; i < list1.size(); i++) {
			System.out.println("list1[" + i + "]=" + list1.get(i));
		}
	}
	
	public static List<Integer> bonusGenerator(int min,int max,int size,int amount) {
		Preconditions.checkArgument((size * min <= amount) && (size * max >= amount));
		int aveCeil = (int) Math.ceil((double)amount / size);
		int aveFloor = (int) Math.floor((double)amount / size);
		int[] res;
		if(aveFloor != aveCeil) {
			int x,y;
			y = aveCeil * size - amount;
			x = amount - aveFloor * size;
			int[] floors = new int[y];
			Arrays.fill(floors, aveFloor);
			int[] ceils = new int[x];
			Arrays.fill(ceils, aveCeil);
			res = ArrayUtils.addAll(shuffle(floors,min,max), shuffle(ceils,min,max));
		}
		else {
			int[] aves = new int[size];
			Arrays.fill(aves, aveCeil);
			res = shuffle(aves, min, max);
		}
		List<Integer>list = new ArrayList<>();
		for(int m:res) {
			list.add(m);
		}
		Collections.shuffle(list);
		return list;
	}
	
	public static int[] shuffle(int[] datas,int min, int max) {
		int sample = datas[0];
		if(sample == min || sample == max) return datas;
		if((double)sample / min <= 1.2) return sideShuffle(datas,min,max);
		if((double)sample / max >= 0.8) return sideShuffle(datas,min,max);
		return strictShuffle(datas,min,max);
	}
	
	public static int[] strictShuffle(int[] datas, int min, int max) {
		int i = 0;
		while(i < datas.length - 2) {
			int l0 = datas[i];
			int l1 = datas[i+1];
			int p = (RandomUtils.nextInt(min, max) * 2 - l0 - l1) / 2;
			if((min <= l0 + p) &&(l0 + p <= max) && (min <= l1 - p) && (l1 - p <= max)) {
				datas[i] = l0 + p;
				datas[i+1] = l1 - p;
			}
			i+=2;
		}
		return datas;
	}
	
	public static int[] sideShuffle(int[] datas, int min, int max) {
		int i = 0;
		while(i < datas.length) {
			int currentValue = datas[i];
			int interval = (int) Math.floor((double)(max - min) / 13);
			if(interval == 0) interval = 1;
			int p = (RandomUtils.nextInt(min, max)-currentValue) / interval;
			if(Math.abs(p) > (datas.length - i - 2)) break;
			datas[i] = currentValue + p * interval;
			int signnum = Integer.signum(p);
			for(int j = 1;j<=Math.abs(p);j++) {
				int value = datas[++i];
				datas[i] = value - signnum * interval;
			}
			i++;
		}
		return strictShuffle(datas,min,max);
	}
}
