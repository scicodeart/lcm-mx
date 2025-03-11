package leetcode.editor.en.backTracing;
import java.util.*;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-18 18:44
 */
public class LetterCombinationsOfAPhoneNumber {

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
        public List<String> letterCombinations(String digits) {

            if (digits == null || digits.length() == 0){
                return new ArrayList<>();
            }
            Map<Character,String> map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            List<String> res = new LinkedList<>();
            search("",digits,0,res,map);
            return res;

        }

        /**
         *
         * @param s
         * @param digits
         * @param i level
         * @param res
         * @param map
         */
        private void search(String s, String digits, int i, List<String> res, Map<Character, String> map) {

            //terminator
            if (i == digits.length()){
                res.add(s);
                return;
            }

            //process
            String letters = map.get(digits.charAt(i));
            for (int j = 0; j < letters.length(); j++) {
                //drill down
                search(s + letters.charAt(j),digits,i+1,res,map);
            }

            //reverse
                    
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
