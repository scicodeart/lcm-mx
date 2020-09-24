package leetcode.editor.en.recursion.DFS;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-24 13:36
 */
public class Minesweeper {
    //Let's play the minesweeper game (Wikipedia, online game)!
//
// You are given a 2D char matrix representing the game board. 'M' represents an
// unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a re
//vealed blank square that has no adjacent (above, below, left, right, and all 4 d
//iagonals) mines, digit ('1' to '8') represents how many mines are adjacent to th
//is revealed square, and finally 'X' represents a revealed mine.
//
// Now given the next click position (row and column indices) among all the unre
//vealed squares ('M' or 'E'), return the board after revealing this position acco
//rding to the following rules:
//
//
// If a mine ('M') is revealed, then the game is over - change it to 'X'.
// If an empty square ('E') with no adjacent mines is revealed, then change it t
//o revealed blank ('B') and all of its adjacent unrevealed squares should be reve
//aled recursively.
// If an empty square ('E') with at least one adjacent mine is revealed, then ch
//ange it to a digit ('1' to '8') representing the number of adjacent mines.
// Return the board when no more squares will be revealed.
//
//
//
//
// Example 1:
//
//
//Input:
//
//[['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'M', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E']]
//
//Click : [3,0]
//
//Output:
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Explanation:
//
//
//
// Example 2:
//
//
//Input:
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Click : [1,2]
//
//Output:
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'X', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Explanation:
//
//
//
//
//
// Note:
//
//
// The range of the input matrix's height and width is [1,50].
// The click position will only be an unrevealed square ('M' or 'E'), which also
// means the input board contains at least one clickable square.
// The input board won't be a stage when game is over (some mines have been reve
//aled).
// For simplicity, not mentioned rules should be ignored in this problem. For ex
//ample, you don't need to reveal all the unrevealed mines when the game is over,
//consider any cases that you will win the game or flag any squares.
//
// Related Topics Depth-first Search Breadth-first Search


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 思路
     * 点开一个点，要么是雷，要么不是：
     *
     * 点到 M，踩雷了，更新为X，游戏结束。
     * 点到 E，空地，分两种情况：
     * 周围 8 个格子有雷，更新为雷数。
     * 周围 8 个格子没有雷，更新为 B，并继续探测这 8 个格子。
     */
    class Solution {
        // 定义 8 个方向
        int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

        public char[][] updateBoard(char[][] board, int[] click) {

            int x = click[0], y = click[1];
            // 1. 若起点是雷，游戏结束，直接修改 board 并返回。
            if (board[x][y] == 'M') {
                board[x][y] = 'X';
            }else {
                // 2. 若起点是空地，则从起点开始向 8 邻域的空地进行深度优先搜索。
                dfs(board, x, y);
            }
            return board;

        }

        private void dfs(char[][] board, int i, int j) {

            // 递归终止条件：判断空地 (i, j) 周围是否有雷，若有，则将该位置修改为雷数，终止该路径的搜索。
            int cnt = 0;
            for (int k = 0; k < 8; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                    continue;
                }
                if (board[x][y] == 'M') {
                    cnt++;
                }
            }

            if (cnt > 0) {
                board[i][j] =  (char)(cnt + '0');
                return;
            }

            // 若空地 (i, j) 周围没有雷，则将该位置修改为 ‘B’，向 8 邻域的空地继续搜索。
            board[i][j] = 'B';
            for (int k = 0; k < 8; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') {
                    continue;
                }
                dfs(board, x, y);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
