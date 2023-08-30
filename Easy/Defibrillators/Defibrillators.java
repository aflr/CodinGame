import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String LONS = in.next();
        String LATS = in.next();
        double LON = Double.parseDouble(LONS.replaceAll(",", "."));
        double LAT = Double.parseDouble(LATS.replaceAll(",", "."));
        LON = LON * (Math.PI / 180);
        LAT = LAT * (Math.PI / 180);
        int N = in.nextInt();
        in.nextLine();
        String winner = null;
        double res = Double.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            String[] info = DEFIB.split(";");
            double deflon = Double.parseDouble(info[4].replaceAll(",", "."));
            double deflat = Double.parseDouble(info[5].replaceAll(",", "."));
            deflon = deflon * (Math.PI / 180);
            deflat = deflat * (Math.PI / 180);
            double distX = (deflon - LON) * Math.cos((LAT + deflat) / 2);
            double distY = deflat - LAT;
            double dist = Math.sqrt(distX * distX + distY * distY) * 6371;
            if (dist < res) {
                winner = info[1];
                res = dist;
            }
        }
        System.out.println(winner);
    }
}
