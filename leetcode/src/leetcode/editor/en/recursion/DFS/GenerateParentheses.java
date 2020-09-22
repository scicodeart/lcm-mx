package leetcode.editor.en.recursion.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 经典：22.生成括号
 * https://leetcode-cn.com/problems/generate-parentheses/#/description
 * @author Lai
 * @version 1.0
 * @date 2020-09-21 17:42
 */
public class GenerateParentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            // 特判
            if (n == 0) {
                return res;
            }
            // 执行深度优先遍历，搜索可能的结果
            dfs("", n, n, res);
            return res;
        }

        /**
         *
         * @param curStr 当前递归得到的结果
         * @param left 左括号还有几个可以使用
         * @param right 右括号还有几个可以使用
         * @param res 结果集
         */
        private void dfs(String curStr, int left, int right, List<String> res) {

            // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
            // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
            if (left == 0 && right == 0) {
                res.add(curStr);
                System.out.println(curStr);
                return;
            }
            // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
            if (left > right) {
                return;
            }
            if (left > 0) {
                dfs(curStr + "(", left - 1, right, res);
            }
            if (right > 0) {
                dfs(curStr + ")", left, right - 1, res);
            }
        }


    }

    public static void main(String[] args) {


        GenerateParentheses.Solution solution = new GenerateParentheses().new Solution();


        List<String> strings = solution.generateParenthesis(2);

    }
}
