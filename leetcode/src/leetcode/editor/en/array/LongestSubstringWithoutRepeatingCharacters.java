//Given a string, find the length of the longest substring without repeating cha
//racters.
//
//
// Example 1:
//
//
//Input: "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//
//
//
// Example 2:
//
//
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//
//
//
// Example 3:
//
//
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//             Note that the answer must be a substring, "pwke" is a subsequence
// and not a substring.
//
//
//
//
// Related Topics Hash Table Two Pointers String Sliding Window

package leetcode.editor.en.array;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters{

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters.Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();

        int result = solution.lengthOfLongestSubstring("duhifehshf");
        System.out.println(result);

    }



    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * o
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {

            int size = s.length();

            int max = 0;

            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j <= size; j++) {

                    // 当一组遍历的数组没有重复数据
                    if (allUnique(s, i, j)){
                        max = Math.max(max,j-i);
                    }
                }
            }

            return max;
        }


        /**
         * 用于切割重复数据，保证一组数据唯一
         * @param s
         * @param start
         * @param end
         * @return
         */
        public boolean allUnique(String s, int start, int end) {
            Set<Character> set = new HashSet<>();
            for (int i = start; i < end; i++) {
                Character ch = s.charAt(i);
                if (set.contains(ch)) return false;
                set.add(ch);
            }
            return true;
        }


        /**
         * 滑动窗口
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring2(String s) {
            int n = s.length(), ans = 0;
            int[] index = new int[128]; // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                i = Math.max(index[s.charAt(j)], i);
                ans = Math.max(ans, j - i + 1);
                index[s.charAt(j)] = j + 1;
            }
            return ans;
        }

    }







//leetcode submit region end(Prohibit modification and deletion)
}