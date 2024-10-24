
// LeetCode -> 951 -> Flip Equivalent Binary Trees

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructors
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

public class L951 {

    // Method to check if two trees are flip equivalent
    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base cases
        if (root1 == null && root2 == null)
            return true; // Both nodes are null, equivalent
        if (root1 == null || root2 == null)
            return false; // One of them is null, not equivalent
        if (root1.val != root2.val)
            return false; // Values are different, not equivalent

        // Recursively check two possibilities:
        // 1. Trees are equivalent without any flip
        // 2. Trees are equivalent with a flip of the left and right subtrees
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Create example trees
        // Tree 1: 1 Tree 2: 1
        // / \ / \
        // 2 3 3 2
        // / / \
        // 4 4 5
        // \
        // 6
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2, new TreeNode(4), null);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2, null, new TreeNode(5, null, new TreeNode(6)));
        root2.left.left = new TreeNode(4);

        boolean result = flipEquiv(root1, root2);

        System.out.println("Are the trees flip equivalent? " + result);
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(h)