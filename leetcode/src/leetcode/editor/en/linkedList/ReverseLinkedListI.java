package leetcode.editor.en.linkedList;

/**
 * @author Lai
 * @version 1.0
 * @date 2022-05-23 20:15
 */
public class ReverseLinkedListI {

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
        public ListNode reverseList(ListNode head) {

            // 空节点，作为前继节点
            ListNode prev = null;
            //用于表示当前指针
            ListNode current = head;
            //用于记录后继指针，以此来获得后驱指针的记忆
            ListNode nextNode = null;

            while (current != null) {
                //后记节点
                nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }

            return prev;
        }
    }
}
