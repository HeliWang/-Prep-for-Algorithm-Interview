/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/clone-graph
@Language: Java
@Datetime: 17-02-11 22:35
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        HashMap <Integer, UndirectedGraphNode> hash = new HashMap <>();
        LinkedList <UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(root);
        
        for (int i = 0; i < queue.size(); i++) {
            UndirectedGraphNode node = queue.get(i);
            if (!hash.containsKey(node.label)) {
                UndirectedGraphNode nodeCopy = new UndirectedGraphNode (node.label);
                hash.put(node.label, nodeCopy);
                for (UndirectedGraphNode neighbor : node.neighbors) {
                    if (neighbor != null) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        
        for (UndirectedGraphNode oNode : queue) {
            if (hash.get(oNode.label).neighbors.size() != 0) continue;
            for (UndirectedGraphNode oNeighbor: oNode.neighbors) {
                hash.get(oNode.label).neighbors.add(
                    hash.get(oNeighbor.label)
                );
            }
        } 
        
        return hash.get(root.label);
    }
}