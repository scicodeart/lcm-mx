package leetcode.editor.en.BinarySearch;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-25 18:31
 */
public class ValidPerfectSquare {
    //Given a positive integer num, write a function which returns True if num is a
//perfect square else False.
//
// Follow up: Do not use any built-in library function such as sqrt.
//
//
// Example 1:
// Input: num = 16
//Output: true
// Example 2:
// Input: num = 14
//Output: false
//
//
// Constraints:
//
//
// 1 <= num <= 2^31 - 1
//
// Related Topics Math Binary Search


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            if(num < 2) return true;
            long left = 2;
            long right = num/2;
            long mid,squared;
            while (left <= right){
                mid = left + (right - left) / 2;
                squared = mid*mid;
                if(squared == num){
                    return true;
                }
                if (squared > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
