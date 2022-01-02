/*
https://leetcode.com/problems/guess-number-higher-or-lower/description/

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

  -1 : My number is lower
   1 : My number is higher
   0 : Congrats! You got it!
Example:
  n = 10, I pick 6.

Return 6.

 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle374_GuessNumberHigherOrLower {

    static abstract class GuessGame {
        int guess(int num) {
            return num;
        }
    }

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int min = 1, max = n;
            while (max > 0) {
                int myGuess = min + (max - min) / 2;
                int flag = guess(myGuess);
                if (flag == 0) {
                    return myGuess;
                } else if (flag == 1) {
                    min = myGuess + 1;
                } else {
                    max = myGuess - 1;
                }
            }
            return 0;
        }
    }
}

