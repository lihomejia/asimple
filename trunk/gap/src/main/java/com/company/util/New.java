package com.company.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 助手类,协助泛型对象的声明和初始化(也仅仅是这个作用).
 * <pre>
 * Collections中的常用类:
 * ArrayList:最常用的List
 * HashMap:利用散列算法,针对key的hashCode计算一个int值,以此值为数组下标将元素放置到"容器数组"中(数组中的每个容器称为"桶",
 *  第一个来到这个桶的元素,将占据第一个位置,后来的则作为它的next),这样在定位该元素时候,查询的次数也就不会和数据量成正比了.
 *  如果hash算法足够好,每个元素都会占据不同的桶,查询就能做到一次到位,但是这个仅仅是理想的.
 *  <B>因此:作为key的对象,它的hashCode结果是"不变"的,否则可能会引起数据掉入黑洞.谨慎修改作为key的类的hashCode和equalto函数.</B>
 * ConcurrentHashMap:HashMap的线程安全版本.
 * LinkedHashMap:HashMap
 * HashSet:
 * 
 * </pre>
 * @author zy.fang
 */
public abstract class New {

	/**
	 * 产生一个ArrayList
	 * 
	 * @param <T>
	 * @return
	 */
	public static <T> ArrayList<T> arrayList() {
		return new ArrayList<T>();
	}

	/**
	 * 产生一个ArrayList,使用指定的数据.
	 * 
	 * @param <T>
	 * @param c
	 * @return
	 */
	public static <T> ArrayList<T> arrayList(Collection<T> c) {
		return new ArrayList<T>(c);
	}

	/**
	 * 产生一个线程安全的Map
	 * 
	 * @param <K>
	 * @param <V>
	 * @return
	 */
	public static <K, V> ConcurrentHashMap<K, V> conMap() {
		return new ConcurrentHashMap<K, V>();
	}

	/**
	 * 产生一个线程安全的Map,使用指定的Map数据.
	 * 
	 * @param <K>
	 * @param <V>
	 * @param m
	 * @return
	 */
	public static <K, V> ConcurrentHashMap<K, V> conMap(Map<K, V> m) {
		return new ConcurrentHashMap<K, V>(m);
	}

	/**
	 * 产生一个HashMap
	 * 
	 * @param <K>
	 * @param <V>
	 * @return
	 */
	public static <K, V> HashMap<K, V> hashMap() {
		return new HashMap<K, V>();
	}

	/**
	 * 产生一个HashMap,使用指定的Map数据.
	 * 
	 * @param <K>
	 * @param <V>
	 * @param m
	 * @return
	 */
	public static <K, V> HashMap<K, V> hashMap(Map<K, V> m) {
		return new HashMap<K, V>(m);
	}

	/**
	 * 产生一个HashSet.
	 * 
	 * @param <E>
	 * @return
	 */
	public static <E> HashSet<E> hashSet() {
		return new HashSet<E>();
	}

	/**
	 * 产生一个HashSet,使用指定的Collection数据(注意:如果Collection中数据有"重复",结果的数据量会少于初始化数据量)
	 * 
	 * @param <E>
	 * @param c
	 * @return
	 */
	public static <E> HashSet<E> hashSet(Collection<E> c) {
		return new HashSet<E>(c);
	}

	/**
	 * 产生一个LinkedHashMap(具有记录数据加入顺序的功能)
	 * 
	 * @param <K>
	 * @param <V>
	 * @return
	 */
	public static <K, V> LinkedHashMap<K, V> linkedMap() {
		return new LinkedHashMap<K, V>();
	}

	/**
	 * 产生一个LinkedHashMap
	 * 
	 * @param <K>
	 * @param <V>
	 * @param m
	 * @return
	 */
	public static <K, V> LinkedHashMap<K, V> linkedMap(Map<K, V> m) {
		return new LinkedHashMap<K, V>(m);
	}

	/**
	 * 产生一个LinkedHashSet
	 * 
	 * @param <E>
	 * @return
	 */
	public static <E> LinkedHashSet<E> linkedSet() {
		return new LinkedHashSet<E>();
	}

	/**
	 * 产生一个LinkedHashSet
	 * 
	 * @param <E>
	 * @param c
	 * @return
	 */
	public static <E> LinkedHashSet<E> linkedSet(Collection<E> c) {
		return new LinkedHashSet<E>(c);
	}

	/**
	 * 返回一个线程安全的lru算法map,因为大部分情况下,lru都是作为缓存存在的,因此直接将其制作成线程安全.
	 * 
	 * @param <K>
	 * @param <V>
	 * @param size 最大容量.
	 * @return
	 */
	public static <K, V> Map<K, V> lruMap(final int size) {
		return (Map<K, V>) Collections.synchronizedMap(new LinkedHashMap<K, V>(size, 0.80f, true) {
			private static final long serialVersionUID = 4594826154977507530L;

			@Override
			protected boolean removeEldestEntry(Entry<K, V> eldest) {
				return size() > size;
			}
		});
	}

	

	private New() {}
}
