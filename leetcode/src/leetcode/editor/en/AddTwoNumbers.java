//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
// 
// Related Topics Linked List Math
package leetcode.editor.en;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {

//leetcode submit region begin(Prohibit modification and deletion)


    class Solution {


        public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            //
            ListNode p = new ListNode(0);
            ListNode a = l1;
            ListNode b = l2;

            //初始进位
            int carry = 0;

            while (a != null || b != null) {
                //a和b节点的值相加，如果有进位还要加上进位的值
                int val = (a == null ? 0 : a.val) + (b == null ? 0 : b.val) + carry;
                //根据val判断是否有进位
                carry = val >= 10 ? 1 : 0;
                //不管有没有进位，val都应该小于10
                val = val % 10;
                p = (a == null ? b : a);
                p.val = val;
                //a和b指针都前进一位
                a = (a == null ? null : a.next);
                b = (b == null ? null : b.next);
                //根据a和b是否为空，p指针也前进一位
                p.next = (a == null ? b : a);
            }
            //不要忘记最后的边界条件，如果循环结束carry>0说明有进位需要处理这个条件
            if (carry > 0) {
                p.next = new ListNode(1);
            }
            //每次迭代实际上都是将val赋给a指针的，所以最后返回的是l1
            return l1;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {


        AddTwoNumbers.Solution solution = new AddTwoNumbers().new Solution();
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(5);

        ListNode result = solution.addTwoNumbers(a, b);
        System.out.println(result.val);

    }
}