/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/flatten-binary-tree-to-linked-list
@Language: Java
@Datetime: 17-02-01 01:12
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            TreeNode leftNode  = node.left;
            TreeNode rightNode = node.right;
            if (leftNode  != null){ 
                node.right = leftNode; 
                node.left  = null;
            } else if (rightNode == null && !stack.empty()) {
                node.right = stack.peek();
            }
            if (rightNode != null) {// Consider the sequence of a stack!!!!!!
                stack.push(rightNode);// First in first out!!!!
            }
            if (leftNode != null) {
                stack.push(leftNode);
            }
        }
    }
}