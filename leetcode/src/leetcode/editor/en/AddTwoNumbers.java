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

public class AddTwoNumbers{

    public static void main(String[] args) {
        TwoSum.Solution solution = new TwoSum().new Solution();
        int[] nums = {3,3};
        int[] ints = solution.twoSum(nums, 6);
        System.out.println(Arrays.toString(ints));

    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {



        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
