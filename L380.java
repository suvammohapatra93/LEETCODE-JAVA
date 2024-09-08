/*LEETCODE:380:INSERT DELETE GET RANDOM O(1)--------------->

Implement the RandomizedSet class:
RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.
Example 1:
Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]
Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
Constraints:
-231 <= val <= 231 - 1
At most 2 * 105 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class L380 {
    // Use static for fields
    private static Map<Integer, Integer> map;
    private static List<Integer> list;
    private static Random random;

    // Constructor to initialize the data structures
    public L380() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    // Static method to insert a value into the set
    public static boolean insert(int val) {
        // If the value is already present, return false
        if (map.containsKey(val)) {
            return false;
        }
        // Add the value to the list and update the map with the index of the value in
        // the list
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    // Static method to remove a value from the set
    public static boolean remove(int val) {
        // If the value is not present, return false
        if (!map.containsKey(val)) {
            return false;
        }
        // Get the index of the value to be removed
        int index = map.get(val);
        // Get the last element in the list
        int lastElement = list.get(list.size() - 1);

        // Swap the element to be removed with the last element
        list.set(index, lastElement);
        // Update the map with the new index of the last element
        map.put(lastElement, index);

        // Remove the last element from the list and delete the value from the map
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    // Static method to get a random element from the set
    public static int getRandom() {
        // Return a random element from the list
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        // Instantiate the L380 class (not strictly necessary since everything is
        // static, but for clarity)
        L380 randomizedSet = new L380();

        // Test insert method
        System.out.println(L380.insert(1)); // Output: true (inserted successfully)
        System.out.println(L380.insert(2)); // Output: true (inserted successfully)
        System.out.println(L380.insert(1)); // Output: false (1 already exists)

        // Test remove method
        System.out.println(L380.remove(1)); // Output: true (removed successfully)
        System.out.println(L380.remove(1)); // Output: false (1 no longer exists)

        // Test getRandom method
        System.out.println(L380.getRandom()); // Output: Should return 2 since only 2 is left in the set
        System.out.println(L380.getRandom()); // Output: Should return 2 again
    }
}

// ! Time Complexity = O(1)
// ! Space Complexity = O(1)
