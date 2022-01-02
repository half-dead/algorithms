package p1500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/making-file-names-unique/
 *
 * @author half-dead
 */
public class Puzzle1487 {

    class Solution {
        public String[] getFolderNames(String[] names) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < names.length; i++) {
                String name = names[i];

                int id = map.getOrDefault(name, -1) + 1;
                String sn = name + (id == 0 ? "" : ("(" + id + ")"));
                while (map.containsKey(sn)) {
                    sn = name + (id == 0 ? "" : ("(" + ++id + ")"));
                }

                map.put(name, id);
                if (!sn.equals(name)) {
                    map.put(sn, 0);
                }
                names[i] = sn;
            }
            return names;
        }
    }
}
