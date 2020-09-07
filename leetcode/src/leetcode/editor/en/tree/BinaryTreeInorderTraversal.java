package leetcode.editor.en.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-07 20:08
 */
public class BinaryTreeInorderTraversal {


    //Given a binary tree, return the inorder traversal of its nodes' values.
//
// Example:
//
//
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,3,2]
//
// Follow up: Recursive solution is trivial, could you do it iteratively?
// Related Topics Hash Table Stack Tree


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
        public List<Integer> inorderTraversal(TreeNode root) {

            if(root!=null){
                inorderTraversal(root.left);
                list.add(root.val);
                inorderTraversal(root.right);
            }
            return list;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
