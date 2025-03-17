package leetcode.editor.en.linkedList.linkedlistcycle;
import java.util.HashSet;

/**
 * @author Lai
 * @version 1.0
 * @date 2022-05-24 22:23
 */
public class LinkedListCycleI {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {

            // 1. hash set
            HashSet<ListNode> collection = new HashSet<>();

            // 2.
            while (head != null) {
                if (collection.contains(head)) {
                    return true;
                } else {
                    collection.add(head);
                }
                head = head.next;
            }
            return false;
        }
    }

    /**
     * 快慢指针：查看两个指针循环是否会重叠
     */
    public class Solution1 {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
}
