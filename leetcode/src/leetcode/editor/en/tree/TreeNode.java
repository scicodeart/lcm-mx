package leetcode.editor.en.tree;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-07 20:32
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


}
