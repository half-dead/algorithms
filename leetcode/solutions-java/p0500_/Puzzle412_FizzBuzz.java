package p0500_;

// Write a program that outputs the string representation of numbers from 1 to n.
//
// But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
//
// Example:
//
// n = 15,
//
// Return:
// [
//  "1",
//  "2",
//  "Fizz",
//  "4",
//  "Buzz",
//  "Fizz",
//  "7",
//  "8",
//  "Fizz",
//  "Buzz",
//  "11",
//  "Fizz",
//  "13",
//  "14",
//  "FizzBuzz"
// ]

import java.util.ArrayList;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle412_FizzBuzz {

    public static void main(String[] args) {
        Puzzle412_FizzBuzz p = new Puzzle412_FizzBuzz();
        Solution solution = p.new Solution();
    }

    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> list = new ArrayList<>(n);
            for (int i = 1; i <= n; i++) {
                if (i % 15 == 0) {
                    list.add("FizzBuzz");
                } else if (i % 5 == 0) {
                    list.add("Buzz");
                } else if (i % 3 == 0) {
                    list.add("Fizz");
                } else {
                    list.add("" + i);
                }
            }
            return list;
        }
    }

    class MockSolution {
        public List<String> fizzBuzz(int n) {
            final int size = n;
            return new java.util.AbstractList<String>() {
                private static final String FIZZ_BUZZ = "FizzBuzz";
                private static final String FIZZ = "Fizz";
                private static final String BUZZ = "Buzz";

                @Override
                public String get(int index) {
                    index++;
                    if (index % 15 == 0) {
                        return FIZZ_BUZZ;
                    } else if (index % 3 == 0) {
                        return FIZZ;
                    } else if (index % 5 == 0) {
                        return BUZZ;
                    } else {
                        return String.valueOf(index);
                    }
                }

                @Override
                public int size() {
                    return size;
                }
            };
        }
    }

}
