
/*LEETCODE:539:MINIMUM TIME DIFFRENCE: */


import java.util.Arrays;
import java.util.List;

public class L539 {

    public static int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440)
            return 0; // Pigeonhole principle: there are only 1440 minutes in a day

        // Convert time points to minutes
        int[] minutes = new int[n];
        for (int i = 0; i < n; i++) {
            String time = timePoints.get(i);
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int mins = Integer.parseInt(parts[1]);
            minutes[i] = hours * 60 + mins;
        }

        // Sort the array of minutes
        Arrays.sort(minutes);

        // Initialize minimum difference as the difference between the first and last
        // time points
        int minDiff = 1440 + minutes[0] - minutes[n - 1]; // Handle circular case

        // Check the differences between consecutive time points
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, minutes[i] - minutes[i - 1]);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        List<String> timePoints = Arrays.asList("23:59", "00:00", "12:34", "22:22");
        int result = findMinDifference(timePoints);
        System.out.println("Minimum Time Difference: " + result);
        // Output will be -> Minimum Time Difference: 1
    }
}

// ! Time Complexity = O(n log n)
// ! Space Complexity = O(n)