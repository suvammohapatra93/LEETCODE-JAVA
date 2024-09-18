
// LEETCODE:875:KOKO EATING BANANS:

import java.util.Arrays;

public class L875 {
    // Helper function to compute hours needed to finish all piles with eating speed
    // k
    private int calculateHours(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            // Use Math.ceil(pile / k) which is equivalent to (pile + k - 1) / k
            hours += (pile + k - 1) / k;
        }
        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        // Step 1: Set the binary search boundaries
        int left = 1; // minimum possible speed
        int right = Arrays.stream(piles).max().getAsInt(); // maximum possible speed

        // Step 2: Perform binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = calculateHours(piles, mid);

            if (hours <= h) {
                right = mid; // Try a slower speed
            } else {
                left = mid + 1; // Increase the speed
            }
        }

        return left; // At the end, left will be the minimum speed that works
    }

    public static void main(String[] args) {
        L875 solution = new L875();
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        System.out.println(solution.minEatingSpeed(piles, h)); // Output: 4
    }
}

// ! Time Complexity = O(log (max(piles)))
// ! Space Complexity = O(1)
