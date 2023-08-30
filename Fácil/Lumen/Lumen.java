import java.util.*;
class Solution {
    public static void main(String args[]) {
        var in = new Scanner(System.in);
        int N = in.nextInt(), L = in.nextInt(), c = 0;
        var lights = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (in.next().equals("C")) {
                    for (int i2 = i - L + 1; i2 < i + L; i2++) {
                        for (int j2 = j - L + 1; j2 < j + L; j2++) {
                            try{
                                lights[i2][j2] = true; // More nesting == more fun
                            } catch (ArrayIndexOutOfBoundsException ex) {}
                        }
                    }
                }
            }
        }
        for (var r : lights)
            for (var b : r)
                c += b ? 0 : 1;
        System.out.println(c);
    }
}
