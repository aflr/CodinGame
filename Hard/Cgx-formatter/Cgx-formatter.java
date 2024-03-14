class Solution {

    private static final String TAB = "    ";

    public static void main(String args[]) {
        System.out.println(processInput(readInput()));
    }

    private static String processInput(String input) {
        StringBuilder sb = new StringBuilder();
        int indent = 0;
        boolean inString = false;
        char lastChar = '\0';
        for (char c : input.toCharArray()) {
            if (c == '\'') {
                if (!inString)
                    prepareNextLine(c, lastChar, indent, sb);
                inString = !inString;
                sb.append(c);
            } else if (inString)
                sb.append(c);
            else if (Character.isWhitespace(c))
                continue;
            else {
                prepareNextLine(c, lastChar, indent, sb);
                if (c == '(')
                    indent++;
                else if (c == ')')
                    sb.append("\n" + TAB.repeat(--indent));
                sb.append(c);
            }
            lastChar = c;
        }
        return sb.toString();
    }

    private static StringBuilder prepareNextLine(char c, char lc, int indent, StringBuilder sb) {
        String str = "\n" + TAB.repeat(indent);
        if (lc == ')') {
            if ("(;)".indexOf(c) == -1)
                return sb.append(str);
        } else if (lc == '(') {
            if (c != ')')
                return sb.append(str);
        } else if (lc == ';')
            return sb.append(str);
        else if (lc == '=' && c == '(')
            return sb.append(str);
        return null;
    }

    private static String readInput() {
        var in = new java.util.Scanner(System.in);
        int N = in.nextInt(); in.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append(in.nextLine());
        return sb.toString();
    }
}
