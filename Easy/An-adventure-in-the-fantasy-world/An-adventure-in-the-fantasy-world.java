import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        char[] moves = in.next().toCharArray();

        int n = in.nextInt(); in.nextLine();
        Map<Position, String> info = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] m = in.nextLine().split(" ", 3);
            info.put(new Position(Integer.parseInt(m[0]), Integer.parseInt(m[1])), m[2]);
        }

        Position myPos = new Position(0, 0);
        int myMoney = 50;
        boolean gameClear = true;
        String lastEnemy = null;

        for (int i = 0; gameClear && i < moves.length; i++) {
            myPos.move(moves[i]);
            if (info.containsKey(myPos)) {
                String[] m = info.get(myPos).split(" ");
                if (m[0].equals("money")) {
                    myMoney += Integer.parseInt(m[1].substring(0, m[1].length() - 1));
                    info.remove(myPos);
                } else if (m[0].equals("enemy")) {
                    if (m[1].equals("goblin") && myMoney >= 50) {
                        myMoney -= 50;
                    } else {
                        lastEnemy = m[1];
                        gameClear = false;
                    }
                }
            }
        }
        System.out.println(gameClear ? "GameClear " + myPos + " " + myMoney + "G"
                : myPos + " " + myMoney + "G " + lastEnemy);
    }

    private static class Position {
        private int y;
        private int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int move(char dir) {
            switch (dir) {
                case 'R': return ++x;
                case 'L': return --x;
                case 'U': return --y;
                case 'D': return ++y;
                default: return 0;
            }
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            Position other = (Position) obj;
            if (x != other.x) return false;
            if (y != other.y) return false;
            return true;
        }

        @Override
        public String toString() {
            return y + " " + x;
        }
    }
}
