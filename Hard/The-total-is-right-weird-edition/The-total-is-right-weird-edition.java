import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), a = in.nextInt();
        List<Set<Integer>> res = new ArrayList<>(12);
        res.add(new HashSet<Integer>() {{add(a);}});
        for (int i = 1; i <= 12; i++) {
            if (res.size() < i) {
                Set<Integer> set = new HashSet<>();
                for (int j = 1; j < i; j++) {
                    var it1 = res.get(j - 1).iterator();
                    while (it1.hasNext()) {
                        int n1 = it1.next();
                        var it2 = res.get(i - j - 1).iterator();
                        while (it2.hasNext()) {
                            int n2 = it2.next();
                            set.add(n1 + n2);
                            set.add(n1 - n2);
                            set.add(n1 * n2);
                            if (n2 != 0 && n1 % n2 == 0)
                                set.add(n1 / n2);
                        }
                    }
                }
                res.add(set);
            }
            if (res.get(i - 1).contains(N)) {
                System.out.println(i);
                Runtime.getRuntime().exit(0);
            }
        }
    }
}
