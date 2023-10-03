class Solution {

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);

        // READ WALLY
        int ww = in.nextInt(), wh = in.nextInt(); in.nextLine();
        char[][] wally = new char[wh][ww];
        for (int i = 0; i < wh; i++) {
            char[] wallyRow = in.nextLine().toCharArray();
            for (int j = 0; j < ww; j++)
                wally[i][j] = wallyRow[j];
        }

        // READ PICTURE
        int pw = in.nextInt(), ph = in.nextInt(); in.nextLine();
        char[][] pic = new char[ph][pw];
        for (int i = 0; i < ph; i++) {
            char[] pictureRow = in.nextLine().toCharArray();
            for (int j = 0; j < pw; j++)
                pic[i][j] = pictureRow[j];
        }

        // FIND WALLY IN PICTURE
        int y = 0, x = 0;
        out: for (y = 0; y <= ph - wh; y++)
            next: for (x = 0; x <= pw - ww; x++) {
                for (int wi = 0; wi < wh; wi++)
                    for (int wj = 0; wj < ww; wj++)
                        if (wally[wi][wj] != ' ' && wally[wi][wj] != pic[y + wi][x + wj])
                            continue next;
                break out;
            }
        System.out.println(x + " " + y);
    }
}
