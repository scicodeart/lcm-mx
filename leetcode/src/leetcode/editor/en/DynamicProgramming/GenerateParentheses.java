package leetcode.editor.en.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-13 00:34
 */
public class GenerateParentheses {

    //
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
//
//
//
//For example, given n = 3, a solution set is:
//
//
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 递归
     */
    class Solution {

        private List<String> result = new ArrayList<>();
        public List<String> generateParenthesis(int n) {

            generate(0, 0, n, "");
            return result;

        }

        private void generate(int left, int right, int n, String s) {

            // terminator
            if (left == n && right == n) {
                result.add(s);
                return;
            }

            //process current logic:left right
            String leftStr = s + "(";
            String rightStr = s + ")";

            //drill down
            if (left < n) {
                generate(left + 1, right, n, leftStr);
            }

            if (left > right) {
                generate(left, right + 1, n, rightStr);
            }
            //reverse states
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
