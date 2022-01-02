package p2000_;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author half-dead
 */
public class Puzzle1797 {
    class AuthenticationManager {

        int ttl;
        TreeSet<Token> ts;
        Map<String, Token> map;

        public AuthenticationManager(int timeToLive) {
            ttl = timeToLive;
            ts = new TreeSet<>();
            map = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            Token t = new Token(tokenId, currentTime + ttl);
            ts.add(t);
            map.put(tokenId, t);
        }

        public void renew(String tokenId, int currentTime) {
            Token prev = map.get(tokenId);
            if (prev == null || prev.expire <= currentTime) return;

            ts.remove(prev);
            prev.expire = currentTime + ttl;
            ts.add(prev);
        }

        public int countUnexpiredTokens(int currentTime) {
            while (ts.size() > 0 && ts.first().expire <= currentTime)
                ts.remove(ts.first());
            return ts.size();
        }

        class Token implements Comparable<Token> {
            String id;
            int expire;

            Token(String id, int expire) {
                this.id = id;
                this.expire = expire;
            }

            public int compareTo(Token o) {
                return expire - o.expire;
            }
        }
    }
}
