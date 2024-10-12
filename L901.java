
//LEETCODE->901->Online stock span

import java.util.Stack;

public class L901 {

    // Stack to store pairs of (price, span)
    private Stack<int[]> stack;

    public L901() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        // Pop elements from the stack while the price on top is less than or equal to
        // the current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1]; // Add the span of the popped element
        }

        // Push the current price and its span onto the stack
        stack.push(new int[] { price, span });

        return span; // Return the span for the current price
    }

    public static void main(String[] args) {
        L901 L901 = new L901();

        System.out.println(L901.next(100)); // Output: 1
        System.out.println(L901.next(80)); // Output: 1
        System.out.println(L901.next(60)); // Output: 1
        System.out.println(L901.next(70)); // Output: 2
        System.out.println(L901.next(60)); // Output: 1
        System.out.println(L901.next(75)); // Output: 4
        System.out.println(L901.next(85)); // Output: 6
    }
}

// ! Time Complexity = O(1)
// ! Space Complexity = O(n)
/**
 * Your L901 object will be instantiated and called as such:
 * L901 obj = new L901();
 * int param_1 = obj.next(price);
 */
