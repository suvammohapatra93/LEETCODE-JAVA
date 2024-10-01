
//LEETCODE-1497->CHECK IF ARRAY PAIRS ARE DIVISIBLE BY K:


public class L1497 {
    public static boolean canArrange(int[] arr, int k) {
        // Array to store frequency of remainders
        int[] remainderCount = new int[k];

        // Calculate the remainders and update the frequency array
        for (int num : arr) {
            // Get the remainder in the range [0, k-1]
            int remainder = ((num % k) + k) % k;
            remainderCount[remainder]++;
        }

        // Check if we can pair up elements based on their remainders
        for (int i = 1; i <= k / 2; i++) {
            // Check if remainder i and remainder (k-i) have the same frequency
            if (remainderCount[i] != remainderCount[k - i]) {
                return false;
            }
        }

        // Special check for elements with remainder 0
        // They should have even frequency since they must be paired with themselves
        return remainderCount[0] % 2 == 0;
    }

    public static void main(String[] args) {
        // Example inputs
        int[] arr = { 1, 2, 3, 4, 5, 10, 6, 7, 8, 9 }; // Array to check
        int k = 5; // Divisor

        // Call the canArrange method and print the result
        boolean result = canArrange(arr, k);
        System.out.println("Can arrange into pairs divisible by " + k + ": " + result);
        // * Output will be -> Can arrange into pairs divisible by 5: true */
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(k)