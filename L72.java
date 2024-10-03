
// LEETCODE:72:EDIT DISTANCE:

public class L72 {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Create a DP array with size (m+1) x (n+1)
        int[][] dp = new int[m + 1][n + 1];

        // Initialize base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Deleting all characters to convert word1 to an empty string
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Inserting all characters to convert empty string to word2
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // No operation needed if characters match
                } else {
                    // Minimum of insert, delete, replace
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], // Delete
                            Math.min(dp[i][j - 1], // Insert
                                    dp[i - 1][j - 1])); // Replace
                }
            }
        }

        // Return the minimum edit distance
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println("The minimum edit distance is: " + minDistance(word1, word2));
        // Output: 3
    }
}

// ! Time Complexity = O(m*n)
// ! Space Complexity = O(m*n)