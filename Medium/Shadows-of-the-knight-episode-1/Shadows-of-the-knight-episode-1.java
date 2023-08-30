import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        // Limits
        int x1 = 0;
        int y1 = 0;
        int x2 = W - 1;
        int y2 = H - 1;

        // game loop
        while (true) {
            // the direction of the bombs from batman's current location
            String bombDir = in.next();
            switch (bombDir) {
                case "U":
                    y2 = Y0 - 1;
                    break;
                case "UR":
                    y2 = Y0 - 1;
                    x1 = X0 + 1;
                    break;
                case "R":
                    x1 = X0 + 1;
                    break;
                case "DR":
                    y1 = Y0 + 1;
                    x1 = X0 + 1;
                    break;
                case "D":
                    y1 = Y0 + 1;
                    break;
                case "DL":
                    y1 = Y0 + 1;
                    x2 = X0 - 1;
                    break;
                case "L":
                    x2 = X0 - 1;
                    break;
                case "UL":
                    y2 = Y0 - 1;
                    x2 = X0 - 1;
                    break;
            }
            X0 = (x1 + x2) / 2;
            Y0 = (y1 + y2) / 2;
            System.out.println(X0 + " " + Y0);
        }
    }
}
