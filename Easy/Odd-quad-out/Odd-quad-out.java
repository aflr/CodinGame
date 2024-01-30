class Solution {

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int sideSize = in.nextInt(), qs[] = new int[4], half = sideSize / 2; in.nextLine();
        for (int i = 0; i < sideSize; i++) {
            char[] ROW = in.nextLine().toCharArray();
            for (int j = 0; j < ROW.length; j++)
                qs[(i < half ? 0 : 2) + (j < half ? 0 : 1)]
                        += Character.isDigit(ROW[j]) ? Character.digit(ROW[j], 10) : 0;
        }
        int oddOut = 0;
        if (qs[1] != qs[2] && qs[1] != qs[3])       oddOut = 1;
        else if (qs[1] != qs[2] && qs[2] != qs[3])  oddOut = 2;
        else if (qs[1] != qs[3] && qs[2] != qs[3])  oddOut = 3;
        System.out.printf("Quad-%d is Odd-Quad-Out\n", oddOut + 1);
        System.out.printf("It has value of %d\n", qs[oddOut]);
        System.out.printf("Others have value of %d\n", qs[(oddOut + 1) % 4]);
    }
}
