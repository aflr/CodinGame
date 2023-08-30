import java.util.*;

class Solution {

    private static class NindexArray {
        public String c;
        public int start;
        public int end;
        public int[] array;

        public NindexArray(String c, int start, int end) {
            this.c = c;
            this.start = start;
            this.end = end;

            array = new int[end - start + 1];
        }

        public int get(int i) {
            return array[i - start];
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        Map<String, NindexArray> arrs = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] assignment = in.nextLine().replaceAll("[\\[\\]\\.\\=]", " ").split(" ");
            String c = assignment[0];
            int start = Integer.parseInt(assignment[1]);
            int end = Integer.parseInt(assignment[3]);
            NindexArray na = new NindexArray(c, start, end);
            for (int j = 7; j < assignment.length; j++) {
                na.array[j - 7] = Integer.parseInt(assignment[j]);
            }
            arrs.put(c, na);
        }
        String x = in.nextLine();

        int res = -1;
        while (true) {
            try {
                res = Integer.parseInt(x);
                break;
            } catch (NumberFormatException nfe) {
                int bo = x.lastIndexOf('[');
                int bc = x.indexOf(']');
                if (bo == -1 || bc == -1)
                    break;
                int pbo = x.substring(0, bo).lastIndexOf('[');
                String c = x.substring(pbo + 1, bo);
                int index = Integer.parseInt(x.substring(bo + 1, bc));
                System.err.println("Array: " + c + "\nIndex: " + index);
                x = x.substring(0, pbo + 1) + arrs.get(c).get(index) + x.substring(bc + 1);
            }
        }

        System.out.println(res);
    }
}
