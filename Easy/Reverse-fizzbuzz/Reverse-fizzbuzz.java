import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), fizz = -1, buzz = -1; in.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(in.nextLine());
        // Find starting value of the list, default to 1
        String firstNumStr = list.stream().filter(str -> {
            try { Integer.parseInt(str); return true; }
            catch (Exception ex) { return false; }
        }).findFirst().orElse("1");
        int start = Integer.parseInt(firstNumStr) - list.indexOf(firstNumStr);
        // Find differences between 2 Fizz / 2 Buzz, if only 1 found, use its value
        int f = -1, b = -1;
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.startsWith("Fizz")) {
                if (f == -1) f = i;
                else if (fizz == -1) fizz = i - f;
            }
            if (str.endsWith("Buzz")) {
                if (b == -1) b = i;
                else if (buzz == -1) buzz = i - b;
            }
        }
        System.out.println((fizz == -1 ? f + start : fizz) + " " + (buzz == -1 ? b + start : buzz));
    }
}
