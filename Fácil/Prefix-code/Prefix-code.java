import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(in.next(), (char)in.nextInt());
        char[] s = in.next().toCharArray();
        String res = "", cs = "";
        for (int i = 0, oi = 0; i < s.length; cs = "", oi = i) {
            while (!map.containsKey(cs) && i < s.length)
                cs += s[i++];
            if (!map.containsKey(cs)) {
                System.out.println("DECODE FAIL AT INDEX " + oi);
                return;
            }
            res += map.get(cs);
        }
        System.out.println(res);
    }
}
