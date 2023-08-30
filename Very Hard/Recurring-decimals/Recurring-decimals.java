import java.util.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long dividend = 10;
        List<Long> ds = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        ds.add(dividend);
        while (dividend != 0) {
            long newdividend = dividend % n * 10;
            if (ds.contains(newdividend)) {
                ds.add(newdividend);
                sb.insert(2 + ds.indexOf(newdividend), '(');
                sb.append(dividend / n);
                sb.append(')');
                break;
            }
            sb.append(dividend / n);
            ds.add(newdividend);
            dividend = newdividend;
        }
        if (dividend == 0)
            System.out.println(BigDecimal.ONE.divide(new BigDecimal(n)).toPlainString());
        else
            System.out.println(sb.toString());
    }
}
