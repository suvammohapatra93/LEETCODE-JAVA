
//LEETCODE:1143:LONGEST COMMON SUBSEQUENCE:

public class L1143 {
    public static int longestCommonSubsequence(String text1, String text2) {
        // Get the lengths of both strings
        int m = text1.length();
        int n = text2.length();

        // Create a 2D array to store the lengths of longest common subsequence
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Return the value at the bottom-right corner which is the result
        return dp[m][n];
    }

    public static void main(String[] args) {
        // Example inputs
        String text1 = "abcde";
        String text2 = "ace";

        // Call the function and print the result
        int result = longestCommonSubsequence(text1, text2);
        System.out.println("Longest Common Subsequence length: " + result);
        // Output will be -> Longest Common Subsequence length: 3
    }
}

// ! Time Complexity = O(m*n)
// ! Space Complexity = O(m*n)