/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/subtree-with-maximum-average
@Language: Java
@Datetime: 17-01-29 23:07
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
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    private TreeNode   subtree       = null;
    private ResultType subtreeResult = null;
    
    private class ResultType {
        int sum, size;
        public ResultType (int sum, int size) { 
            this.sum = sum;
            this.size= size;
        }
    }
    
    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        helper(root);
        return subtree;
    }
    
    public ResultType helper(TreeNode root) {
        // write your code here
        // 易错点：ALL SubTrees must be balanced
        if (root == null) {
            return new ResultType(0, 0);
        }
        
        ResultType left  = helper(root.left);
        ResultType right = helper(root.right);
        
        ResultType result = new ResultType (
            left.sum + right.sum + root.val,
            left.size + right.size + 1
        );
        
        if (subtree == null || 
            result.sum * subtreeResult.size > subtreeResult.sum * result.size
        ) { 
            subtree = root;
            subtreeResult = result;
        }
        return result;
    }
}
