
/*LEETCODE:215:KTH LARGEST ELEMNT IN THE ARRRAY:
 * 
 * Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?
Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
Constraints:
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
 */

import java.util.PriorityQueue;

public class L215 {
    public static int findKthLargest(int[] nums, int k) {
        // Step 1: Create a min-heap (priority queue) to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Step 2: Iterate through the array
        for (int num : nums) {
            // Add the current element to the heap
            minHeap.offer(num);

            // If the size of the heap exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the root (smallest element in the heap)
            }
        }

        // Step 3: The root of the heap is the k-th largest element
        return minHeap.peek();
    }


    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = { 3, 2, 1, 5, 6, 4 };
        int k1 = 2;
        System.out.println("The " + k1 + "-th largest element is: " + findKthLargest(nums1, k1));
        // Output: 5

        // Test case 2
        int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k2 = 4;
        System.out.println("The " + k2 + "-th largest element is: " + findKthLargest(nums2, k2));
        // Output: 4
    }
}


//! Time Complexity = O(n log k)
//! Space Complexity = O(k)