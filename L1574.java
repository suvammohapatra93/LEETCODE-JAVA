
//LeetCode -> 1574 -> 

public class L1574 {

    public static int findLengthOfShortestSubarray(int[] arr) {
        int right = arr.length - 1;

        // Find the first element from the right that breaks the sorted order
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        // If the whole array is already sorted
        if (right == 0) {
            return 0;
        }

        int ans = right; // Initial answer assuming we remove all elements from the left to `right`
        int left = 0;

        // Move `left` pointer from the start to find the minimal length subarray to
        // remove
        while (left < right && (left == 0 || arr[left - 1] <= arr[left])) {
            // Move `right` pointer to the right as long as elements at `right` are smaller
            // than `arr[left]`
            while (right < arr.length && arr[left] > arr[right]) {
                right++;
            }

            // Calculate and update the minimum length of the subarray to remove
            ans = Math.min(ans, right - left - 1);
            left++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 10, 4, 2, 3, 5 };
        int result = findLengthOfShortestSubarray(arr);
        System.out.println("The length of the shortest subarray to remove is: " + result);
    }
}

// ! Time Complexity = O(N)
// ! Space Complexity = O(1)