import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        in.nextLine();
        int low = 0, high = 101;
        for (int i = 1; i <= R; i++) {
            String[] line = in.nextLine().split(" ");
            int num = Integer.parseInt(line[0]);
            switch (line[2]) {
                case "high":
                    high = Math.min(high, num);
                    break;
                case "low":
                    low = Math.max(low, num);
                    break;
                case "on":
                    if (num >= high || num <= low) {
                        System.out.println("Alice cheated in round " + i);
                        return;
                    }
            }
            if (low + 1 >= high) {
                System.out.println("Alice cheated in round " + i);
                return;
            }
        }
        System.out.println("No evidence of cheating");
    }
}
