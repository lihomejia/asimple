package com.company.gap.pesticide.component;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.gap.pesticide.enumeration.PesticideResourceType;
import com.company.gap.pesticide.model.Resource;
import com.company.gap.pesticide.service.IPesticideResourceService;
import com.company.util.New;

@Component
public class PesticideResourceHelper {
	
	private static IPesticideResourceService resourceService;
	
	private static Map<Integer, Resource> resources;
	
	private static Map<PesticideResourceType, List<Resource>> datas;
	
	private synchronized static void init() {
		Map<Integer, Resource> resources2 = New.hashMap();
		Map<PesticideResourceType, List<Resource>> datas2 = New.hashMap();
		
		for (PesticideResourceType type : PesticideResourceType.values()) {
			datas2.put(type, New.<Resource>arrayList());
		}
		
		for (Resource resource : resourceService.findList()) {
			if (!datas2.containsKey(resource.getType())) {
				continue;
			}
			resources2.put(resource.getId(), resource);
			datas2.get(resource.getType()).add(resource);
		}
		
		resources = resources2;
		datas = datas2;
	}
	
	private synchronized static Map<PesticideResourceType, List<Resource>> getDatas() {
		if (datas == null) {
			init();
		}
		
		return datas;
	}
	
	private synchronized static Map<Integer, Resource> getResources() {
		if (resources == null) {
			init();
		}
		return resources;
	}
	
	public static void clearCache() {
		resources = null;
		datas = null;
	}
	
	public static List<Resource> getList(PesticideResourceType type) {
		return getDatas().get(type);
	}
	
	public static List<Resource> getList(PesticideResourceType type, Resource top) {
		List<Resource> list = getList(type);
		List<Resource> ret = New.arrayList();
		if (top != null) {
			ret.add(top);
		}
		if (list != null) {
			ret.addAll(list);
		}
		return ret;
	}
	
	
	public static Resource getResource(Integer id) {
		return getResources().get(id);
	}
	
	public static String getText(Integer id) {
		Resource resource = getResource(id);
		if (resource == null) return null;
		return resource.getName();
	}
	
	@Autowired
	public void setResourceService(IPesticideResourceService resourceService1) {
		resourceService = resourceService1;
	}
}