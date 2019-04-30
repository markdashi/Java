package com.mj.circle;

import com.mj.AbstractList;

/**
 * 双向循环链表
 * @author mark
 *
 * @param <E>
 */
public class CircleLinkedList<E> extends AbstractList<E> {

	// 接口设计
	// 将公共方法抽取到基类 abstract class 
	
	private Node<E> first;
    private Node<E> last;

	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> prev;
		public Node(Node<E> prev, E element, Node<E> next) {
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			if (prev != null) {
				sb.append(prev.element);
			}else {
				sb.append("null");
			}
			sb.append("_").append(element).append("_");
			
			if (next != null) {
				sb.append(next.element);
			}else {
				sb.append("null");
			}
			return sb.toString();
		}
	}

	@Override
	public void clear() {
		size = 0;
		first = null;
		last = null;
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
		
		// 向最后面添加
		// 最开始空链表时 ，last 为空 index == 0 size == 0
		if (index == size) {
			last = new Node<E>(last, element, first); // 最后一个指向first
			if (last.prev == null) { // 这是链表添加的第一个元素
				first = last;
				first.next = first;
				last.next = first;
			}else {
				last.prev.next = last;	
				first.prev = last;
			}
		}else {
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<E>(prev, element, next);
			next.prev = node;
			prev.next = node;
			
			// index = 0 情况
			if (index == 0) { //next = first
				first = node;
			}
		}
		size ++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		
		Node<E> node = first;
		if (size == 1) {
			first = null;
			last = null;
		}else {
			node = node(index);
			Node<E> prev = node.prev;
			Node<E> next = node.next;
			prev.next = next;
			next.prev = prev;
			
			if (index == 0) { //node == first
				first = next;
			}
			// 删除最后一个节点
			if (node == last) { // index == size - 1
				last = prev;
			}
		}
		 size --;
		 return node.element;
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
		
		if (index < (size >> 1)) {
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		} else {
			Node<E> node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
			return node;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder  = new StringBuilder();
		stringBuilder.append("size=").append(size).append(",[");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				stringBuilder.append(", ");
			}
			stringBuilder.append(node);
			node = node.next;
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
