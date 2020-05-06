package leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    //Given a linked list, determine if it has a cycle in it.
//
// To represent a cycle in the given linked list, we use an integer pos which re
//presents the position (0-indexed) in the linked list where tail connects to. If
//pos is -1, then there is no cycle in the linked list.
//
//
//
//
// Example 1:
//
//
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where tail connects to the s
//econd node.
//
//
//
//
//
//
// Example 2:
//
//
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where tail connects to the f
//irst node.
//
//
//
//
//
//
// Example 3:
//
//
//Input: head = [1], pos = -1
//Output: false
//Explanation: There is no cycle in the linked list.
//
//
//
//
//
//
//
// Follow up:
//
// Can you solve it using O(1) (i.e. constant) memory?
// Related Topics Linked List Two Pointers


//leetcode submit region begin(Prohibit modification and deletion)
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
         * 法一，判空
         * @param head
         * @return
         */
        public boolean hasCycle1(ListNode head) {

                Set<ListNode> nodesSeen = new HashSet<>();
                while (head != null) {
                    if (nodesSeen.contains(head)) {
                        return true;
                    } else {
                        nodesSeen.add(head);
                    }
                    head = head.next;
                }
                return false;


        }


        /**
         * 双指针法 快慢指针
         * @param head
         * @return
         */
        public boolean hasCycle2(ListNode head) {
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
//leetcode submit region end(Prohibit modification and deletion)






    public static void main(String[] args) {
        LinkedListCycle.Solution solution = new LinkedListCycle().new Solution();

        ListNode head = new ListNode(4);
        head.next = new ListNode(5);

        System.out.println(solution.hasCycle1(head));

    }



}
