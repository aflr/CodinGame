class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int c = in.nextInt(), p = in.nextInt(); in.nextLine();
        var items = new java.util.ArrayList<String>();
        for (int i = 0; i < c; i++)
            items.add(in.nextLine());
        items.sort(null);
        for (int i = 0; i < p; i++) {
            final String order = in.nextLine(), str;
            items.remove(str = items.stream().filter(item -> item.startsWith(order))
                    .findFirst().orElse("NONE"));
            System.out.println(str.substring(str.lastIndexOf(' ') + 1));
        }
    }
}
