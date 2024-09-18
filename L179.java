
// LEETCODE:179:LARGEST NUMBER:

import java.util.*;

public class L179 {
    public String largestNumber(int[] nums) {
        // Step 1: Convert the integers into strings
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Step 2: Sort the strings based on the custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // Step 3: Handle the case where the largest number is "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Step 4: Join the sorted strings to form the largest number
        StringBuilder largestNum = new StringBuilder();
        for (String num : strNums) {
            largestNum.append(num);
        }

        return largestNum.toString();
    }

    public static void main(String[] args) {
        L179 solution = new L179();
        int[] nums = { 3, 30, 34, 5, 9 };
        System.out.println(solution.largestNumber(nums)); // Output: "9534330"
    }
}

// ! Time Complexity = O(n logn * m);
// ! Space Complexity = O(n)