import java.util.*;
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Set<Integer>> rel = new HashMap<>(n);
        Set<Integer> mentors = new HashSet<>();
        Set<Integer> students = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            rel.putIfAbsent(x, new HashSet<>());
            rel.get(x).add(y);
            mentors.add(x);
            students.add(y);
        }
        mentors.removeAll(students);
        Iterator<Integer> it = mentors.iterator();
        int max = 0;
        while (it.hasNext()) {
            int mentor = it.next();
            max = Math.max(max, longestSuccessionFrom(mentor, rel));
        }
        System.out.println(max);
    }

    private static int longestSuccessionFrom(int id, Map<Integer, Set<Integer>> rel) {
        Iterator<Integer> it = null;
        try {
            it = rel.get(id).iterator();
        } catch (NullPointerException ex) {
            return 1;
        }
        int max = 0;
        while (it.hasNext()) {
            int person = it.next();
            max = Math.max(max, longestSuccessionFrom(person, rel));
        }
        return max + 1;
    }
}
