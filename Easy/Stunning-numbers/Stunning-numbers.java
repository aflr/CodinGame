import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        char[] n = in.nextLine().toCharArray();
        System.out.println(stunning(n));
        System.out.println(nextStunning(n));
    }

    private static boolean stunning(char[] n) {
        for (int is = 0, ie = n.length - 1; is <= ie; is++, ie--) {
            if (n[is] == '3' || n[is] == '4' || n[is] == '7' || n[ie] == '3' || n[ie] == '4' || n[ie] == '7')
                return false;
            if (n[is] == '0' && n[ie] != '0')
                return false;
            if (n[is] == '1' && n[ie] != '1')
                return false;
            if (n[is] == '2' && n[ie] != '2')
                return false;
            if (n[is] == '5' && n[ie] != '5')
                return false;
            if (n[is] == '6' && n[ie] != '9')
                return false;
            if (n[is] == '8' && n[ie] != '8')
                return false;
            if (n[is] == '9' && n[ie] != '6')
                return false;
        }
        return true;
    }

    private static char[] nextStunning(char[] n) {
        char[] res = addOne(n, n.length - 1);
        while (!stunning(res)) {
            for (int i = 0, ie = res.length - 1; i <= ie; i++, ie--) {
                if (res[i] == '3'
                        || res[i] == '4'
                        || res[i] == '7') {
                    addOne(res, i);
                    break;
                }
                if (res[ie] == '3'
                        || res[ie] == '4'
                        || res[ie] == '7'
                        || res[i] == '0' && res[ie] != '0'
                        || res[i] == '1' && res[ie] != '1'
                        || res[i] == '2' && res[ie] != '2'
                        || res[i] == '5' && res[ie] != '5'
                        || res[i] == '6' && res[ie] != '9'
                        || res[i] == '8' && res[ie] != '8'
                        || res[i] == '9' && res[ie] != '6') {
                    res = addOne(res, ie);
                    break;
                }
            }
        }
        return res;
    }

    private static char[] addOne(char[] n, int pos) {

        if (n[pos] != '9') {
            n[pos]++;
            for (int i = pos + 1; i < n.length; i++)
                n[i] = '0';
            return n;
        } else {
            if (pos == 0) {
                char[] bigger = new char[n.length + 1];
                bigger[0] = '1';
                for (int i = 1; i < bigger.length; i++)
                    bigger[i] = '0';
                return bigger;
            } else {
                for (int i = pos; i < n.length; i++)
                    n[i] = '0';
                return addOne(n, pos - 1);
            }
        }
    }
}
