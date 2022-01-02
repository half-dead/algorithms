package p1000_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/guess-the-word/
 *
 * @author half-dead
 */
public class Puzzle843 {

    public static void main(String[] args) {
        Puzzle843 p = new Puzzle843();
        Solution s = p.new Solution();
        s.findSecretWord(new String[]{
                "abcdef", "acdefg", "adefgh", "aefghi", "afghij", "aghijk", "ahijkl",
                "aijklm", "ajklmn", "aklmno", "almnoz", "anopqr", "azzzzz"
        }, p.new Master0("azzzzz"));
    }

    /**
     * the other two strategy is:
     * 1. guess the one with minimum 0 overlap, because the words are generated randomly,
     *    so the chance of getting 0 match is (25/26 ^ 6) = 79%, which means we have 79% chance to narrow down candidates
     * 2. if we dont have to guess from the wordlist,
     *    we can guess the word based on the most frequent character on every position
     */
    class Solution {
        public void findSecretWord(String[] wordlist, Master master) {
            int n = wordlist.length, m = 6;

            Set<Integer> candidates = new HashSet<>(n);

            // calculate and store the overlaps between every two different words:
            // sets[0] stores the indexes of words which has 0 overlap with wordlist[0]......
            // sets[x] stores the indexes of words which has x%6 overlap with wordlist[x/6]
            Set<Integer>[] sets = new Set[m * n];
            for (int i = 0; i < m * n; i++) sets[i] = new HashSet<>();

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int overlap = overlap(wordlist[i], wordlist[j]);
                    sets[m * i + overlap].add(j);
                    sets[m * j + overlap].add(i);
                }
                // in the beginning, every word is a candidate
                candidates.add(i);
            }

            // try 10 guesses
            for (int i = 0; i < 10; i++) {
                // each guess, we choose the one with the largest minimunElimination
                // for example, the overlap array of some word is below:
                // [10, 20, 30, 35, 2, 2]  notice that sum(arr) + 1(the word itself) = candidates.size()
                // minimumElimation is 100-35=65, which means master.guess(word) returned 3
                int best = 0, answer = candidates.iterator().next();
                for (int id : candidates) {
                    int minimumElination = candidates.size();
                    for (int j = 0; j < m; j++) {
                        minimumElination = Math.min(minimumElination, candidates.size() - sets[id * m + j].size());
                    }
                    if (minimumElination > best) {
                        best = minimumElination;
                        answer = id;
                    }
                }

                int guess = master.guess(wordlist[answer]);
                if (guess == 6)
                    break;

                Set<Integer> survivors = sets[answer * m + guess], eliminations = candidates;
                eliminations.removeAll(survivors);
                for (int id : survivors) {
                    for (int j = 0; j < m; j++) {
                        // remove all eliminated words from pre-calculated results
                        sets[id * m + j].removeAll(eliminations);
                    }
                }

                candidates = new HashSet<>(survivors);
            }
        }

        int overlap(String a, String b) {
            int res = 0;
            for (int i = 0; i < 6; i++) if (a.charAt(i) == b.charAt(i)) res++;
            return res;
        }
    }

    interface Master {
        int guess(String word);
    }

    class Master0 implements Master {
        String secret;

        public Master0(String secret) {
            this.secret = secret;
        }

        @Override
        public int guess(String word) {
            return overlap(secret, word);
        }

        int overlap(String a, String b) {
            int res = 0;
            for (int i = 0; i < 6; i++) {
                if (a.charAt(i) == b.charAt(i)) res++;
            }
            return res;
        }
    }

}
