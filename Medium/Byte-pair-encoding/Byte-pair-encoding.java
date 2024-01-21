import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // Read input
        int n = in.nextInt(), m = in.nextInt();
        String input = "";
        for (int i = 0; i < n; i++)
            input += in.next();

        List<String> rules = new ArrayList<>();
        char t = 'Z';
        while (true) {
            // Count byte pair occurrences
            Map<String, Integer> bpo = new LinkedHashMap<>();
            for (int i = 0; i < input.length() - 1; i++) {
                bpo.put(input.substring(i, i + 2),
                        bpo.getOrDefault(input.substring(i, i + 2), 0) + 1);
                // Don't count overlapping repetitions
                if (i < input.length() - 3
                        && input.charAt(i) == input.charAt(i + 1)
                        && input.charAt(i) == input.charAt(i + 2))
                    i++;
            }
            // Find most common byte pair, prefer leftmost
            String bp = null;
            int maxOcc = 0;
            var it = bpo.entrySet().iterator();
            while (it.hasNext()) {
                var e = it.next();
                if (e.getValue() > maxOcc) {
                    bp = e.getKey();
                    maxOcc = e.getValue();
                }
            }
            // Terminate if there are no repeated byte pairs
            if (maxOcc <= 1)
                break;
            // Add new rule
            rules.add(t + " = " + bp);
            // Transform input string with new rule
            input = input.replaceAll(bp, Character.toString(t));
            // Update terminal character
            t--;
        }
        // Print output string and production rules
        System.out.println(input);
        rules.forEach(System.out::println);
    }
}
