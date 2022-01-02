package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/accounts-merge/
 *
 * @author half-dead
 */
public class Puzzle721_AccountsMerge {

    public static void main(String[] args) {
        Puzzle721_AccountsMerge p = new Puzzle721_AccountsMerge();
        Solution s = p.new Solution();
        List<List<String>> res = s.accountsMerge(Arrays.asList(
                Arrays.asList("David", "David0@m.co", "David1@m.co"),
                Arrays.asList("David", "David3@m.co", "David4@m.co"),
                Arrays.asList("David", "David4@m.co", "David5@m.co"),
                Arrays.asList("David", "David2@m.co", "David3@m.co"),
                Arrays.asList("David", "David1@m.co", "David2@m.co")
        ));
        for (List<String> re : res) {
            System.out.println(re);
        }
    }

    // basic Union Find
    class Solution {
        Map<String, String> dsu;

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            dsu = new HashMap<>();

            Map<String, String> emailMap = new HashMap<>();
            for (List<String> account : accounts) {
                String name = account.get(0);

                String baseEmail = account.get(1);
                emailMap.put(baseEmail, name);

                for (int i = 2; i < account.size(); i++) {
                    String email = account.get(i);

                    union(email, baseEmail);
                    emailMap.put(email, name);
                }
            }

            // group emails by their baseEmail
            Map<String, List<String>> temp = new HashMap<>();
            for (String email : emailMap.keySet()) {
                String key = find(email);
                temp.computeIfAbsent(key, x -> new ArrayList<>()).add(email);
            }

            // build result
            List<List<String>> res = new ArrayList<>(temp.size());
            for (String key : temp.keySet()) {
                List<String> emails = temp.get(key);
                Collections.sort(emails);

                List<String> account = new ArrayList<>(emails.size() + 1);
                account.add(emailMap.get(key));
                account.addAll(emails);
                res.add(account);
            }
            return res;
        }

        void union(String a, String b) {
            String ra = find(a), rb = find(b);
            dsu.put(ra, rb);
        }

        String find(String a) {
            String ra = dsu.getOrDefault(a, a);
            while (!ra.equals(a)) {
                a = ra;
                ra = dsu.getOrDefault(a, a);
            }
            return ra;
        }
    }
}
