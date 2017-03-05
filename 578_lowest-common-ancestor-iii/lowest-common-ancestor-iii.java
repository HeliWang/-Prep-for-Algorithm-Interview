/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor-iii
@Language: Java
@Datetime: 17-02-05 00:37
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
    boolean foundA;
    boolean foundB;
    TreeNode firstNode;
    public ResultType (boolean foundA, boolean foundB, TreeNode firstNode) { //Don't forget to have a constructor
        this.foundA = foundA;
        this.foundB = foundB;
        this.firstNode = firstNode;
    }
}
    
public class Solution {
    
    /**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    
    private ResultType LCAHelper(TreeNode Root, TreeNode A, TreeNode B) {
        // write your code here
        if (Root == null){
            return new ResultType(false, false, null);
        }
        
        ResultType leftNode  = LCAHelper (Root.left, A, B);
        ResultType rightNode = LCAHelper (Root.right, A, B);
        
        
        if (leftNode.firstNode != null) {
            return leftNode;
        } else if (rightNode.firstNode != null) {
            return rightNode;
        } else if ((leftNode.foundA || Root == A) && (rightNode.foundB || Root == B)) {
            return new ResultType(true, true, Root);
        } else if ((leftNode.foundB || Root == B) && (rightNode.foundA || Root == A)) {
            return new ResultType(true, true, Root);
        } else {
            return new ResultType((leftNode.foundA || rightNode.foundA  || Root == A), 
            (leftNode.foundB || rightNode.foundB || Root == B), null);
        }
    }
    public TreeNode lowestCommonAncestor3(TreeNode Root, TreeNode A, TreeNode B) {
        ResultType returnVal = LCAHelper (Root, A, B);
        return returnVal.firstNode;
    }
}