/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/maximum-depth-of-binary-tree
@Language: Java
@Datetime: 17-01-29 19:43
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
 
 // An attemptuUsing Traverse
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    private int depth;
    
    public int maxDepth(TreeNode root) {
        depth = 0;
        traverse (root, 1);
        return depth;
    }
    
    private void traverse (TreeNode root, int curdepth) {
        if (root == null) return;
        depth = Math.max (curdepth, depth);
        traverse (root.left, curdepth + 1);
        traverse (root.right, curdepth + 1);
    }
}