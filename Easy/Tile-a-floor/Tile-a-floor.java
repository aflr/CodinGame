import java.util.*;

class Solution {

    private static final char[] H = {'(', ')', '{', '}', '[', ']', '<', '>', '/', '\\'};
    private static final char[] V = {'^', 'v', 'A', 'V', 'w', 'm', 'W', 'M', 'u', 'n', '/', '\\'};

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), T = 2 * N - 1; in.nextLine();
        // Read tile section
        char[][] tile = new char[T][T];
        for (int i = 0; i < N; i++) {
            char[] ROW = in.nextLine().toCharArray();
            for (int j = 0; j < ROW.length; j++)
                tile[i][j] = ROW[j];
        }
        // Fill rest of the tile, first right then down
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N - 1; j++)
                tile[i][T - 1 - j] = flip(tile[i][j],  H);
        for (int i = 0; i < N - 1; i++)
            for (int j = 0; j < T; j++) 
                tile[T - 1 - i][j] = flip(tile[i][j], V);
        // Print floor
        String hr = "+" + "-".repeat(T) + "+" + "-".repeat(T) + "+";
        System.out.println(hr);
        for (int i = 0; i < T; i++)
            System.out.println("|" + join(tile[i]) + "|" + join(tile[i]) + "|");
        System.out.println(hr);
        for (int i = 0; i < T; i++)
            System.out.println("|" + join(tile[i]) + "|" + join(tile[i]) + "|");
        System.out.println(hr);
    }

	private static char flip(char c, char[] h) {
        for (int i = 0; i < h.length; i++)
            if (h[i] == c)
                return (i % 2 == 0) ? h[i + 1] : h[i - 1];
		return c;
	}

    private static String join(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (var c : arr)
            sb.append(c);
        return sb.toString();
    }
}
