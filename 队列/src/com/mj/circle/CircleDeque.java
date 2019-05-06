package com.mj.circle;
/**
 * 循环双端队列
 * 
 * 使用动态数组来实现
 * 
 * @author mark
 *
 */
@SuppressWarnings("unchecked")
public class CircleDeque<E> {
	
	private int front;
	private int size;
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public CircleDeque(){
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}

	// 从头部出队
	public E deQueueFront() {
		E frontElement = elements[front];
	    elements[front] = null;
	    front =  index(1);
	    size--;
	    return frontElement;
	}
    // 从头部入队
	public void enQueueFront(E element) {
		ensureCapacity(size+1);
		
		front = index(-1);
		elements[front] = element;
		size++;
	}
	// 从尾部入队
	public void enQueueRear(E element) {
		ensureCapacity(size+1);

		elements[index(size)] = element;
		size++;
	}
	// 从尾部出队
	public E deQueueRear() {
		int realIndex = index(size-1);
		E rearElement = elements[realIndex];
		elements[realIndex] = null;
		size--;
		return rearElement;
	}
    // 获取头部
	public E front() {
		return elements[front];
	}
	//获取尾部
	public E rear() {
		return elements[index(size-1)];
	}
	//索引查找
	private int index(int index) {
		index += front;
		if (index < 0) {
			return index + elements.length;
		}
		return index % elements.length;
	}
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		// 扩容1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E [] newElements = (E[]) new Object[newCapacity];
		
		System.out.println("开始扩容...." + "oldSize=" + size + " " + "newSize= "+ newElements.length);
		
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[(front+i)%elements.length];
		}
		
		elements = newElements;
		
		// 重置front
		front = 0;
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

