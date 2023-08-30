import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String exp = in.next();
        Stack<Character> s = new Stack<>();
        boolean error = false;
        for (char c : exp.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                s.push(c);
            else if (c == ')' || c == ']' || c == '}'){
                try {
                    char b = s.pop();
                    switch (b) {
                        case '(':
                            if (c != ')')
                                throw new RuntimeException();
                            break;
                        case '[':
                            if (c != ']')
                                throw new RuntimeException();
                            break;
                        case '{':
                            if (c != '}')
                                throw new RuntimeException();
                            break;
                    }
                } catch (RuntimeException rte) {
                    error = true;
                    break;
                }
            }
        }
        System.out.println((s.size() == 0 && !error) ? "true" : "false");
    }
}
