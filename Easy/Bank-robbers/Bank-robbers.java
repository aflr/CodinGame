interface Solution {
    static void main(String[]$) {
        var S = new java.util.Scanner(System.in);
        int R = S.nextInt(), V = S.nextInt(), rs[] = new int[R--];
        for (int i = 0; i < V; java.util.Arrays.sort(rs), i++) 
            rs[0] += new int[]{125,625,3125,15625,78125,390625}[S.nextInt()-3]<<S.nextInt();
        System.out.println(rs[R]);
    }
}
