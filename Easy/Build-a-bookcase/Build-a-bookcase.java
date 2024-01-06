interface Solution {
    static void main(String[] $) {
        var in = new java.util.Scanner(System.in);
        int h = in.nextInt() - 1, w = in.nextInt(), n = in.nextInt();
        System.out.println("/".repeat(w / 2) + (w % 2 == 1 ? "^" : "") + "\\".repeat(w / 2));
        for (int i = n; i > 0; i--) {
            for (int j = 1; j < h / n; j++)
                System.out.println("|" + " ".repeat(w - 2) + "|");
            if (i <= h % n)
                System.out.println("|" + " ".repeat(w - 2) + "|");
            System.out.println("|" + "_".repeat(w - 2) + "|");
        }
    }
}
