import java.util.Arrays;
import java.util.HashMap;

package 04_Arrays_N_Strings.In;

public class ValidAnagram {
    // Approach using sorting - O(nlogm + mlogn ) time = O(1) or O(n+m) space
    //if lengths are not equal, they cannot be anagrams
    //convert strings to char arrays, sort them and compare
    public boolean isAnagramSorting(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
    //  Optimized Approach using frequency counting - O(n + m) time = O(1) space
    public boolean isAnagramFrequencyCounting(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26]; // Assuming only lowercase letters a-z
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
    // Approach using HashMap - O(n + m) time = O(n) space
    public boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }

}
