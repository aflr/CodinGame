import java.util.*;

class Solution {

    private static int HI, WI;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        HI = in.nextInt(); WI = in.nextInt(); in.nextLine();
        boolean expanded = in.nextLine().equals("expanded");
        int howManyTriangles = in.nextInt();
        ArrayList<Triangle> triangles = new ArrayList<>(howManyTriangles);
        for (int i = 0; i < howManyTriangles; i++)
            triangles.add(new Triangle(in.nextInt(), in.nextInt(), in.nextInt(),
                    in.nextInt(), in.nextInt(), in.nextInt()));
        for (int i = 0; i < HI; System.out.println(), i++)
            for (int j = 0; j < WI; j++) {
                boolean fill = true;
                for (Triangle t : triangles)
                    if (t.inTriangle(j, i))
                        fill = !fill;
                System.out.print((fill ? "*" : " ")
                        + (expanded && j != WI - 1 ? " " : ""));
            }
    }

    private static class Triangle {
        private int x1, y1, x2, y2, x3, y3;

        public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }

        public boolean inTriangle(int x, int y) {
            return area() == area(x1, y1, x2, y2, x, y)
                    + area(x1, y1, x, y, x3, y3) + area(x, y, x2, y2, x3, y3);
        }

        public int area() {
            return Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        }

        public static int area(int x1, int y1, int x2, int y2, int x3, int y3) {
            return Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        }
    }
}
