package leetcode.editor.en.DynamicProgramming;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-12 02:27
 */
public class NthUglyNumber {

    //我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//
//
//
// 示例:
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
// 说明:
//
//
// 1 是丑数。
// n 不超过1690。
//
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
// Related Topics 数学


    //leetcode submit region begin(Prohibit modification and deletion)



    class SolutionByDB {
        public int nthUglyNumber(int n) {
            int[] res = new int[n];
            res[0] = 1;
            int p2 = 0, p3 = 0, p5 = 0;
            for (int i = 1; i < n; i++) {
                // 更新数组
                res[i] = Math.min(res[p2] * 2, Math.min(res[p3] * 3, res[p5] * 5));
                // 移动指针
                if (res[i] == res[p2] * 2) p2++;
                if (res[i] == res[p3] * 3) p3++;
                if (res[i] == res[p5] * 5) p5++;
            }
            return res[n - 1];
        }
    }


    class Solution {
        private int[] uglyNumber = {2,3,5};
        public int nthUglyNumber(int n) {
            //创建小根堆，每次出堆的都是最小值
            Queue<Long> queue = new PriorityQueue<>();
            queue.add(1L);
            //记录出堆的个数，出堆的元素完全按照从小到大排序
            int count = 0;
            while (! queue.isEmpty()){
                long cut = queue.poll();

                //如果出堆的个数>=n,当前cut就是第n个丑数
                if(++count >= n){
                    return (int) cut;
                }
                for(int num : uglyNumber){
                    //排除重复的数字
                    if(! queue.contains(num * cut)){
                        queue.add(num * cut);
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
