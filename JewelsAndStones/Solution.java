package JewelsAndStones;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-11-12 10:00
 **/
import java.util.HashMap;
import java.util.Map;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

 The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

 Example 1:

 Input: J = "aA", S = "aAAbbbb"
 Output: 3
 Example 2:

 Input: J = "z", S = "ZZ"
 Output: 0
 Note:

 S and J will consist of letters and have length at most 50.
 The characters in J are distinct.
 */
class Solution {
  public int numJewelsInStones(String J, String S) {
    Map<Character, Integer> resultMap = new HashMap<>();
    char[] jewelTypes = J.toCharArray();
    int jewels = 0;
    for (int i = 0; i < jewelTypes.length; i++) {
      resultMap.put(jewelTypes[i], new Integer(0));
    }
    for (int i = 0; i < S.length(); i++) {
        if (resultMap.containsKey(S.charAt(i))){
//          resultMap.put(S.charAt(i), resultMap.get(S.charAt(i)) + 1);
          jewels++;
        }
    }
    return jewels;
  }

  public static void main(String[] args) {
    long begin = System.currentTimeMillis();
    int jewels = new Solution().numJewelsInStones("aA", "aAAbbbb");
    long end = System.currentTimeMillis();
    System.out.println("Time used: "+ (end-begin) + " ms");
    System.out.println(jewels);
  }
}