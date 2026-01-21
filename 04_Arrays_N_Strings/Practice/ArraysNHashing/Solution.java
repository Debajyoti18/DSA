package Practice.ArraysNHashing;
/**
 * Create an empty map where each key will be the sorted version of a string and each value will be a list of words that match that key.
    For every string in the input array, convert it to a char array and sort the characters.
    Form a new string from that sorted character array.
    Check if this sorted string exists as a key in the map; if not, create a new empty list for it.
    Add the original string to the list mapped to this sorted key.
    After processing all strings, return all the lists stored in the map as the final grouped anagrams.
 */
public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    
    for (String str : strs) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        String sortedStr = new String(charArray);
        
        if (!map.containsKey(sortedStr)) {
            map.put(sortedStr, new ArrayList<>());
        }
        map.get(sortedStr).add(str);
    }
    
    return new ArrayList<>(map.values());
}
// Time Complexity: O(N * K log K) where N is the number of strings and K is the maximum length of a string.
// Space Complexity: O(N * K) for storing the output lists
//optimal approach using HashTable to store the frequency of characters

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}