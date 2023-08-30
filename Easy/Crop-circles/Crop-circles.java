class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        String[] ins = in.nextLine().split(" ");

        // Create and initialize field
        char[][] field = new char[25][38];
        for (int i = 0; i < 25; i++)
            for (int j = 0; j < 38; j++)
                field[i][j] = j % 2 == 0 ? '{' : '}';

        for (int i = 0; i < ins.length; i++)
            draw(field, ins[i]);

        java.util.Arrays.stream(field).forEach(r -> System.out.println(String.valueOf(r)));
    }

    private static void draw(char[][] field, String ins) {
        // Mode: 0 -> mow, 1 -> plant, 2 -> plant/mow
        int mode = 0;
        if (ins.startsWith("PLANTMOW")) {
            mode = 2; ins = ins.substring(8);
        } else if (ins.startsWith("PLANT")) {
            mode = 1; ins = ins.substring(5);
        }

        int x = ins.charAt(0) - 'a';
        int y = ins.charAt(1) - 'a';
        int dia = Integer.parseInt(ins.substring(2));

        for (int i = 0; i < 25; i++)
            for (int j = 0; j < 38; j++)
                if (dist(i, j / 2, y, x) <= dia / 2d)
                    switch (mode) {
                        case 0: field[i][j] = ' '; break;
                        case 1: field[i][j] = (j % 2 == 0) ? '{' : '}'; break;
                        case 2: field[i][j] = (field[i][j] == ' ') ? ((j % 2 == 0) ? '{' : '}') : ' ';
                    }
    }

    private static double dist(int y1, int x1, int y2, int x2) {
        return Math.sqrt((y1 - y2) * (y1 - y2) + (x1 - x2) * (x1 - x2));
    }
}
