import java.util.*;

class Solution {
    private static int L;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        List<String> deck = Arrays.asList(in.nextLine().split(" "));
        L = deck.size();
        var idxs = faro(n, java.util.stream.IntStream.range(0, L).toArray());
        StringBuilder sb = new StringBuilder();
        Arrays.stream(idxs).forEach(i -> sb.append(" " + deck.get(i)));
        System.out.println(sb.substring(1));
    }

    private static int[] faro(int t, int[] a) {
        if (t == 0) return a;
        int[] na = new int[L];
        for (int i = 0; i < L; i++)
            na[(2 * i + 2 * i / (L + L % 2)) % (L + L % 2)] = a[i];
        return faro(t - 1, na);
    }
}
