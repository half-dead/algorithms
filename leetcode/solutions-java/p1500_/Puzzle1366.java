package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rank-teams-by-votes/
 *
 * @author half-dead
 */
public class Puzzle1366 {

    public static void main(String[] args) {
        Solution s = new Puzzle1366().new Solution();
        System.out.println(s.rankTeams(new String[]{
                "FVSHJIEMNGYPTQOURLWCZKAX", "AITFQORCEHPVJMXGKSLNZWUY", "OTERVXFZUMHNIYSCQAWGPKJL", "VMSERIJYLZNWCPQTOKFUHAXG", "VNHOZWKQCEFYPSGLAMXJIUTR", "ANPHQIJMXCWOSKTYGULFVERZ", "RFYUXJEWCKQOMGATHZVILNSP", "SCPYUMQJTVEXKRNLIOWGHAFZ", "VIKTSJCEYQGLOMPZWAHFXURN", "SVJICLXKHQZTFWNPYRGMEUAO", "JRCTHYKIGSXPOZLUQAVNEWFM", "NGMSWJITREHFZVQCUKXYAPOL", "WUXJOQKGNSYLHEZAFIPMRCVT", "PKYQIOLXFCRGHZNAMJVUTWES", "FERSGNMJVZXWAYLIKCPUQHTO", "HPLRIUQMTSGYJVAXWNOCZEKF", "JUVWPTEGCOFYSKXNRMHQALIZ", "MWPIAZCNSLEYRTHFKQXUOVGJ", "EZXLUNFVCMORSIWKTYHJAQPG", "HRQNLTKJFIEGMCSXAZPYOVUW", "LOHXVYGWRIJMCPSQENUAKTZF", "XKUTWPRGHOAQFLVYMJSNEIZC", "WTCRQMVKPHOSLGAXZUEFYNJI"
        }));
    }

    class Solution {
        public String rankTeams(String[] votes) {
            int n = votes[0].length();
            int[][] cnt = new int[26][n + 1];
            char a = 'A';
            for (int[] pair : cnt) pair[n] = a++;

            for (String vote : votes)
                for (int i = 0; i < n; i++)
                    cnt[vote.charAt(i) - 'A'][i]++;
            Arrays.sort(cnt, (p, q) -> {
                for (int i = 0; i < n; i++) if (p[i] != q[i]) return q[i] - p[i];
                return p[n] - q[n];
            });
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) sb.append((char) (cnt[i][n]));
            return sb.toString();
        }
    }
}
