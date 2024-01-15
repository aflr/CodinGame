import java.util.regex.*;

class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        String[] mother = in.nextLine().split(":", 2)[1].trim().split(" ");
        String[] child = in.nextLine().split(":", 2)[1].trim().split(" ");
        for(int i = 0; i < mother.length; i++)
            child[i] = child[i].replaceAll("[" + Pattern.quote(mother[i]) + "]", "");
        int n = in.nextInt(); in.nextLine();
next:   for (int i = 0; i < n; i++) {
            String[] father = in.nextLine().split(":", 2), ch = father[1].trim().split(" ");
            for (int j = 0; j < mother.length; j++) {
                if (child[j].length() == 1 && !ch[j].contains(child[j]))
                    continue next;
                if (child[j].length() == 0 && !ch[j].contains(mother[j].substring(0, 1))
                        && !ch[j].contains(mother[j].substring(1, 2)))
                    continue next;
            }
            System.out.println(father[0] + ", you are the father!");
            return;
        }
    }
}
