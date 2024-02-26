import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt(); in.nextLine();
        final Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            char[] row = in.nextLine().replaceAll(" ", "").toCharArray();
            for (int j = 0; j < row.length; j++)
                map.put(row[j], i + "" + j);
        }
        System.out.println(in.nextLine().chars().mapToObj(c -> map.get((char) c)).reduce(String::concat).get());
    }
}
