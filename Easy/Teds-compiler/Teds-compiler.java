interface Solution {
    static void main(String[]$) {
        var l = new java.util.Scanner(System.in).nextLine().toCharArray();
        int len = -1, stack = 0;
        while (stack >= 0 && ++len < l.length)
            stack += l[len] == '<' ? 1 : -1;
        System.out.println(len);
    }
}
