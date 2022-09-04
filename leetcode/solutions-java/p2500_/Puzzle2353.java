package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/design-a-food-rating-system/
 *
 * @author half-dead
 */
public class Puzzle2353 {

    public static void main(String[] args) {
        FoodRatings fr = new Puzzle2353().new FoodRatings(new String[]{
                "czopaaeyl", "lxoozsbh", "kbaxapl"
        }, new String[]{
                "dmnuqeatj", "dmnuqeatj", "dmnuqeatj"
        }, new int[]{11, 2, 15});

        fr.changeRating("czopaaeyl", 12);
        System.out.println(fr.highestRated("dmnuqeatj"));
        fr.changeRating("kbaxapl", 8);
        fr.changeRating("lxoozsbh", 5);
        System.out.println(fr.highestRated("dmnuqeatj"));
    }

    class FoodRatings {

        String[] foods;
        String[] cuisines;
        int[] ratings;

        Map<String, Integer> rmap;
        Map<String, TreeSet<String>> map = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            this.foods = foods;
            this.cuisines = cuisines;
            this.ratings = ratings;

            rmap = new HashMap<>(foods.length);
            for (int i = 0; i < foods.length; i++) {
                rmap.put(foods[i], i);
            }

            for (int i = 0; i < foods.length; i++) {

                TreeSet<String> ts = new TreeSet<>((a, b) -> {
                    int p = rmap.get(a), q = rmap.get(b);
                    int d = ratings[q] - ratings[p];
                    return d != 0 ? d : a.compareTo(b);
                });

                String cuisine = cuisines[i];
                map.computeIfAbsent(cuisine, x -> ts).add(foods[i]);
            }
        }

        public void changeRating(String food, int newRating) {
            int idx = rmap.get(food);
            TreeSet<String> ts = map.get(cuisines[idx]);
            ts.remove(food);

            ratings[idx] = newRating;
            ts.add(food);
        }

        public String highestRated(String cuisine) {
            return map.get(cuisine).first();
        }
    }

}
