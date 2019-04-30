package 链表;

import javax.xml.soap.Node;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：

	输入：1->2->4, 1->3->4
	输出：1->1->2->3->4->4

 * @author mark
 *
 */
public class _21_合并两个有序链表 {

	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 ListNode head2 = l2;
		 ListNode head1 = l1;		 
		 while (head2.next != null) {
			 while(head1.next != null) {
				 if (head2.val <= head1.val) {
					 ListNode node = new ListNode(head2.val);
					 head1.next = node;
					 node.next = head1.next.next;
				}
				 head1 = head1.next;
			 } 
			 head2 = head2.next;
		 }
		 return l1;
	 }
	 
	 public static void main(String[] args) {
		 //ListNode l1 = new ListNode(1);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		
		ListNode l1 = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = null;
		
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(4);
		
		ListNode l2 = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = null;
		
		ListNode re = mergeTwoLists(l1,l2);
		System.out.println(re);
	}
}
