package p2000_;

import java.util.*;

/**
 * https://leetcode.com/problems/design-movie-rental-system/
 *
 * @author half-dead
 */
public class Puzzle1912 {

    public static void main(String[] args) {
        MovieRentingSystem mrs = new Puzzle1912().new MovieRentingSystem(3, new int[][]{
                {0, 1, 5}, {0, 2, 6}, {0, 3, 7}, {1, 1, 4}, {1, 2, 7}, {2, 1, 5}
        });
        System.out.println(mrs.search(1));
        mrs.rent(0, 1);
        mrs.rent(1, 2);
        System.out.println(mrs.report());
        mrs.drop(1, 2);
        System.out.println(mrs.search(2));
    }

    class MovieRentingSystem {

        Map<Long, E> emap;
        Map<Integer, TreeSet<E>> mmap;
        TreeSet<E> rented;

        public MovieRentingSystem(int n, int[][] entries) {
            emap = new HashMap<>(entries.length);
            mmap = new HashMap<>();
            for (int[] entry : entries) {
                int shop = entry[0], movie = entry[1], price = entry[2];
                E e = new E(shop, movie, price);
                emap.put(key(shop, movie), e);

                mmap.computeIfAbsent(movie, x -> new TreeSet<>()).add(e);
            }

            rented = new TreeSet<>(Comparator.comparingInt((E a) -> a.price)
                    .thenComparingInt(a -> a.shop)
                    .thenComparingInt(a -> a.movie));
        }

        public List<Integer> search(int movie) {
            List<Integer> res = new ArrayList<>(5);
            TreeSet<E> ts = mmap.get(movie);
            if (ts == null) return res;

            for (E e : ts) {
                res.add(e.shop);
                if (res.size() == 5) break;
            }
            return res;
        }

        public void rent(int shop, int movie) {
            E e = emap.get(key(shop, movie));
            mmap.get(movie).remove(e);

            rented.add(e);
        }

        public void drop(int shop, int movie) {
            E e = emap.get(key(shop, movie));
            mmap.get(movie).add(e);

            rented.remove(e);
        }

        public List<List<Integer>> report() {
            List<List<Integer>> res = new ArrayList<>(5);
            for (E e : rented) {
                List<Integer> record = new ArrayList<>(2);
                record.add(e.shop);
                record.add(e.movie);
                res.add(record);
                if (res.size() == 5) break;
            }
            return res;
        }

        long key(int shop, int movie) {
            return ((long) shop << 32) | movie;
        }
    }

    class E implements Comparable<E> {
        int shop, movie, price;

        E(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }

        public int compareTo(E e) {
            int d = price - e.price;
            if (d != 0) return d;
            return shop - e.shop;
        }
    }
}
