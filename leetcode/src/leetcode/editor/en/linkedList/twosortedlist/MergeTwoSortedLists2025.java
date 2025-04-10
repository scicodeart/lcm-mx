package leetcode.editor.en.linkedList.twosortedlist;

/**
 * @author laichuanmin
 * @date 2025/4/2 15:09
 * @version 1.0
 */

/**
 * @author laichuanmin
 * @version 1.0
 * @date 2025/4/2 15:09
 */
public class MergeTwoSortedLists2025 {

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
    class Solution1 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode prehead = new ListNode(0);
            ListNode prev = prehead;

            while (list1 != null && list2 != null) {
                //用当前指针走一遍,串连起来
                if (list1.val <= list2.val) {
                    prev.next = list1;
                    list1 = list1.next;
                } else {
                    prev.next = list2;
                    list2 = list2.next;
                }
                //每一步，指针都往下走
                prev = prev.next;
            }
            //走到这里，已经至少有一个list为null了，则合并剩余的list
            if (list2 == null) {
                prev.next = list1;
            } else {
                prev.next = list2;
            }
            return prehead.next;
        }
    }

    //递归：返回下一个要连接的点
    class Solution2 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            } else if (list2 == null) {
                return list1;
            } else if (list1.val < list2.val) {
                //连接下一个nextNode，但是需要指出list1.next
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }
}
