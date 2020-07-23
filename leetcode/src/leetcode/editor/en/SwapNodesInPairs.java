package leetcode.editor.en;

/**
 * @Author: Lai
 * @Date: 2020/7/23 21:41
 * @Version 1.0
 */
public class SwapNodesInPairs {

//Given a linked list, swap every two adjacent nodes and return its head.
//
// You may not modify the values in the list's nodes, only nodes itself may be c
//hanged.
//
//
//
// Example:
//
//
//Given 1->2->3->4, you should return the list as 2->1->4->3.
//
// Related Topics Linked List
// 👍 2318 👎 172


//leetcode submit region begin(Prohibit modification and deletion)
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

        }



    }

    public static void main(String[] args) {

        SwapNodesInPairs.Solution solution = new SwapNodesInPairs().new Solution();
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = null;
        System.out.println(solution.swapPairs(test).val);

    }
//leetcode submit region end(Prohibit modification and deletion)

}
