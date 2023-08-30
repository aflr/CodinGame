class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        String[] a = in.nextLine().split(" "), b = in.nextLine().split(" ");
        long sum = 0;
        for (int i = 0, j = 0; i < a.length || j < b.length;) {
            long ac = Long.parseLong(a[i]), bc = Long.parseLong(b[j]);
            int av = Integer.parseInt(a[i + 1]), bv = Integer.parseInt(b[j + 1]);
            long minc = Math.min(ac, bc);
            sum += minc * av * bv;
            ac -= minc;
            if (ac == 0) i += 2;
            else a[i] = Long.toString(ac);
            bc -= minc;
            if (bc == 0) j += 2;
            else b[j] = Long.toString(bc);
        }
        System.out.println(sum);
    }
}
