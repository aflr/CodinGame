import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Network network = new Network();

        String idStartJourney = in.next();
        String idEndJourney = in.next();

        int N = in.nextInt(); in.nextLine();
        // Read all stops in the network (graph nodes)
        for (int i = 0; i < N; i++) {
            String[] stop = in.nextLine().split(",");
            network.addStop(new Stop(stop[0], stop[1].replaceAll("\"", ""), Double.parseDouble(stop[3]),
                    Double.parseDouble(stop[4])));
        }
        int M = in.nextInt(); in.nextLine();
        // Read all routes in the network (graph links)
        for (int i = 0; i < M; i++) {
            String[] route = in.nextLine().split(" ");
            network.addRoute(route[0], route[1]);
        }
        // Find shortest path, print it
        List<Stop> path = network.getShortestPath(idStartJourney, idEndJourney);
        if (path == null)
            System.out.println("IMPOSSIBLE");
        else
            path.forEach(x -> System.out.println(x.fullName));
    }

    private static class Network {
        private Map<Stop, List<Stop>> routes;

        public Network() {
            routes = new HashMap<>();
        }

        public void addStop(Stop stop) {
            routes.put(stop, new ArrayList<>());
        }

        public void addRoute(String idStart, String idEnd) {
            routes.get(getStopFromId(idStart)).add(getStopFromId(idEnd));
        }

        private Stop getStopFromId(String str) {
            for (Stop stop : routes.keySet())
                if (str.equals(stop.id))
                    return stop;
            return null;
        }

        public List<Stop> getShortestPath(String idStartJourney, String idEndJourney) {
            Stop start = getStopFromId(idStartJourney);
            Stop end = getStopFromId(idEndJourney);

            // Structures needed to perform A* algorithm
            Map<Stop, Stop> cameFrom = new HashMap<>();
            // g = actual cost from start to current node
            Map<Stop, Double> g = new HashMap<>();
            // f = g + heuristic (distance)
            Map<Stop, Double> f = new HashMap<>();
            // open = list of discovered nodes. Could have also used TreeSet
            PriorityQueue<Stop> open = new PriorityQueue<>((a, b) -> Double.compare(f.get(a), f.get(b)));

            open.add(start);
            g.put(start, 0.0);
            f.put(start, start.distance(end));

            while (!open.isEmpty()) {
                // Take node from open, starting by lowest f
                Stop current = open.poll();
                if (current.equals(end)) {
                    return reconstructPath(cameFrom, current);
                }

                for (Stop neighbor : routes.get(current)) {
                    double gScore = g.get(current) + current.distance(neighbor);
                    if (gScore < g.getOrDefault(neighbor, Double.MAX_VALUE)) {
                        cameFrom.put(neighbor, current);
                        g.put(neighbor, gScore);
                        f.put(neighbor, gScore + neighbor.distance(end));
                        if (!open.contains(neighbor))
                            open.add(neighbor);
                    }
                }
            }
            // Impossible to reach goal
            return null;
        }

        private List<Stop> reconstructPath(Map<Stop, Stop> cameFrom, Stop current) {
            List<Stop> path = new ArrayList<>();
            path.add(current);
            while (cameFrom.containsKey(current)) {
                current = cameFrom.get(current);
                // Add to the front of the path, since we start at the end
                path.add(0, current);
            }
            return path;
        }
    }

    private static class Stop {
        String id;
        String fullName;
        double lat;
        double lon;

        public Stop(String id, String fullName, double lat, double lon) {
            this.id = id;
            this.fullName = fullName;
            this.lat = Math.toRadians(lat);
            this.lon = Math.toRadians(lon);
        }

        public double distance(Stop other) {
            double x = (other.lon - this.lon) * Math.cos((this.lat + other.lat) / 2);
            double y = other.lat - this.lat;
            return (Math.sqrt(x * x + y * y) * 6371);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Stop other = (Stop) obj;
            if (id == null) {
                if (other.id != null)
                    return false;
            } else if (!id.equals(other.id))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return id + " " + String.format("%-20s", fullName) + " (" + lat + "," + lon + ")";
        }
    }
}
