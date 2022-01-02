package p1000_;

/**
 * https://leetcode.com/problems/expressive-words/
 *
 * @author half-dead
 */
public class Puzzle809_ExpressiveWords {
    public static void main(String[] args) {
        Puzzle809_ExpressiveWords p = new Puzzle809_ExpressiveWords();
        Solution s = p.new Solution();
        System.out.println(s.expressiveWords("dddiiiinnssssssoooo", new String[]{
                "dinnssoo", "ddinso", "ddiinnso", "ddiinnssoo", "ddiinso", "dinsoo", "ddiinsso", "dinssoo", "dinso"
        }));
    }

    class Solution {
        public int expressiveWords(String s, String[] words) {
            int count = 0, sLen = s.length(), sLen1 = sLen - 1;
            for (String word : words) {
                int i = 0, j = 0, wLen = word.length(), wLen1 = wLen - 1;
                while (i < wLen && j < sLen) {
                    char cw = word.charAt(i), cs = s.charAt(j);
                    if (cw != cs) break;

                    int rw = 1, rs = 1;
                    while (i < wLen1 && word.charAt(i + 1) == cw) {i++;rw++;}
                    while (j < sLen1 && s.charAt(j + 1) == cs) {j++;rs++;}

                    if (rw > rs || (rw == 1 && rs == 2)) break;

                    i++;j++;
                    if (i == wLen && j == sLen) count++;
                }
            }
            return count;
        }
    }
}
