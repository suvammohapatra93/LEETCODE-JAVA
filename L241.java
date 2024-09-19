
// LEETCODE:241:DIFFERENT WAYS TO ADD PARANTHESIS:

import java.util.ArrayList;
import java.util.List;

public class L241 {
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        // Base case: if the expression is a single number, return it as a result
        if (expression.matches("\\d+")) {
            result.add(Integer.parseInt(expression));
            return result;
        }

        // Iterate over each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the character is an operator
            if (c == '+' || c == '-' || c == '*') {
                // Recursively solve the left and right parts of the expression
                List<Integer> leftResults = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightResults = diffWaysToCompute(expression.substring(i + 1));

                // Combine the results from left and right parts based on the operator
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        switch (c) {
                            case '+':
                                result.add(left + right);
                                break;
                            case '-':
                                result.add(left - right);
                                break;
                            case '*':
                                result.add(left * right);
                                break;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String expression = "2*3-4*5";
        List<Integer> results = diffWaysToCompute(expression);
        System.out.println("Different ways to compute: " + results);
        // Output will be -> Different ways to compute: [-34, -10, -14, -10, 10]
    }
}

// ! Time Complexity = O(n * 2^n)
// ! Space Complexity = O(n * 2^n)