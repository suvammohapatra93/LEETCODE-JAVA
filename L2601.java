
// LeetCode -> 2601 -> Prime Substratcion Operation

public class L2601 {

    public static boolean primeSubOperation(int[] nums) {
        int maxElement = getMaxElement(nums);

        // Store the sieve array.
        boolean[] sieve = new boolean[maxElement + 1];
        fill(sieve, true);
        sieve[1] = false;
        for (int i = 2; i <= Math.sqrt(maxElement + 1); i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= maxElement; j += i) {
                    sieve[j] = false;
                }
            }
        }

        // Start by storing the currValue as 1, and the initial index as 0.
        int currValue = 1;
        int i = 0;
        while (i < nums.length) {
            // Store the difference needed to make nums[i] equal to currValue.
            int difference = nums[i] - currValue;

            // If difference is less than 0, then nums[i] is already less than
            // currValue. Return false in this case.
            if (difference < 0) {
                return false;
            }

            // If the difference is prime or zero, then nums[i] can be made
            // equal to currValue.
            if (sieve[difference] || difference == 0) {
                i++;
                currValue++;
            } else {
                // Otherwise, try for the next currValue.
                currValue++;
            }
        }
        return true;
    }

    // Method to get the maximum element in the array
    private static int getMaxElement(int[] nums) {
        int max = -1;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Method to fill an array with a specific boolean value
    private static void fill(boolean[] arr, boolean value) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 9, 11 };
        boolean result = primeSubOperation(nums);
        System.out.println("Can prime subtraction operation be done? " + result);
        // Output -> true
    }
}

// ! Time Complexity = O(n root m)
// ! Space Complexity = O(m)