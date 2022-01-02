/*
https://leetcode.com/problems/sort-characters-by-frequency/description/

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:
    Input:
    "tree"
    Output:
    "eert"
    Explanation:
    'e' appears twice while 'r' and 't' both appear once.
    So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:
    Input:
    "cccaaa"
    Output:
    "cccaaa"
    Explanation:
    Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
    Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:
    Input:
    "Aabb"
    Output:
    "bbAa"
    Explanation:
    "bbaA" is also a valid answer, but "Aabb" is incorrect.
    Note that 'A' and 'a' are treated as two different characters.
 */


package p0500_;

import java.util.Arrays;

/**
 * @author half-dead
 */
public class Puzzle451_SortCharactersByFrequency {

    public static void main(String[] args) {
        Solution solution = new Puzzle451_SortCharactersByFrequency().new Solution();
        System.out.println(solution.frequencySort("tree"));
    }

    class Solution {
        public String frequencySort(String s) {
            final int size = 128;
            char[] chars = s.toCharArray();
            int[] counts = new int[size];
            for (char c : chars) {
                counts[c]++;
            }

            for (int i = 0; i < size; i++) {
                if (counts[i] > 0) {
                    counts[i] = (counts[i] << 8) + i;
                }
            }
            Arrays.sort(counts);

            char[] result = new char[s.length()];
            int m = 0;
            for (int i = size - 1; i >= 0; i--) {
                int k = counts[i];
                if (k > 0) {
                    char c = (char) (k % size);
                    int count = k >>> 8;
                    while (count > 0) {
                        result[m++] = c;
                        count--;
                    }
                }
            }
            return new String(result);
        }
    }

    class Solution3 {
        public String frequencySort(String s) {
            int[] f = new int[256];
            char[] chars = s.toCharArray();
            char[] res = new char[s.length()];

            for (char c : chars)
                f[c]++;

            for (int i = 0; i < res.length; ) {
                int max = 0;
                int c = 0;

                for (int j = 0; j < f.length; j++) {
                    if (f[j] > max) {
                        max = f[j];
                        c = j;
                    }
                }

                f[c] = 0;
                while (max-- > 0)
                    res[i++] = (char) c;
            }

            return new String(res);
        }
    }
}
