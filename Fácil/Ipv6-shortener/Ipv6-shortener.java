import java.util.*;
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // Remove leading zeros by parsing hex values
        String[] ips = in.nextLine().split(":");
        int[] ip = new int[8];
        for (int i = 0; i < 8; i++)
            ip[i] = Integer.parseInt(ips[i], 16);

        // Turn the numbers back into a string
        String newip = "";
        for (int i = 0; i < ip.length; i++) {
            newip += Integer.toHexString(ip[i]);
            if (i != ip.length - 1)
                newip += ":";
        }

        // Remove the longest possible zero-only contiguous blocks, from 8 to 2
        for (int i = 7; i >= 1; i--) {
            String regex = "(^|:)0" + ":0".repeat(i) + "($|:)";
            if (newip.matches("(.*)?" + regex + "(.*)?")) {
                System.out.println(newip.replaceFirst(":?" + regex + ":?", "::"));
                return;
            }
        }
        System.out.println(newip);
    }
}
