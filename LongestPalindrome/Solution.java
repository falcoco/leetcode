package LongestPalindrome;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-09-13 13:56
 **/

import java.util.HashMap;
import java.util.Iterator;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest
 * palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note: Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input: "abccccdd"
 *
 * Output: 7
 *
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

class Solution {
  public static int longestPalindrome(String s) {
    char[] chars = s.toCharArray();
    HashMap<Character, Integer> statistiques = new HashMap<>();
    // Calculate the frequence of each character
    for (int i = 0; i < chars.length; i++) {
      Integer timer =  statistiques.get(chars[i]);
      if (timer != null){
        statistiques.put(chars[i], ++timer);
      }else {
        statistiques.put(chars[i], new Integer(1));
      }
    }
    // add all even number， add one odd number
    int length = 0;
    Object key;
    Integer value;
    boolean singleFlag = false;
    int oddMaxLength = 0;
    Iterator iterator = statistiques.keySet().iterator();
    while (iterator.hasNext()){
      key = iterator.next();
      value = statistiques.get(key);
      if (value % 2 == 0){
        length += value;
      }else if(value == 1){
        singleFlag = true;
      }else if (value % 2 == 1 && value != 1){
        length += value - 1;
        singleFlag = true;
      }
    }
    if (singleFlag){
      length ++;
    }
    length += oddMaxLength;
    return length;
  }

  public static void main(String[] args) {
    String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
    System.out.println(longestPalindrome(s));
  }
}