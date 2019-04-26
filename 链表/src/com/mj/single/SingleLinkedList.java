package com.mj.single;

import com.mj.AbstractList;

public class SingleLinkedList<E> extends AbstractList<E> {

	// 接口设计
	// 将公共方法抽取到基类 abstract class 
	
	private Node<E> first;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	private static class Node<E> {
		E element;
		Node<E> next;
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}	
	}

	@Override
	public void clear() {
		size = 0;
		first = null;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}

	@Override
	public E get(int index) {
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = node(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		if (index == 0) {
			 first = new Node<E>(element, first);
		}else {
			Node<E> prev = node(index - 1);
			prev.next = new Node<E>(element, prev.next);
		}
		size ++;
	}

	@Override
	public E remove(int index) {
		Node<E> old = first;
		if (index == 0) {
			first = first.next;
		} else {
			 Node<E> prev = node(index-1);
			 old = prev.next;
			 prev.next = prev.next.next;
		}
		 size --;
		 return old.element;
	}

	@Override
	public int indexOf(E element) {
		if (element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i;
				node = node.next;
			}
		}else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element.equals(element)) return i;
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	
	/**
	 * 获取index位置对应的节点对象
	 * @param index
	 * @return
	 */
	private Node<E> node(int index) {
		rangeCheck(index);
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder  = new StringBuilder();
		stringBuilder.append("size=").append(size).append(",[");
		Node<E> node = first;
		while(node != null) {
			stringBuilder.append(", ");
			stringBuilder.append(node.element);
			node = node.next;
		}
//		for (int i = 0; i < size; i++) {
//			if (i != 0) stringBuilder.append(", ");
//			stringBuilder.append(node.element);
//			node = node.next;
//		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
