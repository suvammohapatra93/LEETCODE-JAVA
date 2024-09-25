
// LEETCODE:2416:SUM OF PREFIX SCORES OF STRINGS:

public class L2416 {

    // Trie Node class to store frequency of prefixes
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0; // To store the frequency of prefixes
    }

    // Insert word into Trie and update prefix frequency
    private static void insert(String word, TrieNode root) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.count++; // Increment prefix frequency count
        }
    }

    // Calculate prefix score for a word
    private static int getPrefixScore(String word, TrieNode root) {
        TrieNode node = root;
        int score = 0;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            node = node.children[index];
            score += node.count; // Add the frequency count of this prefix
        }
        return score;
    }

    // Main function to calculate the sum of prefix scores
    public static int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();

        // Insert all words into the Trie
        for (String word : words) {
            insert(word, root);
        }

        // Calculate prefix scores for each word
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = getPrefixScore(words[i], root);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = { "abc", "ab", "bc", "b" };
        int[] result = sumPrefixScores(words);
        for (int score : result) {
            System.out.print(score + " ");
        }
        // Expected Output: 5 4 3 2
    }
}
