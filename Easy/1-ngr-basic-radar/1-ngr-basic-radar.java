import java.util.*;

class Solution {

    private static final double DIST = 13_000d; // m
    private static final int SPEED_LIMIT = 130; // km/h

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String plate = in.next();
            String radarname = in.next();
            long timestamp = in.nextLong();
            Car tmp = new Car(plate, timestamp);
            if (radarname.equals("A21-42"))
                cars.add(tmp);
            else if (radarname.equals("A21-55"))
                cars.get(cars.indexOf(tmp)).setEnd(timestamp);
        }

        cars.sort(null);

        //cars.stream().forEach(System.err::println);
        cars.stream().filter(car -> car.getSpeed() > SPEED_LIMIT).forEach(System.out::println);
    }

    private static class Car implements Comparable<Object> {
        private String plate;
        private long start;
        private long end;

        public Car(String plate, long start) {
            this.plate = plate;
            this.start = start;
        }

        public void setEnd(long end) {
            this.end = end;
        }

        public int getSpeed() {
            long elapsedMs = end - start;
            return (int) (DIST / elapsedMs * 3600d);
        }

        @Override
        public String toString() {
            return plate + " " + getSpeed();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if (this == obj)
                return true;
            if (!(obj instanceof Car))
                return false;
            Car other = (Car) obj;
            return this.plate.equals(other.plate);
        }

        @Override
        public int hashCode() {
            return plate.hashCode();
        }

        @Override
        public int compareTo(Object o) {
            return this.plate.compareTo(((Car) o).plate);
        }
    }
}
