class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        var sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(in.nextLine());
        char[] code = sb.toString().replaceAll("\\\\\\\\", "")
            .replaceAll("\\\\\"", "").toCharArray();
        boolean inQuotes = false, someBrackets = false;
        var st = new java.util.Stack<Character>();
        for (char c : code) {
            if (inQuotes && c != '\"') continue;
            switch (c) {
                case '\"':
                    inQuotes = !inQuotes; break;
                case '(': case '{': case '[':
                    st.push(c); someBrackets = true; break;
                case ')': case '}': case ']':
                    if (st.isEmpty()) {
                        System.out.println("Invalid"); return;
                    }
                    char open = st.pop();
                    if (open == '(' && c != ')'
                        || open == '{' && c != '}'
                        || open == '[' && c != ']') {
                            System.out.println("Invalid"); return;
                        }
            }
        }
        System.out.println(!st.isEmpty() ? "Invalid" : someBrackets ? "Valid" : "No brackets");
    }
}
