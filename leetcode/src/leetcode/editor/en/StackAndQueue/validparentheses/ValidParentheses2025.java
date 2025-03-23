package leetcode.editor.en.StackAndQueue.validparentheses;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class ValidParentheses2025 {


    /**
     * 1. 暴力解法：把最里层的对匹配，然后置为空，然后不断消除匹配对，如果为空则true；
     * <p>
     * 2. stack解法：入栈左括号，右括号查看是否匹配
     */
    class Solution {


        Map<Character, Character> pairs = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};


        public boolean isValid(String s) {
            if (s.length() % 2 == 1) {
                return false;
            }
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                //如果是key（右括号），则查看stack是否已经有value匹配
                if (pairs.containsKey(c)) {
                    Character value = pairs.get(c);
                    if (stack.isEmpty() || stack.peek() != value) {
                        return false;
                    }
                    stack.pop();
                } else {
                    // left enter stack
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    }

}
