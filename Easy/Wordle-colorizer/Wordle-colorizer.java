import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String attempt = in.nextLine();
            System.err.println(attempt);

            char[] cloneAns = answer.toCharArray();
            char[] cloneAtt = attempt.toCharArray();

            // Only process correctly placed letters
            for (int j = 0; j < 5; j++) {
                if (attempt.charAt(j) == cloneAns[j]) {
                    cloneAns[j] = '2';
                    cloneAtt[j] = '2';
                }
            }

            // Now process everything else
            for (int j = 0; j < 5; j++) {
                if (cloneAtt[j] == '2' || cloneAtt[j] == '1')
                    continue;
                for (int k = 0; k < 5; k++) {
                    if (cloneAtt[j] == cloneAns[k]) {
                        cloneAns[k] = '1';
                        cloneAtt[j] = '1';
                        k = 5;
                    }
                }
            }
            for (int j = 0; j < 5; j++) {
                switch (cloneAtt[j]) {
                    case '2':
                        System.out.print('#');
                        break;
                    case '1':
                        System.out.print('O');
                        break;
                    default:
                        System.out.print('X');
                }
            }
            System.out.println();
        }
    }
}
