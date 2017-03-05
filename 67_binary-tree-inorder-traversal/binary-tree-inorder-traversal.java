/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/binary-tree-inorder-traversal
@Language: Java
@Datetime: 17-01-30 03:09
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
    //Iterative
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null; // previously traversed node
        TreeNode curr = root;
    
        if (root == null) {
            return result;
        }
    
        stack.push(root);
        while (!stack.empty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr) {
                // traverse down the tree by â
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (prev.right == curr) {
                result.add(prev.val);
                // traverse down the tree by â
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                // traverse up the tree from the left
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.right == prev) {
                /*
                // traverse up the tree from the right (Could be removed)
                */
                stack.pop();
            } else if (curr == prev) {
                // traverse on a leaf of the tree
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return result;
    }
}