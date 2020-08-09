package leetcode.editor.en;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {


    //Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
//
// An input string is valid if:
//
//
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
//
//
// Note that an empty string is also considered valid.
//
// Example 1:
//
//
//Input: "()"
//Output: true
//
//
// Example 2:
//
//
//Input: "()[]{}"
//Output: true
//
//
// Example 3:
//
//
//Input: "(]"
//Output: false
//
//
// Example 4:
//
//
//Input: "([)]"
//Output: false
//
//
// Example 5:
//
//
//Input: "{[]}"
//Output: true
//
// Related Topics String Stack


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // Hash table that takes care of the mappings.
        private HashMap<Character, Character> mappings;

        // Initialize hash map with mappings. This simply makes the code easier to read.
        public Solution() {
            this.mappings = new HashMap<Character, Character>();
            this.mappings.put(')', '(');
            this.mappings.put('}', '{');
            this.mappings.put(']', '[');
        }

        /**
         * 使用栈作为该问题的中间数据结构的算法
         *
         * @param s
         * @return
         */
        public boolean isValid(String s) {

            //初始化容器
            Stack<Character> stack = new Stack<Character>();

            //分解字符串
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                //校验key
                if (mappings.containsKey(c)){
                    //查看是否已经有相对应的push，如果有就pop
                    if (stack.contains(mappings.get(c))){
                        stack.pop();
                    }else {
                        return false;
                    }
                }else {
                    stack.push(c);
                }
            }
            if (stack.empty()){
                return true;
            }else {
                return false;
            }
        }
     }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        ValidParentheses.Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("("));

    }


}
