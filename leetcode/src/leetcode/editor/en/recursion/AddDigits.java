package leetcode.editor.en.recursion;

public class AddDigits {

    //Given a non-negative integer num, repeatedly add all its digits until the resu
//lt has only one digit.
//
// Example:
//
//
//Input: 38
//Output: 2
//Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
//             Since 2 has only one digit, return it.
//
//
// Follow up:
//Could you do it without any loop/recursion in O(1) runtime? Related Topics Mat
//h


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int addDigits(int num) {
            if (num < 10) {
                return num;
            }
            int next = 0;
            while (num != 0) {
                next = next + num % 10;
                num /= 10;
            }
            return addDigits(next);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
