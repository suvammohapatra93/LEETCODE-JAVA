/*LEETCODE:725:SPLIT LINKEDLIST IN PARTS:

Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.Return an array of the k parts.
Example 1:
Input: head = [1,2,3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but its string representation as a ListNode is [].
Example 2:
Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
Output: [[1,2,3,4],[5,6,7],[8,9,10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
Constraints:
The number of nodes in the list is in the range [0, 1000].
0 <= Node.val <= 1000
1 <= k <= 50
 */

// Definition for singly-linked list.
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

public class L725 {
    public static ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Determine the size of each part and the remainder
        int partSize = length / k;
        int remainder = length % k;

        // Initialize the result array
        ListNode[] result = new ListNode[k];

        // Reset the current pointer to head
        current = head;
        for (int i = 0; i < k; i++) {
            // Set the head of the current part
            result[i] = current;

            // Calculate the correct size for this part
            int currentPartSize = partSize + (i < remainder ? 1 : 0);

            // Traverse the list to the end of the current part
            for (int j = 0; j < currentPartSize - 1 && current != null; j++) {
                current = current.next;
            }

            // Detach the current part from the rest of the list
            if (current != null) {
                ListNode nextPart = current.next;
                current.next = null;
                current = nextPart;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage of the splitListToParts method
        // Creating a linked list 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 3;

        // Splitting the list into k parts
        ListNode[] parts = splitListToParts(head, k);

        // Printing the result
        for (ListNode part : parts) {
            while (part != null) {
                System.out.print(part.val + " ");
                part = part.next;
            }
            System.out.println();
        }
    }
}

//! Time Complexity = O(n)
//! Space Complexity = O(k)
