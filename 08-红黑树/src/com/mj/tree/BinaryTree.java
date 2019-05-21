package com.mj.tree;

import java.util.LinkedList;
import java.util.Queue;
import com.mj.printer.BinaryTreeInfo;
@SuppressWarnings("unchecked")
public class BinaryTree<E> implements BinaryTreeInfo{

	protected int size = 0;
	protected Node<E> root;
	
	public int size() {
	    return size;
	}
    public boolean isEmpty() {
    	return size == 0;
    }
    public void clear() {
		root = null;
		size = 0;
	}
    /**
     *  前序遍历
     */
    public void preorderTraversal() {
		preorderTraversal(root);
	}
    private void preorderTraversal(Node<E> node) {
		if (node == null) return;
    	System.out.println(node.elememt);
    	preorderTraversal(node.left);
    	preorderTraversal(node.right);
	}
    
    /**
     *  中序遍历
     */
    public void inorderTraversal() {
    	inorderTraversal(root);

    }
    public void inorderTraversal(Node<E> node) {
    	if (node == null) return;
    	inorderTraversal(node.left);
    	System.out.println(node.elememt);
    	inorderTraversal(node.right);
    }

    // 左 2 -> 1  打印出1
    // 右 1 
    /**
     * 后序遍历
     * 
     */
    public void postorderTraversal() {
    	postorderTraversal(root);
    }
    public void postorderTraversal(Node<E> node) {
    	if (node == null) return;
    	postorderTraversal(node.left);
    	postorderTraversal(node.right);
    	System.out.println(node.elememt);
    }
    
    /**
     * 层序遍历
     * 实现思路: 使用队列
     * 
     * 1. 将根节点入队
     * 2.循环执行以下操作，直到队列为空
     * 	将队头 A 出队，进行访问
     * 	将 A 的左子节点入队
     * 	将 A 的右自己节点入队
     * 
     */
    public void levelOrderTraversal() {
		
    	Queue<Node<E>> queue = new LinkedList<>();
    	queue.offer(root);

    	while (!queue.isEmpty()) {
			Node<E> node = queue.poll();    		
    		System.out.println(node.elememt);
    		if (node.left != null) queue.offer(node.left);
    		if (node.right != null) queue.offer(node.right);
    		
		}
	}
    
    public void levelorderTraversal() {
		
    	Queue<Node<E>> queue  = new LinkedList<>();
    	queue.offer(root);
    	
    	while (!queue.isEmpty()) {
    		Node<E> node = queue.poll();
    		// 进行节点访问....
    		
    		if (node.left != null) queue.offer(node.left);
    		if (node.right != null) queue.offer(node.right);
		}
    	
	}
	protected Node<E> createNode(E element,Node<E> parent) {
		return new Node<E>(element, parent);
	}
    
    public int height() {
    	return 0;
	}
    
	public int height(Node<E> node) {
	    return 0;
	}
    protected static class Node<E>{
		E elememt;
		Node<E> left;
		Node<E> right;
		Node<E> parent;
    	public Node(E elememt,Node<E> parent) {
			this.elememt = elememt;
			this.parent = parent;	
		}
    	/**
    	 * 是否叶子节点
    	 * @return
    	 */
    	public boolean isLeaf() {
			return left == null && right == null;
		}
    	/**
    	 * 是否有两个孩子
    	 * @return
    	 */
    	public boolean hasTwoChildren() {
			return left != null && right != null;
		}
    	
    	/**
    	 * 是否父节点的左子节点
    	 * @return
    	 */
    	public boolean isLeftChild() {
			return parent != null && this == parent.left;
		}
    	/**
    	 * 是否父节点的右子节点
    	 * @return
    	 */
    	public boolean isRightChild() {
    		return parent != null && this == parent.right;
    	}
    	
    	/**
    	 * 返回兄弟节点
    	 * @return
    	 */
    	public Node<E> sibling() {
			if (isLeftChild()) {
				return parent.right;
			}
			if (isRightChild()) {
				return parent.left;
			}
			return null;
		}
    	
    }
    /**
     * 前驱节点 - 中序遍历的前一个节点
     * @param node
     * @return
     */
	protected Node<E> predecessor(Node<E> node) {
    	if (node == null) return null;
    	
    	// 前驱节点在左子树当中（left.right.right....）
    	Node<E> p = node.left;
    	if (node.left != null) {
    		while(p.right != null) {
    			p = p.right;
    		}
    		return p;
		}
    	
    	// 从父节点，祖父节点中寻找前驱节点
    	while (node.parent != null && node == node.parent.left) {
			node = node.parent;
		}
    	
    	// node.parent == null
    	// node == node.parent.right
    	return node.parent;
	}
	protected Node<E> successor(Node<E> node) {
    	if (node == null) return null;
    	
    	// 后继节点在右子树当中（right.left.left....）
    	Node<E> p = node.right;
    	if (p != null) {
    		while(p.left != null) {
    			p = p.left;
    		}
    		return p;
    	}
    	
    	// 从父节点，祖父节点中寻找后继节点
    	while (node.parent != null && node == node.parent.right) {
    		node = node.parent;
    	}
    	
    	// node.parent == null
    	// node == node.parent.right
    	return node.parent;
    }
	@Override
	public Object root() {
		return root;
	}
	@Override
	public Object left(Object node) {
		return ((Node<E>)node).left;
	}
	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}
	@Override
	public Object string(Object node) {
		return node;
//		Node<E> myNode = ((Node<E>)node);
//		String parentString = "null";
//		if (myNode.parent != null) {
//			parentString = myNode.parent.elememt.toString();
//		}
//		return myNode.elememt + "_p(" + parentString + ")";
	}
}
