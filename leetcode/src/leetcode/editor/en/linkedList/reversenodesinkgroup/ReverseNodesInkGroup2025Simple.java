package leetcode.editor.en.linkedList.reversenodesinkgroup;

public class ReverseNodesInkGroup2025Simple {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /**
         * 输入：head = [1,2,3,4,5], k = 2
         * 输出：[2,1,4,3,5]
         *
         * 递归：
         * 1.定义头节点和k个节点后的尾指针
         * 2.头尾反转，找尾指针
         * 3.递归（尾指针，K）
         *
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
