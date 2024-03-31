import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); in.nextLine();
        List<String>[] synonymGroups = new List[N];
        for (int i = 0; i < N; i++) {
            synonymGroups[i] = Arrays.asList(in.nextLine().split(", "));
            synonymGroups[i].sort((s1, s2) -> s2.length() - s1.length());
        }
        Map<String, List<String>> res = new TreeMap<>();
        for (List<String> synonyms : synonymGroups)
            for (int i = 0; i < synonyms.size() - 1; i++)
                for (int j = i + 1; j < synonyms.size(); j++)
                    if (isKangarooOf(synonyms.get(i), synonyms.get(j))) {
                        res.putIfAbsent(synonyms.get(i), new ArrayList<>());
                        res.get(synonyms.get(i)).add(synonyms.get(j));
                    }
        if (res.isEmpty())
            System.out.println("NONE");
        else for (var en : res.entrySet())
            System.out.println(en.getKey() + ": " + en.getValue().stream()
                    .sorted().collect(java.util.stream.Collectors.joining(", ")));
    }

    private static boolean isKangarooOf(String kangaroo, String joey) {
        int j = 0;
        for (int i = 0; i < kangaroo.length() && j < joey.length(); i++)
            if (kangaroo.charAt(i) == joey.charAt(j))
                j++;
        return j == joey.length();
    }
}
