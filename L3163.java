
//LeetCode -> 3163 -> String Compression |||

public class L3163 {
    public static int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];

        // Fill the dp array with a large value (indicating unprocessed states)
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // Base case: the length of an empty string is zero
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (dp[i][j] == Integer.MAX_VALUE)
                    continue; // Skip uninitialized states

                // Case 1: Delete the current character
                if (j + 1 <= k) {
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j]);
                }

                // Case 2: Keep the current character
                int length = 0;
                int same = 0;
                int different = 0;

                // Count consecutive characters and compress
                for (int l = i; l < n; l++) {
                    if (s.charAt(l) == s.charAt(i)) {
                        same++;
                        // Calculate compressed length based on same character counts
                        if (same <= 1)
                            length++;
                        else if (same <= 9)
                            length = length + 1;
                        else if (same == 10)
                            length = length + 1;
                    } else {
                        different++;
                    }

                    // Check if we can keep these characters within the allowed deletions
                    if (j + different <= k) {
                        dp[l + 1][j + different] = Math.min(dp[l + 1][j + different], dp[i][j] + length);
                    } else {
                        break;
                    }
                }
            }
        }

        // Find the minimum compressed length at the end of the string, with up to k
        // deletions
        int result = Integer.MAX_VALUE;
        for (int j = 0; j <= k; j++) {
            result = Math.min(result, dp[n][j]);
        }

        return result;
    }

    public static void main(String[] args) {

        String s = "aaabcccd";
        int k = 2;

        int result = getLengthOfOptimalCompression(s, k);
        System.out.println("Minimum length of compressed string: " + result);
        // Outut -> 6
    }
}

// ! Time Complexity -> O(n * k)
// ! Space Complexity -> O(n * k)