package leetcode.editor.en.bitwise;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-10-27 21:10
 */
public class PowerOfTwo {
    //给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
//
// 示例 1:
//
// 输入: 1
//输出: true
//解释: 20 = 1
//
// 示例 2:
//
// 输入: 16
//输出: true
//解释: 24 = 16
//
// 示例 3:
//
// 输入: 218
//输出: false
// Related Topics 位运算 数学


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         *
         * @param n
         * @return
         */
        public boolean isPowerOfTwo(int n) {
            if (n == 0) return false;
            while (n % 2 == 0) n /= 2;
            return n == 1;

        }
    }

    class Solution2 {
        public boolean isPowerOfTwo(int n) {
            if (n == 0) return false;
            long x = (long) n;
            return (x & (-x)) == x;
        }
    }


    /**
     * 二进制只有一个1 所以会把1消除
     */
    class Solution3 {

        public boolean isPowerOfTwo(int n) {
            if(n <= 0)
                return false;
            return (n & (n-1)) == 0;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
