import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeSet<Num> nums = new TreeSet<>();
        for (int i = 0; i < n; i++)
            nums.add(new Num(in.nextInt()));
        System.out.println(Arrays.toString(nums.toArray()).replaceAll("[\\[\\],]", ""));
    }

    private static class Num implements Comparable<Object> {
        private static final String[][] IR = {
                { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
                { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
                { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
                { "", "M", "MM", "MMM" }
        };

        private int num;
        private String roman;

        public Num(int num) {
            this.num = num;
            roman = IR[3][num / 1000] + IR[2][num / 100 % 10] + IR[1][num / 10 % 10] + IR[0][num % 10];
        }

        @Override
        public int compareTo(Object o) {
            return this.roman.compareTo(((Num) o).roman);
        }

        @Override
        public String toString() {
            return Integer.toString(num);
        }
    }
}
