package com.mj;

import java.util.Comparator;

import com.mj.printer.BinaryTrees;
import com.mj.printer.BinaryTrees.PrintStyle;

public class Main {

	private static class PersonComparator implements Comparator<Person>{
		@Override
		public int compare(Person o1, Person o2) {
			return o1.getAge() - o2.getAge();
		}
		
	} 
	
	public static void main(String[] args) {
		
		test2();
//		Integer data[] = new Integer[] {
//			7,4,9,2,5,8,11,3,12,1	
//		};
//		BinarySearchTree<Integer> bst0 = new BinarySearchTree<Integer>();
//		for (int i = 0; i < data.length; i++) {
//			bst0.add(data[i]);
//		}
//		BinaryTrees.println(bst0);
			
	}
	
	public static void test2() {
		
		Integer data[] = new Integer[] {
				7,4,9,2,5,8,11,3,12,1	
			};
		
		BinarySearchTree<Person> bst = new BinarySearchTree<>(new PersonComparator());
		
		for (int i = 0; i < data.length; i++) {
			bst.add(new Person(data[i]));
		}
		BinaryTrees.println(bst);
	}
	private static void test() {
		// 这样可以定义Person  二叉搜索树 节点的比较方法
		// 默认是之前自定义的比较方法
		BinarySearchTree<Person> bst = new BinarySearchTree<>(new PersonComparator());
		bst.add(new Person(10));
		bst.add(new Person(11));
		bst.add(new Person(12));
		
		// 匿名类实现定义构造器
		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		bst2.add(new Person(10));
		bst2.add(new Person(11));
		bst2.add(new Person(12));
		
	}
}
