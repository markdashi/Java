package com.mj.tree;

import java.util.Comparator;

public class AVLTree<E> extends BBST<E> {

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
	
	@Override
	protected void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
		super.afterRotate(grand, parent, child); 
		// 更新高度
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
		@Override
		public String toString() {
			String parentString = "null";
			if (parent != null) {
				parentString = parent.elememt.toString();
			}
			return elememt + "_p(" + parentString + ")_h(" + height + ")";
		}
	}
	

}
