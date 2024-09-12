
/*LEETCODE: 2336 :SMALLEST NUMBER IN INFINITE SET : 
 * 
 * You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
Implement the SmallestInfiniteSet class:
SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
int popSmallest() Removes and returns the smallest integer contained in the infinite set.
void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
Example 1:
Input
["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
[[], [2], [], [], [], [1], [], [], []]
Output
[null, null, 1, 2, 3, null, 1, 4, 5]
Explanation
SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
 

Constraints:

1 <= num <= 1000
At most 1000 calls will be made in total to popSmallest and addBack.
*/

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class L2336 {
    private PriorityQueue<Integer> pq;
    private Set<Integer> addedSet;
    private int smallest;

    // Constructor to initialize the data structures
    public L2336() {
        pq = new PriorityQueue<>();
        addedSet = new HashSet<>();
        smallest = 1;
    }

    // popSmallest function to return the smallest number
    public int popSmallest() {
        // If the priority queue has elements, return the smallest element from the
        // priority queue
        if (!pq.isEmpty()) {
            int popped = pq.poll();
            addedSet.remove(popped);
            return popped;
        }
        // Otherwise, return the current smallest value (incremented each time)
        return smallest++;
    }

    // addBack function to add back a number to the set
    public void addBack(int num) {
        // Add the number back only if it's smaller than the current smallest number
        // and it's not already present in the priority queue
        if (num < smallest && addedSet.add(num)) {
            pq.offer(num);
        }
    }

    public static void main(String[] args) {
        L2336 obj = new L2336();
        System.out.println(obj.popSmallest()); // Output: 1
        System.out.println(obj.popSmallest()); // Output: 2
        obj.addBack(1);
        System.out.println(obj.popSmallest()); // Output: 1
        System.out.println(obj.popSmallest()); // Output: 3
    }
}

// ! Time Complexity = O(log k)
// ! Space Complexity = O(k)
