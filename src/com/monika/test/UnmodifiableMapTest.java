package com.monika.test;

import com.monika.test.domain.Point;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * Collections.unmodifiableMap(map)返回指定Map的不可修改视图。客户端不能进行改变数据的行为。
 *  注：Collections.unmodifiableMap实际上只为您提供保护，即无法更改对map中保存的对象的引用。
 *      只是通过了put、remove、putAll、clear方法限制了返回的map，
 *      但是，仍然可以从类外部修改原始封装映射，因为Collections.unmodifiableMap不会生成map映射内容的任何副本。
 */
public class UnmodifiableMapTest {
	private Map<String, Point> map = new HashMap<>();

	public UnmodifiableMapTest() {
		map.put("China", new Point(1, 1));
		map.put("USA", new Point(2, 2));
		//...
	}

	public Map<String, Point> getUnmodifiableMapTest(){
		return Collections.unmodifiableMap(map);
	}

	public static void main(String[] args) {
		UnmodifiableMapTest test = new UnmodifiableMapTest();
		Map<String, Point> umap = test.getUnmodifiableMapTest();

		String location = "China";
		Point point = umap.get(location);
		System.out.println(String.format("key=%s , value=%s", location,point));

		try {
			umap.put(location, new Point(11,11));
		}catch (UnsupportedOperationException e) {
			//不能通过put方法去改变map视图
			System.err.println(String.format("map put [key=%s] error, [value=%s]", location,umap.get(location)));
		}

		//从外部修改map内部映射
		point.setXY(22, 22);
		System.out.println(String.format("map put [key=%s] success, [value=%s]",location,umap.get(location)));
	}
}	
/**
 * 打印的结果：
 * 		key=China , value=Point [x=1, y=1]
 *		map put [key=China] success, [value=Point [x=22, y=22]] 
 *		map put [key=China] error, [value=Point [x=1, y=1]]
 */


