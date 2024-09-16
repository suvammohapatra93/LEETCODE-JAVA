
// LEETCODE:2300:SUCCESSFUL PAIRS OF SPELLS AND POTIONS:

import java.util.Arrays;

public class L2300 {
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        // Sort potions array
        Arrays.sort(potions);

        // For each spell, find how many potions create a successful pair
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            // Binary search for the first potion that makes spell * potion >= success
            int left = 0, right = m;
            while (left < right) {
                int mid = (left + right) / 2;
                if ((long) spell * potions[mid] >= success) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // The number of successful potions is the remaining ones after index 'left'
            result[i] = m - left;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] spells = { 10, 20, 30 };
        int[] potions = { 1, 2, 3, 4, 5 };
        long success = 100;

        int[] result = successfulPairs(spells, potions, success);

        System.out.println(Arrays.toString(result));
        //Output will be -> [0, 1, 2]
    }
}

// ! Time Complexity = O(n log m)
// ! Space Compplexity = O(1)