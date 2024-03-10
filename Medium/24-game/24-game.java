import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        List<Double> v = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            v.add((double) in.nextInt());
        System.out.println(search(v));
    }

    private static boolean search(List<Double> v) {
        if (v.size() == 1)
            return Math.abs(v.get(0) - 24) < 0.0000001d;
        for (int i = 0; i < v.size(); i++) {
            for (int j = 0; j < v.size(); j++) {
                if (i == j) continue;
                for (var op : "+-*/".toCharArray()) {
                    double n = 0d;
                    switch (op) {
                        case '+':
                            n = v.get(i) + v.get(j); break;
                        case '-':
                            n = v.get(i) - v.get(j); break;
                        case '*':
                            n = v.get(i) * v.get(j); break;
                        case '/':
                            if (v.get(j) == 0) continue;
                            n = v.get(i) / v.get(j); break;
                    }
                    List<Double> nv = new ArrayList<>();
                    nv.add(n);
                    for (int k = 0; k < v.size(); k++)
                        if (k != i && k != j)
                            nv.add(v.get(k));
                    if (search(nv))
                        return true;
                }
            }
        }
        return false;
    }
}
