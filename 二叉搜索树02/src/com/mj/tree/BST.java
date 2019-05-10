package com.mj.tree;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class BST<E> extends BinaryTree<E>  {

	private Comparator<E> comparator; // 比较器
	
	public BST() {
		this(null);
	}
	public BST(Comparator<E> comparator) {
		this.comparator = comparator;
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
    
    public static interface Visitor<E> {
		void visit(E element);
	}
}
