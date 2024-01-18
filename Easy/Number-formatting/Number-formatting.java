import java.math.*;

class Solution {
    public static void main(String args[]) {
        System.out.println(format(parseNumber((new java.util.Scanner(System.in)).nextLine()).divide(new BigDecimal(2))));
    }

    private static BigDecimal parseNumber(String numstr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numstr.length(); i++)
            if (Character.isDigit(numstr.charAt(i)))
                sb.append(numstr.charAt(i));
            else if (numstr.charAt(i) == '.' && sb.indexOf(".") == -1)
                sb.append('.');
        return sb.length() == 1 ? BigDecimal.ZERO : new BigDecimal(sb.toString());
    }

    private static String format(BigDecimal num) {
        StringBuilder sb = new StringBuilder();
        String str = num.toString();
        if (str.charAt(0) == '0')
            str = str.substring(1);
        int dot = str.indexOf('.');
        // Add 'x' at beginning
        sb.append("x".repeat(9 - (dot == -1 ? str.length() : dot)));
        if (dot == 1 && str.charAt(0) == '0')
            sb.append('x');
        // Add digits
        sb.append(str.replace(".", ""));
        // Add 'x' at end
        sb.append("x".repeat(6 - (dot == -1 ? 0 : (str.length() - dot - 1))));
        // Insert all commas and dots
        sb.insert(3, ",").insert(7, ",").insert(11, ".").insert(15, ".");
        return sb.toString();
    }
}
