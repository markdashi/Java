package com.mj;

import com.mj.circle.CircleLinkedList;
import com.mj.circle.CircleLinkedList2;
import com.mj.circle.SingleCircleLinkedList;
import com.mj.single.SingleLinkedList;

public class Main {

	// 约瑟夫问题
	static void josephus() {
		CircleLinkedList2<Integer> list = new CircleLinkedList2<Integer>();
		for (int i = 1; i <= 8; i++) {
			list.add(i);
		}
		// 指向头结点
		list.reset();
		
		while (!list.isEmpty()) {
			list.next();
			list.next();
			System.out.println(list.remove());
		}
	}
	
	
	public static void main(String[] args) {
		
		josephus();
		
//		List<Integer> list = new ArrayList<Integer>();
//		test(list);
//		System.out.println(list);
		
//		List<Integer> list2 = new LinkedList<Integer>();
//		test(list2);
//		System.out.println(list2);
		
//		List<Integer> list3 = new SingleCircleLinkedList<Integer>();
//		test(list3);
//		System.out.println(list3);
		
//	    List<Integer> list4 = new CircleLinkedList<Integer>();
//	    test(list4);
//	    System.out.println(list4);
	}
	
	@SuppressWarnings("static-access")
	static private void test(List<Integer> list) {
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		
		list.add(0,55); //  [55,11,22,33,44]
		list.add(2,66); //	[55,11,66,22,33,44]
		list.add(list.size(),77); // [55,11,66,22,33,44,77]
		
		list.remove(0); // [11,66,22,33,44,77]
		list.remove(2); // [11,66,33,44,77]
		list.remove(list.size() - 1); // [11,66,33,44]
		
		Asserts.test(list.indexOf(44) == 3);
		Asserts.test(list.indexOf(22) == list.ELEMENT_NOT_FOUND);
		Asserts.test(list.contains(33));
		Asserts.test(list.get(0) == 11);
		Asserts.test(list.get(1) == 66);
		Asserts.test(list.get(list.size() - 1) == 44);
	}
	
	void test2() {
		List<Integer> list = new ArrayList2<Integer>();
		  for (int i = 0; i < 50; i++) {
			list.add(i);
		  }
		  
		  for (int i = 0; i < 50; i++) {
			list.remove(0);
		} 
		System.out.println(list);
		 
		/**
		 * SoftReference<T>
		 * gc root对象 引用的话对象不会被释放
		 * 1> 被局部变量指向的对象
		 * @param args
		 */
	}
	void test() {
		//List<Integer> list1 = new ArrayList<Integer>();
		
		List<Integer> list = new SingleLinkedList<Integer>();
		
		list.add(20);
		list.add(0, 10);
		list.add(30);
		list.add(list.size(), 40);
		
		list.remove(1);
		
		System.out.println(list);
	}
}
