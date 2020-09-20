package leetcode.editor.en.backTracing;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-19 00:25
 */
public class NumberOfIsland {
    //Given a 2d grid map of '1's (land) and '0's (water), count the number of islan
//ds. An island is surrounded by water and is formed by connecting adjacent lands
//horizontally or vertically. You may assume all four edges of the grid are all su
//rrounded by water.
//
//
// Example 1:
//
//
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
//
//
// Example 2:
//
//
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
//
// Related Topics Depth-first Search Breadth-first Search Union Find


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 方法一：深度优先搜索
         * 我们可以将二维网格看成一个无向图，竖直或水平相邻的 11 之间有边相连。
         *
         * 为了求出岛屿的数量，我们可以扫描整个二维网格。如果一个位置为 11，则以其为起始节点开始进行深度优先搜索。在深度优先搜索的过程中，每个搜索到的 11 都会被重新标记为 00。
         *
         * 最终岛屿的数量就是我们进行深度优先搜索的次数。
         * @param grid
         * @return
         */
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            int num_islands = 0;
            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        ++num_islands;
                        dfs(grid, r, c);
                    }
                }
            }
            return num_islands;
        }

        void dfs(char[][] grid, int r, int c) {
            int nr = grid.length;
            int nc = grid[0].length;

            if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
                return;
            }

            grid[r][c] = '0';
            dfs(grid, r - 1, c);
            dfs(grid, r + 1, c);
            dfs(grid, r, c - 1);
            dfs(grid, r, c + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
