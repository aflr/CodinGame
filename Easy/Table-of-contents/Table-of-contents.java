class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        var st = new java.util.Stack<Integer>();
        int lineLen = in.nextInt(), N = in.nextInt(); in.nextLine();
        for (int i = 0; i < N; i++) {
            String[] l = in.nextLine().split(" ");
            int depth = l[0].lastIndexOf('>') + 2;
            while (st.size() < depth && st.add(0));
            while (st.size() > depth && st.pop() != 0);
            st.push(st.pop() + 1);
            String s1 = "    ".repeat(depth - 1) + st.peek() + " " + l[0].substring(depth - 1);
            System.out.format("%s%s%s\n", s1, ".".repeat(lineLen - s1.length() - l[1].length()), l[1]);
        }
    }
}
