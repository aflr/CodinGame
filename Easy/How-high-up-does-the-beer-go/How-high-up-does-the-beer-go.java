class Solution {

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        double bottomRadius = in.nextDouble(), topRadius = in.nextDouble(),
                glassHeight = in.nextDouble(), beerVol = in.nextDouble(),
                left = 0d, right = glassHeight, center = (left + right) / 2d,
                newTopRadius = 0d, vol;
        do {
            center = (left + right) / 2d;
            newTopRadius = (topRadius - bottomRadius) / glassHeight * center + bottomRadius;
            vol = volumeOfFrustum(center, bottomRadius, newTopRadius);
            if (vol < beerVol) left = center;
            else right = center;
        } while (Math.abs(vol - beerVol) > 0.01d);
        System.out.printf("%.1f\n", center);
    }

    private static double volumeOfFrustum(double height, double r, double R) {
        return (Math.PI * height * (r * r + r * R + R * R)) / 3d;
    }
}
