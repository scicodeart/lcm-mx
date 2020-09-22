package leetcode.editor.en.recursion.tree;

import leetcode.editor.en.recursion.TreeNode;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-14 02:08
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    //Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Note:
//You may assume that duplicates do not exist in the tree.
//
// For example, given
//
//
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7]
//
// Return the following binary tree:
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics Array Tree Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
        }

        /**
         * 递归函数
         * @param preorder 前序数组
         * @param p_start 前序子树的开始指针
         * @param p_end 前序子树的结束指针
         * @param inorder 后序数组
         * @param i_start 后序子树的开始指针
         * @param i_end 后序子树的结束指针
         * @return
         */
        private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end){

            // preorder 为空，直接返回 null
            if (p_start == p_end) {
                return null;
            }
            int root_val = preorder[p_start];
            TreeNode root = new TreeNode(root_val);
            //在中序遍历中找到根节点的位置
            int i_root_index = 0;
            for (int i = i_start; i < i_end; i++) {
                if (root_val == inorder[i]) {
                    i_root_index = i;
                    break;
                }
            }

            //左子树个数
            int leftNum = i_root_index - i_start;
            //递归的构造左子树
            root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);


            //递归的构造右子树
            root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
