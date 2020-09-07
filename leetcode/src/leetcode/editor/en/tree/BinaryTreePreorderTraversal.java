package leetcode.editor.en.tree;

import java.util.ArrayList;
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
//leetcode submit region end(Prohibit modification and deletion)

}
