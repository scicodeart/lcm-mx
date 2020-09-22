package leetcode.editor.en.recursion.DFS;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-23 02:06
 */
public class NumberOfIslandsA {

    class Solution {
        int n;
        int m;
        public int numIslands(char[][] grid) {

            int count = 0;

            n = grid.length;
            if (grid.length == 0) return 0;
            m = grid[0].length;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    // set the 1 into 0
                    if (grid[i][j] == '1') {
                        count++;
                        spreadTransform(grid, i, j);
                    }
                }
            }
            return count;
        }

        private void spreadTransform(char[][] grid, int i, int j) {

            if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            spreadTransform(grid,i-1,j);
            spreadTransform(grid,i+1,j);
            spreadTransform(grid,i,j-1);
            spreadTransform(grid,i,j+1);
        }

    }

}
