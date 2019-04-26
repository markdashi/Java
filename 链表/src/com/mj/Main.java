package com.mj;

import java.util.Iterator;

import com.mj.single.SingleLinkedList;

public class Main {

	public static void main(String[] args) {
		  List<Integer> list = new ArrayList2<Integer>();
		  for (int i = 0; i < 50; i++) {
			list.add(i);
		  }
		  
		  for (int i = 0; i < 50; i++) {
			list.remove(0);
		} 
		System.out.println(list);
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
