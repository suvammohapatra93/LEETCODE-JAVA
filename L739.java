
//LeetCode -> 739 -> DAILY TEMPRATURE:

import java.util.Stack;

public class L739 {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // While there are indices in the stack and current temperature is higher than
            // the temperature at the top index of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index; // Calculate the difference in days
            }
            stack.push(i); // Push current index to the stack
        }

        return result; // Days to wait for a warmer temperature
    }

    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };

        int[] result = dailyTemperatures(temperatures);

        for (int days : result) {
            System.out.print(days + " ");
        }
        // Output -> 1 1 4 2 1 1 0 0
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)