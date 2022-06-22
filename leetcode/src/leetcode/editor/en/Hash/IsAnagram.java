package leetcode.editor.en.Hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Lai
 * @version 1.0
 * @date 2022-06-22 22:26
 */
public class IsAnagram {


    class SolutionOptimize {
        public boolean isAnagram(String s, String t) {
            int[] count = new int[26];

            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }

            for (int i = 0; i < t.length(); i++) {
                count[t.charAt(i) - 'a']--;
            }

            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0){
                    return false;
                }
            }
            return true;
        }
    }


    class Solution {
        public boolean isAnagram(String s, String t) {
            HashMap map1 = new HashMap();
            for (int i = 0; i < s.length(); i++) {
                if (map1.containsKey(s.charAt(i))) {
                    map1.put(s.charAt(i), (int) map1.get(s.charAt(i)) + 1);
                } else {
                    map1.put(s.charAt(i), 1);
                }
            }

            for (int i = 0; i < t.length(); i++) {
                if (map1.containsKey(t.charAt(i))){
                    map1.put(t.charAt(i),(int) map1.get(t.charAt(i)) - 1);
                }else {
                    return false;
                }
            }

            for (int i = 0; i < map1.size(); i++) {
                if ((int)map1.get(s.charAt(i)) != 0 ){
                    return false;
                }
            }
            return true;
        }
    }

    class SolutionBruteForce {
        public boolean isAnagram(String s, String t) {
            //排序
            char[] sChar = s.toCharArray();
            char[] tChar = t.toCharArray();

            Arrays.sort(sChar);
            Arrays.sort(tChar);

            return Arrays.equals(sChar, tChar);

        }
    }
}
