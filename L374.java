
/*LEETCODE:374:GUESS NUMBER HIGHER OR LOWER: */

// Assume GuessGame class is provided in the LeetCode environment
class GuessGame {
    public int guess(int num) {
        // Placeholder method, overridden in the subclass for testing
        return 0;
    }
}

public class L374 extends GuessGame {

    // The solution method using binary search
    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            // Calculate the middle of the current range
            int mid = low + (high - low) / 2;

            int result = guess(mid);

            if (result == 0) {
                return mid; // Found the correct guess
            } else if (result == -1) {
                high = mid - 1; // Guess is too high
            } else {
                low = mid + 1; // Guess is too low
            }
        }

        return -1; // Should never reach here for valid input
    }

    // Override the guess method for testing purposes (this part simulates the game
    // logic)
    @Override
    public int guess(int num) {
        int pickedNumber = 6; // Example picked number for testing

        if (num > pickedNumber) {
            return -1; // The guess is too high
        } else if (num < pickedNumber) {
            return 1; // The guess is too low
        } else {
            return 0; // The guess is correct
        }
    }

    // Main method to test the guessNumber function
    public static void main(String[] args) {
        L374 solution = new L374();

        // Define the upper bound n
        int n = 10;

        // Call guessNumber and print the result
        int result = solution.guessNumber(n);
        System.out.println("Guessed Number: " + result); // Expected output: 6
    }
}

// ! Time Complexity = O(log n)
// ! Space Complexity = O(1)