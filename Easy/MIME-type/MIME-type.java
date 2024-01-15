import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();

        Map<String, String> lookup = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String EXT = in.next();
            String MT = in.next();

            // Add them to a Map<EXT, MT>
            lookup.put(EXT.toLowerCase(), MT);
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine().toLowerCase();

            if (!FNAME.contains("."))
                System.out.println("UNKNOWN");
            else {
                String fext = FNAME.substring(FNAME.lastIndexOf(".") + 1);
                if (lookup.containsKey(fext)) {
                    System.out.println(lookup.get(fext));
                } else
                    System.out.println("UNKNOWN");
            }
        }
    }
}
