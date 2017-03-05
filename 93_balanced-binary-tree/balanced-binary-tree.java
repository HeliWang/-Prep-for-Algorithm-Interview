/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/balanced-binary-tree
@Language: Java
@Datetime: 17-01-29 22:35
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
 
 
class ResultType {
    boolean isBalanced;
    int maxDepth;
    public ResultType (boolean isBalanced, int maxDepth) { //Don't forget to have a constructor
        this.isBalanced = isBalanced;
        this.maxDepth   = maxDepth;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root){
        return isBalancedHelper(root).isBalanced;
    }
    public ResultType isBalancedHelper(TreeNode root) {
        // write your code here
        // 易错点：ALL SubTrees must be balanced
        if (root == null) {
            return new ResultType (true, 0);
        }
        
        ResultType left = isBalancedHelper (root.left);
        ResultType right = isBalancedHelper (root.right);
        if (!left.isBalanced || !right.isBalanced || (Math.abs(left.maxDepth - right.maxDepth) > 1)) {
            return new ResultType (false, -1);
        }
        return new ResultType (true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }
}