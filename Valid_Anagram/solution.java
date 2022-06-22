package Valid_Anagram;

/**
 * NOTE: Use "alphabet buckets" to track the amount of times
 * each letter is used in String `s`. Then, subtract from the 
 * buckets each letter used in String `t`. If every bucket is 
 * equal to 0, the words are anagrams. Otherwise, they are not.
 */

public class solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}