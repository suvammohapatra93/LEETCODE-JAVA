
/*LEETCODE:1466:REORDER ROUTES TO MAKE ALL PATHS LEAD TO THE CITY 0:
There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.This year, there will be a big event in the capital (city 0), and many people want to travel to this city.Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.It's guaranteed that each city can reach city 0 after reorder.
Example 1:
Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 2:
Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 3:
Input: n = 3, connections = [[1,0],[2,0]]
Output: 0
Constraints:
2 <= n <= 5 * 104
connections.length == n - 1
connections[i].length == 2
0 <= ai, bi <= n - 1
ai != bi
 */

import java.util.*;

public class L1466 {

    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();

        // Initialize the graph with empty lists for each city
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Populate the graph with the connections
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            // Add the forward edge with a flag (1 means it needs reordering if traversed)
            graph.get(u).add(new int[] { v, 1 });
            // Add the reverse edge with a flag (0 means it doesn't need reordering)
            graph.get(v).add(new int[] { u, 0 });
        }

        // DFS or BFS to count the number of reorders required
        // Use a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int reorderCount = 0;

        // Start from city 0
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int currentCity = queue.poll();

            // Traverse the neighbors of the current city
            for (int[] neighbor : graph.get(currentCity)) {
                int nextCity = neighbor[0];
                int needsReorder = neighbor[1];

                // If the next city is not visited
                if (!visited[nextCity]) {
                    // If the edge needs reordering, increment the count
                    reorderCount += needsReorder;
                    // Mark the next city as visited
                    visited[nextCity] = true;
                    // Add the next city to the queue for further exploration
                    queue.offer(nextCity);
                }
            }
        }

        return reorderCount;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        L1466 solution = new L1466();

        // Example 1:
        int n1 = 6;
        int[][] connections1 = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
        int result1 = solution.minReorder(n1, connections1);
        System.out.println("Minimum reorders needed for Example 1: " + result1);
        // Expected output: 3

        // Example 2:
        int n2 = 5;
        int[][] connections2 = { { 1, 0 }, { 1, 2 }, { 3, 2 }, { 3, 4 } };
        int result2 = solution.minReorder(n2, connections2);
        System.out.println("Minimum reorders needed for Example 2: " + result2);
        // Expected output: 2

        // Example 3:
        int n3 = 3;
        int[][] connections3 = { { 1, 0 }, { 2, 0 } };
        int result3 = solution.minReorder(n3, connections3);
        System.out.println("Minimum reorders needed for Example 3: " + result3);
        // Expected output: 0
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)