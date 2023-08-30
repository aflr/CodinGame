interface Solution {
    static void main(String[] $) {
        var in = new java.util.Scanner(System.in);
        var u = in.nextLine().split(" ");
        for (int i = 0, h = Integer.parseInt(u[2]); i < h; System.out.println(), i++) {
            for (int j = 0; j < (u[0].equals("right") ? Math.min(i, h - 1 - i) : Math.abs(i - h / 2)) * Integer.parseInt(u[5]); j++)
                System.out.print(' ');
            for (int j = 0, n = Integer.parseInt(u[1]); j < n; j++) {
                for (int k = 0; k < Integer.parseInt(u[3]); k++)
                    System.out.print(u[0].equals("right") ? '>' : '<');
                for (int k = 0; j != n - 1 && k < Integer.parseInt(u[4]); k++)
                    System.out.print(' ');
            }
        }
    }
}
