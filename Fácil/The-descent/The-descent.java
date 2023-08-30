import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        // game loop
        while (true) {
            int localMax = Integer.MIN_VALUE;
            int index = 0;
            for (int i = 0; i < 8; i++) {
                int h = in.nextInt();
                index = h > localMax ? i : index;
                localMax = Math.max(localMax, h);
            }
            System.out.println(index);
        }
    }
}
