package p1000_;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/number-of-atoms/
 *
 * @author half-dead
 */
public class Puzzle726 {

    class Solution {
        public String countOfAtoms(String formula) {
            int[] n = new int[1];
            StringBuilder element = new StringBuilder();
            Map<String, Integer> curMap = new HashMap<>(), poppedMap = new HashMap<>();
            LinkedList<Map<String, Integer>> stack = new LinkedList<>();
            stack.push(curMap);

            for (char c : formula.toCharArray()) {
                if (Character.isLetter(c)) {
                    if (Character.isUpperCase(c))
                        calculate(curMap, poppedMap, element, n);

                    element.append(c);
                } else if (Character.isDigit(c)) {
                    n[0] = n[0] * 10 + (c - '0');
                } else {
                    calculate(curMap, poppedMap, element, n);

                    if (c == '(') stack.push(new HashMap<>());
                    else if (c == ')') poppedMap = stack.pop();

                    curMap = stack.peek();
                }
            }
            calculate(curMap, poppedMap, element, n);

            TreeMap<String, Integer> treeMap = new TreeMap<>(curMap);
            element = new StringBuilder();
            for (String e : treeMap.keySet()) {
                int cnt = treeMap.get(e);
                element.append(e);
                if (cnt > 1) element.append(cnt);
            }
            return element.toString();
        }

        void calculate(Map<String, Integer> curMap, Map<String, Integer> poppedMap, StringBuilder element, int[] n) {
            if (n[0] == 0) n[0] = 1;
            if (poppedMap.size() > 0) {
                for (String e : poppedMap.keySet())
                    curMap.put(e, curMap.getOrDefault(e, 0) + poppedMap.get(e) * n[0]);
                poppedMap.clear();
            } else if (element.length() > 0) {
                String e = element.toString();
                curMap.put(e, curMap.getOrDefault(e, 0) + n[0]);
                element.delete(0, element.length());
            }
            n[0] = 0;
        }
    }
}
