package ToLowerCase;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-11-19 16:24
 **/

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.



 Example 1:

 Input: "Hello"
 Output: "hello"
 Example 2:

 Input: "here"
 Output: "here"
 Example 3:

 Input: "LOVELY"
 Output: "lovely"
 *
 */
class Solution {
  public String toLowerCase(String str) {
    char[] chars = str.toCharArray();
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i]>= 'A' && chars[i] <= 'Z'){
        chars[i] += 32;
      }
      builder.append(chars[i]);
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.toLowerCase("PiTAs"));
  }
}
