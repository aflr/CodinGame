import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String actorName = in.nextLine();
        int n = in.nextInt(); in.nextLine();
        List<Actor> actors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] movieCast = in.nextLine().split(": ")[1].split(", ");
            for (String actor : movieCast) {
                Actor aux = new Actor(actor);
                int idx = actors.indexOf(aux);
                if (idx < 0) actors.add(new Actor(actor, movieCast));
                else actors.get(idx).addConnectedActors(movieCast);
            }
        }
        PriorityQueue<Actor> queue = new PriorityQueue<>((a1, a2) -> a1.deg - a2.deg);
        queue.addAll(actors);
        while (!queue.isEmpty()) {
            Actor curr = queue.remove();
            if (curr.name.equals(actorName)) {
                System.out.println(curr.deg); System.exit(0);
            }
            for (String str : curr.connectedActors) {
                Actor next = queue.stream().filter(a -> a.name.equals(str)).findAny().orElse(null);
                if (next == null)
                    continue;
                if (curr.deg + 1 < next.deg) {
                    queue.remove(next);
                    next.deg = curr.deg + 1;
                    queue.add(next);
                }
            }
        }
    }

    private static class Actor {
        protected String name;
        protected int deg;
        protected Set<String> connectedActors;

        public Actor(String name) {
            this.name = name;
        }

        public Actor(String name, String[] movieCast) {
            this.name = name;
            this.deg = name.equals("Kevin Bacon") ? 0 : Integer.MAX_VALUE;
            this.connectedActors = new HashSet<>();
            addConnectedActors(movieCast);
        }

        public boolean addConnectedActors(String[] movieCast) {
            boolean added = false;
            for (String castMember : movieCast)
                if (!castMember.equals(name))
                    added |= connectedActors.add(castMember);
            return added;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || !(o instanceof Actor))
                return false;
            return this.name.equals(((Actor) o).name);
        }

        @Override
        public int hashCode() {
            return this.name.hashCode();
        }
    }
}
