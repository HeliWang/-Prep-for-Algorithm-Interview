/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/course-schedule-ii
@Language: Java
@Datetime: 17-02-13 00:31
*/

public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        // Topological Problem
        // In-degree(usded in topological problem)
        // Out-degree (Not used here)
        
        /*
        1. Collect in-degree data
        2. Put all nodes that in-degree = 0 into queue
        3. Bfs
        */
        int resultCount = 0;
        int[] result = new int[numCourses];
        if (numCourses == 0 || prerequisites == null || prerequisites == null) {
            return result;
        } 
        // 1.Indegree calculation
        // (1).Initialization 
        Map<Integer, Queue<Integer>> outEdge = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
            outEdge.put(i, new LinkedList<Integer>());
        }
        // (2).Indegree Sum
        for (int i = 0; i < prerequisites.length; i++) { // length!!!!!!!
            int post = prerequisites[i][0]; 
            int pre = prerequisites[i][1];
            outEdge.get(pre).offer(post);
            indegree.put(post, 1 + indegree.get(post));// PUT!!!!!!
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree.get(i) == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[resultCount++] = course;
            for (int neighbor : outEdge.get(course)) {
                int newIndegree = indegree.get(neighbor) - 1;
                indegree.put(neighbor, newIndegree);
                if (newIndegree == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (resultCount == numCourses) return result; else return new int[0];
    }
}