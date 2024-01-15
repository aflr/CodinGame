import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // Number of floors
        int a = in.nextInt(); // Steps up
        int b = in.nextInt(); // Steps down
        int k = in.nextInt(); // Elevator origin
        int m = in.nextInt(); // Elevator destination

        Set<Integer> visited = new HashSet<>();
        visited.add(k);
        // Move toward destination, stop when as close as possible
        if (k < m)
            while (Math.abs(k + a - m) < Math.abs(k - m) && k + a >= 1 && k + a <= n)
                visited.add(k += a);
        else if (k > m)
            while (Math.abs(k - b - m) < Math.abs(k - m) && k - b >= 1 && k - b <= n)
                visited.add(k -= b);
        // Try to maneuver
        while (k != m) {
            if (k + a <= n && k < m) {
                k += a;
            } else if (k - b >= 1 && k > m) {
                k -= b;
            } else {
                if (k + a <= n) k += a;
                else if (k - b >= 1) k -= b;
            }
            if (!visited.add(k)) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
        System.out.println(visited.size() - 1);
    }
}
