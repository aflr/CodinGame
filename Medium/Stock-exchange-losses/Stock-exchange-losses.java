class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int p = 0, max = 0;
        for (int i = in.nextInt(); i > 0; i--) {
            int v = in.nextInt();
            max = Math.max(max, v);
            p = Math.min(p, v - max);
        }
        System.out.println(p);
    }
}
