package UniqueMorseCodeWords;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-11-19 16:43
 **/

import java.util.HashMap;

/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

 For convenience, the full table for the 26 letters of the English alphabet is given below:

 [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.

 Return the number of different transformations among all words we have.

 Example:
 Input: words = ["gin", "zen", "gig", "msg"]
 Output: 2
 Explanation:
 The transformation of each word is:
 "gin" -> "--...-."
 "zen" -> "--...-."
 "gig" -> "--...--."
 "msg" -> "--...--."

 There are 2 different transformations, "--...-." and "--...--.".
 Note:

 The length of words will be at most 100.
 Each words[i] will have length in range [1, 12].
 words[i] will only consist of lowercase letters.
 */

class Solution {
  public int uniqueMorseRepresentations(String[] words) {
    String[] morseCode = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    HashMap<String, Integer> statistics = new HashMap<>();
    int count = 0;
    StringBuilder builder;
    for (int i = 0; i < words.length; i++) {
      builder = new StringBuilder();
      String word = words[i].toLowerCase();
      char[] chars = word.toCharArray();
      for (int j = 0; j < chars.length; j++) {
        builder.append(morseCode[chars[j] - 'a']);
      }
      if (statistics.get(builder.toString()) == null){
        statistics.put(builder.toString(), 0);
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
  }
}
