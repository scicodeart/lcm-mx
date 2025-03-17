package leetcode.editor.en.linkedList.reversenodesinkgroup;

public class ReverseNodesInKGroup2025 {
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
        public ListNode reverseKGroup(ListNode head, int k) {

            ListNode dummy = new ListNode(0);    // 此处只是设置一个哨兵节点
            dummy.next = head;      // 哨兵节点的下一个指向首节点
            ListNode pre = dummy;       // 上一段的最后一个节点 节点初始化
            ListNode end = dummy;       // 本段最后一个节点

            while (end.next != null) {
                // 此处是为了找到其中的 k 个子节点
                for(int i = 0 ; i < k && end != null; i++){
                    end = end.next;
                }

                // 如果直接到头了，那就说明没有满足 k 个
                if(end == null){
                    break;
                }

                ListNode start = pre.next;      // 此处是为记录原始未反转段的起始节点
                ListNode nextStart = end.next;  // 记录下一个阶段  起始点

                end.next = null;                // 此处是为了进行后面的反转操作，断开此处链接,让后面反转操作知道截断点在哪里
                pre.next = reverse(start);      // 反转操作

                start.next = nextStart;         // 反转之后，start节点实际是已经最后一个节点了，为了和后面的划分段链接，让他的下一个节点连接上下一段的起始点即可
                pre = start;                    // pre再次来到下一段的上一个节点，也就是本段的结尾点
                end = pre;                      // 结束点，准备开始下一段的循环找 k 长度的段操作
            }
            return dummy.next;
        }


        public ListNode reverse(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }
}
