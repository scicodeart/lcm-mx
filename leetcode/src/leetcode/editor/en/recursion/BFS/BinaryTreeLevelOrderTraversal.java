package leetcode.editor.en.recursion.BFS;

import com.sun.tools.javac.util.ListBuffer;
import leetcode.editor.en.recursion.TreeNode;

import javax.management.ListenerNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-21 15:12
 */
public class BinaryTreeLevelOrderTraversal {

    //Given a binary tree, return the level order traversal of its nodes' values. (i
//e, from left to right, level by level).
//
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
//
//return its level order traversal as:
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics Tree Breadth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution1 {

        /**
         * DFS 遍历模版
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> allResults = new ArrayList<>();
            if (root == null) {
                return allResults;
            }
            travel(root, 0, allResults);
            return allResults;
        }

        private void travel(TreeNode root, int level, List<List<Integer>> results) {
            if (results.size() == level) {
                results.add(new ArrayList<>());
            }
            results.get(level).add(root.val);
            if (root.left != null) {
                travel(root.left, level + 1, results);
            }
            if (root.right != null) {
                travel(root.right, level + 1, results);
            }
        }
    }

    /**
     * BFS
     */
    class Solution2 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> allResults = new ArrayList<>();
            if (root == null) {
                return allResults;
            }
            //先入先出
            Queue<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            while (!nodes.isEmpty()) {
                int size = nodes.size();
                List<Integer> results = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    //出队
                    TreeNode node = nodes.poll();
                    //遍历
                    results.add(node.val);
                    if (node.left != null) {
                        nodes.add(node.left);
                    }
                    if (node.right != null) {
                        nodes.add(node.right);
                    }
                }
                allResults.add(results);
            }
            return allResults;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
