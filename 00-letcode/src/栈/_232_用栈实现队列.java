package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 
 * @author mark
 * 
 * 实现思路:
 * 准备两个栈: inStack outStack
 * 》入队时，push到inStack 中
 * 》出队时
 * 		》》 如果outStack 为空，将inStack 所有元素逐一弹出，push 到 outStack，outStack弹出栈顶元素
 *		》》 如果outStack 不为空，outStack弹出栈顶元素
 */
public class _232_用栈实现队列 {

    private Stack<Integer> inStack = new Stack<Integer>();
    private Stack<Integer> outStack = new Stack<Integer>();
    
    public _232_用栈实现队列() {
        
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if (outStack.isEmpty()) {
			while(!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
        return outStack.pop();
    }
    // 获取队头元素，并不会删除元素
    public int peek() {
    	if (outStack.isEmpty()) {
			while(!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
    	return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
