package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/submissions/
 *
 * @author half-dead
 */
public class Puzzle2115 {

    // dfs
    class Solution {
        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            Set<String> supplyset = new HashSet<>();
            Collections.addAll(supplyset, supplies);

            int n = recipes.length;
            Map<String, Integer> rmap = new HashMap<>(n);
            for (int i = 0; i < n; i++) rmap.put(recipes[i], i);

            boolean[] done = new boolean[n], doing = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (done[i] || doing[i]) continue;
                dfs(i, recipes, ingredients, rmap, supplyset, done, doing);
            }

            List<String> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (done[i]) res.add(recipes[i]);
            }
            return res;
        }

        private boolean dfs(int i, String[] recipes, List<List<String>> ingredients, Map<String, Integer> rmap,
                            Set<String> supplyset, boolean[] done, boolean[] doing) {
            if (i < 0) return false;
            if (done[i]) return true;
            if (doing[i]) return false;
            doing[i] = true;

            boolean res = true;
            for (String ingr : ingredients.get(i)) {
                if (supplyset.contains(ingr)) continue;

                int j = rmap.getOrDefault(ingr, -1);
                res = res && dfs(j, recipes, ingredients, rmap, supplyset, done, doing);
            }
            if (res) {
                done[i] = true;
                supplyset.add(recipes[i]);
            }
            return res;
        }
    }

    // bfs
    class BfsSolution {
        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            Set<String> supplyset = new HashSet<>();
            Collections.addAll(supplyset, supplies);

            int n = recipes.length;
            Set<Integer> idset = new HashSet<>(n);
            for (int i = 0; i < n; i++) idset.add(i);

            while (true) {
                Set<Integer> newadd = new HashSet<>();
                for (int i : idset) {
                    List<String> list = ingredients.get(i);

                    int need = 0;
                    for (String ingr : list) {
                        if (!supplyset.contains(ingr)) {
                            need++;
                        }
                    }

                    if (need == 0) {
                        newadd.add(i);
                        supplyset.add(recipes[i]);
                    }
                }
                idset.removeAll(newadd);
                if (newadd.size() == 0) break;
            }

            List<String> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!idset.contains(i))
                    res.add(recipes[i]);
            }
            return res;
        }
    }
}
