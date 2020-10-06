package leetcode.editor.en.BinarySearch;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-25 17:17
 */
public class SqrtX {
    //Implement int sqrt(int x).
//
// Compute and return the square root of x, where x is guaranteed to be a non-ne
//gative integer.
//
// Since the return type is an integer, the decimal digits are truncated and onl
//y the integer part of the result is returned.
//
// Example 1:
//
//
//Input: 4
//Output: 2
//
//
// Example 2:
//
//
//Input: 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since
//             the decimal part is truncated, 2 is returned.
//
// Related Topics Math Binary Search


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解体思路：
         * 方法一：二分法
         * 思路分析：使用二分法搜索平方根的思想很简单，就类似于小时候我们看的电视节目中的“猜价格”游戏，高了就往低了猜，低了就往高了猜，范围越来越小。
         * 因此，使用二分法猜算术平方根就很自然。
         *
         * 一个数的平方根肯定不会超过它自己，不过直觉还告诉我们，一个数的平方根最多不会超过它的一半，例如 8 的平方根，8 的一半是 4，4^2=16>8
         * 如果这个数越大越是如此，因此我们要计算一下，这个边界是多少。为此，解如下不等式：
         *  (a/2)^2 >= a
         *
         * 意即：如果一个数的一半的平方大于它自己，那么这个数的取值范围。解以上不等式得 a \ge 4a≥4 或者 a \le 0a≤0。
         *
         * 于是边界值就是 44，那么对 00、11、22、33 分别计算结果，很容易知道，这 44 个数的平方根依次是 00、11、11、11。
         *
         * 注意：这 44 个特值如果没有考虑到，有可能导致你设置的搜索边界不正确。在使用二分法寻找平方根的时候，要特别注意边界值的选择，以下给出两个参考代码。
         *
         * 参考代码 1：所有的数都放在一起考虑，为了照顾到 00 把左边界设置为 00，为了照顾到 11 把右边界设置为 x // 2 + 1。
         *
         * 作者：liweiwei1419
         * 链接：https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         * @param x
         * @return
         */
        public int mySqrt(int x) {
            // 注意：针对特殊测试用例，例如 2147395599
            // 要把搜索的范围设置成长整型
            // 为了照顾到 0 把左边界设置为 0
            long left = 0;
            // # 为了照顾到 1 把右边界设置为 x // 2 + 1
            long right = x / 2 + 1;
            while (left < right) {
                // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
                // long mid = left + (right - left + 1) / 2;
                long mid = (left + right + 1) >>> 1;
                long square = mid * mid;
                if (square > x) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            // 因为一定存在，因此无需后处理
            return (int) left;

        }
    }

    //java
    public class SolutionforFresh {

        public int mySqrt(int x) {
            int left = 0;
            int right = x;
            while (left <= right) {
                long mid = (left + right) / 2;
                if (mid * mid == x)
                    return (int) mid;
                else if (mid * mid < x)
                    left = (int) (mid + 1);
                else
                    right = (int) (mid - 1);
            }
            return right;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
