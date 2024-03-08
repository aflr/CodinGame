class Solution {
    public static void main(String args[]) {
        int N = (new java.util.Scanner(System.in)).nextInt();
        System.out.println(N == 1 ? 1 : 2 * (N - Integer.highestOneBit(N - 1)));
    }
}
