package leetcode.editor.en.bitwise;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-10-27 20:39
 */
public class NumberOfOneBits {
    //编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
//
//
//
// 示例 1：
//
// 输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
//
//
// 示例 2：
//
// 输入：00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
//
//
// 示例 3：
//
// 输入：11111111111111111111111111111101
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
//
//
//
// 提示：
//
//
// 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的
//还是无符号的，其内部的二进制表示形式都是相同的。
// 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
//
//
//
//
// 进阶:
//如果多次调用这个函数，你将如何优化你的算法？
// Related Topics 位运算


    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value

        /**
         * 一开始，掩码 m=1 因为 1 的二进制表示是
         *
         * 0000 0000 0000 0000 0000 0000 0000 0001
         * 显然，任何数字跟掩码 11 进行逻辑与运算，都可以让我们获得这个数字的最低位。
         * 检查下一位时，我们将掩码左移一位。
         * 0000 0000 0000 0000 0000 0000 0000 0010
         *
         * @param n
         * @return
         */
        public int hammingWeight(int n) {
            int bits = 0;
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                if ((n & mask) != 0) {
                    bits++;
                }
                mask <<= 1;
            }
            return bits;
        }

        /**
         * 在二进制表示中，数字 n 中最低位的 1 总是对应 n−1 中的 0 。因此，
         * 将 n 和 n - 1 与运算总是能把 n 中最低位的 1 变成 0 ，并保持其他位不变。
         *
         *
         * @param n
         * @return
         */
        public int hammingWeight2(int n) {
            int sum = 0;
            while (n != 0) {
                sum++;
                n &= (n - 1);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
