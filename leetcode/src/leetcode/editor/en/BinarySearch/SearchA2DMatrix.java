package leetcode.editor.en.BinarySearch;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-10-07 00:25
 */
public class SearchA2DMatrix {
    //Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties:
//
//
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previou
//s row.
//
//
//
// Example 1:
//
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
//Output: true
//
//
// Example 2:
//
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
//Output: false
//
//
// Example 3:
//
//
//Input: matrix = [], target = 0
//Output: false
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 0 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104
//
// Related Topics Array Binary Search


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {

            int m = matrix.length;
            if (m == 0) return false;
            int n = matrix[0].length;

            int left = 0;
            int right = m*n - 1;
            int pivotIndex,pivotElement;
            while (left <= right) {
                pivotIndex = (left + right) / 2;
                //计算几列几行
                pivotElement = matrix[pivotIndex / n][pivotIndex % n];
                if (target == pivotElement) return true;
                else {
                    if (target < pivotElement) right = pivotIndex - 1;
                    else left = pivotIndex + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
