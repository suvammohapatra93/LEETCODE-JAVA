/*LEETCODE:547:NUMBER OF provinces:
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.
Example 1:
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
Constraints:
1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
 */

public class L547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // Number of cities
        boolean[] visited = new boolean[n]; // Array to keep track of visited cities
        int provinces = 0; // Initialize number of provinces

        for (int i = 0; i < n; i++) {
            // If city i has not been visited, it starts a new province
            if (!visited[i]) {
                provinces++;
                dfs(isConnected, visited, i); // Explore all cities in this province
            }
        }

        return provinces; // Return the total number of provinces
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true; // Mark city i as visited
        for (int j = 0; j < isConnected.length; j++) {
            // If city i and city j are directly connected and j is not visited
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j); // Recursively visit all connected cities
            }
        }
    }

    public static void main(String[] args) {
        // Test case 1: Example case
        int[][] isConnected1 = {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
        };
        System.out.println("Number of provinces for isConnected1: " + new L547().findCircleNum(isConnected1));
        // Output should be 2

        // Test case 2: All cities are connected
        int[][] isConnected2 = {
                { 1, 1, 1 },
                { 1, 1, 1 },
                { 1, 1, 1 }
        };
        System.out.println("Number of provinces for isConnected2: " + new L547().findCircleNum(isConnected2));
        // Output should be 1

        // Test case 3: No cities are connected
        int[][] isConnected3 = {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 }
        };
        System.out.println("Number of provinces for isConnected3: " + new L547().findCircleNum(isConnected3));
        // Output should be 3

        // Test case 4: Two separate clusters
        int[][] isConnected4 = {
                { 1, 0, 0, 1 },
                { 0, 1, 1, 0 },
                { 0, 1, 1, 0 },
                { 1, 0, 0, 1 }
        };
        System.out.println("Number of provinces for isConnected4: " + new L547().findCircleNum(isConnected4));
        // Output should be 2

        // Test case 5: Single city
        int[][] isConnected5 = {
                { 1 }
        };
        System.out.println("Number of provinces for isConnected5: " + new L547().findCircleNum(isConnected5));
        // Output should be 1
    }
}

// Time Complexity = O(n^2)
// Space Complexity = O(n)
