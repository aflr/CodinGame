import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String exp = in.next();
            Stack<Character> s = new Stack<>();
            for (char c : exp.toCharArray()) {
                if (c == '(' || c == '[' || c == '{' || c == '<' || c == ')' || c == ']' || c == '}' || c == '>') {
                    char b;
                    try {
                        b = s.pop();
                    } catch (EmptyStackException ese) {
                        s.push(c);
                        continue;
                    }
                    switch (b) {
                        case '(':
                        case ')':
                            if (c != ')' && c != '(') {
                                s.push(b);
                                s.push(c);
                            }
                            break;
                        case '[':
                        case ']':
                            if (c != ']' && c != '[') {
                                s.push(b);
                                s.push(c);
                            }
                            break;
                        case '{':
                        case '}':
                            if (c != '}' && c != '{') {
                                s.push(b);
                                s.push(c);
                            }
                            break;
                        case '<':
                        case '>':
                            if (c != '>' && c != '<') {
                                s.push(b);
                                s.push(c);
                            }
                            break;
                    }
                }
            }
            System.out.println((s.size() == 0) ? "true" : "false");
        }
    }
}
