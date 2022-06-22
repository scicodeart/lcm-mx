package leetcode.editor.en.Hash;


import java.util.*;


/**
 * @author Lai
 * @version 1.0
 * @date 2022-06-22 23:05
 */
public class GroupAnagramsI {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            //排序，存入map的key
            Map<String, List<String>> map = new HashMap<>();

            for (int i = 0; i < strs.length; i++) {
                char[] array = strs[i].toCharArray();
                Arrays.sort(array);
                String key = new String(array);

                if (map.containsKey(key)) {
                    List<String> valueList = map.get(key);
                    valueList.add(strs[i]);
                    map.put(key, valueList);
                } else {
                    map.put(key, new ArrayList<>(Arrays.asList(strs[i])));
                }
            }
            return new ArrayList<List<String>>(map.values());
        }
    }


    public static void main(String[] args) {
        GroupAnagramsI.Solution solution = new GroupAnagramsI().new Solution();
        String[] a = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(solution.groupAnagrams(a));

    }
}
