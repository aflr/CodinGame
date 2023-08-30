import java.util.*;

class Solution {
    private static boolean and(boolean one, boolean two) {
        return (one && two);
    }

    private static boolean or(boolean one, boolean two) {
        return (one || two);
    }

    private static boolean xor(boolean one, boolean two) {
        return (one || two) && (!one || !two);
    }

    private static boolean logic(String op, boolean one, boolean two) {
        switch (op) {
            case "AND":
                return and(one, two);
            case "OR":
                return or(one, two);
            case "XOR":
                return xor(one, two);
            case "NAND":
                return !and(one, two);
            case "NOR":
                return !or(one, two);
            case "NXOR":
                return !xor(one, two);
            default:
                return false;
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int len = -1;
        // Read and store all input lines
        Map<String, String> input = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String inputName = in.next();
            String inputSignal = in.next();
            if (i == 0)
                len = inputSignal.length();

            input.put(inputName, inputSignal);
        }

        // Read output names and operations,
        // calculate and store results
        Map<String, String> out = new LinkedHashMap<>();
        for (int i = 0; i < m; i++) {
            String outputName = in.next();
            String type = in.next();
            String inputName1 = in.next();
            String inputName2 = in.next();

            char[] i1 = input.get(inputName1).toCharArray();
            char[] i2 = input.get(inputName2).toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                sb.append(logic(type, i1[j] == '-', i2[j] == '-') ? '-' : '_');
            }
            out.put(outputName, sb.toString());
        }
        // Print all output lines
        out.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
