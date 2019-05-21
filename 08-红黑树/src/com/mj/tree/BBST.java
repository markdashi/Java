package com.mj.tree;

import java.util.Comparator;

import com.mj.tree.BinaryTree.Node;

public class BBST<E> extends BST<E> {

	public BBST() {
		this(null);
	}
	public BBST(Comparator<E> comparator) {
		super(comparator);
	}
	/**
	 * 左旋转
	 * @param node
	 */
	protected void rotateLeft(Node<E> grand) {
       // p child g
		Node<E> parent = grand.right;
		Node<E> child = parent.left;
		
		grand.right = child;
		parent.left = grand;
		
		// 维护parent 和 height
		 afterRotate(grand, parent, child);
	}
	/**
	 * 右旋转
	 * @param node
	 */
	protected void rotateRight(Node<E> grand) {
		Node<E> parent = grand.left;
		Node<E> child = parent.right;
		
	   grand.left = child;
	   parent.right = grand;
	   // 维护parent 和 height
	   afterRotate(grand, parent, child);
	}
	protected void afterRotate(Node<E> grand,Node<E> parent, Node<E> child) {
		  
		// 让parent称为子树的根节点
		 parent.parent = grand.parent;
		// 让旋转后的节点称为这棵树的根节点
		   if (grand.isLeftChild()) {
			   grand.parent.left = parent;
		   }else if (grand.isRightChild()) {
			   grand.parent.right = parent;
		   }else {
			   root = parent;
		   }
		   
		   // 维护parent和height
		  if (child != null) {
			  child.parent = grand;
		  }
		   grand.parent = parent;
	}

}
