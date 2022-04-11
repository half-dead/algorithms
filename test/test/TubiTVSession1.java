package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;


/**
 * Fetch the following csv and get top 10 rating movies.
 * https://gist.githubusercontent.com/CatTail/18695526bd1adcc21219335f23ea5bea/raw/54045ceeae6a508dec86330c072c43be559c233b/movies.csv
 */
public class TubiTVSession1 {
    private static final String RESOURCE_URL = "https://gist.githubusercontent.com/CatTail/18695526bd1adcc21219335f23ea5bea/raw/54045ceeae6a508dec86330c072c43be559c233b/movies.csv";
    private static final int LIMIT = 10;

    public static void main(String[] args) throws IOException {
        URL website = new URL(RESOURCE_URL);
        PriorityQueue<Movie> pq = new PriorityQueue<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(website.openStream()))) {
            br.lines().skip(1).map(Movie::new).forEach(movie -> {
                pq.offer(movie);
                if (pq.size() > LIMIT) {
                    pq.poll();
                }
            });
        }

        System.out.println("Top " + LIMIT + " rating movies are:");
        LinkedList<Movie> list = new LinkedList<>();
        pq.forEach(list::push);
        list.forEach(System.out::println);
    }

    static class Movie implements Comparable<Movie> {
        private final String name;
        private final double runTime, score;
        private final Comparator<Movie> comparator = Comparator.<Movie>comparingDouble(x -> x.score)
                .thenComparingDouble(x -> x.runTime);

        Movie(String line) {
            int third = line.lastIndexOf(','), second = line.lastIndexOf(',', third - 1);
            score = Double.parseDouble(line.substring(third + 1));
            runTime = Double.parseDouble(line.substring(second + 1, third));
            name = line.substring(0, second);
        }

        @Override
        public int compareTo(Movie o) {
            return comparator.compare(this, o);
        }

        @Override
        public String toString() {
            return "Movie{" +
                    "name='" + name + '\'' +
                    ", runTime=" + runTime +
                    ", score=" + score +
                    '}';
        }
    }

}