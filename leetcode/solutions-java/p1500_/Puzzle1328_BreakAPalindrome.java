package p1500_;

/**
 * https://leetcode.com/problems/break-a-palindrome/
 *
 * @author half-dead
 */
public class Puzzle1328_BreakAPalindrome {

    public static void main(String[] args) {
        Solution s = new Puzzle1328_BreakAPalindrome().new Solution();
        System.out.println(s.breakPalindrome("abccba"));
    }

    class Solution {
        public String breakPalindrome(String palindrome) {
            if (palindrome.length() <= 1) return "";

            char[] arr = palindrome.toCharArray();
            int mid = arr.length / 2;
            for (int i = 0; i < mid; i++) {
                if (arr[i] != 'a') {
                    arr[i] = 'a';
                    return String.valueOf(arr);
                }
            }
            // original string contains only letter 'a', so replace the last letter to 'b'
            arr[arr.length - 1] = 'b';
            return String.valueOf(arr);
        }
    }
}
