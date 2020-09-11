package leetcode.editor.en.tree;

import java.util.List;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-08 19:34
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};