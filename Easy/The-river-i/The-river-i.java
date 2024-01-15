class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        long r1 = in.nextLong(), r2 = in.nextLong();
        while (r1 != r2)
            if (r1 < r2)
                r1 += sumdigits(r1);
            else
                r2 += sumdigits(r2);
        System.out.println(r1);
    }
    private static long sumdigits(long n) {
        long sum = 0;
        for (char c : String.valueOf(n).toCharArray())
            sum += (int) c - '0';
        return sum;
    }
}
