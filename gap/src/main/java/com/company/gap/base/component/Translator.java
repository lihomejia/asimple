package com.company.gap.base.component;

import java.util.List;

public interface Translator<K, V> {
	
	V translate(K key);
	
	List<V> translate(List<K> keys);

}
