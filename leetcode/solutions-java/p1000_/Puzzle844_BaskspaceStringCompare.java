package p1000_;

/**
 * https://leetcode.com/problems/backspace-string-compare/submissions/
 *
 * @author half-dead
 */
public class Puzzle844_BaskspaceStringCompare {

    public static void main(String[] args) {
        Puzzle844_BaskspaceStringCompare p = new Puzzle844_BaskspaceStringCompare();
        Solution s = p.new Solution();
        boolean b = s.backspaceCompare("ab##", "a#b#");
        System.out.println(b);
    }

    class Solution {
        public boolean backspaceCompare(String s, String t) {
            int sIndex = s.length() - 1;
            int tIndex = t.length() - 1;
            while (sIndex >= 0 || tIndex >= 0) {
                int backspaceCount = 0;
                char charS = ' ', charT = ' ';

                do {
                    charS = ' ';
                    while (sIndex >= 0 && s.charAt(sIndex) == '#') {
                        sIndex--;
                        backspaceCount++;
                    }
                    while (backspaceCount > 0 && sIndex >= 0) {
                        if (s.charAt(sIndex) != '#') {
                            backspaceCount--;
                        } else {
                            backspaceCount++;
                        }
                        sIndex--;
                    }
                    if (sIndex >= 0) {
                        charS = s.charAt(sIndex);
                    }
                } while (charS == '#');


                backspaceCount = 0;
                do {
                    charT = ' ';
                    while (tIndex >= 0 && t.charAt(tIndex) == '#') {
                        tIndex--;
                        backspaceCount++;
                    }
                    while (backspaceCount > 0 && tIndex >= 0) {
                        if (t.charAt(tIndex) != '#') {
                            backspaceCount--;
                        } else {
                            backspaceCount++;
                        }
                        tIndex--;
                    }
                    if (tIndex >= 0) {
                        charT = t.charAt(tIndex);
                    }
                } while (charT == '#');


                if (charS != charT) {
                    return false;
                }
                sIndex--;
                tIndex--;
            }
            return true;
        }
    }
}
