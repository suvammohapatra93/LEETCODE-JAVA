
// LEETCODE:746:MIN COST CLIMBING STAIRS:

public class L746 {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for (int i = 2; i < n; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[n - 1], cost[n - 2]);
    }

    public static void main(String[] args) {
        int[] cost = { 10, 15, 20 };
        System.out.println("Minimum cost to climb the stairs is: " + minCostClimbingStairs(cost));

        // Output will be -> Minimum cost to climb the stairs is: 15
    }
}

// ! Time Ciomplexity = O(n)
// ! Space Ciomplexity = O(1)
