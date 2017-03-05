/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/number-of-islands
@Language: Java
@Datetime: 17-02-13 01:52
*/

public class Solution {
    class Coordinate {
        int x,y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int island = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    markByBFS(grid, i, j);
                    island++;
                }
            }
        }
        return island;
    }
    
    void markByBFS(boolean[][] grid, int x, int y) {
        int [] directionX = {0, 1, -1, 0}; //ARRAY INITIALIZATION!!!!
        int [] directionY = {1, 0, 0, -1};
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer (new Coordinate(x, y));

        while (!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            grid[coor.x][coor.y] = false;
            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            //It would not return by original path!!!!!!!!!!!!

            for (int i = 0; i < 4; i++) {
                Coordinate adj = new Coordinate(
                    coor.x + directionX[i],
                    coor.y + directionY[i]
                );
                if (!inBound(adj, grid)) {
                    continue;
                }
                if (grid[adj.x][adj.y]) {
                    queue.offer(adj);
                }
            }
        }
    }
    
    private boolean inBound(Coordinate coor, boolean[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        return coor.x >= 0 && coor.x < m && coor.y >= 0 && coor.y < n;
    }
}