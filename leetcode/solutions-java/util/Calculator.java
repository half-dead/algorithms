package util;

import java.util.Stack;

/**
 * @author half-dead
 */
abstract class Calculator<T> {
    abstract protected T parseNumber(String s);

    abstract protected T add(T a, T b);

    abstract protected T minus(T a, T b);

    abstract protected T multiply(T a, T b);

    abstract protected T divide(T a, T b);


    public T calculate(String s, T defaultValue) {
        if (s == null) {
            return defaultValue;
        }
        s = s.replaceAll("\\s+", "");
        if (s.length() == 0) {
            return defaultValue;
        }
        pos = 0;
        return parse(s, defaultValue);
    }

    private int pos;

    private T parse(String s, T defaultValue) {
        Stack<T> st = new Stack<>();
        T cur = defaultValue;
        char sign = '+';

        while (pos < s.length()) {
            if (s.charAt(pos) == '(') {
                // skip the '('
                pos++;
                cur = parse(s, defaultValue);
                // skip the ')'
                pos++;
            } else {
                StringBuilder number = new StringBuilder();
                while (pos < s.length()) {
                    char ch = s.charAt(pos);
                    if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(' || ch == ')') {
                        break;
                    }
                    number.append(ch);
                    pos++;
                }
                cur = parseNumber(number.toString());
            }
            if (sign == '+') st.push(cur);
            if (sign == '-') st.push(minus(defaultValue, cur));
            if (sign == '*') st.push(multiply(st.pop(), cur));
            if (sign == '/') st.push(divide(st.pop(), cur));

            if (pos >= s.length() || s.charAt(pos) == ')') break;
            sign = s.charAt(pos++);
        }
        T ans = defaultValue;
        while (!st.empty()) {
            ans = add(ans, st.pop());
        }
        return ans;
    }
}
