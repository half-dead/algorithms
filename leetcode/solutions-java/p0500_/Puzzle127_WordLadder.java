package p0500_;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/
 *
 * @author half-dead
 */
public class Puzzle127_WordLadder {
    public static void main(String[] args) {
        Puzzle127_WordLadder p = new Puzzle127_WordLadder();
        Solution2 s = p.new Solution2();
        System.out.println(s.ladderLength("leet", "code", Arrays.asList("lest", "leet", "lose", "code", "lode", "robe", "lost")));
    }

    class Solution2 {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Map<String, Set<String>> graph = new HashMap<>();
            for (String word : wordList) graph.put(word, new HashSet<>());
            if (!graph.containsKey(endWord)) return 0;

            int len = wordList.size();
            for (int i = 0; i < len; i++)
                for (int j = i + 1; j < len; j++) {
                    String from = wordList.get(i), to = wordList.get(j);
                    if (canReach(from, to)) {
                        graph.get(from).add(to);
                        graph.get(to).add(from);
                    }
                }

            LinkedList<String> queue = new LinkedList<>();
            for (String w : graph.keySet()) if (canReach(beginWord, w)) queue.push(w);
            if (queue.size() == 0) return 0;

            int count = 1;
            while (queue.size() > 0) {
                count++;
                LinkedList<String> next = new LinkedList<>();
                while (queue.size() > 0) {
                    String step = queue.pop();
                    if (step.equals(endWord)) return count;

                    if (graph.containsKey(step)) {
                        for (String neighbour : graph.get(step)) {
                            next.add(neighbour);
                            graph.get(neighbour).remove(step);
                        }
                        graph.remove(step);
                    }
                }
                queue = next;
            }
            return 0;
        }

        boolean canReach(String a, String b) {
            int sum = 0;
            for (int i = 0; i < a.length(); i++)
                if (a.charAt(i) != b.charAt(i)) sum++;
            return sum == 1;
        }
    }

    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (wordList == null || wordList.size() == 0) return 0;
            HashSet<String> start = new HashSet<>();
            HashSet<String> end = new HashSet<>();
            HashSet<String> dic = new HashSet<>(wordList);
            start.add(beginWord);
            end.add(endWord);
            if (!dic.contains(endWord)) return 0;
            return bfs(start, end, dic, 2);

        }

        public int bfs(HashSet<String> st, HashSet<String> ed, HashSet<String> dic, int l) {
            if (st.size() == 0) return 0;
            if (st.size() > ed.size()) {
                return bfs(ed, st, dic, l);
            }
            dic.removeAll(st);
            HashSet<String> next = new HashSet<>();
            for (String s : st) {
                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char tmp = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (tmp == c) continue;
                        arr[i] = c;
                        String nstr = new String(arr);
                        if (dic.contains(nstr)) {
                            if (ed.contains(nstr)) return l;
                            else next.add(nstr);
                        }
                    }
                    arr[i] = tmp;
                }
            }
            return bfs(next, ed, dic, l + 1);
        }
    }
}
