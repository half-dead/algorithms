package p1500_;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/
 *
 * @author half-dead
 */
public class Puzzle1452 {

    // this is a shit question, 19ms, beats 99%
    class Solution {
        public List<Integer> peopleIndexes(List<List<String>> fcs) {
            HashSet<String>[] sets = new HashSet[fcs.size()];
            int i = 0;
            for (List<String> fc : fcs) sets[i++] = new HashSet<>(fc);

            List<Integer> res = new ArrayList<>();
            i = 0;
            for (HashSet<String> set1 : sets) {
                boolean subset = false;
                for (HashSet<String> set2 : sets) {
                    if (set1 == set2) continue;
                    if (set2.size() > set1.size() && set2.containsAll(set1)) {
                        subset = true;
                        break;
                    }
                }
                if (!subset) res.add(i);
                i++;
            }
            return res;
        }
    }
}
