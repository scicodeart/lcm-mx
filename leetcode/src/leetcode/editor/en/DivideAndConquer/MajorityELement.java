package leetcode.editor.en.DivideAndConquer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 分治法 哈希法 排序法
 *
 * @author Lai
 * @version 1.0
 * @date 2020-09-17 17:52
 */
public class MajorityELement {

    //Given an array of size n, find the majority element. The majority element is t
//he element that appears more than ⌊ n/2 ⌋ times.
//
// You may assume that the array is non-empty and the majority element always ex
//ist in the array.
//
// Example 1:
//
//
//Input: [3,2,3]
//Output: 3
//
// Example 2:
//
//
//Input: [2,2,1,1,1,2,2]
//Output: 2
//
// Related Topics Array Divide and Conquer Bit Manipulation


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {

        /**
         * hash
         *
         * @param nums
         * @return
         */
        public int majorityElement(int[] nums) {

            //方法计算hashMap
            Map<Integer, Integer> counts = countNums(nums);

            //遍历hash，找出结果
            Set<Map.Entry<Integer, Integer>> entries = counts.entrySet();

            //用于保存最大的键值对
            Map.Entry<Integer, Integer> majorityEntry = null;

            for (Map.Entry<Integer, Integer> entry : entries) {
                //找出最大值 返回key
                if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                    majorityEntry = entry;
                }
            }

            return majorityEntry.getKey();
        }

        /**
         * 方法计算hashMap
         *
         * @param nums
         * @return
         */
        private Map<Integer, Integer> countNums(int[] nums) {
            Map<Integer, Integer> mapCounts = new HashMap<>();

            for (int num : nums) {
                if (mapCounts.containsKey(num)) {
                    mapCounts.put(num, mapCounts.get(num) + 1);
                }else {
                    mapCounts.put(num, 1);
                }
            }
            return mapCounts;
        }
    }

    class Solution2 {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length/2];
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 分治法
     * 如果数 a 是数组 nums 的众数，如果我们将 nums 分成两部分，那么 a 必定是至少一部分的众数。
     *
     * 我们可以使用反证法来证明这个结论。假设 a 既不是左半部分的众数，也不是右半部分的众数，
     * 那么 a 出现的次数少于 l / 2 + r / 2 次，其中 l 和 r 分别是左半部分和右半部分的长度。
     * 由于 l / 2 + r / 2 <= (l + r) / 2，说明 a 也不是数组 nums 的众数，因此出现了矛盾。所以这个结论是正确的。
     *
     * 这样以来，我们就可以使用分治法解决这个问题：将数组分成左右两部分，分别求出左半部分的众数 a1 以及右半部分的众数 a2，随后在 a1 和 a2 中选出正确的众数。
     *
     */
    class Solution3 {

        /**
         * hash
         *
         * @param nums
         * @return
         */
        public int majorityElement(int[] nums) {
            return majorityElementRec(nums, 0, nums.length-1);

        }

        private int majorityElementRec(int[] nums, int lo, int hi) {
            if (lo == hi) {
                return nums[lo];
            }

            // recurse on left and right halves of this slice.
            int mid = (hi-lo)/2 + lo;
            int left = majorityElementRec(nums, lo, mid);
            int right = majorityElementRec(nums, mid+1, hi);

            // if the two halves agree on the majority element, return it.
            if (left == right) {
                return left;
            }

            // otherwise, count each element and return the "winner".
            int leftCount = countInRange(nums, left, lo, hi);
            int rightCount = countInRange(nums, right, lo, hi);

            return leftCount > rightCount ? left : right;
        }

        private int countInRange(int[] nums, int num, int lo, int hi) {
            int count = 0;
            for (int i = lo; i <= hi; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }

    }}
