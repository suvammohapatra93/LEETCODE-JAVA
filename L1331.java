
//LeetCode -> 1331 -> Rank transform of an array 

import java.util.*;

public class L1331 {
    public static int[] arrayRankTransform(int[] arr) {
        // Store the rank for each number in arr
        HashMap<Integer, Integer> numToRank = new HashMap<>();
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        int rank = 1;
        for (int i = 0; i < sortedArr.length; i++) {
            if (i > 0 && sortedArr[i] > sortedArr[i - 1]) {
                rank++;
            }
            numToRank.put(sortedArr[i], rank);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numToRank.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 40, 10, 20, 30 };
        int[] result = arrayRankTransform(arr);
        System.out.println(Arrays.toString(result));
        // Output will be -> [4, 1, 2, 3]
    }
}

// ! Time Complexity = O(n log n)
// ! Space Complexity = O(1)