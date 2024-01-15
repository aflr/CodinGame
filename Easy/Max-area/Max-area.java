class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        String[] inputs = in.nextLine().split(" ");
        int i = 0, e = n - 1, max = 0;
        while (i < e) {
            int a = Integer.parseInt(inputs[i]), b = Integer.parseInt(inputs[e]);
            max = Math.max(max, Math.min(a, b) * (e - i));
            if (a < b) i++; else e--;
        }
        System.out.println(max);
    }
}
