interface Solution {
    static void main(String[]$) {
        var in = new java.util.Scanner(System.in);
        System.out.println(in.nextLine()
            .matches(java.util.regex.Pattern.compile("[{}()\\[\\].+*^$\\\\|]")
            .matcher(in.nextLine()).replaceAll("\\\\$0")
            .replaceAll("\\?", ".").replaceAll("~", ".*")) ? "MATCH" : "FAIL");
    }
}
