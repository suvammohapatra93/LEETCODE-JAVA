
/*LEETCODE : 1371:FIND THE LONGEST SUBSTRING CONTAINING  */

import java.util.HashMap;

public class L1371 {
    public int findTheLongestSubstring(String s) {
        // Handle empty string case
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Map to store the first occurrence of a particular bitmask state
        HashMap<Integer, Integer> firstOccurrence = new HashMap<>();

        // Start with bitmask 0 at index -1 (before any characters are processed)
        firstOccurrence.put(0, -1);

        // Bitmask state to track even/odd occurrence of vowels a, e, i, o, u
        int state = 0;
        int maxLength = 0;

        // Traverse through the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Toggle the corresponding bit for each vowel
            if (c == 'a') {
                state ^= (1 << 0);
            } else if (c == 'e') {
                state ^= (1 << 1);
            } else if (c == 'i') {
                state ^= (1 << 2);
            } else if (c == 'o') {
                state ^= (1 << 3);
            } else if (c == 'u') {
                state ^= (1 << 4);
            }

            // If this bitmask state has been seen before
            if (firstOccurrence.containsKey(state)) {
                // Calculate the length of the substring from the first occurrence
                maxLength = Math.max(maxLength, i - firstOccurrence.get(state));
            } else {
                // If not seen, store the first occurrence of this state
                firstOccurrence.put(state, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Create an instance of the Solution class
        L1371 solution = new L1371();

        // Test case 1: Input string with alternating vowels
        String test1 = "eleetminicoworoep";
        int result1 = solution.findTheLongestSubstring(test1);
        System.out.println("Test 1 - Longest Substring Length: " + result1); // Expected output: 13

        // Test case 2: Input string with no vowels
        String test2 = "bcdfghjklmnpqrstvwxyz";
        int result2 = solution.findTheLongestSubstring(test2);
        System.out.println("Test 2 - Longest Substring Length: " + result2); // Expected output: 21

        // Test case 3: Input string with only vowels
        String test3 = "aeiouaeiou";
        int result3 = solution.findTheLongestSubstring(test3);
        System.out.println("Test 3 - Longest Substring Length: " + result3); // Expected output: 10

        // Test case 4: Input string with random characters
        String test4 = "leetcodeisawesome";
        int result4 = solution.findTheLongestSubstring(test4);
        System.out.println("Test 4 - Longest Substring Length: " + result4); // Expected output: 5

        // Test case 5: Empty string
        String test5 = "";
        int result5 = solution.findTheLongestSubstring(test5);
        System.out.println("Test 5 - Longest Substring Length: " + result5); // Expected output: 0
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)
