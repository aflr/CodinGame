class Solution {
    public static void main(String args[]) {
        String N = (new java.util.Scanner(System.in)).nextLine();
        try {
            float f = Float.parseFloat(N);
            int bits = Float.floatToRawIntBits(f);
            String bin = String.format("%32s", Integer.toBinaryString(bits)).replaceAll(" ", "0");
            System.out.printf("[%s][%s][%s]\n", bin.substring(0, 1), bin.substring(1, 9), bin.substring(9));
            System.out.println("0x" + String.format("%8s", Integer.toHexString(bits).toUpperCase()).replaceAll(" ", "0"));
        } catch (NumberFormatException nfe) {
            System.out.print("[0][11111111][11111111111111111111111]\nNaN\n");
        }
    }
}
