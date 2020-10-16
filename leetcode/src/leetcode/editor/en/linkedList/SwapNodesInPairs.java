package leetcode.editor.en.linkedList;

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
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapPairsPriority(ListNode head) {

            // Dummy node acts as the prevNode for the head node
            // of the list and hence stores pointer to the head node.
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode prev = dummy;

            while (head != null && head.next != null) {

                ListNode first = head;
                ListNode second = head.next;

                prev.next = second;
                first.next = second.next;
                second.next = first;

                head = first.next;
                prev = first;
            }
            return dummy.next;

        }


        //递归
        public ListNode swapPairs(ListNode head) {

            if ((head == null) || (head.next == null)) {
                return head;
            }

            //定义前后节点
            ListNode pre = head;
            ListNode post = head.next;
            pre.next = swapPairs(post.next);

            //交换
            post.next = pre;
            return post;
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
