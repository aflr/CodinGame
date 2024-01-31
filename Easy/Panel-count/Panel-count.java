import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int P = in.nextInt(); in.nextLine();
        List<String> properties = new ArrayList<>(P);
        for (int i = 0; i < P; i++)
            properties.add(in.nextLine());
        int N = in.nextInt(); in.nextLine();
        List<Person> persons = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            String[] person = in.nextLine().split(" ");
            Person p = new Person();
            for (int j = 1; j < person.length; j++)
                p.addProp(properties.get(j - 1), person[j]);
            persons.add(p);
        }
        int F = in.nextInt(); in.nextLine();
        for (int i = 0; i < F; i++) {
            String[] formula = in.nextLine().split(" ");
            List<Person> candidates = new ArrayList<>(){{addAll(persons);}};
            for (int j = 0; candidates.size() > 0 && j < formula.length; j += 2){
                String[] prop = formula[j].split("=");
                if (properties.contains(prop[0]))
                    candidates.removeIf(c -> !c.getProp(prop[0]).equals(prop[1]));
                else
                    candidates.clear();
            }
            System.out.println(candidates.size());
        }
    }

    private static class Person {
        private Map<String, String> props;

        public Person() {
            props = new HashMap<>();
        }

        public void addProp(String propName, String propValue) {
            props.put(propName, propValue);
        }

        public String getProp(String propName) {
            return props.get(propName);
        }
    }
}
