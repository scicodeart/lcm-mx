package leetcode.editor.en.linkedList.linkedlistcycle;


import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2025 {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        /**
         * 1. 放到hashset里
         * 2. 判断set集合是否存在
         * @param head
         * @return
         */
        public boolean hasCycleHash(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head)) {
                    return true;
                }else {
                    set.add(head);
                    head = head.next;
                }
            }
            return false;
        }

        /**
         * 1. 快慢指针
         * 2. 快指针走两步，慢指针走一步，查看是否相交
         * @param head
         * @return
         */
        public boolean hasCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
}
