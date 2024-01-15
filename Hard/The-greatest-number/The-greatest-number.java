import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine())
            in.nextLine();
        String input = in.nextLine();
        boolean dot = input.indexOf('.') != -1;
        boolean minus = input.indexOf('-') != -1;
        int[] ds = new int[N - (dot ? 1 : 0) - (minus ? 1 : 0)];
        for (int i = 0, j = 0; i < N * 2; i += 2) {
            char c = input.charAt(i);
            if (c != '.' && c != '-')
                ds[j++] = c - '0';
        }
        Arrays.sort(ds);
        StringBuilder sb = new StringBuilder();
        if (minus) // Looking for smallest number, early dot
        {
            sb.append('-');
            sb.append(ds[0]);
            if (dot)
                sb.append('.');
            for (int i = 1; i < ds.length; i++)
                sb.append(ds[i]);
        } else { // Looking for biggest number, late dot
            for (int i = ds.length - 1; i >= 1; i--)
                sb.append(ds[i]);
            if (dot)
                sb.append('.');
            sb.append(ds[0]);
        }
        double res = Double.parseDouble(sb.toString());
        if (res % 1 == 0)
            System.out.println((long)res);
        else
            System.out.println(res);
    }
}
