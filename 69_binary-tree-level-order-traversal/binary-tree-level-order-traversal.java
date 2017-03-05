/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal
@Language: Java
@Datetime: 17-02-09 23:21
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
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList <Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null)  queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            results.add(level);
        }
        return results;
    }
}

/**
public class Template {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        Arraylist<ArrayList <Integer>> results = new ArrayList<>();
        if (root == null) {
            return reuslts;
        }
        Queue <TreeNode> queue = new LinkedList <Integer>();
        queue.offer(root);
        
        while (!queue.isEmpty()){
            int QueueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)  queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
        }
    }
}
**/