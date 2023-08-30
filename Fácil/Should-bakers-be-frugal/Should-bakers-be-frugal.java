import java.util.*;
class Solution {
    public static void main(String args[]) {
        var in = new Scanner(System.in);
        float side = in.nextFloat(), dia = in.nextFloat();
        int waste = (int)(side / dia) * (int)(side / dia), frugal = 0, cut;
        while (side >= dia) {
            frugal += cut = (int)(side / dia) * (int)(side / dia);
            side = (float)Math.sqrt(side * side - cut * Math.PI * (dia / 2) * (dia / 2));
        }
        System.out.println(frugal - waste);
    }
}
