
// LEETCODE:386:LEXIGROPHICAL NUMBERS:

import java.util.ArrayList;
import java.util.List;

public class L386 {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, result);
        }
        return result;
    }

    private static void dfs(int current, int n, List<Integer> result) {
        if (current > n)
            return;
        result.add(current);
        for (int i = 0; i < 10; i++) {
            if (current * 10 + i > n)
                return;
            dfs(current * 10 + i, n, result);
        }
    }

    public static void main(String[] args) {
        int n = 13; 
        List<Integer> result = lexicalOrder(n);
        System.out.println(result); 
        // Output will be: [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)