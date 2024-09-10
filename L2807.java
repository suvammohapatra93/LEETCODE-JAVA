
/*LEETCODE:2807->Insert Greatest Common Divisor in LinkedList 
 * 
 * Given the head of a linked list head, in which each node contains an integer value.
Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.Return the linked list after insertion.
The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
Example 1:
Input: head = [18,6,10,3]
Output: [18,6,6,2,10,1,3]
Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes the linked list after inserting the new nodes (nodes in blue are the inserted nodes).
- We insert the greatest common divisor of 18 and 6 = 6 between the 1st and the 2nd nodes.
- We insert the greatest common divisor of 6 and 10 = 2 between the 2nd and the 3rd nodes.
- We insert the greatest common divisor of 10 and 3 = 1 between the 3rd and the 4th nodes.
There are no more adjacent nodes, so we return the linked list.
Example 2:
Input: head = [7]
Output: [7]
Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes the linked list after inserting the new nodes.
There are no pairs of adjacent nodes, so we return the initial linked list.
Constraints:
The number of nodes in the list is in the range [1, 5000].
1 <= Node.val <= 1000
*/



// Definition for singly-linked list.
public class L2807 {

    // Definition for singly-linked list with static modifier
    public static class ListNode {

        int val;
        ListNode next;

        // Constructors
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

    // Insert Greatest Common Divisors into the linked list
    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers to traverse the list
        ListNode node1 = head;
        ListNode node2 = head.next;

        // Traverse the linked list
        while (node2 != null) {
            int gcdValue = calculateGCD(node1.val, node2.val);
            ListNode gcdNode = new ListNode(gcdValue);

            // Insert the GCD node between node1 and node2
            node1.next = gcdNode;
            gcdNode.next = node2;

            // Move to the next pair of nodes
            node1 = node2;
            node2 = node2.next;
        }

        return head;
    }

    // Helper method to calculate the greatest common divisor using the Euclidean
    // algorithm
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Create a sample linked list: 5 -> 10 -> 15
        ListNode head = new ListNode(5);
        head.next = new ListNode(10);
        head.next.next = new ListNode(15);

        // Print the original list
        System.out.print("Original List: ");
        printList(head);

        // Apply the method to insert GCD nodes
        head = insertGreatestCommonDivisors(head);

        // Print the modified list
        System.out.print("Modified List with GCDs inserted: ");
        printList(head);
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
