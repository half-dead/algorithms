package p0500_;

// You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
//
// For example:
//
// Secret number:  "1807"
// Friend's guess: "7810"
// Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
// Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".
//
// Please note that both secret number and friend's guess may contain duplicate digits, for example:
//
// Secret number:  "1123"
// Friend's guess: "0111"
// In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
// You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 */
public class Puzzle299_BullsAndCows {

    public static void main(String[] args) {
        Puzzle299_BullsAndCows p = new Puzzle299_BullsAndCows();
        Solution2 s = p.new Solution2();
        String hint = s.getHint("0765860239", "5736153483");
        System.out.println(hint);
    }

    public class Solution {
        public String getHint(String secret, String guess) {
            int bulls = 0, cows = 0;
            Map<Character, Integer> beginIndex = new HashMap<>(10);
            for (char c = '0'; c <= '9'; c++) {
                beginIndex.put(c, 0);
            }

            char[] chars = guess.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; i++) {
                char gc = chars[i];
                if (secret.charAt(i) == gc) {
                    bulls++;
                } else {
                    int gcIndex = beginIndex.get(gc);
                    while (gcIndex <= len) {
                        int sc = -1;
                        if ((sc = secret.indexOf(gc, gcIndex)) >= 0) {
                            if (chars[sc] != gc) {
                                cows++;
                                beginIndex.put(gc, sc + 1);
                                break;
                            } else {
                                gcIndex++;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            return bulls + "A" + cows + "B";
        }
    }

    public class Solution2 {
        public String getHint(String secret, String guess) {
            int bulls = 0;
            int cows = 0;
            int[] numbers = new int[10];
            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == guess.charAt(i)) bulls++;
                else {
                    if (numbers[secret.charAt(i) - '0']++ < 0) cows++;
                    if (numbers[guess.charAt(i) - '0']-- > 0) cows++;
                }
            }
            return bulls + "A" + cows + "B";
        }
    }

}
