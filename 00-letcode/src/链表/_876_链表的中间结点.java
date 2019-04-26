package 链表;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/solution/
 * @author mark
 *
 */
public class _876_链表的中间结点 {
	
	/**
	 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
	 *	如果有两个中间结点，则返回第二个中间结点。
	 *  [1,2,3,4,5]
		输出：此列表中的结点 3 (序列化形式：[3,4,5])
		返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
		注意，我们返回了一个 ListNode 类型的对象 ans，这样：
		ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
	 * @param head
	 * @return
	 */
	// 无法使用递归，因为拿到子链表的中间节点无法得到完整链表的中间节点
	// 利用快慢指针 ,一个指针是另外一个的二倍速度,就可以找到二分之1的
	public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
			if (fast.next != null) {
				fast = fast.next;
			}
		}
	   return slow;
    }
}
