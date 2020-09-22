package leetcode.editor.en.recursion.DFS;

import java.util.HashSet;

/**
 *
 * @author Lai
 * @version 1.0
 * @date 2020-09-21 17:14
 */
public class MinimumGeneticMutation {
    //A gene string can be represented by an 8-character long string, with choices f
//rom "A", "C", "G", "T".
//
// Suppose we need to investigate about a mutation (mutation from "start" to "en
//d"), where ONE mutation is defined as ONE single character changed in the gene s
//tring.
//
// For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
//
// Also, there is a given gene "bank", which records all the valid gene mutation
//s. A gene must be in the bank to make it a valid gene string.
//
// Now, given 3 things - start, end, bank, your task is to determine what is the
// minimum number of mutations needed to mutate from "start" to "end". If there is
// no such a mutation, return -1.
//
// Note:
//
//
// Starting point is assumed to be valid, so it might not be included in the ban
//k.
// If multiple mutations are needed, all mutations during in the sequence must b
//e valid.
// You may assume start and end string is not the same.
//
//
//
//
// Example 1:
//
//
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//return: 1
//
//
//
//
// Example 2:
//
//
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//return: 2
//
//
//
//
// Example 3:
//
//
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//return: 3
//
//
//
//


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int minStepCount = Integer.MAX_VALUE;
        public int minMutation(String start, String end, String[] bank) {
            dfs(new HashSet<>(), 0, start, end, bank);
            return (minStepCount == Integer.MAX_VALUE) ? -1 : minStepCount;
        }

        private void dfs(HashSet<String> step, int stepCount, String current, String end, String[] bank) {
            if (current.equals(end))
                minStepCount = Math.min(stepCount, minStepCount);
            for (String str: bank) {
                int diff = 0;
                for (int i = 0; i < str.length(); i++)
                    if (current.charAt(i) != str.charAt(i))
                        if (++diff > 1) break;
                if (diff == 1 && !step.contains(str)) {
                    step.add(str);
                    dfs(step, stepCount + 1, str, end, bank);
                    step.remove(str);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
