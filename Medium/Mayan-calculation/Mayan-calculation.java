import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();

        char[][] nums = new char[H][L * 20];

        // Store long matrix with numbers 0 to 19
        for (int i = 0; i < H; i++) {
            char[] numeral = in.next().toCharArray();
            for (int j = 0; j < numeral.length; j++) {
                nums[i][j] = numeral[j];
            }
        }

        // Parse n1
        int S1 = in.nextInt();
        int i1 = S1 / H; // how many digits to read
        long n1 = 0;
        for (int i = i1 - 1; i >= 0; i--) {
            int curr = -1;
            char[][] cc = new char[H][L];
            for (int j = 0; j < H; j++) { // Read digit chars into matrix
                char[] num1Line = in.next().toCharArray();
                for (int k = 0; k < num1Line.length; k++) {
                    cc[j][k] = num1Line[k];
                }
            }
            for (int j = 0; j < 20 && curr == -1; j++) { // Identify digit, assign to curr
                boolean soFarSoGood = true; // The comparison is good for now
                for (int k = 0; k < H && soFarSoGood; k++) {
                    for (int l = 0; l < L && soFarSoGood; l++) {
                        if (nums[k][j * L + l] != cc[k][l]) {
                            soFarSoGood = false;
                        }
                    }
                }
                if (soFarSoGood) { // If we found an identical digit, save it
                    curr = j;
                }
            }
            n1 *= 20;
            n1 += curr;
        }

        // Parse n2
        int S2 = in.nextInt();
        int i2 = S2 / H; // how many digits to read
        long n2 = 0;
        for (int i = i2 - 1; i >= 0; i--) {
            int curr = -1;
            char[][] cc = new char[H][L];
            for (int j = 0; j < H; j++) { // Read digit chars into matrix
                char[] num2Line = in.next().toCharArray();
                for (int k = 0; k < num2Line.length; k++) {
                    cc[j][k] = num2Line[k];
                }
            }
            for (int j = 0; j < 20 && curr == -1; j++) { // Identify digit, assign to curr
                boolean soFarSoGood = true; // The comparison is good for now
                for (int k = 0; k < H && soFarSoGood; k++) {
                    for (int l = 0; l < L && soFarSoGood; l++) {
                        if (nums[k][j * L + l] != cc[k][l]) {
                            soFarSoGood = false;
                        }
                    }
                }
                if (soFarSoGood) { // If we found an identical digit, save it
                    curr = j;
                }
            }
            n2 *= 20;
            n2 += curr;
        }

        // Do operation
        String operation = in.next();
        long nres = -1;
        switch (operation) {
            case "+":
                nres = n1 + n2;
                break;
            case "-":
                nres = n1 - n2;
                break;
            case "*":
                nres = n1 * n2;
                break;
            case "/":
                nres = n1 / n2;
                break;
        }

        int digitsres = calcdigitsbase(nres, 20);
        // Solution matrix. For big numbers, very tall
        char[][] res = new char[H * digitsres][L];

        for (int i = 0; i < digitsres; i++) // Add digits to solution matrix
        {
            int digit = (int) (nres / (long) (Math.pow(20, digitsres - 1 - i))); // always in range [0,19]
            nres %= (long) (Math.pow(20, digitsres - 1 - i));
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < L; k++) {
                    res[i * H + j][k] = nums[j][digit * L + k];
                }
            }
        }

        // Print solution matrix
        for (char[] r : res) {
            for (char c : r)
                System.out.print(c);
            System.out.println();
        }
    }

    private static int calcdigitsbase(long num, int base) {
        if (num < base)
            return 1;
        return 1 + calcdigitsbase(num / base, base);
    }
}
