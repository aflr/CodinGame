import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in); in.nextLine();
        String[] groups = in.nextLine().split(" ");
        RideManager rm = new RideManager();
        for (String group : groups)
            rm.addGroup(group);
        System.out.println(rm);
    }

    private static class RideManager {
        private List<Ride> rides;
        private int rideWithX;

        public RideManager() {
            rides = new ArrayList<>();
            rides.add(new Ride());
            rideWithX = -1;
        }

        public boolean addGroup(String group) {
            if (!Ride.validGroup(group))
                return false;
            Ride r = rides.get(rides.size() - 1);
            int wagonsNeeded = (group.length() + 1) / 2;
            if (r.getAvailableWagons() < wagonsNeeded)
                rides.add(r = new Ride());
            if (rideWithX < 0 && group.contains("x"))
                rideWithX = rides.size();
            int[] people = Ride.countPeopleInGroup(group);
            r.seatGroup(people[0], people[1], people[2] > 0);
            return true;
        }

        public String toString() {
            return rideWithX + "\n" + rides.get(rideWithX - 1);
        }
    }

    private static class Ride {
        private char[][] seats;

        public Ride() {
            seats = new char[2][10];
            for (int i = 0; i < seats.length; i++)
                for (int j = 0; j < seats[i].length; j++)
                    seats[i][j] = 'D';
        }

        public int getAvailableWagons() {
            int w = 0;
            while (w < 10 && (seats[0][w] != 'D' || seats[1][w] != 'D'))
                w++;
            return 10 - w;
        }

        public void seatGroup(int adults, int kids, boolean x) {
            int w = 0;
            while (seats[0][w] != 'D' || seats[1][w] != 'D')
                w++;
            while (adults > 0) {
                seats[0][w] = 'A';
                adults--;
                if (kids > 0) {
                    seats[1][w] = x ? 'x' : 'k';
                    x = false;
                    kids--;
                } else if (adults > 0) {
                    seats[1][w] = 'A';
                    adults--;
                }
                w++;
            }
        }

        public static boolean validGroup(String group) {
            if (group.length() >= 20)
                return false;
            int[] people = countPeopleInGroup(group);
            return people[0] >= people[1];
        }

        public static int[] countPeopleInGroup(String group) {
            int[] people = { 0, 0, 0 };
            for (char c : group.toCharArray())
                switch (c) {
                    case 'x':
                        people[2]++;
                    case 'k':
                        people[1]++;
                        break;
                    case 'A':
                        people[0]++;
                        break;
                }
            return people;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("/< |");
            for (int j = 0; j < seats[0].length; j++)
                sb.append(' ').append(seats[0][j]).append(" |");
            sb.append("\n\\< |");
            for (int j = 0; j < seats[1].length; j++)
                sb.append(' ').append(seats[1][j]).append(" |");
            return sb.toString();
        }
    }
}
