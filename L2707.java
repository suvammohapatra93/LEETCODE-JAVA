
// LEETCODE:2707:EXTRA CHARACTERS IN A STRING:

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L2707 {
    public static int minExtraChar(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary)); // Store dictionary in a set for fast lookup
        int n = s.length();
        int[] dp = new int[n + 1]; // dp[i] will store the minimum extra characters from index i to the end

        // Initialize dp array with max values (maximum extra chars is the whole
        // substring)
        Arrays.fill(dp, n);
        dp[n] = 0; // Base case: no extra chars after the end of the string

        // Iterate backwards through the string
        for (int i = n - 1; i >= 0; i--) {
            // Try every substring starting from index i
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (dict.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }
            dp[i] = Math.min(dp[i], dp[i + 1] + 1); // Case where character s[i] is unmatched
        }

        return dp[0]; // The result is the minimum extra characters from the start
    }

    public static void main(String[] args) {
        String s = "leetscode";
        String[] dictionary = { "leet", "code", "leetcode" };
        System.out.println(minExtraChar(s, dictionary));
        // Output: 1 (extra character 's')
    }
}

// ! Time Complexity = O(n^2)
// ! Space Complexity = O(n)