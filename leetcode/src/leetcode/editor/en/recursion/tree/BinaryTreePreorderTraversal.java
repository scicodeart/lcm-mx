package leetcode.editor.en.recursion.tree;

import leetcode.editor.en.recursion.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-07 21:09
 */
public class BinaryTreePreorderTraversal {

    //Given a binary tree, return the preorder traversal of its nodes' values.
//
// Example:
//
//
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,2,3]
//
//
// Follow up: Recursive solution is trivial, could you do it iteratively?
// Related Topics Stack Tree


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
            List<Integer> list=new ArrayList<Integer>();
            public List<Integer> preorderTraversal(TreeNode root) {

                if(root!=null){
                    list.add(root.val);
                    preorderTraversal(root.left);
                    preorderTraversal(root.right);
                }
                return list;
            }

    }

    class Solution2 {

        /**
         * 在这个算法中，输出到最终结果的顺序按照 Top->Bottom 和 Left->Right，符合前序遍历的顺序。
         * @param root
         * @return
         */
          public List<Integer> preorderTraversal(TreeNode root) {

              LinkedList<TreeNode> stack = new LinkedList<>();
              LinkedList<Integer> output = new LinkedList<>();
              if (root == null) {
                  return output;
              }
              stack.add(root);
              while (!stack.isEmpty()) {
                  TreeNode node = stack.pollLast();
                  output.add(node.val);
                  if (node.right != null) {
                      stack.add(node.right);
                  }
                  if (node.left != null) {
                      stack.add(node.left);
                  }
              }
              return output;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
