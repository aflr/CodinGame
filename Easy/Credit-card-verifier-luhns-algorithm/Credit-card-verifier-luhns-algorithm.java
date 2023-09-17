class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        for (int i = 0, sum = 0; i < n; sum = 0, i++) {
            char[] card = in.nextLine().replaceAll(" ", "").toCharArray();
            for (int j = 0; j < 16; j += 2)
                sum += (card[j] - '0') * 2 + (card[j] < '5' ? 0 : -9);
            for (int j = 1; j < 16; j += 2)
                sum += (card[j] - '0');
            System.out.println(sum % 10 == 0 ? "YES" : "NO");
        }
    }
}
