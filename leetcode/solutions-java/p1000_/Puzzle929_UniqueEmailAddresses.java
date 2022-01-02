package p1000_;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/unique-email-addresses/
 *
 * @author half-dead
 */
public class Puzzle929_UniqueEmailAddresses {
    class Solution {
        public int numUniqueEmails(String[] emails) {
            HashSet<String> set = new HashSet<>();
            for (String s : emails) {
                int index = s.indexOf('@');
                String localname = s.substring(0, index);
                String domainname = s.substring(index + 1);
                int plusIndex = localname.indexOf('+');
                if (plusIndex > 0) {
                    localname = localname.substring(0, plusIndex);
                }
                localname = localname.replaceAll("\\.", "");
                set.add(localname + domainname);
            }
            return set.size();
        }
    }
}
