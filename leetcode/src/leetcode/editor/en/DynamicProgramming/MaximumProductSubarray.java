package leetcode.editor.en.DynamicProgramming;

/**
 * @author Hermione.lai
 * @date 2022/2/28 9:22 PM
 */
public class MaximumProductSubarray {
    class Solution {

        public int maxProductWrong(int[] nums) {

            //错误版本，没有ac，模仿
            int ans = nums[0];
            int product = 1;
            for (int num : nums) {
                product = Math.max(num, product * num);
                ans = Math.max(product, ans);
            }
            return ans;
        }


        /**
         * 碰到负数怎么办，把负数的结果先缓存起来，如果后面又有负数，就换回来，则负负得正;
         *
         * @param nums
         * @return
         */
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE;//结果最大值
            int imax = 1;
            int imin = 1;//阶段最大值 阶段最小值
            for (int tmp : nums) {
                //当遇到负数的时候进行交换，因为阶段最小*负数就变阶段最大了，反之同理
                if (tmp < 0) {
                    int exc = imax;
                    imax = imin;
                    imin = exc;
                }
                //在这里用乘积和元素本身比较的意思是：
                //对于最小值来说，最小值是本身则说明这个元素值比前面连续子数组的最小值还小。相当于重置了阶段最小值的起始位置
                imax = Math.max(imax * tmp, tmp);
                imin = Math.min(imin * tmp, tmp);
                //对比阶段最大值和结果最大值
                max = Math.max(imax, max);
            }
            return max;
        }
    }
}
