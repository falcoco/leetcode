package LongestPalindromicSubstring;

class Solution {
    public static String longestPalindrome(String s) {
        boolean [][] dp = new boolean[s.length()][s.length()];
        int maxLen = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = (s.charAt(j) == s.charAt(i)) &&((i - j <= 2) ||  dp[j+1][i-1]);
                if (dp[j][i]){
                    if (i - j + 1 > maxLen){
                        maxLen = i - j + 1;
                        result = s.substring(j, i + 1);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String raw = "babadcbbc";
        System.out.println(longestPalindrome(raw));
    }
}