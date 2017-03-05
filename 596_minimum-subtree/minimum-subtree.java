/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/minimum-subtree
@Language: Java
@Datetime: 17-01-29 22:06
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
     * @return the root of the minimum subtree
     */
     
    /* Combination of traverse and recursion!*/
    private TreeNode subtree  = null;
    private int subtreeSumMin = Integer.MAX_VALUE; // Integer.MAX_VALUE!!!!!!!!
    
    /* 如何单用recursion? 看 balanced-binary-tree 那个例子
    知识点：Result Type - 当我们需要return多个变量时候
    class ResultType {int var1; var2;}
    */
    
    public TreeNode findSubtree(TreeNode root) {
        recursion(root);
        return subtree;
    }
    
    private int recursion (TreeNode root) { //这回返回的是subtree的Sum
        if (root == null) return 0;
        int sum = recursion(root.left) + recursion(root.right) + root.val;
        if (sum < subtreeSumMin) {
            subtreeSumMin = sum;
            subtree = root;
        }
        return sum;
    }
    
}