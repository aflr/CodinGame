interface Solution {
    static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int N = in.nextInt(), A = in.nextInt(), B = in.nextInt();
        String s = Integer.toString(A).repeat(A);
        for (int i = 1; s.length() < N;) {
            try {
                s += Integer.toString(B).repeat(s.charAt(i++) - '0');
            } catch (StringIndexOutOfBoundsException ex) {
                s += Integer.toString(B).repeat(B);}
            s += Integer.toString(A).repeat(s.charAt(i++) - '0');
        }
        System.out.println(s.substring(0, N));
    }
}
