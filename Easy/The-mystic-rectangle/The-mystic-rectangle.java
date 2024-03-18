class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int x = in.nextInt(), y = in.nextInt();
        int dx = Math.abs(x - in.nextInt()), dy = Math.abs(y - in.nextInt());
        dy = Math.min(dy, 150 - dy); dx = Math.min(dx, 200 - dx);
        float t = .5f * Math.min(dy, dx) + (dy > dx ? .4f : .3f) * Math.abs(dy - dx);
        System.out.printf("%.1f\n", t);
    }
}
