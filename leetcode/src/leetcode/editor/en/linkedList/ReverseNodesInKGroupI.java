package leetcode.editor.en.linkedList;

/**
 * @author Lai
 * @version 1.0
 * @date 2022-05-31 17:11
 */
public class ReverseNodesInKGroupI {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /**
         * 每组递归
         * 反转链表
         */
        public ListNode reverseKGroup(ListNode head, int k) {

            //1. null
            if (head == null || head.next == null) {
                return head;
            }

            //2. head for next round
            ListNode tail = head;
            for (int i = 0; i < k; i++) {
                if (tail == null) {
                    return head;
                }
                tail = tail.next;
            }

            //3. reverse
            ListNode preNode = reverseLinkedList(head, tail);

            //4.link the last round
            head.next = reverseKGroup(tail, k);

            return preNode;

        }
    }

    private ListNode reverseLinkedList(ListNode head, ListNode tail) {
        ListNode pre = null;
        while (head != tail) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
