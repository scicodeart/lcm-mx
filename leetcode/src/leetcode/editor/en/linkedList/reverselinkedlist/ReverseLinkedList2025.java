package leetcode.editor.en.linkedList.reverselinkedlist;

public class ReverseLinkedList2025 {


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     *
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     */
    class Solution {
        /**
         * 定义新的临时node相当于复制了一个新的链表
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {

            // 空节点，作为前继节点
            ListNode prev = null;
            //用于表示当前指针
            ListNode current = head;
            //用于记录后继指针，以此来获得后驱指针的记忆
            ListNode nextNode = null;

            while (current != null) {
                //定义后驱节点，挪动后驱
                nextNode = current.next;
                //反转
                current.next = prev;
                //挪动前驱
                prev = current;
                //挪动当前指针
                current = nextNode;
            }
            return prev;
        }

        public ListNode reverseListPractice(ListNode head) {
            ListNode prev = null;
            ListNode current = head;
            ListNode nextNode = null;
            while (current != null) {
                nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }
            return prev;
        }


        public ListNode reverseListPracticeI(ListNode head) {
            ListNode prev = null;
            ListNode current = head;
            ListNode nextNode = null;
            while (current != null) {
              nextNode =  current.next;
              head.next = prev;
              prev = current;
              current = nextNode;
            }
            return prev;
        }
    }
}
