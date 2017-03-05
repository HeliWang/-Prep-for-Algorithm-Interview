/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/topological-sorting
@Language: Java
@Datetime: 17-02-12 00:56
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        
        // write your code here
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        if (graph == null) return order;
        
        //1. count indegree (we only care of nodes with indegree == 0)
        Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);
        
        //2. topological sorting - bfs
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        
        for (DirectedGraphNode node : graph) {
            if (indegree.get(node) == 0) {
                queue.offer(node);
                order.add(node);
            }
        }
        
        while (!queue.isEmpty()){
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                // node -> neighbor
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    order.add(neighbor);
                }
            }
        }
        
        return order;
    }
    
    private Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph){
                
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            indegree.put (node, 0);
        }
        
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }
        return indegree;
    }
}