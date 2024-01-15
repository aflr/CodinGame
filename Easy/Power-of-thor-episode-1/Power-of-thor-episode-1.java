import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTx = in.nextInt(); // Thor's starting X position
        int initialTy = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            int remainingTurns = in.nextInt();

            if (lightY > initialTy && (initialTy++ != -1))
                System.out.print("S");
            else if (lightY < initialTy && ((initialTy-- != -1)))
                System.out.print("N");
            if (lightX > initialTx && (initialTx++ != -1))
                System.out.print("E");
            else if (lightX < initialTx && (initialTx-- != -1))
                System.out.print("W");
            System.out.println();
        }
    }
}
