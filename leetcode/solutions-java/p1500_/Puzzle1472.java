package p1500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/design-browser-history/
 *
 * @author half-dead
 */
public class Puzzle1472 {

    class BrowserHistory {
        List<String> list = new ArrayList<>();
        int cur, max;

        public BrowserHistory(String homepage) {
            list.add(homepage);
        }

        public void visit(String url) {
            if ((max = ++cur) == list.size()) list.add(url);
            else list.set(cur, url);
        }

        public String back(int steps) {
            return list.get(cur = Math.max(0, cur - steps));
        }

        public String forward(int steps) {
            return list.get(cur = Math.min(max, cur + steps));
        }
    }
}
