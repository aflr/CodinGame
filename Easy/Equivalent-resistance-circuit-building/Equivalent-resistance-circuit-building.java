import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Map<String, Integer> dic = new HashMap<>(N);
        for (int i = 0; i < N; i++)
            dic.put(in.next(), in.nextInt());
        in.nextLine();
        String[] circuit = in.nextLine().split(" ");
        Stack<Float> res = new Stack<>();
        for (String s : circuit) {
            float calc = 0;
            switch(s) {
                case "(": res.push(Float.NEGATIVE_INFINITY); break;
                case "[": res.push(Float.POSITIVE_INFINITY); break;
                case ")":
                    while (res.peek() != Float.NEGATIVE_INFINITY)
                        calc += res.pop();
                    res.pop(); res.push(calc); break;
                case "]":
                    while (res.peek() != Float.POSITIVE_INFINITY)
                        calc += 1 / res.pop();
                    res.pop(); res.push(1 / calc); break;
                default: res.push((float)dic.get(s)); break;
            }
        }
        System.out.printf("%.1f", res.peek());
    }
}
