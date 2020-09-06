package leetcode.editor.en.StackAndQueue;

import java.util.Stack;

public class ValidParenthesesA {
    //Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid.
//
// An input string is valid if:
//
//
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
//
//
//
// Example 1:
//
//
//Input: s = "()"
//Output: true
//
//
// Example 2:
//
//
//Input: s = "()[]{}"
//Output: true
//
//
// Example 3:
//
//
//Input: s = "(]"
//Output: false
//
//
// Example 4:
//
//
//Input: s = "([)]"
//Output: false
//
//
// Example 5:
//
//
//Input: s = "{[]}"
//Output: true
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.
//
// Related Topics String Stack


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {

            if(s.isEmpty())
                return true;
            Stack<Character> stack=new Stack<Character>();

            for(char c:s.toCharArray()){
                if(c=='('){
                    stack.push(')');
                }else if (c=='['){
                    stack.push(']');
                }else if (c=='{'){
                    stack.push('}');
                }else if(stack.empty() || c!=stack.pop()){
                    return false;
                }
            }
            if(stack.empty())
                return true;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
