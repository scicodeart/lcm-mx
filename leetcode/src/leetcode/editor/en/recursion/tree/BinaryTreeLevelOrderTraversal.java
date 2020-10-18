package leetcode.editor.en.recursion.tree;

import leetcode.editor.en.recursion.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-10-18 20:12
 */
public class BinaryTreeLevelOrderTraversal {
    //给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {


        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) return res;
            dfs(root,0,res);

            return res;
        }

        private void dfs(TreeNode root, int i, List<List<Integer>> res) {

            // 避免重复创建容器
            if(res.size() - 1 < i){
                res.add(new ArrayList<Integer>());
            }

            res.get(i).add(root.val);
            if (root.left!= null){
                dfs(root.left,i+1,res);
            }
            if (root.right != null) {
                dfs(root.right,i+1,res);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
