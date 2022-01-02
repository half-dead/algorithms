package p0500_;

import java.util.*;

/**
 * https://leetcode.com/problems/design-twitter/
 *
 * @author half-dead
 */
public class Puzzle355 {
    class Twitter {
        int idx = 0;
        Map<Integer, Set<Integer>> following;
        Map<Integer, LinkedList<int[]>> tweets;

        public Twitter() {
            following = new HashMap<>();
            tweets = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            tweets.computeIfAbsent(userId, k -> new LinkedList<>()).push(new int[]{idx++, tweetId});
        }

        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

            following.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
            for (int uid : following.get(userId)) {
                LinkedList<int[]> list = tweets.get(uid);
                if (list == null) continue;

                int count = 0;
                Iterator<int[]> it = list.iterator();
                while (count < 10 && it.hasNext()) {
                    q.add(it.next());
                    count++;
                }
            }

            while (q.size() > 10) q.poll();
            LinkedList<Integer> result = new LinkedList<>();
            while (q.size() > 0) result.addFirst(q.poll()[1]);
            return result;
        }

        public void follow(int followerId, int followeeId) {
            following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            following.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
        }
    }

}
