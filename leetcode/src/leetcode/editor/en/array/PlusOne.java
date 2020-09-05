package leetcode.editor.en.array;

import java.util.Deque;
import java.util.LinkedList;

public class PlusOne {

//Given a non-empty array of digits representing a non-negative integer, increme
//nt one to the integer.
//
// The digits are stored such that the most significant digit is at the head of
//the list, and each element in the array contains a single digit.
//
// You may assume the integer does not contain any leading zero, except the numb
//er 0 itself.
//
//
// Example 1:
//
//
//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//
//
// Example 2:
//
//
//Input: digits = [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
//
//
// Example 3:
//
//
//Input: digits = [0]
//Output: [1]
//
//
//
// Constraints:
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
// Related Topics array


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    //当前数字不是9，则直接+1；加完后直接return；
                    digits[i] += 1;
                    return digits;
                }

            }
            //没有return，说明所有位都是进位，则长度+1
            digits= new int[digits.length + 1];
            digits[0] = 1;
            return digits;

        }



        public int[] plusOne2(int[] digits) {
            int carry = 1;
            Deque<Integer> stack = new LinkedList<>();
            for (int i = digits.length - 1; i >= 0 || carry != 0; i--) {
                int sum = carry;
                if (i >= 0) {
                    sum += digits[i];
                }
                stack.push(sum % 10);
                carry = sum / 10;
            }
            int[] res = new int[stack.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = stack.pop();
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
