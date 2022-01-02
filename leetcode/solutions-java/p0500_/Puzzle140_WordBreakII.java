package p0500_;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break-ii/
 *
 * @author half-dead
 */
public class Puzzle140_WordBreakII {

    public static void main(String[] args) {
        Puzzle140_WordBreakII p = new Puzzle140_WordBreakII();
        Solution s = p.new Solution();
        System.out.println(s.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(s.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
//        System.out.println(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

    // dfs with memoization
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict);
            HashMap<String, List<String>> cache = new HashMap<>();
            cache.put("", Collections.singletonList(""));
            return dfs(s, dict, cache);
        }

        List<String> dfs(String s, Set<String> dict, Map<String, List<String>> cache) {
            if (cache.containsKey(s)) return cache.get(s);
            List<String> result = new LinkedList<>();
            for (String word : dict)
                if (s.startsWith(word))
                    for (String tail : dfs(s.substring(word.length()), dict, cache))
                        result.add(word + (tail.isEmpty() ? "" : " " + tail));
            cache.put(s, result);
            return result;
        }
    }

    // backtracking, TLE
    class Solution2 {
        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<Character> charSet = new HashSet<>();
            for (String word : wordDict) for (int i = 0; i < word.length(); i++) charSet.add(word.charAt(i));
            for (int i = 0; i < s.length(); i++) if (!charSet.contains(s.charAt(i))) return new ArrayList<>();

            Set<String> set = new HashSet<>(wordDict);
            List<String> result = new ArrayList<>();
            LinkedList<String> current = new LinkedList<>();
            char[] chars = s.toCharArray();
            backtracking(result, set, current, chars, 0);
            return result;
        }

        void backtracking(List<String> list, Set<String> dict, LinkedList<String> current, char[] chars, int begin) {
            if (begin == chars.length) {
                StringBuilder s = new StringBuilder();
                for (String word : current) {
                    if (s.length() > 0) s.append(' ');
                    s.append(word);
                }
                System.out.println(s);
                list.add(s.toString());
            }
            StringBuilder builder = new StringBuilder();
            for (int i = begin; i < chars.length; i++) {
                builder.append(chars[i]);
                if (dict.contains(builder.toString())) {
                    current.addLast(builder.toString());
                    backtracking(list, dict, current, chars, i + 1);
                    current.removeLast();
                }
            }
        }
    }
}
