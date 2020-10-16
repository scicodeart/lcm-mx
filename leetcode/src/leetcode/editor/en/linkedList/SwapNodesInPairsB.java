package leetcode.editor.en.linkedList;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-10-16 15:31
 */
public class SwapNodesInPairsB {
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
        public ListNode swapPairs(ListNode head) {
            //一个指针：用于头部方向，保持方向不动返回结果
            ListNode dummy = new ListNode(-1);

            //head指针保持
            dummy.next = head;

            //第三个指针用于循环交换
            ListNode pre = dummy;

            // first 和 second用于互相交换
            ListNode first = head;


            while (first!=null && first.next != null){
                ListNode second = first.next;

                pre.next = second;
                first.next = second.next;
                second.next = first;

                pre = first;
                first = first.next;
            }

            return dummy.next;
        }
    }
}
