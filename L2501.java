
//LeetCode -> 2501 -> longest square streak in an array

import java.util.*;

public class L2501 {

    public static int longestSquareStreak(int[] nums) {
        // Map to store the length of square streak for each number
        Map<Integer, Integer> streakLengths = new HashMap<>();

        Arrays.sort(nums);

        for (int number : nums) {
            int root = (int) Math.sqrt(number);

            // Check if the number is a perfect square and its square root is in the map
            if (root * root == number && streakLengths.containsKey(root)) {
                // If so, extend the streak from its square root
                streakLengths.put(number, streakLengths.get(root) + 1);
            } else {
                // Otherwise, start a new streak
                streakLengths.put(number, 1);
            }
        }

        // Find the maximum streak length
        int longestStreak = 0;
        for (int streakLength : streakLengths.values()) {
            longestStreak = Math.max(longestStreak, streakLength);
        }

        // Return -1 if no valid streak found, otherwise return the longest streak
        return longestStreak == 1 ? -1 : longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 16, 2, 9, 25, 3, 49 };

        int result = longestSquareStreak(nums);
        System.out.println("The longest square streak is: " + result);
    }
}

// ! Time Complexity = O(n log n)
// ! Space Complexity = O(n)