import java.util.*;

class Solution {

    public static final String digits = "0123456789X";

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        List<String> invalid = new ArrayList<>();
        next: for (int i = 0; i < N; i++) {
            char[] ISBN = in.nextLine().toCharArray();
            if (ISBN.length != 10 && ISBN.length != 13) {
                invalid.add(String.valueOf(ISBN));
                continue next;
            }
            int sum = 0;
            for (int j = 0; j < ISBN.length; j++) {
                int val = digits.indexOf(ISBN[j]);
                if (val == -1 || ISBN.length == 13 && val == 10) {
                    invalid.add(String.valueOf(ISBN));
                    continue next;
                }
                sum += (ISBN.length == 10) ? val * (10 - j) : val * (j % 2 == 0 ? 1 : 3);
            }
            if (sum % (ISBN.length == 10 ? 11 : 10) != 0)
                invalid.add(String.valueOf(ISBN));
        }
        System.out.println(invalid.size() + " invalid:");
        for (String s : invalid)
            System.out.println(s);
    }
}
