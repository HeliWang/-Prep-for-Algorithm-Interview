/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/graph-valid-tree
@Language: Java
@Datetime: 17-02-05 22:56
*/

// version 1: BFS
public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }
        
        if (edges.length != n - 1) {
            return false;
        }
        
        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
        
        // bfs
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();
        
        queue.offer(0);
        hash.add(0);
        int visited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;
            for (Integer neighbor : graph.get(node)) {
                if (hash.contains(neighbor)) {
                    continue;
                }
                hash.add(neighbor);
                queue.offer(neighbor);
            }
        }
        
        return (visited == n);
    }
    
    private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return graph;
    }
}



/*
//You can choose between the following List implementations in the Java Collections API:
java.util.ArrayList.
java.util.LinkedList.
java.util.Vector.
java.util.Stack.

List  <- ArrayList LinkedList Stack
Queue <- LinkedList
Set   <- HashSet
Map   <- HashMap
*/