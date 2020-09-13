package leetcode.editor.en.topk;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-13 18:11
 */
public class KthMagicNumber {

    class Solution {

        /**
         * 如果把丑数数列叫做 ugly[i]，那么考虑一下三个数列：
         * 1. ugly[0]*3,ugly[1]*3,ugly[2]*3,ugly[3]*3,ugly[4]*3,ugly[5]*3……
         * 2. ugly[0]*5,ugly[1]*5,ugly[2]*5,ugly[3]*5,ugly[4]*5,ugly[5]*5……
         * 3. ugly[0]*7,ugly[1]*7,ugly[2]*7,ugly[3]*7,ugly[4]*7,ugly[5]*7……
         * <p>
         * 上面这个三个数列合在一起就形成了新的、更长的丑数数列。
         * <p>
         * 如果合在一起呢？这其实就是一个合并有序线性表的问题。
         * <p>
         * 作者：orangex
         * 链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci/solution/di-k-ge-shu-jiu-shi-xiang-bu-tong-wei-he-san-zhi-z/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param k
         * @return
         */
        public int getKthMagicNumber(int k) {
            int[] numList = new int[k + 1];

            int p3 = 0, p5 = 0, p7 = 0;

            numList[0] = 1;
            for (int i = 1; i < k; i++) {

                //合并三个数列 越小的公因数排在越前
                numList[i] = Math.min(Math.min(numList[p3] * 3, numList[p5] * 5), numList[p7] * 7);

                if (numList[i] == numList[p3] * 3) p3++;
                if (numList[i] == numList[p5] * 5) p5++;
                if (numList[i] == numList[p7] * 7) p7++;
            }
            return numList[k - 1];
        }
    }
}
