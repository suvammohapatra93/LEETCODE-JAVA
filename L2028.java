/*LEETCODE:2028:FIND MISSING OBSERVATION ->
You have observations of n + m 6-sided dice rolls with each face numbered from 1 to 6. n of the observations went missing, and you only have the observations of m rolls. Fortunately, you have also calculated the average value of the n + m rolls.You are given an integer array rolls of length m where rolls[i] is the value of the ith observation. You are also given the two integers mean and n.Return an array of length n containing the missing observations such that the average value of the n + m rolls is exactly mean. If there are multiple valid answers, return any of them. If no such array exists, return an empty array.The average value of a set of k numbers is the sum of the numbers divided by k.Note that mean is an integer, so the sum of the n + m rolls should be divisible by n + m.
Example 1:
Input: rolls = [3,2,4,3], mean = 4, n = 2
Output: [6,6]
Explanation: The mean of all n + m rolls is (3 + 2 + 4 + 3 + 6 + 6) / 6 = 4.
Example 2:
Input: rolls = [1,5,6], mean = 3, n = 4
Output: [2,3,2,2]
Explanation: The mean of all n + m rolls is (1 + 5 + 6 + 2 + 3 + 2 + 2) / 7 = 3.
Example 3:
Input: rolls = [1,2,3,4], mean = 6, n = 4
Output: []
Explanation: It is impossible for the mean to be 6 no matter what the 4 missing rolls are.
Constraints:
m == rolls.length
1 <= n, m <= 105
1 <= rolls[i], mean <= 6
*/

public class L2028 {
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length; // Number of observed rolls
        int totalSum = (m + n) * mean; // Total required sum

        int observedSum = 0; // Sum of observed rolls
        for (int roll : rolls) {
            observedSum += roll;
        }

        int missingSum = totalSum - observedSum; // Sum needed from missing rolls

        // Check if it's possible to distribute missingSum among n rolls
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0]; // Not possible to have such a distribution
        }

        // Result array to store the missing rolls
        int[] result = new int[n];

        // Distribute the missing sum across the missing rolls
        int baseValue = missingSum / n; // Base value for each roll
        int remainder = missingSum % n; // Remainder to distribute

        // Fill the result array
        for (int i = 0; i < n; i++) {
            result[i] = baseValue + (i < remainder ? 1 : 0);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] rolls = { 3, 2, 4, 3 };
        int mean = 4;
        int n = 2;

        int[] missing = missingRolls(rolls, mean, n);
        for (int value : missing) {
            System.out.print(value + " ");
        }
    }
}

// ! Time Complexity = O(m + n)
// ! Space Complexity = O(n)