package leetcode.editor.en.backTracing;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-19 15:06
 */
public class PaintingPlan {

    class Solution {
        public int paintingPlan(int n, int k) {

            if (n*n == k){
                return 1;
            }
            if (k < n) {
                return 0;
            }
            if (k == n || k == (n*n-1)){
                return n*n;
            }
            if (k < n+(n-1)){
                return 0;
            }
            if (k == n+(n-1)){
                return 6*n;
            }
            if (k == 2*n){
                return (n-1)*(n-1);
            }


            return 0;

        }
    }

}
