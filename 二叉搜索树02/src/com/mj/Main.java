package com.mj;

import com.mj.printer.BinaryTrees;
import com.mj.tree.AVLTree;
import com.mj.tree.BST;

public class Main {
	
	public static void main(String[] args) {

		Integer data[] = new Integer[] {
				51, 77, 59, 47
		};
		
		AVLTree<Integer> avl = new AVLTree<>();
		for (int i = 0; i < data.length; i++) {
			avl.add(data[i]);
		}
		BinaryTrees.println(avl);
		System.out.println("------------\n");
		avl.remove(77);
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
