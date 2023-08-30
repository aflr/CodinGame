import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int tributes = in.nextInt(); in.nextLine();

        Map<String, List<String>> killed = new TreeMap<>();
        Map<String, String> killer = new TreeMap<>();

        for (int i = 0; i < tributes; i++) {
            String playerName = in.nextLine();
            killed.put(playerName, new ArrayList<>());
            killer.put(playerName, null);
        }
        int turns = in.nextInt(); in.nextLine();
        for (int i = 0; i < turns; i++) {
            String[] info = in.nextLine().replaceAll(",", "").split(" ");
            for (int j = 2; j < info.length; j++) {
                killed.get(info[0]).add(info[j]);
                killer.put(info[j], info[0]);
            }
        }
        Iterator<String> it = killed.keySet().iterator();
        while (it.hasNext()) {
            String name = it.next();
            System.out.println("Name: " + name);
            System.out.print("Killed: ");
            if (killed.get(name).isEmpty())
                System.out.println("None");
            else {
                List<String> k = killed.get(name);
                k.sort(null);
                for (int i = 0; i < k.size(); i++) {
                    System.out.print(k.get(i));
                    if (i != k.size() - 1)
                        System.out.print(", ");
                }
                System.out.println();
            }
            System.out.print("Killer: ");
            if (killer.get(name) == null)
                System.out.println("Winner");
            else
                System.out.println(killer.get(name));
            if (it.hasNext())
                System.out.println();
        }
    }
}
