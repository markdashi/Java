package com.mj;

import java.util.Comparator;

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
    public void remove(E element) {
    	
    }
    public boolean contains(E element) {
		return false;
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
    private static class Node<E>{
    	E elememt;
    	Node<E> left;
    	Node<E> right;
    	Node<E> parent;
    	public Node(E elememt,Node<E> parent) {
			this.elememt = elememt;
			this.parent = parent;	
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
