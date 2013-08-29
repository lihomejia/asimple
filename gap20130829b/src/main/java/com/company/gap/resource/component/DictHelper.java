package com.company.gap.resource.component;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.gap.resource.enumeration.DictType;
import com.company.gap.resource.model.Dict;
import com.company.gap.resource.service.IDictService;
import com.company.util.New;

@Component
public class DictHelper {
	
	private static IDictService dictService;
	
	private static Map<Integer, Dict> dicts;
	
	private static Map<DictType, List<Dict>> datas;
	
	
	private synchronized static void init() {
		Map<Integer, Dict> dicts2 = New.hashMap();
		Map<DictType, List<Dict>> datas2 = New.hashMap();
		
		for (DictType type : DictType.values()) {
			datas2.put(type, New.<Dict>arrayList());
		}
		
		for (Dict dict : dictService.findList()) {
			if (!datas2.containsKey(dict.getType())) {
				continue;
			}
			
			dicts2.put(dict.getId(), dict);
			datas2.get(dict.getType()).add(dict);
		}
		
		dicts = dicts2;
		datas = datas2;
	}
	
	private synchronized static Map<DictType, List<Dict>> getDatas() {
		if (datas == null) {
			init();
		}
		
		return datas;
	}
	
	private synchronized static Map<Integer, Dict> getDicts() {
		if (dicts == null) {
			init();
		}
		return dicts;
	}
	
	public static void clearCache() {
		dicts = null;
		datas = null;
	}
	
	public static List<Dict> getList(DictType type) {
		return getDatas().get(type);
	}
	
	public static Dict getDict(Integer id) {
		return getDicts().get(id);
	}
	
	public static String getText(Integer id) {
		Dict dict = getDict(id);
		if (dict == null) return null;
		return dict.getName();
	}
	
	@Autowired
	public void setDictService(IDictService dictService1) {
		dictService = dictService1;
	}
}