class Solution {

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int n = in.nextInt();
        String packet = in.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, size; i < n; i += 7 + size) {
            boolean isDrop = packet.substring(i, i + 3).equals("101");
            String strSize = packet.substring(i + 3, i + 7);
            size = Integer.parseInt(strSize, 2);
            if (isDrop)
                sb.append("001" + strSize + packet.substring(i + 7, i + 7 + size));
        }
        System.out.println(sb.toString());
    }
}
