import java.util.*;

class Solution {

    private static List<Integer> inventory(List<Integer> old) {
        List<Integer> list = new ArrayList<>();

        int prev = 0, count = 0;
        for (int i = 0; i < old.size(); i++) {
            int curr = old.get(i);
            if (curr == prev) { // If same element found, only count
                count++;
            } else { // If different element found, add previous one to list
                if (prev > 0) {
                    list.add(count);
                    list.add(prev);
                }
                prev = curr;
                count = 1;
            }

            // If last element of the list, add it to list immediately
            if (i == old.size() - 1) {
                list.add(count);
                list.add(curr);
            }
        }
        return list;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int L = in.nextInt();

        // Create a list and initialize it
        List<Integer> list = new ArrayList<>();
        list.add(R);

        // Update list with next inventory
        for (int i = 1; i < L; i++)
            list = inventory(list);

        // Print result
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1)
                System.out.print(" ");
        }
        System.out.println();
    }
}
