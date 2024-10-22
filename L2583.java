
//LeetCode -> 2583 -> kth largest sum ina binary tree

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class L2583 {
    public static long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null)
            return -1;

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            // Maintain a min heap of size k
            minHeap.offer(levelSum);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element
            }
        }

        // Check if we have enough levels
        return minHeap.size() == k ? minHeap.peek() : -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int k = 2;
        long result = kthLargestLevelSum(root, k);

        System.out.println("The " + k + "th largest level sum is: " + result);
        // output will be -> The 2th largest level sum is: 5
    }
}

// ! Time Complexity = O(N log k)
// ! Space Complexity = O(max(W,k))