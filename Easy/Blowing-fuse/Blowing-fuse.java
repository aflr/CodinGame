class Solution {

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int max = 0, val = 0, p[] = new int[in.nextInt()], o[] = new int[in.nextInt()], c = in.nextInt();
        boolean on[] = new boolean[p.length], blown = false;
        for (int i = 0; i < p.length; i++)
            p[i] = in.nextInt();
        for (int i = 0; i < o.length; i++)
            o[i] = in.nextInt() - 1;
        for (int i = 0; !blown && i < o.length; i++) {
            val += p[o[i]] * (on[o[i]] ? -1 : 1);
            on[o[i]] = !on[o[i]];
            max = Math.max(max, val);
            if (val > c)
                blown = true;
        }
        if (blown)
            System.out.println("Fuse was blown.");
        else {
            System.out.printf("Fuse was not blown.\nMaximal consumed current was %d A.\n", max);
        }
    }
}
