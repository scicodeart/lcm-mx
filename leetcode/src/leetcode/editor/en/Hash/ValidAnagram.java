package leetcode.editor.en.Hash;

import java.util.Arrays;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-06 19:49
 *
 * 有效的字母异位词
 *
 */
public class ValidAnagram {

    //Given two strings s and t , write a function to determine if t is an anagram o
//f s.
//
// Example 1:
//
//
//Input: s = "anagram", t = "nagaram"
//Output: true
//
//
// Example 2:
//
//
//Input: s = "rat", t = "car"
//Output: false
//
//
// Note:
//You may assume the string contains only lowercase alphabets.
//
// Follow up:
//What if the inputs contain unicode characters? How would you adapt your soluti
//on to such case?
// Related Topics Hash Table Sort


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 1.暴力法：排序，然后字符串是否相等 O(nlogn)
         * 2.hash存储字母出现个数
         * 算法：
         *
         * 为了检查 tt 是否是 ss 的重新排列，我们可以计算两个字符串中每个字母的出现次数并进行比较。因为 SS 和 TT 都只包含 A-ZA−Z 的字母，所以一个简单的 26 位计数器表就足够了。
         * 我们需要两个计数器数表进行比较吗？实际上不是，因为我们可以用一个计数器表计算 ss 字母的频率，用 tt 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            //26个坑位（26个字母的）
            int[] counter = new int[26];
            for (int i = 0; i < s.length(); i++) {

                //'a'的ascii码值是97，数组默认每个坑位都是0，字母出现则坑位标记+1
                counter[s.charAt(i) - 'a']++;
                //比对字符，t字符串中相同char出现则标记-1，以此来抵消字母出现次数
                counter[t.charAt(i) - 'a']--;
            }
            for (int count : counter) {
                if (count != 0) {
                    return false;
                }
            }
            return true;

        }

        /**
         * 1.暴力法：排序，然后字符串是否相等  O(nlogn)
         * 2.hash存储字母出现个数
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagramSecond(String s, String t) {

            if (s.length() != t.length()){
                return false;
            }
            char[] charS = s.toCharArray();
            char[] charT = t.toCharArray();

            Arrays.sort(charS);
            Arrays.sort(charT);

            return Arrays.equals(charS,charT);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
