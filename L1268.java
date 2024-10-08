
// LEETCODE:1268-> Search Suggestions System

import java.util.*;

public class L1268 {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        List<String> suggestions = new ArrayList<>();
    }

    private static void insertProduct(TrieNode root, String product) {
        TrieNode currentNode = root;
        for (char c : product.toCharArray()) {
            currentNode.children.putIfAbsent(c, new TrieNode());
            currentNode = currentNode.children.get(c);
            if (currentNode.suggestions.size() < 3) { // Add to suggestions only if size < 3
                currentNode.suggestions.add(product);
            }
        }
    }

    private static List<List<String>> searchTrie(TrieNode root, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        TrieNode currentNode = root;
        for (char c : searchWord.toCharArray()) {
            if (currentNode != null) {
                currentNode = currentNode.children.get(c);
            }
            result.add(currentNode == null ? new ArrayList<>() : currentNode.suggestions);
        }
        return result;
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // Sort products lexicographically

        TrieNode root = new TrieNode();
        for (String product : products) {
            insertProduct(root, product); // Insert each product into the trie
        }

        return searchTrie(root, searchWord); // Search and return results based on searchWord
    }

    public static void main(String[] args) {
        String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
        String searchWord = "mouse";

        List<List<String>> result = suggestedProducts(products, searchWord);

        for (List<String> list : result) {
            System.out.println(list);
        }
    }
}

// ! Time Complexity = O(m+n log n+n*1)
// ! Space Complexity = O(n*1)