import java.util.*;

class Solution {

    private static class FizzBuzzer {
        private HashMap<String, Integer> fb;

        public FizzBuzzer(int n) {
            fb = new HashMap<>(n);
            fill(n);
        }

        private void fill(int n) {
            for (int i = n; i > 0; i--) {
                int fc = 0, bc = 0;
                fc += Integer.toString(i).chars().filter(c -> c == '3').count();
                for (int j = i; j > 1 && j % 3 == 0; j /= 3, fc++);
                bc += Integer.toString(i).chars().filter(c -> c == '5').count();
                for (int j = i; j > 1 && j % 5 == 0; j /= 5, bc++);
                if (fc > 0 || bc > 0)
                    fb.put("Fizz".repeat(fc) + "Buzz".repeat(bc), i);
            }
        }

        public String findFirst(String s) {
            return fb.containsKey(s) ? Integer.toString(fb.get(s)) : "ERROR";
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        FizzBuzzer fizzbuzzer = new FizzBuzzer(1000);
        for (int i = 0; i < n; i++) {
            String row = in.nextLine();
            if (row.matches("(.*[35].*)|(.*0)"))
                System.out.println("ERROR");
            else
                try {
                    System.out.println(Integer.parseInt(row) % 3 == 0 ? "ERROR" : row);
                } catch (NumberFormatException ex) {
                    System.out.println(fizzbuzzer.findFirst(row));
                }
        }
    }
}
