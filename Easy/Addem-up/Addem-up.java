class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int N = in.nextInt(), cost = 0;
        var cards = new java.util.ArrayList<Integer>(N);
        for (int i = 0; i < N; i++)
            cards.add(in.nextInt());
        for (int num; cards.size() > 1; cards.add(num)) {
            cards.sort(null);
            cost += (num = cards.remove(1) + cards.remove(0));
        }
        System.out.println(cost);
    }
}
