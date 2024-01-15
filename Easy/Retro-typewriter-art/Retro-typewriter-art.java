import java.util.*;
interface Solution {
    static void main(String args[]) {
        var in = new Scanner(System.in);
        for (String s : in.nextLine().split(" "))
            processChunk(s, '\0', -1);
        p("\n");
    }
    static void processChunk(String s, char c, int r) {
        if (s.equals("nl") && p("\n")) return;
        char[] cs = s.toCharArray();
        if (s.matches("(.*)sp$"))       c = ' ';
        else if (s.matches("(.*)bS$"))  c = '\\';
        else if (s.matches("(.*)sQ$"))  c = '\'';
        else {
            c = cs[cs.length - 1];
            r = Integer.parseInt(s, 0, cs.length - 1, 10);
        }
        if (r == -1) r = Integer.parseInt(s, 0, cs.length - 2, 10);
        p((c + "").repeat(r));
    }
    static boolean p(String s) {
        System.out.print(s); return true;
    }
}
