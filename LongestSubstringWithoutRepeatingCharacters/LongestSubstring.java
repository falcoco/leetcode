package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.

     Example 1:

     Input: "abcabcbb"
     Output: 3
     Explanation: The answer is "abc", which the length is 3.
     Example 2:

     Input: "bbbbb"
     Output: 1
     Explanation: The answer is "b", with the length of 1.
     Example 3:

     Input: "pwwkew"
     Output: 3
     Explanation: The answer is "wke", with the length of 3.
     Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> singleMap = new HashMap<>();
        if (s.length() < 1){
            return 0;
        }

        int length = 0;
        int maxLength = 0;
        int cursor = 0;
        char[] arrays = s.toCharArray();

        for (int i = 0; i < arrays.length; i++) {
            cursor = i;
            length = 0;
            while (cursor < arrays.length){
                if(singleMap.get(arrays[cursor]) == null){
                    singleMap.put(arrays[cursor], 1);
                    length ++;
                }else if (singleMap.get(arrays[cursor]) == 1){
                    break;
                }
                cursor++;
            }
            singleMap.clear();
            maxLength = length > maxLength ? length : maxLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
