interface Solution {
    static void main(String[]$) {
        var in = new java.util.Scanner(System.in);
        var keys = in.nextLine().toCharArray();
        var sb = new StringBuilder();
        for (int i = 0, j = 0; i < keys.length; i++) {
            switch (keys[i]) {
                case '-': if (j != 0) sb.deleteCharAt(--j); break;
                case '<': j--; break;
                case '>': j++; break;
                default: sb.insert(j++, keys[i]);
            }
            if (j < 0) j = 0;
            if (j > sb.length()) j = sb.length();
        }
        System.out.println(sb.toString());
    }
}
