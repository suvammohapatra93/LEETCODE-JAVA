/*LEETCODE:1367:LINKEDLIST IN A BINARY TREE:
Given a binary tree root and a linked list with head as the first node. 
Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.
In this context downward path means a path that starts at some node and goes downwards.
Example 1:
Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Explanation: Nodes in blue form a subpath in the binary Tree.  
Example 2:
Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Example 3:
Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: false
Explanation: There is no path in the binary tree that contains all the elements of the linked list from head.
Constraints:
The number of nodes in the tree will be in the range [1, 2500].
The number of nodes in the list will be in the range [1, 100].
1 <= Node.val <= 100 for each node in the linked list and binary tree.
 */


/* Definition for singly-linked list.*/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/*Definition for a binary tree node.*/
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

public class L1367 {

    // Function to check if the linked list is a subpath of the binary tree
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }

        // Check if the linked list can start from the current node of the tree
        if (doesListStartFromTreeNode(head, root)) {
            return true;
        }

        // Otherwise, recursively check the left and right subtrees
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    // Helper function to check if the linked list matches the binary tree starting
    // from the current node
    private boolean doesListStartFromTreeNode(ListNode head, TreeNode node) {
        // If the list is fully traversed, we found a match
        if (head == null) {
            return true;
        }

        // If the tree node is null or values don't match, return false
        if (node == null || head.val != node.val) {
            return false;
        }

        // Recursively check the next list node with left or right subtree nodes
        return doesListStartFromTreeNode(head.next, node.left) || doesListStartFromTreeNode(head.next, node.right);
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        // Create a sample linked list: 4 -> 2 -> 8
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        // Create a sample binary tree:
        // 1
        // / \
        // 4 4
        // / / \
        // 2 5 8
        // / / \
        // 1 6 8
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(8);

        L1367 solution = new L1367();
        boolean result = solution.isSubPath(head, root);

        // Output the result
        System.out.println("Is the linked list a subpath of the binary tree " + result);
    }
}

//! Time Complexity = O(N * M)
//! Space Complexity = O(H)