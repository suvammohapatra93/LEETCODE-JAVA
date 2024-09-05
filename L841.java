/*LEETCODE:841:KEYS AND ROOMS ->
There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
Example 1:
Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation: 
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.
Example 2:
Input: rooms = [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
Constraints:
n == rooms.length
2 <= n <= 1000
0 <= rooms[i].length <= 1000
1 <= sum(rooms[i].length) <= 3000
0 <= rooms[i][j] < n
All the values of rooms[i] are unique.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(); // Number of rooms
        boolean[] visited = new boolean[n]; // To track visited rooms
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS

        // Start with room 0
        visited[0] = true;
        queue.add(0);

        // BFS
        while (!queue.isEmpty()) {
            int room = queue.poll();
            // Go through all the keys in the current room
            for (int key : rooms.get(room)) {
                if (!visited[key]) { // If the room hasn't been visited
                    visited[key] = true; // Mark it as visited
                    queue.add(key); // Add it to the queue to explore its keys
                }
            }
        }

        // Check if all rooms have been visited
        for (boolean v : visited) {
            if (!v)
                return false; // If any room hasn't been visited, return false
        }

        return true;
    }

    public static void main(String[] args) {
        L841 solution = new L841();

        // Example 1
        List<List<Integer>> rooms1 = new ArrayList<>();
        rooms1.add(List.of(1)); // Room 0 has key to Room 1
        rooms1.add(List.of(2)); // Room 1 has key to Room 2
        rooms1.add(List.of(3)); // Room 2 has key to Room 3
        rooms1.add(List.of()); // Room 3 has no keys
        System.out.println("Example 1: " + solution.canVisitAllRooms(rooms1)); // Expected: true

        // Example 2
        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(List.of(1, 2, 3)); // Room 0 has keys to Room 1, Room 2, Room 3
        rooms2.add(List.of()); // Room 1 has no keys
        rooms2.add(List.of()); // Room 2 has no keys
        rooms2.add(List.of()); // Room 3 has no keys
        System.out.println("Example 2: " + solution.canVisitAllRooms(rooms2)); // Expected: true

        // Example 3
        List<List<Integer>> rooms3 = new ArrayList<>();
        rooms3.add(List.of(1)); // Room 0 has key to Room 1
        rooms3.add(List.of(2)); // Room 1 has key to Room 2
        rooms3.add(List.of(0)); // Room 2 has key to Room 0 (cycle)
        rooms3.add(List.of()); // Room 3 has no keys
        System.out.println("Example 3: " + solution.canVisitAllRooms(rooms3)); // Expected: false
    }
}


//! Time Complexity = O(V+E)
//! Space Complexity = O(V)