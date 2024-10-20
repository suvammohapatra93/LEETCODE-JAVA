
//LeetCode ->1106 -> Parsing a Boolean eXPRESSION ->

import java.util.*;

public class L1106 {

    public static boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for (char currChar : expression.toCharArray()) {
            if (currChar == ',' || currChar == '(')
                continue; // Skip commas and open parentheses

            // Push operators and boolean values to the stack
            if (currChar == 't' || currChar == 'f' || currChar == '!' || currChar == '&' || currChar == '|') {
                st.push(currChar);
            }
            // Handle closing parentheses and evaluate the subexpression
            else if (currChar == ')') {
                // Use a list to gather all values between the last '(' and the operator
                List<Character> values = new ArrayList<>();

                while (st.peek() != '!' && st.peek() != '&' && st.peek() != '|') {
                    values.add(st.pop());
                }

                // Pop the operator
                char op = st.pop();

                // Evaluate the current subexpression based on the operator
                if (op == '!') {
                    // '!' applies to a single value
                    char val = values.get(0);
                    st.push(val == 't' ? 'f' : 't');
                } else if (op == '&') {
                    // '&' is true if all are true
                    st.push(values.contains('f') ? 'f' : 't');
                } else {
                    // '|' is true if at least one is true
                    st.push(values.contains('t') ? 't' : 'f');
                }
            }
        }

        // The final result is at the top of the stack
        return st.peek() == 't';
    }

    public static void main(String[] args) {

        String expression = "|(&(t,f,t),!(t))"; // This is a boolean expression to parse
        boolean result = parseBoolExpr(expression);

        System.out.println("The result of parsing the expression '" + expression + "' is: " + result);
        // Output -> The result of parsing the expression '|(&(t,f,t),!(t))' is: false
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)