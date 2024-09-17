
// LEETCODE:884:UNCOMMON  WORDS FROM TWO SENTENCES:

import java.util.*;

public class L884 {
    public static String[] uncommonFromSentences(String s1, String s2) {
        // Combine both sentences
        String[] words = (s1 + " " + s2).split(" ");

        // Map to store word counts
        Map<String, Integer> wordCount = new HashMap<>();

        // Count occurrences of each word
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Collect uncommon words (which appear exactly once)
        List<String> result = new ArrayList<>();
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) == 1) {
                result.add(word);
            }
        }

        // Convert result list to array and return
        return result.toArray(new String[0]);
    }

    // Main method for testing
    public static void main(String[] args) {
        String s1 = "apple apple";
        String s2 = "banana orange";
        System.out.println(Arrays.toString(uncommonFromSentences(s1, s2)));
        // Output will be -> [banana, orange]
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)