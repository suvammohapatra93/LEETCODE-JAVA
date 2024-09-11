
/*LEETCODE:135:CANDY:

There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.
Example 1:
Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:
Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
Constraints:
n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104
*/

public class L135 {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0)
            return 0;

        // Step 1: Create an array to store the number of candies for each child
        int[] candies = new int[n];

        // Step 2: Initialize each child with 1 candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Step 3: First pass - Left to Right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Step 4: Second pass - Right to Left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Step 5: Sum up the total number of candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }

    // Main method to test the candy distribution
    public static void main(String[] args) {
        int[] ratings1 = { 1, 0, 2 };
        System.out.println("Total candies needed (Test 1): " + candy(ratings1));
        // Output: 5 (children get 2, 1, 2 candies)

        int[] ratings2 = { 1, 2, 2 };
        System.out.println("Total candies needed (Test 2): " + candy(ratings2));
        // Output: 4 (children get 1, 2, 1 candies)
    }
}


//! Time Complexity = O(n)
//! Space Complexity = O(n)