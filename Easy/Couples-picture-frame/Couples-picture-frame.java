class Solution {

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        String wife = in.nextLine(), husband = in.nextLine();
        int lcm = lcm(wife.length(), husband.length());
        System.out.println(wife.repeat(lcm / wife.length()));
        for (int i = 0; i < lcm; i++)
            System.out.println(husband.charAt(i % husband.length())
                    + " ".repeat(lcm - 2)
                    + wife.charAt(i % wife.length()));
        System.out.println(husband.repeat(lcm / husband.length()));
    }

    private static int lcm(int a, int b) {
        int num = Math.abs(a * b);
        while (a != 0 && b != 0) {
            b %= a;
            if (b != 0)
                a %= b;
        }
        return num / (a != 0 ? a : b);
    }
}
