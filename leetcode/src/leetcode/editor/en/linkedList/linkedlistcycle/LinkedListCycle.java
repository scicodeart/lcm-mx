package leetcode.editor.en.linkedList.linkedlistcycle;

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
         * 法一，判空 循环节点判断指针节点是否为空，直到循环到出现相同节点，则可判断是否有环
         * @param head
         * @return
         */
        public boolean hasCycle1(ListNode head) {

            //容器
            Set<ListNode> container = new HashSet<>();

            while (head != null){
                //如果已经重复 说明已经第二环了
                if (container.contains(head)){
                    return true;
                }else {
                    container.add(head);
                }

                //循环
                head = head.next;
            }
            return false;
        }


        /**
         * 双指针法 快慢指针 （一个指针循环走一步，一个指针循环走两步，如果是有环，则一定会相遇，即value相等）
         * @param head
         * @return
         */
        public boolean hasCycle2(ListNode head) {

            if (head == null || head.next == null ){
                return false;
            }

            ListNode a = head;
            ListNode b = head.next;

            while (b != null && b.next != null){
                if (a.val == b.val){
                    return true;
                }
                a = a.next;
                b = b.next.next;
            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)





}
