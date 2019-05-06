package com.mj;

import com.mj.circle.CircleDeque;
import com.mj.circle.CircleQueue;

public class Main {
	
	public static void main(String[] args) {
		
		douleCircleQueue();
	}
	
	/**
	 * 循环队列测试
	 */
	static void douleCircleQueue(){
		CircleDeque<Integer> queue = new CircleDeque<>();
		
		// 真是内存结构 和 队列实际 排布没有关系
		// 头 4 5     尾
		for (int i = 0; i < 10; i++) {
			queue.enQueueFront(i+1);
			queue.enQueueRear(i+100);
		}
//		for (int i = 0; i < 3; i++) {
//			queue.deQueueFront();
//			queue.deQueueRear();
//		}
//		queue.enQueueFront(11);
//		queue.enQueueFront(12);
		System.out.println(queue);
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueueFront());
		}
	}
	
	/**
	 * 循环队列测试
	 */
	static void circleQueue() {
		CircleQueue<Integer> queue = new CircleQueue<>();
		
		// 0 1 2 3 4 5 6 7 8 9
		for (int i = 0; i < 10; i++) {
			queue.enQueue(i);
		}
		// null null null null null 5 6 7 8 9
//		for (int i = 0; i < 5; i++) {
//			queue.deQueue();
//		}
//		System.out.println(queue);
//		//15 16 17 18 19 5 6 7 8 9
//		for (int i = 15; i < 23; i++) {
//			queue.enQueue(i);
//		}
		System.out.println(queue);
//		while (!queue.isEmpty()) {
//			System.out.println(queue.deQueue());
//		}
//		System.out.println(queue);
		
	}
	
	static void Deque(){
		Deque<Integer> queue = new Deque<>();
		queue.enQueueFront(11);
		queue.enQueueFront(22);
		queue.enQueueRear(33);
		queue.enQueueRear(44);   // 44 33 11 22
		
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueueRear());
		}
	}
	static void queue() {
		Queue<Integer> queue = new Queue<>();
		queue.enQueue(11);
		queue.enQueue(22);
		queue.enQueue(33);
		queue.enQueue(44);
		queue.enQueue(55);
		
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
	}
}
