package se;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map
 * Map看起来像一个多行两列的表格，以key-value的形式存储元素
 * 其中key不允许重复(equals比较)，常用实现类:HashMap
 * @author liurenyou
 *
 */
public class MapDemo {
	public static void main(String[] args) {
		Map<String,Integer> m =new HashMap<String,Integer>();
		/*
		 * 将给定key-value信息存入Map中
		 * V put(K k,V v)
		 * 由于Map要求key不能重复，所以若给定的key在Map
		 * 中已经存在，则是替换value操作
		 */
		m.put("数学", 90);
		m.put("语文", 91);
		m.put("英语", 93);
		m.put("物理", 94);
		System.out.println("初始:"+m);
		m.put("数学",95);
		System.out.println("修改后:"+m);
		
		/*
		 * 根据key获取对应value
		 * V get(K k) 
		 * 若key不存在则返回null
		 * 注意:若value是包装类类型时，尽量不要用其对应的
		 * 基本类型变量接收，避免自动拆箱导致空指针出现
		 */
		System.out.println("数学成绩:"+m.get("数学"));
		
		/*
		 * 判断当前Map中是否包含给定的key或value (equals原则)
		 * boolean containsKey()
		 * boolean containsValue()
		 */
		boolean ck = m.containsKey("体育");
		boolean cv = m.containsValue(95);
		System.out.println("体育:"+ck+" 95:"+cv);
		
		/*
		 * 遍历所有key
		 * Set<K> keySet()
		 * 将Map中的所有key存入一个Set集合返回，此时遍历该集合
		 * 就相当于遍历了Map中的所有key
		 */
		Set<String> keySet = m.keySet(); 
		for(String str : keySet) {
			System.out.println("key:"+str);
		}
		
		/*
		 * 遍历每组键值对
		 * Set<Enter> entrySet()
		 * 将每组键值对存入一个Set集合返回，entry是Mapd额内部类，
		 * 每一个实例用于表示Map中的一组键值对
		 */
		Set<Entry<String,Integer>> entrySet = m.entrySet();
		for(Entry<String,Integer> e : entrySet) {
			String s = e.getKey();
			Integer v = e.getValue();
			System.out.println("key:"+s+" value:"+v);
		}
		
		/*
		 * 遍历所有value (很少使用)
		 * Collection value()
		 * 将所有value存入一个集合返回
		 */
		Collection<Integer> c = m.values();
		for(Integer i : c) {
			System.out.println("value:"+i);
		}
	}
}
