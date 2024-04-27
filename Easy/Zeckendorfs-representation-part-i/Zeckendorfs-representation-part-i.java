import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public static void main(String args[]) {
        long N = (new Scanner(System.in)).nextLong();
        List<Long> fibs = fibsUntil(N), zecks = new ArrayList<>();
        for (long c; N > 0;)
            if (N >= (c = fibs.remove(fibs.size() - 1)) && zecks.add(c))
                N -= c;
        System.out.println(zecks.stream().map(l -> l.toString())
                .collect(Collectors.joining("+")));
    }

    private static List<Long> fibsUntil(long n) {
        List<Long> list = new ArrayList<>();
        Long[] f = { 1L, 2L };
        list.addAll(List.of(f));
        for (int i = 0; i < 89 && f[0] + f[1] < n; i++)
            list.add(f[i % 2] = f[0] + f[1]);
        return list;
    }
}
