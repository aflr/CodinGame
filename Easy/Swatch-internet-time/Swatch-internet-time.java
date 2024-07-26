import java.math.*;

class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        // Read and preprocess input
        String[] rawtime = in.nextLine().split(" ");
        String[] HHMMSS = rawtime[0].split(":");
        String[] strTZ = rawtime[1].substring(3).split(":");
        char signTZ = strTZ[0].charAt(0);
        strTZ[0] = strTZ[0].substring(1);
        // Original timezone, as minutes. Expected to be from -720 to +840
        int TZ = (Integer.parseInt(strTZ[0]) * 60 + Integer.parseInt(strTZ[1]))
                * (signTZ == '+' ? 1 : -1);
        // Original time, separated
        int HH = Integer.parseInt(HHMMSS[0]), MM = Integer.parseInt(HHMMSS[1]),
                SS = Integer.parseInt(HHMMSS[2]);
        // Change original time to target timezone
        MM += 60 - TZ;
        for (; MM < 0; MM += 60) HH--;
        for (; MM >= 60; MM -= 60) HH++;
        // Correct hours of the day in case they are less than 0 or more than 23
        HH = (HH + 24) % 24;
        // Apply formula, rounding half-up
        int res = (3600 * HH + 60 * MM + SS);
        BigDecimal bd = (new BigDecimal(res))
                .divide(new BigDecimal("86.4"), 2, RoundingMode.HALF_UP);
        System.out.println("@" + bd);
    }
}
