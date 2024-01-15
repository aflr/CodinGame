import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        int exitFloor = in.nextInt(); // floor on which the exit is found
        int exitPos = in.nextInt(); // position of the exit on its floor
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
        int nbElevators = in.nextInt(); // number of elevators

        // Store positions of elevators in array
        // All floors have exactly 1 elevator
        int[] elevs = new int[nbElevators + 1];
        for (int i = 0; i < nbElevators; i++) {
            int elevatorFloor = in.nextInt(); // floor on which this elevator is found
            int elevatorPos = in.nextInt(); // position of the elevator on its floor
            elevs[elevatorFloor] = elevatorPos;
        }

        // game loop
        int genPos = -1;
        while (true) {
            int cloneFloor = in.nextInt(); // floor of the leading clone
            int clonePos = in.nextInt(); // position of the leading clone on its floor
            String direction = in.next(); // direction of the leading clone: LEFT or RIGHT

            // Learn where generator is (within floor 0)
            if (genPos == -1)
                genPos = clonePos;

            // If no active clone, wait
            if (cloneFloor == -1)
            {
                System.out.println("WAIT");
                continue;
            }
            
            // If already at exit floor, search for it
            if (cloneFloor == exitFloor)
            {
                if (exitPos > clonePos && direction.equals("LEFT"))
                    System.out.println("BLOCK");
                else if (exitPos < clonePos && direction.equals("RIGHT"))
                    System.out.println("BLOCK");
                else
                    System.out.println("WAIT");
                continue;
            }

            // If not at exit floor, search for elevator
            if (elevs[cloneFloor] == clonePos)
                System.out.println("WAIT");
            else if (elevs[cloneFloor] > clonePos && direction.equals("LEFT"))
                System.out.println("BLOCK");
            else if (elevs[cloneFloor] < clonePos && direction.equals("RIGHT"))
                System.out.println("BLOCK");
            else
                System.out.println("WAIT");
        }
    }
}
