
// LEETCODE:714:BEST TIME TO BUY AND SELL STOCK WITH 

public class L714 {
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0)
            return 0;

        int cash = 0; // Maximum profit with no stock
        int hold = -prices[0]; // Maximum profit holding a stock

        for (int i = 1; i < n; i++) {
            cash = Math.max(cash, hold + prices[i] - fee); // Max of selling stock or doing nothing
            hold = Math.max(hold, cash - prices[i]); // Max of buying stock or doing nothing
        }
        return cash;
    }

    public static void main(String[] args) {
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;
        System.out.println(maxProfit(prices, fee)); // Output: 8
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)