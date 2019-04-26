package 链表;


/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @author mark
 *
 */
public class _203_移除链表元素 {

	
	/**
	 * 删除链表中等于给定值 val 的所有节点。
	 * 输入: 1->2->6->3->4->5->6, val = 6
	 * 输出: 1->2->3->4->5
	 * 递归版本
	 * @return
	 */
	public ListNode removeElements(ListNode head, int val) {
       if (head == null) return head;
       head.next = removeElements(head.next, val);
       return head.val == val? head.next : head;
    }
	
	
	/**
	 * 非递归方法
	 * 需要 巧妙处理前几个节点都是val的情况  ---- 添加虚拟头结点
	 * 前两行增加一个header，这样避免前n个node 数据为val的情况，
	 * @return
	 */
	public ListNode removeElements2(ListNode head, int val) {
	   ListNode header = new ListNode(-1);
	   header.next = head;
	   ListNode cur = header;
	   while (cur.next != null) {
		   if (cur.next.val == val) {
			cur.next = cur.next.next;
		}else {
			cur = cur.next;
		}
	   }
	   return header.next;
	}
}
