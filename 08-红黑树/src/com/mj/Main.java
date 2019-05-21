package com.mj;

import com.mj.printer.BinaryTrees;
import com.mj.tree.AVLTree;
import com.mj.tree.BST;
import com.mj.tree.RBTree;

public class Main {
	
	public static void main(String[] args) {

		test3();
	}
	
	
	private static void test3() {
		Integer data[] = new Integer[] {
				99, 11, 56, 31, 54, 68, 78, 13, 87, 8
		};
		
		RBTree<Integer> rb = new RBTree<>();
		for (int i = 0; i < data.length; i++) {
			rb.add(data[i]);
			System.out.println("【" + data[i] + "】");
			BinaryTrees.println(rb);
			System.out.println("--------------------------------------");
		}
	}
	
	private static void test1() {
		Integer data[] = new Integer[] {
				19, 72, 73, 6, 28, 65, 62, 31
		};
		
		AVLTree<Integer> avl = new AVLTree<>();
		for (int i = 0; i < data.length; i++) {
			avl.add(data[i]);
		}
		BinaryTrees.println(avl);
	}
	
	private void test2() {
		Integer data[] = new Integer[] {
				83, 74, 92, 61, 11
		};
		
		AVLTree<Integer> avl = new AVLTree<>();
		for (int i = 0; i < data.length; i++) {
			avl.add(data[i]);
			System.out.println("【" + data[i] + "】");
			BinaryTrees.println(avl);
			System.out.println("--------------------------------------");
		}
		
		//BinaryTrees.println(avl);
	}
	
	private static void test() {
		Integer data[] = new Integer[] {
			7,4,9,10,2,5,8,6,11,3,12,1
		};
		
		BST<Integer> bst = new BST<Integer>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		BinaryTrees.println(bst);
		
		bst.remove(9);
		BinaryTrees.println(bst);
	}
}
