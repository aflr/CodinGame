import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        for (int i = in.nextInt(); i > 0; i--)
            players.add(new Player(in.nextInt(), in.next().charAt(0)));
        for (List<Player> winners = new ArrayList<>(); players.size() > 1; players = List.copyOf(winners), winners.clear())
            for (int i = 0; i < players.size(); i += 2)
                winners.add(Player.fight(players.get(i), players.get(i + 1)));
        System.out.println(players.get(0));
    }

    private static class Player {
        int NUMPLAYER;
        char SIGNPLAYER;
        List<Integer> playersBeaten;

        public Player(int NUMPLAYER, char SIGNPLAYER) {
            this.NUMPLAYER = NUMPLAYER;
            this.SIGNPLAYER = SIGNPLAYER;
            playersBeaten = new ArrayList<>();
        }

        public static Player fight(Player p1, Player p2) {
            p1.playersBeaten.add(p2.NUMPLAYER);
            p2.playersBeaten.add(p1.NUMPLAYER);
            if (p1.SIGNPLAYER == p2.SIGNPLAYER)
                return p1.NUMPLAYER < p2.NUMPLAYER ? p1 : p2;
            return List.of("CP", "PR", "RL", "LS", "SC", "CL", "LP", "PS", "SR", "RC")
                    .contains(p1.SIGNPLAYER + "" + p2.SIGNPLAYER) ? p1 : p2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(NUMPLAYER).append('\n');
            for (int n : playersBeaten)
                sb.append(n).append(' ');
            return sb.deleteCharAt(sb.length() - 1).toString();
        }
    }
}
