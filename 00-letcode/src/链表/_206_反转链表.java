package 链表;


/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author mark
 * 递归  和  非递归
 */

/**
 * 函数调用栈
 * reverseList
 * 
 * **/
public class _206_反转链表 {
	
	
	/**
	 * 递归方法
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head; // 节点不存在或者只有一个节点
		ListNode newhead = reverseList(head.next);
	    head.next.next = head;
	    head.next = null;
		return newhead;
    }
	
	/**
	 * 非递归
	 * @param head
	 * @return
	 */
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) return head; // 节点不存在或者只有一个节点
		 ListNode newHead = null;
		 while (head != null) {
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		 return newHead;
    }
	public static void main(String[] args) {
		
		// 测试
//		ListNode node1 = new ListNode(10);
//		ListNode node2 = new ListNode(20);
//		ListNode node3 = new ListNode(30);
//		ListNode node4 = new ListNode(40);
//		ListNode node5 = new ListNode(50);
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		ListNode newHeadListNode = reverseList(node1);
//		System.out.println(newHeadListNode);
	}
}
