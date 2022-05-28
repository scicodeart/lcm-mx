package leetcode.editor.en.StackAndQueue;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Lai
 * @version 1.0
 * @date 2022-05-27 22:23
 */
public class ValidParenthesesI {

    class Solution {

        /**
         * 匹配左
         * @param s
         * @return
         */
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '('){
                    stack.push(')');
                }else if (c == '['){
                    stack.push(']');
                }else if (c == '{'){
                    stack.push('}');
                }else if (stack.isEmpty() || c != stack.pop()){
                    return false;
                }
            }
            //循环完后，stack是否已经pop完
            if (stack.isEmpty()){
                return true;
            }
            return false;
        }
    }

    class Solution2 {


        /**
         * 匹配左
         * @param s
         * @return
         */
        public boolean isValid(String s) {

            HashMap<Character, Character> mappings = new HashMap<>();
            mappings.put(')', '(');
            mappings.put('}', '{');
            mappings.put(']', '[');


            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                //这个时候要出站了
                if (mappings.containsKey(c)){
                    if (stack.isEmpty() || stack.peek() != mappings.get(c)){
                        return false;
                    }else {
                        stack.pop();
                    }
                 //这个时候进栈
                }else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()){
                return true;
            }else {
                return false;
            }
        }
    }
}
