package p1000_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-duplicate-file-in-system/
 *
 * @author half-dead
 */
public class Puzzle609_FindDuplicateFileInSystem {
    class Solution {
        public List<List<String>> findDuplicate(String[] paths) {
            Map<String, List<String>> map = new HashMap<>();
            for (String s : paths) {
                int len = s.length();
                int idx = s.indexOf(' ');
                String dir = s.substring(0, idx);
                while (idx >= 0) {
                    int left = s.indexOf('(', idx + 1);
                    int right = s.indexOf(')', idx + 1);
                    String filename = s.substring(idx + 1, left);
                    String content = s.substring(left + 1, right);
                    String path = dir + "/" + filename;
                    if (map.containsKey(content)) {
                        map.get(content).add(path);
                    } else {
                        List<String> list = new ArrayList<>();
                        list.add(path);
                        map.put(content, list);
                    }
                    idx = s.indexOf(' ', idx + 1);
                }
            }
            List<List<String>> result = new ArrayList<>();
            for (String key : map.keySet()) {
                List<String> list = map.get(key);
                if (list.size() > 1) {
                    result.add(list);
                }
            }
            return result;
        }
    }
}
