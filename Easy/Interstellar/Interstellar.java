import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Vector ship = new Vector(in.nextLine().toCharArray());
        Vector wormhole = new Vector(in.nextLine().toCharArray());

        Vector aux = wormhole.subtract(ship);
        System.out.println("Direction: " + aux.simplify());
        System.out.println("Distance: " + aux.distance());
    }

    private static class Vector {
        private int I;
        private int J;
        private int K;

        public Vector(int I, int J, int K) {
            this.I = I;
            this.J = J;
            this.K = K;
        }

        public Vector(char[] chars) {
            I = 0; J = 0; K = 0;
            for (int i = 0, n = 0, sign = 1; i < chars.length; i++)
                if (chars[i] == '-')
                    sign = -1;
                else if (Character.isDigit(chars[i]))
                    n = n * 10 + chars[i] - '0';
                else if (chars[i] >= 'i' && chars[i] <= 'k') {
                    switch (chars[i]) {
                        case 'i': I = sign * (n == 0 ? 1 : n); break;
                        case 'j': J = sign * (n == 0 ? 1 : n); break;
                        case 'k': K = sign * (n == 0 ? 1 : n); break;
                    }
                    n = 0; sign = 1;
                }
        }

        public Vector subtract(Vector o) {
            return new Vector(I - o.I, J - o.J, K - o.K);
        }

        public Vector simplify() {
            int gcd = gcd(Math.abs(I), gcd(Math.abs(J), Math.abs(K)));
            return new Vector(I / gcd, J / gcd, K / gcd);
        }

        public String distance() {
            return String.format("%.2f", Math.sqrt(I * I + J * J + K * K));
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (I != 0)
                sb.append((I > 0 ? "+" : "-") + (Math.abs(I) != 1 ? Math.abs(I) : "") + "i");
            if (J != 0)
                sb.append((J > 0 ? "+" : "-") + (Math.abs(J) != 1 ? Math.abs(J) : "") + "j");
            if (K != 0)
                sb.append((K > 0 ? "+" : "-") + (Math.abs(K) != 1 ? Math.abs(K) : "") + "k");
            if (sb.charAt(0) == '+')
                sb.deleteCharAt(0);
            return sb.toString();
        }
    }

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        return gcd(b % a, a);
    }
}
