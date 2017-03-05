/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/build-post-office-ii
@Language: Java
@Datetime: 17-02-13 05:09
*/

class Point {
    int x;
    int y;
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        ArrayList <Point> houses = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] hash = new boolean[m][n];
        int[][] result = new int[m][n];
        int[][] resultSize = new int[m][n];
    
        // Find houses
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    houses.add(new Point(i, j));
                }
                hash[i][j] = false;
                result[i][j] = Integer.MAX_VALUE;
                resultSize[i][j] = 0;
            }
        }
        // For each house - bfs
        int[] deltaX = {1, 0, 0, -1};
        int[] deltaY = {0, 1, -1, 0};
        for (Point house : houses) {
            Queue <Point> queue = new LinkedList<Point>();
            queue.offer(house);
            hash[house.x][house.y] = true;
            int distance = 0;
            while (!queue.isEmpty()) {
               int queueSize = queue.size();
               distance ++;
               for (int i = 0; i < queueSize; i++) {
                   Point head = queue.poll();
                   for (int j = 0; j < 4; j++) {
                        Point newPt = new Point (head.x + deltaX[j],
                                                head.y + deltaY[j]);
                        if ((newPt.x >= 0) && (newPt.x < m)
                            && (newPt.y >= 0) && (newPt.y < n)
                            && !hash[newPt.x][newPt.y]
                            && (grid[newPt.x][newPt.y] == 0)){
                                queue.offer(newPt);
                                if (result[newPt.x][newPt.y] == Integer.MAX_VALUE) {
                                    result[newPt.x][newPt.y] = distance;
                                    hash[newPt.x][newPt.y] = true; // Avoid Duplicate!!
                                    resultSize[newPt.x][newPt.y] += 1;
                                } else {
                                    result[newPt.x][newPt.y] += distance; //Maybe duplicate!!!
                                    hash[newPt.x][newPt.y] = true; // Avoid Duplicate!!
                                    resultSize[newPt.x][newPt.y] += 1;
                                }
                            }
                   }
               }
            }
            // 擦屁股，为下次loop做准备
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++) {
                    hash[i][j] = false;
                }
            }
        }
        
        // Find smallest sum
        int smallest = Integer.MAX_VALUE;
    
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && resultSize[i][j] == houses.size())
                   smallest = Math.min (result[i][j], smallest);
            }
        }
        return smallest==Integer.MAX_VALUE? -1 : smallest;
    }
}