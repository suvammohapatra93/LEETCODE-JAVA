/*LEETCODE 994-> ROTTING TOMATOES ->

You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
 * 
 */

import java.util.*;

public class L994 {

    // Helper class to store the coordinates of the orange
    static class Orange {
        int x, y;

        Orange(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int orangesRotting(int[][] grid) {
        // Edge case: if the grid is empty
        if (grid == null || grid.length == 0)
            return -1;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Orange> queue = new LinkedList<>();
        int freshOranges = 0; // Count of fresh oranges

        // Traverse the grid and initialize the queue with rotten oranges
        // Also count the number of fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Orange(i, j)); // Add rotten oranges to queue
                } else if (grid[i][j] == 1) {
                    freshOranges++; // Count fresh oranges
                }
            }
        }

        // If there are no fresh oranges, return 0 (no time is required)
        if (freshOranges == 0)
            return 0;

        // Directions for moving up, down, left, right
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int minutes = 0;

        // BFS to spread the rot
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotSpread = false;
            for (int i = 0; i < size; i++) {
                Orange current = queue.poll();
                int x = current.x;
                int y = current.y;

                // Check all 4 directions
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    // If the adjacent orange is fresh, make it rotten and add to queue
                    if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // Mark as rotten
                        queue.offer(new Orange(newX, newY));
                        freshOranges--; // Decrease the count of fresh oranges
                        rotSpread = true;
                    }
                }
            }
            // If any oranges became rotten in this minute, increase the time
            if (rotSpread)
                minutes++;
        }

        // If there are still fresh oranges, return -1 (not possible to rot all)
        return freshOranges == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        // Example grid
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };

        int result = orangesRotting(grid);
        System.out.println("Minimum number of minutes to rot all oranges: " + result);
    }
}

//! Time Complexity = O(n)
//! Space Complexity = O(n)
