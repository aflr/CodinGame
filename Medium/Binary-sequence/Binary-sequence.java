import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), indexes[] = new int[N]; in.nextLine();
        for (int i = 0; i < N; i++)
            indexes[i] = Integer.parseInt(in.nextLine(), 2);
        for (int i = 0; i < N; i++)
            System.out.println(indexes[i] < Integer.MAX_VALUE / 2 ? binaryString(indexes[i] + 1).charAt(indexes[i]) : '1');
    }
    private static String binaryString(int size) {
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; sb.length() < size; i++)
            sb.append(Integer.toBinaryString(i));
        return sb.toString();
    }
}
