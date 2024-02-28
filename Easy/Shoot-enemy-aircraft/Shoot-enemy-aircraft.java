class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        char[][] sky = new char[in.nextInt() - 1][];
        for (int i = 0; i < sky.length; i++)
            sky[sky.length - i - 1] = in.next().toCharArray();
        int M = in.next().indexOf('^');
        var t = new java.util.ArrayList<Integer>();
        for (int i = 0; i < sky.length; i++)
            for (int j = 0; j < sky[i].length; j++)
                if (sky[i][j] == '>' || sky[i][j] == '<')
                    t.add(Math.abs(M - j) - i - 1);
        t.sort(null);
        for (int i = 0, p = 0; i < t.size(); p = t.get(i++)) {
            System.out.println("WAIT\n".repeat(t.get(i) - p - 1) + "SHOOT");
        }
    }
}
