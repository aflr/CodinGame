import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> listX = new ArrayList<>(N), listY = new ArrayList<>(N);
        for (int i = 0; i < N && listX.add(in.nextInt()) && listY.add(in.nextInt()); i++);
        int west = listX.stream().mapToInt(x -> (int) x).min().getAsInt();
        int east = listX.stream().mapToInt(x -> (int) x).max().getAsInt();
        listY.sort(null);
        double med;
        if (listY.size() % 2 == 0)
            med = (listY.get((listY.size() / 2)) + listY.get(listY.size() / 2)) / 2.0;
        else
            med = listY.get((listY.size() / 2));
        long sum = east - west;
        sum += listY.stream().mapToDouble(x -> (double) x).reduce(0, (old, elem) -> old + Math.abs(elem - med));
        System.out.println(sum);
    }
}
