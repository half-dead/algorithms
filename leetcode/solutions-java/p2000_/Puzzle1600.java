package p2000_;

import java.util.*;

/**
 * https://leetcode.com/problems/throne-inheritance/
 *
 * @author half-dead
 */
public class Puzzle1600 {

    class ThroneInheritance {

        String king;
        Map<String, List<String>> map = new HashMap<>();
        Set<String> tomb = new HashSet<>();

        public ThroneInheritance(String kingName) {
            king = kingName;
        }

        public void birth(String parentName, String childName) {
            map.computeIfAbsent(parentName, x -> new ArrayList<>()).add(childName);
        }

        public void death(String name) {
            tomb.add(name);
        }

        public List<String> getInheritanceOrder() {
            Deque<String> dq = new LinkedList<>();
            dq.addLast(king);

            List<String> res = new ArrayList<>();
            while (dq.size() > 0) {
                String curr = dq.pollFirst();
                List<String> children = map.get(curr);
                if (children != null) {
                    for (int i = children.size() - 1; i >= 0; i--) {
                        dq.addFirst(children.get(i));
                    }
                }
                if (!tomb.contains(curr)) {
                    res.add(curr);
                }
            }
            return res;
        }
    }

}
