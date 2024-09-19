
// LEETCODE:28:FIND THE INDEX OF FIRST OCCURANCE IN A STRING:

public class L28 {
    public static int strStr(String haystack, String needle) {
        // Edge case: if needle is empty, return 0 (defined by the problem)
        if (needle.isEmpty()) {
            return 0;
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        // Edge case: if the haystack is shorter than the needle, return -1
        if (needleLength > haystackLength) {
            return -1;
        }

        // Iterate through the haystack up to the point where the remaining characters
        // are fewer than needle's length
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            // Compare the substring of haystack from index i with the needle
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i; // Return the starting index of the first occurrence
            }
        }

        return -1; // If no match is found, return -1
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        int result = strStr(haystack, needle);
        System.out.println("First occurrence index: " + result);
        //Output will be -> First occurrence index: 0
    }
}

// ! Time Complexity = O((n-m+1)m)
// ! Space Complexity = O(1)