package leetcode.editor.en.backTracing;

import java.util.*;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-18 20:27
 */
public class LetterCombinationsOfAPhoneNumberA {
    //Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent.
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters.
//
//
//
// Example:
//
//
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// Note:
//
// Although the above answer is in lexicographical order, your answer could be i
//n any order you want.
// Related Topics String Backtracking


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Character,String> map = new HashMap<Character,String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");

    }};



        public List<String> letterCombinations(String digits) {

            if (digits == null || digits.length() == 0){
                return new ArrayList<>();
            }
            List<String> res = new LinkedList<>();
            search("",digits,0,res);
            return res;

        }

        private void search(String s, String digits, int i, List<String> res) {

            //terminator
            if (i == digits.length()){
                res.add(s);
                //跳出本次
                return;
            }

            String letters = map.get(digits.charAt(i));
            for (int j = 0; j < letters.length(); j++) {
                search(s+letters.charAt(i),digits,i+1,res);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
