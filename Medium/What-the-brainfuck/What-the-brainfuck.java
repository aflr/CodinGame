import java.util.*;

class Solution {
    private static final String[] ERROR = { "", "SYNTAX ERROR", "POINTER OUT OF BOUNDS", "INCORRECT VALUE" };

    private static int[] arr; // Array of cells
    private static int p = 0; // Pointer
    private static String code = ""; // Program
    private static ArrayList<Integer> in = new ArrayList<>(); // Input numbers
    private static String out = "";
    private static int errno = 0;
    private static HashMap<Integer, Integer> br = new HashMap<>(); // Pairs of brackets

    public static void main(String args[]) {
        readInput();
        parseBrackets();
        execute();
        System.out.println(errno == 0 ? out : ERROR[errno]);
    }

    private static void readInput() {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        arr = new int[sc.nextInt()];
        int N = sc.nextInt();
        sc.nextLine();
        // Read program
        for (int i = 0; i < L; i++)
            code += sc.nextLine();
        // Read inputs
        for (int i = 0; i < N; i++)
            in.add(sc.nextInt());
    }

    private static void parseBrackets() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < code.length(); i++) {
            switch (code.charAt(i)) {
                case '[':
                    stack.push(i);
                    break;
                case ']':
                    if (stack.empty())
                        errno = 1;
                    else {
                        int j = stack.pop();
                        br.put(j, i);
                        br.put(i, j);
                    }
            }
        }
        if (!stack.empty())
            errno = 1;
    }

    private static void execute() {
        for (int i = 0; i < code.length() && errno == 0; i++) {
            switch (code.charAt(i)) {
                case '>':
                    if (++p >= arr.length)
                        errno = 2;
                    break;
                case '<':
                    if (--p < 0)
                        errno = 2;
                    break;
                case '+':
                    if (++arr[p] > 255)
                        errno = 3;
                    break;
                case '-':
                    if (--arr[p] < 0)
                        errno = 3;
                    break;
                case '.':
                    out += (char) arr[p];
                    break;
                case ',':
                    arr[p] = in.remove(0);
                    break;
                case '[':
                    if (arr[p] == 0)
                        i = br.get(i);
                    break;
                case ']':
                    if (arr[p] != 0)
                        i = br.get(i);
                    break;
            }
        }
    }
}
