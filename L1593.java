
// LeetCode -> 1593 -> Split a string into the max number of unique substrings

import java.util.*;

public class L1593 {

    public static int maxUniqueSplit(String s) {
        // Keep track of the seen substrings
        Set<String> seen = new HashSet<>();
        // We only need an int variable, no need for an array for a single int value
        return backtrack(s, 0, seen);
    }

    private static int backtrack(String s, int start, Set<String> seen) {
        // Base case: If we have reached the end, return 0
        if (start == s.length()) {
            return 0;
        }

        int maxCount = 0;

        // Try every possible substring starting from 'start'
        for (int end = start + 1; end <= s.length(); ++end) {
            String substring = s.substring(start, end);

            // If the substring is unique
            if (!seen.contains(substring)) {
                // Add the substring to the seen set
                seen.add(substring);

                // Recursively count unique substrings from the next position
                // Add 1 for the current unique substring
                int result = 1 + backtrack(s, end, seen);

                // Keep track of the maximum count
                maxCount = Math.max(maxCount, result);

                // Backtrack: remove the substring from the seen set
                seen.remove(substring);
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();

        int result = maxUniqueSplit(inputString);
        System.out.println("Maximum number of unique splits: " + result);

        scanner.close();
    }
}

// ! Time Complexity = O(2^n)
// ! Space Complexity = O(1)