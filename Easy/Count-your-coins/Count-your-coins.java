import java.util.*;
class Solution {
    public static void main(String args[]) {
        var in = new Scanner(System.in);
        int goal = in.nextInt(), n = in.nextInt(), coinCount = 0, val = 0, counts[] = new int[n];
        Map<Integer, Integer> coins = new TreeMap<>(); // val, count
        for (int i = 0; i < n; i++)
            counts[i] = in.nextInt();
        for (int i = 0; i < n; i++)
            coins.put(in.nextInt(), counts[i]);
        for (var en : coins.entrySet()) {
            if (val >= goal)
                break;
            int take = Math.min(en.getValue(), (int)Math.ceil((goal - val) * 1.0 / en.getKey()));
            coinCount += take;
            val += take * en.getKey();
        }
        System.out.println(val >= goal ? coinCount : -1);
    }
}
