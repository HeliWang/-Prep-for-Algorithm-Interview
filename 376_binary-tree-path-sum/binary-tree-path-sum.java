/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum
@Language: Java
@Datetime: 17-02-05 18:02
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
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Lets try Using Traverse!!! Top->Down Return value by param
        List<List<Integer>> result = new ArrayList<>(); // 易错！！！ List 是个interface
        List<Integer> path = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        path.add(root.val);
        helper(root, path, target, root.val, result);
        return result;
    }
    void helper(TreeNode root, List<Integer> path, int target, int sum, List<List<Integer>> result) {
        // Lets try Using Traverse!!! Top->Down Return value by param
        
        // meet leaf
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
        
        // go left
        if (root.left != null) {
            path.add(root.left.val);
            helper(root.left, path, target, sum + root.left.val, result);
            path.remove(path.size() - 1);
        }
        
        // go right
        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, path, target, sum + root.right.val, result);
            path.remove(path.size() - 1);
        }
    }
   
    
    /**
    void helper(TreeNode root, List<Integer> path, int target, int currentSum, List<List<Integer>> result) {
        // Lets try Using Traverse!!! Top->Down Return value by param
        if (root == null) {
            if (currentSum == target) {
               result.add(new ArrayList<Integer>(path)); // result.add (path); DEEP COPY!!!!!!!!!!!!!!
            } 
        }
        path.add(root.val);
        currentSum += root.val;
        helper(root.left, path, target, currentSum, result)
        helper(root.right, path, target, currentSum, result);
        // 擦屁股！
        path.remove(path.size() - 1);
    }

     *  Input
        {1,1,1,3,4,4,3,#,#,1,#,5,7}, 6
        Output
        [[1,1,4]]
        Expected
        []
     * 
     * **/
}