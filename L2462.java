
/*LEETCODE:2462:TOTAL COST TO HIRE K WORKERS: */

import java.util.PriorityQueue;

public class L2462 {
    public static long totalCost(int[] costs, int k, int candidates) {
        // Min heap for left and right workers
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int n = costs.length;
        int leftIndex = 0;
        int rightIndex = n - 1;
        long totalCost = 0;

        // Add initial candidates from the left and right to their respective heaps
        for (int i = 0; i < candidates && leftIndex <= rightIndex; i++) {
            leftHeap.add(costs[leftIndex++]);
        }

        for (int i = 0; i < candidates && leftIndex <= rightIndex; i++) {
            rightHeap.add(costs[rightIndex--]);
        }

        // Hire k workers
        for (int i = 0; i < k; i++) {
            if (!leftHeap.isEmpty() && (rightHeap.isEmpty() || leftHeap.peek() <= rightHeap.peek())) {
                totalCost += leftHeap.poll();
                if (leftIndex <= rightIndex) {
                    leftHeap.add(costs[leftIndex++]);
                }
            } else {
                totalCost += rightHeap.poll();
                if (leftIndex <= rightIndex) {
                    rightHeap.add(costs[rightIndex--]);
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        
        int[] costs = { 10, 20, 30, 40, 50, 60, 70 };
        int k = 3; 
        int candidates = 2; 

        
        long result = L2462.totalCost(costs, k, candidates);

        
        System.out.println("Total cost to hire " + k + " workers: " + result);
        //Output will be -> Total cost to hire 3 workers: 60
    }
}

// ! Time Complexity = O(k log candies)
// ! Space Complexity = O(candidates)