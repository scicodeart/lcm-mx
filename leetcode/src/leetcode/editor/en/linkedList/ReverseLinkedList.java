package leetcode.editor.en.linkedList;

public class ReverseLinkedList {


    //Reverse a singly linked list.
//
// Example:
//
//
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
//
//
// Follow up:
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both?
// Related Topics Linked List


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


        /**
         * 反转链表
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {

            //用于记录当前节点的前驱
            ListNode previous = null;
            //用于表示当前指针
            ListNode current = head;
            //用于记录后记指针，以此来获得后驱指针的记忆
            ListNode nextNode = null;

            while (current!=null){
                //后记节点
                nextNode = current.next;
                //让当前指针指向previous前驱
                current.next = previous;
                //按顺序规律记录前驱
                previous = current;
                //当前指针后移
                current = nextNode;
            }
            return previous;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {

        ReverseLinkedList.Solution solution = new ReverseLinkedList().new Solution();
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = null;
        System.out.println(solution.reverseList(test).val);

    }

}
