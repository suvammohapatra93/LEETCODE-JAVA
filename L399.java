/*LEETCODE:399:EVALUATE DIVISION: ---------------->

You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.Return the answers to all queries. If a single answer cannot be determined, return -1.0.
Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
Example 1:
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
note: x is undefined => -1.0
Example 2:
Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:
Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
Constraints:
1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */

import java.util.*;

public class L399 {
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Step 1: Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(numerator, new HashMap<>());
            graph.putIfAbsent(denominator, new HashMap<>());

            graph.get(numerator).put(denominator, value);
            graph.get(denominator).put(numerator, 1.0 / value);
        }

        // Step 2: Process each query
        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String numerator = queries.get(i).get(0);
            String denominator = queries.get(i).get(1);

            if (!graph.containsKey(numerator) || !graph.containsKey(denominator)) {
                results[i] = -1.0;
            } else if (numerator.equals(denominator)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, numerator, denominator, 1.0, visited);
            }
        }

        return results;
    }

    private static double dfs(Map<String, Map<String, Double>> graph, String current, String target, double value,
            Set<String> visited) {
        if (current.equals(target)) {
            return value;
        }

        visited.add(current);

        Map<String, Double> neighbors = graph.get(current);
        for (String neighbor : neighbors.keySet()) {
            if (!visited.contains(neighbor)) {
                double result = dfs(graph, neighbor, target, value * neighbors.get(neighbor), visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = { 2.0, 3.0 };

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        double[] results = calcEquation(equations, values, queries);

        System.out.println(Arrays.toString(results));
    }
}

//! Time Complexity = O(Q * (V+E))
//! Space Complexity = O((V+E))