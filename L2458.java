
//LeetCode -> 2458 -> Height of a binary tree after subtree removal queries

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class L2458 {
    public static int[] treeQueries(TreeNode root, int[] queries) {
        // Maps to store node depths and subtree heights
        Map<Integer, Integer> nodeDepths = new HashMap<>();
        Map<Integer, Integer> subtreeHeights = new HashMap<>();

        // Maps to store the first and second largest heights at each level
        Map<Integer, Integer> firstLargestHeight = new HashMap<>();
        Map<Integer, Integer> secondLargestHeight = new HashMap<>();

        // Perform DFS to calculate depths and heights
        dfs(root, 0, nodeDepths, subtreeHeights, firstLargestHeight, secondLargestHeight);

        int[] results = new int[queries.length];

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int queryNode = queries[i];
            int nodeLevel = nodeDepths.get(queryNode);

            // Calculate the height of the tree after removing the query node
            if (subtreeHeights.get(queryNode).equals(firstLargestHeight.get(nodeLevel))) {
                results[i] = nodeLevel + secondLargestHeight.getOrDefault(nodeLevel, 0) - 1;
            } else {
                results[i] = nodeLevel + firstLargestHeight.getOrDefault(nodeLevel, 0) - 1;
            }
        }

        return results;
    }

    // Depth-first search to calculate node depths and subtree heights
    private static int dfs(TreeNode node, int level, Map<Integer, Integer> nodeDepths,
            Map<Integer, Integer> subtreeHeights, Map<Integer, Integer> firstLargestHeight,
            Map<Integer, Integer> secondLargestHeight) {
        if (node == null)
            return 0;

        nodeDepths.put(node.val, level);

        // Calculate the height of the current subtree
        int leftHeight = dfs(node.left, level + 1, nodeDepths, subtreeHeights, firstLargestHeight, secondLargestHeight);
        int rightHeight = dfs(node.right, level + 1, nodeDepths, subtreeHeights, firstLargestHeight,
                secondLargestHeight);
        int currentHeight = 1 + Math.max(leftHeight, rightHeight);

        subtreeHeights.put(node.val, currentHeight);

        // Update the largest and second largest heights at the current level
        int currentFirstLargest = firstLargestHeight.getOrDefault(level, 0);
        if (currentHeight > currentFirstLargest) {
            secondLargestHeight.put(level, currentFirstLargest);
            firstLargestHeight.put(level, currentHeight);
        } else if (currentHeight > secondLargestHeight.getOrDefault(level, 0)) {
            secondLargestHeight.put(level, currentHeight);
        }

        return currentHeight;
    }

    public static void main(String[] args) {
        // Example tree creation
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        // Queries
        int[] queries = { 2, 3, 4, 5 };

        // Get results for the queries
        int[] results = treeQueries(root, queries);

        // Print the results
        System.out.println("Results:");
        for (int result : results) {
            System.out.println(result);
        }
    }
}

// ! Time Complexity = O(n+q)
// ! Space Complexity = O(b)