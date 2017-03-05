/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/binary-tree-paths
@Language: Java
@Datetime: 17-01-29 21:34
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
 
 
// An attemptu Using Divide and Conquer

public class Solution {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
     // Think carefully of the returned value of this function!!!
     // 1. 定义 2. 拆解 3. 结束
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> paths = new ArrayList<String>(); //!!!!!!! List <String> xxx = new ArrayList <String>; 
        // 不能写成List <String>!!必须List<String> 
        // 牢记 new ArrayList<String>(); 后面的()!!!!!!!
        if (root == null) { // null
            return paths;
        }
        if (root.left == null && root.right == null) {
            paths.add (String.valueOf(root.val)); // + "" works as well
            return paths;
        }
        
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        
        for (String path : leftPaths) { //拆解: 分别call self并且Merge
            paths.add (root.val + "->" + path);
        }        
        for (String path : rightPaths) { //拆解: 分别call self并且Merge
            paths.add (root.val + "->" + path);
        }
        return paths;
    }
}