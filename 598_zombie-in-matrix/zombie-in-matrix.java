/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/zombie-in-matrix
@Language: Java
@Datetime: 17-02-12 21:17
*/

class Coordinate {
    int x,y;
    public Coordinate (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    public int zombie(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int WALL = 0;
        int ZOMBIE = 0;
        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        
        // First put all zombie to queue, as well as get the number of walls
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 2) WALL++;
                if (grid[i][j] == 1) {
                    ZOMBIE++;
                    queue.offer(new Coordinate(i, j));
                } 
            }
        }
        
        // Turn all neighbors to zombies
        int [] directionX = {0, 1, -1, 0};
        int [] directionY = {1, 0, 0, -1};
        int days = 0;
        
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Coordinate zombie = queue.poll();
                for (int j = 0; j < 4; j++){
                    Coordinate neighbour = 
                       new Coordinate(zombie.x + directionX[j], zombie.y + directionY[j]);
                    // First check if the neighbour is a valid point
                    // Second check if the neighbour is a human
                    if (neighbour.x >= 0 && neighbour.x < m
                        && neighbour.y >= 0 && neighbour.y < n
                        && grid[neighbour.x] [neighbour.y] == 0) {
                            grid[neighbour.x] [neighbour.y] = 1;
                            queue.offer(neighbour); 
                            ZOMBIE++;
                        }
                }
            }
            if (queue.size() != 0) days ++;
        }
        if((ZOMBIE + WALL) == m * n) return days; else return -1;
    }
    
    
}