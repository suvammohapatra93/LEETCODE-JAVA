
// LEETCODE:62:UNIQUE PATHS:

public class L62 {

    public static int uniquePaths(int m, int n) {
        // DP table to store the number of unique paths to each cell
        int[][] dp = new int[m][n];

        // Initialize the first row and first column to 1 (base case)
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1; // Only one way to move down
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1; // Only one way to move right
        }

        // Fill the DP table using the state transition relation
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Sum of top and left cells
            }
        }

        // The value in the bottom-right corner is the answer
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        int result = uniquePaths(m, n);
        System.out.println("Number of unique paths: " + result);
        // Expected Output: 28
    }
}

// ! Time Complexity = O(m*n)
// ! Space Complexity = O(m*n)