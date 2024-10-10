
//LEETCODE -> 452 -> Minimum Number of Arrows to Burst Balloons

import java.util.Arrays;

public class L452 {
    public static int findMinArrowShots(int[][] points) {
        // Sort the balloons based on their ending points
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // Start with one arrow
        int end = points[0][1]; // Track the end point of the first balloon

        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the end of the previous balloon, we need
            // another arrow
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1]; // Update the end point to the current balloon's end point
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        int result = findMinArrowShots(points);
        System.out.println("Minimum number of arrows needed: " + result);
        // Output -> Minimum number of arrows needed: 2
    }
}

// ! Time Complexity = O(n log n)
// ! Space Complexity = O(1)