
/*LEETCODE:1684:COUNT THE NUMBER OF CONSISTENT STRINGS:
 * 
 * You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.
Return the number of consistent strings in the array words.
Example 1:
Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
Example 2:
Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.
Example 3:
Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
Output: 4
Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
Constraints:
1 <= words.length <= 104
1 <= allowed.length <= 26
1 <= words[i].length <= 10
The characters in allowed are distinct.
words[i] and allowed contain only lowercase English letters.
 */

import java.util.*;

public class L1684 {
    public static int countConsistentStrings(String allowed, String[] words) {
        // Step 1: Create a set of allowed characters
        Set<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }

        // Step 2: Initialize the count of consistent strings
        int consistentCount = 0;

        // Step 3: Iterate through each word in the words array
        for (String word : words) {
            boolean isConsistent = true;

            // Step 4: Check if each character of the word is in the allowed set
            for (char c : word.toCharArray()) {
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }

            // Step 5: If the word is consistent, increment the count
            if (isConsistent) {
                consistentCount++;
            }
        }

        // Step 6: Return the total count of consistent strings
        return consistentCount;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = { "ad", "bd", "aaab", "baa", "badab" };

        // Call the function and print the result
        int result = countConsistentStrings(allowed, words);
        System.out.println("The number of consistent strings is: " + result); // Output: 2
    }
}

// ! Time Complexity = O(n*m)
// ! Space Complexity = O(k)