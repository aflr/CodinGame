class Solution {

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int count = in.nextInt(), res = 0;
        for (int i = 0; i < count; i++)
            res += parse(in.next());
        printDecimary(Integer.toString(res));
    }

    private static int parse(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++)
            num = num * 10 + Character.digit(str.charAt(i), 11);
        return num;
    }

    private static void printDecimary(String str) {
        while (str.contains("0")) {
            str = str.replaceAll("100", "9A");
            for (int i = 0; i < 9; i++)
                str = str.replaceAll(i + 1 + "0", i + "A");
            str = str.replaceFirst("^0", "");
        }
        System.out.println(str);
    }
}
