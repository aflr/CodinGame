import java.util.*;

class Solution {
    public static void main(String args[]) {
        var in = new Scanner(System.in);
        // Read input, split, parse
        String[] line = in.nextLine().split("/");
        int[] ip = Arrays.stream(line[0].split("\\.")).mapToInt(Integer::parseInt).toArray();
        int cidr = Integer.parseInt(line[1]);

        // Calculate mask
        int[] mask = new int[4];
        for (int i = 0; i < 4; cidr -= Math.min(cidr, 8), i++)
            mask[i] = Integer.parseInt("1".repeat(Math.min(cidr, 8)) + "0".repeat(8 - Math.min(cidr, 8)), 2);

        // Calculate network and broadcast addresses
        int[] net = { ip[0] & mask[0], ip[1] & mask[1], ip[2] & mask[2], ip[3] & mask[3] };
        int[] bcast = { net[0] | ~mask[0] & 0xFF, net[1] | ~mask[1] & 0xFF, net[2] | ~mask[2] & 0xFF, net[3] | ~mask[3] & 0xFF};

        // Print in dot-decimal notation
        System.out.println(Arrays.toString(net).replaceAll(", ", ".").replaceAll("[\\]\\[]", ""));
        System.out.println(Arrays.toString(bcast).replaceAll(", ", ".").replaceAll("[\\]\\[]", ""));
    }
}
