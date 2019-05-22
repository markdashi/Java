package com.mj;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import com.mj.printer.BinaryTreeInfo;

public class BinarySearchTree<E> implements BinaryTreeInfo {
	private int size = 0;
	private Node<E> root;
	private Comparator<E> comparator; // 比较器
	
	public BinarySearchTree() {
		this(null);
	}
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}
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
    public boolean contains(E element) {
		return node(element) != null;
	}
    public void add(E element) {
    	elementNotNullCheck(element);
    	
    	// 添加第一个节点
    	if (root == null) {
			root = new Node<>(element, null);
			size++;
			return;
		}
    	
    	//添加不是第一个节点
    	
    	Node<E> node = root;
    	Node<E> parent = null;
    	int cmp = 0;
    	while (node != null) {
    		cmp = compare(element,node.elememt);
    		parent = node;
    		if (cmp > 0) {
    			node = node.right;
    		}else if(cmp < 0){
    			node = node.left;
    		}else { //相等
    			
    			// 最好进行覆盖
    			return;
    		}
		}
    	// 创建一个新的节点
    	Node<E> newNode = new Node<>(element, parent);
    	//看插入父节点哪一边
    	if (cmp > 0) {
			parent.right = newNode;
		}else {
			parent.left = newNode;
		}
    	size++;
	}
    
    
    /**
     * 删除元素
     * @param element
     */
    public void remove(E element) {
    	remove(node(element));
    }
    
    /**
     *  删除元素 真实逻辑
     * @param node
     */
    private void remove(Node<E> node) {
		if (node == null) return;
		size --;
		// 删除度为2的节点
		if (node.hasTwoChildren()) {
			Node<E> pre = predecessor(node);
			node.elememt = pre.elememt; // 用前驱节点的值覆盖它原来的值
			
			//删除前驱节点
			// 一个度为2的节点，它的前驱或者后继节点的度只能是1 或者 0
			node = pre;
		}
    	
		//度为1 或者 度为 0的节点
		Node<E> replace = node.left!=null? node.left : node.right;
		
		if (replace == null) { // 度为0 的节点
			if (node == root) { // 度为0 且为根节点
				root = null;
			}else if (node == node.parent.left) {
				node.parent.left = replace;
			}else { // node == node.parent.right
				node.parent.right = replace;
			}
		}else { // 度为1的节点
			replace.parent = node.parent;
			
			if (node == root) {
				root = replace;
			}else if (node == node.parent.left) {
				node.parent.left = replace;
			}else { //node == node.parent.right
				node.parent.right = replace;
			}
		}    	
	}

    
    /**
     * 传递一个元素进来查找节点
     * @param element
     * @return
     */
    private Node<E> node(E element) {
//	    elementNotNullCheck(element);
	    Node<E> node = root;
	    while (node != null) {
			int cmp = compare(element, node.elememt);
			if (cmp == 0) return node;
			if (cmp > 0) {
				node = node.right;
			}else {
				node = node.left;
			}
		}
	    // node == null
    	return node;
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
    
    /**
     * 是否完全二叉树
     * @return
     */
    public boolean isComplete() {
		if (root == null) return false;
    	Queue<Node<E>> queue = new LinkedList<>();
    	queue.offer(root);
    	
    	boolean leaf = false;
    	while (!queue.isEmpty()) {
			
    		Node<E> node = queue.poll();
    		if (leaf && !node.isLeaf()) return false;
    		
    		if (node.left != null) {
    			 queue.offer(node.left);
    		}else if (node.right != null) {
				return false;
			}
    		if (node.right != null) {
				queue.offer(node.right);
			}else {  // node.right == null
				leaf = true;
			}
		}
    	
    	return true;
	}
    
    
    public int height() {
		
    	
    	return 0;
	}
    
	public int height(Node<E> node) {
			
	    	
	    return 0;
	}
    
    
    
    /**
     * @param e1
     * @param e2
     * @return 返回 0 e1 = e2 | >0  e1>e2  | < 0  e1 < e2
     */
    private int compare(E e1,E e2) {
    	if (comparator != null) {
    		comparator.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
	}
    
    private void elementNotNullCheck(E element) {
    	if (element == null) throw new IllegalArgumentException("element must not be null");
	}
    
    
    /**
     * 前驱节点 - 中序遍历的前一个节点
     * @param node
     * @return
     */
    @SuppressWarnings("unused")
	private Node<E> predecessor(Node<E> node) {
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
    private Node<E> successor(Node<E> node) {
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
    
    
    public static interface Visitor<E> {
		void visit(E element);
	}
    
    private static class Node<E>{
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
		return ((Node<E>)node).elememt;
	}
}
