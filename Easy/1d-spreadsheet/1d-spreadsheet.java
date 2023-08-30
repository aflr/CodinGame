import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), sol[];
        Arrays.fill(sol = new int[N], Integer.MIN_VALUE);
        String[] op = new String[N], arg1 = new String[N], arg2 = new String[N];
        for (int i = 0; i < N; i++) {   // Read
            op[i] = in.next();
            arg1[i] = in.next();
            arg2[i] = in.next();
        }
        for (int i = 0; i < N; i++)     // Solve
            solve(sol, i, op, arg1, arg2);
        for (int n : sol)               // Print
            System.out.println(n);
    }
    private static int solve(int[] sol, int i, String[] op, String[] arg1, String[] arg2) {
        if (sol[i] != Integer.MIN_VALUE)
            return sol[i];
        int n1 = (arg1[i].charAt(0) == '$') ? solve(sol, Integer.parseInt(arg1[i].substring(1)), op, arg1, arg2) : Integer.parseInt(arg1[i]);
        switch (op[i]) {
            case "VALUE":
                sol[i] = n1; break;
            case "ADD": case "SUB": case "MULT":
                int n2 = (arg2[i].charAt(0) == '$') ? solve(sol, Integer.parseInt(arg2[i].substring(1)), op, arg1, arg2) : Integer.parseInt(arg2[i]);
                if (op[i].equals("ADD"))
                    sol[i] = n1 + n2;
                else if (op[i].equals("SUB"))
                    sol[i] = n1 - n2;
                else if (op[i].equals("MULT"))
                    sol[i] = n1 * n2;
        }
        return sol[i];
    }
}
