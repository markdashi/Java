package com.mj.tree;

import java.util.Comparator;

public class AVLTree<E> extends BST<E> {

	public AVLTree() {
	  this(null);
	}
	public AVLTree(Comparator<E> comparator) {
		super(comparator);
	}
	
	@Override
	protected void afterAdd(Node<E> node) {
		// 找最近的不平衡节点
		while ((node = node.parent) != null) {
			if (isBalanced(node)) { // 平衡
			  // 更新高度
				updateHeight(node); 
				
			}else { // 
				// 恢复平衡
				rebalance(node);
				// 整棵树恢复平衡
				break;
			}
		}
	}
	
	@Override
	protected void afterRemove(Node<E> node) {
		// 找最近的不平衡节点
		while ((node = node.parent) != null) {
			if (isBalanced(node)) { // 平衡
			  // 更新高度
				updateHeight(node); 
				
			}else { // 
				// 恢复平衡
				rebalance(node);
			}
		}
	}
	
	@Override
	protected Node<E> createNode(E element, Node<E> parent) {
		return new AVLNode<>(element, parent);
	}
	
	/**
	 * 判断当前节点是否平衡
	 * @param node
	 * @return
	 */
	private boolean isBalanced(Node<E> node) {
		return Math.abs(((AVLNode<E>)node).balanceFactor()) <= 1;
	}
	
	private void updateHeight(Node<E> node) {
		((AVLNode<E>) node).updateHeight();
	}
	
	/**
	 * 恢复平衡
	 * @param node 高度最低的那个不平衡节点
	 */
	private void rebalance(Node<E> grand) {
		Node<E> parent = ((AVLNode<E>)grand).tallerChild();
		Node<E> node = ((AVLNode<E>)parent).tallerChild();
		
		if (parent.isLeftChild()) { // L
			if (node.isLeftChild()) { // LL
				rotateRight(grand);
			}else { // LR
				rotateLeft(parent);
				rotateRight(grand);
			}
		}else { // R
			if (node.isLeftChild()) { // RL
				rotateRight(parent);
				rotateLeft(grand);
			}else { // RR
				rotateLeft(grand);
			}
		}
	}
	
	/**
	 * 左旋转
	 * @param node
	 */
	private void rotateLeft(Node<E> grand) {
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
	private void rotateRight(Node<E> grand) {
		Node<E> parent = grand.left;
		Node<E> child = parent.right;
		
	   grand.left = child;
	   parent.right = grand;
	   // 维护parent 和 height
	   afterRotate(grand, parent, child);
	}
	private void afterRotate(Node<E> grand,Node<E> parent, Node<E> child) {
		  
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
		   
		   updateHeight(grand);
		   updateHeight(parent);	
	}
	
	private static class AVLNode<E> extends Node<E> {
		int height = 1;
		public AVLNode(E elememt, Node<E> parent) {
			super(elememt, parent);
		}
		// 平衡因子
		public int balanceFactor() {
			int leftHeight = left == null? 0 : ((AVLNode<E>) left).height;
			int rightHeight = right == null? 0 : ((AVLNode<E>) right).height;
			return leftHeight - rightHeight;
		}
		
		/**
		 *  更新高度
		 */
		public void updateHeight() {
			int leftHeight = left == null? 0 : ((AVLNode<E>) left).height;
			int rightHeight = right == null? 0 : ((AVLNode<E>) right).height;
			height =  1 + Math.max(leftHeight, rightHeight);
		}
		public Node<E> tallerChild() {
			int leftHeight = left == null? 0 : ((AVLNode<E>) left).height;
			int rightHeight = right == null? 0 : ((AVLNode<E>) right).height;
			if (leftHeight > rightHeight) return left;
			if (leftHeight < rightHeight) return right;
			return isLeftChild()?left:right;
		}
	}
	

}
