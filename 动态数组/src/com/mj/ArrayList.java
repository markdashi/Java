package com.mj;

//  option + command + j 生成注释
public class ArrayList<E> {
	/**
	 * 元素的数量
	 */
	private int size;
	/**
	 * 所有元素
	 * */
	private E[] elements;
	
	private static final int DEFAULT_CAPACITY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;
	@SuppressWarnings("unchecked")
	public ArrayList(int capaticy) {
		capaticy  = capaticy < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capaticy;
		elements = (E[]) new Object[capaticy];
	}
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * 清除所有元素
	 */
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	/**
	 * 元素的数量
	 * @return
	 */
      
	public int size() {
		return size;
	}

	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 是否包含某个元素
	 * @param element
	 * @return
	 */
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}

	/**
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(E element) {
		add(size,element);
		/**
		if (size < elements.length) {
			elements[size] = element;
			size++;
		}else {
			System.out.println("容量不足开始扩容" + ",");
			// 扩容
			int newElements[] = new int [2*size];
			for (int i = 0; i < size; i++) {
				newElements[i] = elements[i];
			}
			elements = newElements;
	        //添加元素
			elements[size] = element;
			size++;
		}
		**/
	}
	/**
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) {
	if (index< 0 || index >= size) {
		throw new IndexOutOfBoundsException("index:"+ index + ", size:" + size);
	}	
		return elements[index];
	}

	/**
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素ֵ
	 */
	public E set(int index, E element) {
		if (index< 0 || index >= size) {
			throw new IndexOutOfBoundsException("index:"+ index + ", size:" + size);
		}	
		E oldElement = elements[index];
		elements[index] = element;
		return oldElement;
	}

	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void add(int index, E element) {
		if (index< 0 || index > size) {
			throw new IndexOutOfBoundsException("index:"+ index + ", size:" + size);
		}
        ensureCapacity( size + 1);
		size++;
		for (int i = size-1; i > index; i--) {
			elements[i] = elements[i-1];
		}
		elements[index] = element;
	}

	/**
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	
	public E remove(int index) {
		if (index< 0 || index >= size) {
			throw new IndexOutOfBoundsException("index:"+ index + ", size:" + size);
		}
		E old = elements[index];
		for (int i = index+1; i < size; i++) {
			elements[i-1] = elements[i];
		}
		//size--; 需要清空内存地址
		elements[--size] = null;
		return old;
	}

	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) return i;
			}
		}else {
			for (int i = 0; i < size; i++) {
				if (elements[i].equals(element)) return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	/**
	 *  保证要有capacity的容量
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E [] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		// 可以优化拷贝的速度
		// System.arraycopy(src, srcPos, dest, destPos, length);
		System.out.println(oldCapacity + ": 扩容为:" + newCapacity);
	}
	
	@Override
	public String toString() {
		// size=3,[]
		StringBuilder stringBuilder  = new StringBuilder();
		stringBuilder.append("size=").append(size).append(",[");
		for (int i = 0; i < size; i++) {
			if (i != 0) stringBuilder.append(", ");
			stringBuilder.append(elements[i]);
			//if (i != size - 1) stringBuilder.append(", ");
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	public int capacity() {
		return elements.length;
	}
}
