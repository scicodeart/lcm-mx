package leetcode.editor.en.BinarySearch;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-10-13 23:44
 */
public class ValidPerfectSquareA {
    class Solution {
        public boolean isPerfectSquare(int num) {

            if(num < 2) return true;
            long left = 2;
            long right = num/2;

            long target;
            while (left <= right){
                target = left + (right-left)/2;
                long sqt = target*target;
                if (sqt == num){
                    return true;
                }if (sqt > num){
                    right =target -1;
                }else {
                    left = target + 1;
                }
            }
            return false;
        }
    }
}
