package com.yedam.java.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class test {
	public static void main(String[] args) {

//		Map<String, Integer> map = new HashMap<String, Integer>();
//
//		map.put("sda", 51);
//		map.put("qwas", 5078);

//		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
//
//		while (entryIterator.hasNext()) {
//			Map.Entry<String, Integer> entry = entryIterator.next();
//			entry.getKey();
//			entry.getValue();
//		}


		Map<String,Integer> map =new HashMap<String,Integer>();
		map.put("qwe",123);
		map.put("qasvc", 56312);
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator =entrySet.iterator();
		while(entryIterator.hasNext()) 
		{
			
		}
				
	}
}
