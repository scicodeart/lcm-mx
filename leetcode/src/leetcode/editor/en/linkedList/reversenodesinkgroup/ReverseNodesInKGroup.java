package leetcode.editor.en.linkedList.reversenodesinkgroup;

/**
 * @author Lai
 * @version 1.0
 * @date 2022-05-24 23:07
 */
public class ReverseNodesInKGroup {

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
         * 递归
         * @param head
         * @param k
         * @return
         */
        public ListNode reverseKGroup(ListNode head, int k) {
            //判空
            if (head == null || head.next == null) { return head; }
            ListNode tail = head;
            //保证head节点是下一组的头结点
            for (int i = 0; i < k; i++) {
                if (tail == null) { return head; }
                tail = tail.next;
            }

            ListNode newNode = reverse206(head, tail);
            //下一轮的开始的地方就是tail
            head.next = reverseKGroup(tail, k);
            return newNode;
        }

        private ListNode reverse206(ListNode head, ListNode tail) {
            ListNode pre = null;
            //为什么这里是！= tail，tail为一组结尾的next节点
            while (head != tail) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }
}
