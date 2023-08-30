import java.util.*;
import java.awt.Point;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }

        // Read entire map, store into String array
        String[] a = new String[30];
        for (int i = 0; i < height; i++) {
            a[i] = in.nextLine();
        }

        for (int y = 0; y < height; y++) {
            String line = a[y];
            for (int x = 0; x < width; x++)
            {
                char c = line.charAt(x);
                if (c == '.')
                    continue;
                System.out.print(x + " " + y + " ");

                // Find next right node
                Point right = new Point(-1, -1);
                for (int k = x + 1; k < width; k++)
                {
                    if (line.charAt(k) != '.')
                    {
                        right.x = k;
                        right.y = y;
                        break;
                    }
                }
                System.out.print(right.x + " " + right.y + " ");

                // Find next down node
                Point down = new Point(-1, -1);
                for (int k = y + 1; k < height; k++)
                {
                    if (a[k].charAt(x) != '.')
                    {
                        down.x = x;
                        down.y = k;
                        break;
                    }
                }
                System.out.print(down.x + " " + down.y);

                System.out.println();
            }
            
        }
    }
}
