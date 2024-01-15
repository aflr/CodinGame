import java.util.*;
class Player {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(), H = in.nextInt();
        in.nextLine();
        int[][] rooms = new int[H][W];
        for (int i = 0; i < H; i++) {
            String[] LINE = in.nextLine().split(" ");
            for (int j = 0; j < W; j++)
                rooms[i][j] = Integer.parseInt(LINE[j]);
        }
        for (in.nextInt();;) {
            int xi = in.nextInt(), yi = in.nextInt();
            String pos = in.next();
            switch (rooms[yi][xi]) {
                case 1: case 3: case 7: case 8: case 9: case 12: case 13:
                    yi++;
                    break;
                case 10:
                    xi--;
                    break;
                case 11:
                    xi++;
                    break;
                case 2: case 6:
                    if (pos.equals("LEFT")) xi++;
                    else xi--;
                    break;
                case 4:
                    if (pos.equals("RIGHT")) yi++;
                    else xi--;
                    break;
                case 5:
                    if (pos.equals("LEFT")) yi++;
                    else xi++;
                    break;
            }
            System.out.println(xi + " " + yi);
        }
    }
}
