/*LEETCODE:3217:DELETE NODES FROM LINKEDLIST PRESENT IN ARRAY ->
You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.
Example 1:
Input: nums = [1,2,3], head = [1,2,3,4,5]
Output: [4,5]
Explanation:
Remove the nodes with values 1, 2, and 3.
Example 2:
Input: nums = [1], head = [1,2,1,2,1,2]
Output: [2,2,2]
Explanation:
Remove the nodes with value 1.
Example 3:
Input: nums = [5], head = [1,2,3,4]
Output: [1,2,3,4]
Explanation:
No node has value 5.
Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 105
All elements in nums are unique.
The number of nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105
The input is generated such that there is at least one node in the linked list that has a value not present in nums.
 * 
 */

import java.util.HashSet;

public class L3217 {

    // Definition for singly-linked list.
    public static class ListNode {
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

    public ListNode modifiedList(int[] nums, ListNode head) {
        if (head == null)
            return null; // Handle edge case when the list is empty

        // Convert nums array to a HashSet for O(1) lookup
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Create a dummy node to simplify edge cases where we need to delete the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Start from the dummy node
        ListNode current = dummy;

        while (current.next != null) {
            if (set.contains(current.next.val)) {
                // Skip the node which needs to be deleted
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        // Return the modified list, which starts from dummy.next
        return dummy.next;
    }

    // Main method to test the modifiedList method
    public static void main(String[] args) {
        L3217 solution = new L3217();

        // Test case 1
        int[] nums1 = { 1, 3 };
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result1 = solution.modifiedList(nums1, head1);
        printList(result1); // Expected Output: 2 -> 4

        // Test case 2
        int[] nums2 = { 2, 4 };
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result2 = solution.modifiedList(nums2, head2);
        printList(result2); // Expected Output: 1 -> 3

        // Test case 3: No nodes to remove
        int[] nums3 = { 5, 6 };
        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode result3 = solution.modifiedList(nums3, head3);
        printList(result3); // Expected Output: 1 -> 2 -> 3

        // Test case 4: Empty list
        int[] nums4 = { 1, 2 };
        ListNode result4 = solution.modifiedList(nums4, null);
        printList(result4); // Expected Output: (nothing, as the list is empty)
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

// Time Complexity = O(n+m)
// Space Complexity = O(m)