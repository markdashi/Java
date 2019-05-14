package com.mj;

import com.mj.printer.BinaryTrees;
import com.mj.tree.AVLTree;
import com.mj.tree.BST;

public class Main {
	
	public static void main(String[] args) {
		Integer data[] = new Integer[] {
				7,4,9,10,2,5,8,6,11,3,12,1
			};
		
		AVLTree<Integer> avl = new AVLTree<Integer>();
		for (int i = 0; i < data.length; i++) {
			avl.add(data[i]);
		}
		BinaryTrees.println(avl);
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
