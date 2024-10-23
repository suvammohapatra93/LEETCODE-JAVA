
//LeetCode : 2641 : Cousins in Binary Tree II

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Default constructor
    TreeNode() {
    }

    // Constructor with a value
    TreeNode(int val) {
        this.val = val;
    }

    // Constructor with a value, left, and right child
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class L2641 {

    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        // Queue to store nodes at each level
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        // Initial sum is the root value
        int previousLevelSum = root.val;

        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
            int currentLevelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = nodeQueue.poll();

                // Calculate sum of children (left and right)
                int childSum = (currentNode.left != null ? currentNode.left.val : 0) +
                        (currentNode.right != null ? currentNode.right.val : 0);

                // First calculate new values for children
                if (currentNode.left != null) {
                    currentLevelSum += currentNode.left.val;
                    currentNode.left.val = previousLevelSum - childSum; // Update left child
                    nodeQueue.offer(currentNode.left); // Add to queue
                }

                if (currentNode.right != null) {
                    currentLevelSum += currentNode.right.val;
                    currentNode.right.val = previousLevelSum - childSum; // Update right child
                    nodeQueue.offer(currentNode.right); // Add to queue
                }

                // Now update the current node's value after processing children
                currentNode.val = previousLevelSum - currentNode.val;
            }

            // Update previousLevelSum for the next level
            previousLevelSum = currentLevelSum;
        }

        return root;
    }
}

// ! Time Complexity = O(N)
// ! Space Complexity = O(w)