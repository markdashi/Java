package com.mj;

import com.mj.list.LinkedList;
import com.mj.list.List;

/**
 * 双端队列
 * @author mark
 * 使用双向链表来实现
 */
public class Deque<E> {

	private List<E> list = new LinkedList<>();
	
	public int size() {
       return list.size();
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	// 从尾部入队
	public void enQueueRear(E element) {
		list.add(element);
	}
	
	// 从头部出队
	public E deQueueFront() {
		return list.remove(0);
	}
    // 从头部入队
	public void enQueueFront(E element) {
		list.add(0,element);
	}
	// 从尾部出队
	public E deQueueRear() {
       return list.remove(list.size()-1);
	}
    // 获取头部
	public E front() {
		return list.get(0);
	}
	//获取尾部
	public E rear() {
		return list.get(list.size() - 1);
	}
}
