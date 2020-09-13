package leetcode.editor.en.tree;


import java.util.Stack;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-13 01:23
 */
public class ValidateBinarySearchTree {
    //Given a binary tree, determine if it is a valid binary search tree (BST).
//
// Assume a BST is defined as follows:
//
//
// The left subtree of a node contains only nodes with keys less than the node's
// key.
// The right subtree of a node contains only nodes with keys greater than the no
//de's key.
// Both the left and right subtrees must also be binary search trees.
//
//
//
//
// Example 1:
//
//
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
//
//
// Example 2:
//
//
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
//
// Related Topics Tree Depth-first Search


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
        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        public boolean helper(TreeNode node, Integer lower, Integer upper) {
            if (node == null) return true;

            int val = node.val;
            if (lower != null && val <= lower) return false;
            if (upper != null && val >= upper) return false;

            if (! helper(node.right, val, upper)) return false;
            if (! helper(node.left, lower, val)) return false;
            return true;
        }

    }
    class Solution2 {
        public boolean isValidBST(TreeNode root) {

            Stack<TreeNode> stack = new Stack();

            double inorder = - Double.MAX_VALUE;
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
                if (root.val <= inorder) return false;
                inorder = root.val;
                root = root.right;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
