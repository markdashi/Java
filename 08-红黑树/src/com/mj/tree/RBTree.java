package com.mj.tree;

import java.util.Comparator;

public class RBTree<E> extends BBST<E> {
	private static final boolean RED = false;
	private static final boolean BLACK = true;

	public RBTree() {
		this(null);
	}
	public RBTree(Comparator<E> comparator) {
		super(comparator);
	}
	
	private Node<E> color(Node<E> node, boolean color) {
		if (node == null) return node;
		((RBNode<E>)node).color = color;
		return node;
	}
	private Node<E> red(Node<E> node) {
		return color(node, RED);
	}
	private Node<E> black(Node<E> node) {
		return color(node, BLACK);
	}
	private boolean colorOf(Node<E> node) {
		return node == null?BLACK:((RBNode<E>)node).color;
	}
	private boolean isBlack(Node<E> node) {
		return colorOf(node) == BLACK;
	}
	private boolean isRed(Node<E> node) {
		return colorOf(node) == RED;
	}
	

	
	@Override
	protected void afterAdd(Node<E> node) {
		Node<E> parent = node.parent;
		// 添加的是根节点
		if (parent == null) {
			black(node);
			return;
		}
		// 如果父节点是黑色，直接返回
		if (isBlack(parent)) return;

		// uncle节点
		Node<E> uncle = parent.sibling();
		// 祖父节点
		Node<E> grand = parent.parent;
		if (isRed(uncle)) { // uncle 节点是红色
			black(parent);
			black(uncle);
			// 把祖父节点当做是新添加的节点
			afterAdd(red(grand));
			return;
		}
		
		// 叔父节点不是红色
		if (parent.isLeftChild()) { // L
			red(grand);
			if (node.isLeftChild()) { // LL
				black(parent);
			} else { // LR
				black(node);
				rotateLeft(parent);
			}
			rotateRight(grand);
		} else { // R
			red(grand);
			if (node.isLeftChild()) { // RL
			   black(node);
			   rotateRight(parent);
			} else { // RR
				black(parent);
			}
			rotateLeft(grand);
		}
		
		
//		// 叔父节点不是红色
//		if (parent.isLeftChild()) { // L
//			if (node.isLeftChild()) { // LL
//				black(parent);
//				red(grand);
//				rotateRight(grand);
//			} else { // LR
//				black(node);
//				red(grand);
//				rotateLeft(parent);
//				rotateRight(grand);
//			}
//		} else { // R
//			if (node.isLeftChild()) { // RL
//			   black(node);
//			   red(grand);
//			   rotateRight(parent);
//			   rotateLeft(grand);
//			} else { // RR
//				black(parent);
//				red(grand);
//				rotateLeft(grand);
//			}
//		}
		
	}
	@Override
	protected Node<E> createNode(E element, Node<E> parent) {
		return new RBNode<>(element, parent);
	}
    private static class RBNode<E> extends Node<E> {
		boolean color;
    	public RBNode(E elememt, Node<E> parent) {
			super(elememt, parent);
		}
    	@Override
    	public String toString() {
    		String str = "";
    		if (color == RED) {
    			str = "R_";
			}
    		return str + elememt.toString();
    	}
    }
	

}
