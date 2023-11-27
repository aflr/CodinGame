import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt(), N = in.nextInt(), currEnd = 0;
        List<Integer[]> painted = new ArrayList<>(), unpainted = new ArrayList<>();
        for (int i = 0; i < N; i++)
            painted.add(new Integer[]{in.nextInt(), in.nextInt()});
        painted.sort((o1, o2) -> o1[0] - o2[0]);
        for (var e : painted) 
            if (e[0] <= currEnd)
                currEnd = (e[1] > currEnd) ? e[1] : currEnd;
            else if (unpainted.add(new Integer[]{currEnd, e[0]}))
                currEnd = e[1];
        if (currEnd < L)
            unpainted.add(new Integer[]{currEnd, L});
        if (unpainted.isEmpty())
            System.out.println("All painted");
        else
            unpainted.forEach(e -> System.out.println(e[0] + " " + e[1]));
    }
}
