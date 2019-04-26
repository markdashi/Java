package 链表;


/**
 * 判断一个链表是否有环
 * @author mark
 *
 */
public class _141_环形链表 {
   
	/**
	 * 利用快慢指针
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        // 循环条件是到达尾节点了
        while (fast != null && fast.next != null) {
        	if (slow == fast) return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
    }
	public static void main(String[] args) {
	}

}
