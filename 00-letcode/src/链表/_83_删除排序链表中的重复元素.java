package 链表;


/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @author mark
 *
 */
public class _83_删除排序链表中的重复元素 {
    
	
	/**
	 *  给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
	 *  输入: 1->1->2
	 *	输出: 1->2
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = head;
        while (head != null && head.next != null) {
			if (head.val == head.next.val) {
				head.next = head.next.next;
			}else {
				head = head.next;
			}
		}
        return newHead;
    }
}
