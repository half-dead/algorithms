package p0500_;

import java.util.*;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 *
 * @author half-dead
 */
public class Puzzle187_RepeatedDNASequences {

    public static void main(String[] args) {
        Puzzle187_RepeatedDNASequences p = new Puzzle187_RepeatedDNASequences();
        Solution s = p.new Solution();
        System.out.println(s.findRepeatedDnaSequences("TGCTCCTGTCACAACTTCTTTACCAGCCTGTTTTTCTAGAGTCGGCTCAAAACCTGCCTTTATGCGCAGCTGTCCACGAGAATTTCATGTTATCGAGGACCGCGATATACCCAATCGCGCGCCCCAGAAAAAAGAGTCTTACCAGATGTATACGGTGACGACCCAGTGGGTAAGACCGCTCTGCTCAGCGACCCGTCCATACCCACAGTCAGCCATGTGTGACATATCAGCGTGCATTCTTGATCTGTATGGGTGCGCTGCCCCCGCACTTGATGGGGTATGTGATGACTCCGCTCGGTAAGCAAGACCCTGGGGGTTCGGACGTAGGGTATACCCGAACTTCACGTATGCGGACACCAACGCACGTGCCAATTTATCTAACGTATGTCTCCATGCCGCCCAGAAGGTTAAAGTGGACCGCCGTTCGTATACTGTTTCTGCAATTGTGTGCGGCAGCACCAGGTAGAGAGCATTCTATTTCGCTAGCTAGTAAATCTACTTCACCGAGTCTGGAAGCTCCAATCGCTGTTTACAAACTTTTTGCCCCTGCGTGGGTCAGGCCATGTCCCGTTCCCGAGGATTCTAGCACTGACCTAGCCCTATATCACGAGCCGGGTTTTCTTAAAATAGAGATCGGGACGTTAAGGTCTTATGAACGGCTTCAGCTATCTTCCGCTTACCAACTGAGCCGAACTATCTCCGGGTGTTACATGGATCCTAAAATGCTCTCCAATTTTGCCCCTGCATGGTATTTCTCTTGAGACTACTGGATCTACCTGGGTTGTGCATGTTTCGTGTCTCTTCCGACGTTCGACAATTGGGGGCGACGCTTTAAGTTCTACTACGGTGAGATGCACATCCCACGGACGCCCTTTTCCTTTGGCTCTTCCTACGTTCGCGAGCGGTCCTGTAGGACAGTTGCTTTATGCCAACTTTTACGAGGGTGGAATACAGTATCGCCATGACACTCTGAAAAAGGATGGAAGACCTGAGATTCACC"));
    }

    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            int len = s.length(), mod = 1 << 20, mask = 0xFFFFF, n = 0;
            if (len < 11) return new ArrayList<>();

            int[] ints = new int['T' + 1];
            ints['C'] = 1; ints['G'] = 2; ints['T'] = 3;

            List<String> list = new ArrayList<>();
            BitSet seen = new BitSet(mod), added = new BitSet(mod);
            for (int i = 0; i < len; i++) {
                n = (n << 2) & mask | ints[s.charAt(i)];
                if (i >= 9)
                    if (seen.get(n)) {
                        if (!added.get(n)) {
                            added.set(n);
                            list.add(s.substring(i - 9, i + 1));
                        }
                    } else seen.set(n);
            }
            return list;
        }
    }

    class Solution2 {
        char[] chars = new char[]{' ', 'A', 'C', 'G', 'T'}, holder = new char[10];
        int[] ints = new int['T' + 1];

        {
            ints['A'] = 1;
            ints['C'] = 2;
            ints['G'] = 3;
            ints['T'] = 4;
        }

        public List<String> findRepeatedDnaSequences(String s) {
            int len = s.length();
            if (len < 11) return new ArrayList<>();

            Set<String> result = new HashSet<>();
            Set<Integer> seen = new HashSet<>();
            int num = 0, mod = 25 * 25 * 25 * 25 * 25;
            for (int i = 0; i < len; i++) {
                int curr = ints[s.charAt(i)];
                num *= 5;
                num += curr;
                num %= mod;

                if (i >= 9 && !seen.add(num)) result.add(toString(num));
            }
            return new ArrayList<>(result);
        }

        private String toString(int i) {
            for (int idx = 9; idx >= 0; i /= 5, idx--) holder[idx] = chars[i % 5];
            return new String(holder);
        }
    }
}
