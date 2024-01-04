import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        final int[] R = { in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt() };
        final int n = in.nextInt(); in.nextLine();

        // Read instructions
        ArrayList<String[]> instructions = new ArrayList<>();
        for (int i = 0; i < n; i++)
            instructions.add(in.nextLine().split(" "));

        // Execute program
        for (int i = 0; i < n; i++) {
            String[] ins = instructions.get(i);
            int dst, op1, op2;
            boolean immop1, immop2;
            switch (ins[0]) {
                case "MOV":
                    dst = parseRegister(ins[1]);
                    immop1 = (op1 = parseRegister(ins[2])) < 0;
                    R[dst] = immop1 ? Integer.parseInt(ins[2]) : R[op1];
                    break;
                case "ADD":
                case "SUB":
                    dst = parseRegister(ins[1]);
                    immop1 = (op1 = parseRegister(ins[2])) < 0;
                    immop2 = (op2 = parseRegister(ins[3])) < 0;
                    R[dst] = (immop1 ? Integer.parseInt(ins[2]) : R[op1])
                            + (immop2 ? Integer.parseInt(ins[3]) : R[op2]) * (ins[0].equals("ADD") ? 1 : -1);
                    break;
                case "JNE":
                    dst = Integer.parseInt(ins[1]);
                    op1 = parseRegister(ins[2]);
                    immop2 = (op2 = parseRegister(ins[3])) < 0;
                    if (R[op1] != (immop2 ? Integer.parseInt(ins[3]) : R[op2]))
                        i = dst - 1;
                    break;
                default:
                    throw new IllegalArgumentException("Bad instruction: " + ins[0]);
            }
        }
        // Print registers
        System.out.format("%d %d %d %d\n", R[0], R[1], R[2], R[3]);
    }

    private static int parseRegister(String s) {
        switch (s) {
            case "a": return 0;
            case "b": return 1;
            case "c": return 2;
            case "d": return 3;
            default: return -1;
        }
    }
}
