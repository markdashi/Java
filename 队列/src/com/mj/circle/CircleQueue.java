package com.mj.circle;
/**
 * 循环队列
 * 使用动态数组来实现
 * @author mark
 *
 */
@SuppressWarnings("unchecked")
public class CircleQueue<E> {
	
	private int front;
	private int size;
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public CircleQueue(){
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void enQueue(E element) {
		ensureCapacity(size+1);
		
		elements[(front+size)%elements.length] = element;
		size++;
	}
	public E deQueue() {
	    E frontElement = elements[front];
	    elements[front] = null;
	    front =  (front+1)%elements.length;
	    size--;
	    return frontElement;
	}
	public E front() {
		return elements[front];
	}
	
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		// 扩容1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E [] newElements = (E[]) new Object[newCapacity];
		
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[(front+i)%elements.length];
		}
		
		elements = newElements;
		
		// 重置front
		front = 0;
	}
	
	// 封装索引查找
	private int index(int index) {
		return (index+front)%elements.length;
	}
	
	@Override
		public String toString() {
		StringBuilder stringBuilder  = new StringBuilder();
		stringBuilder.append("capacity=").append(elements.length)
		.append(" front=").append(front)
		.append(" size=").append(size).append(",[");
		for (int i = 0,len= elements.length; i < len; i++) {
			if (i != 0) {
				stringBuilder.append(", ");
			}
			stringBuilder.append(elements[i]);
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
		}
}
