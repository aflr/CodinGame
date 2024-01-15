import java.util.*;

class Solution {

    private static boolean error = false;

    private static void unary(String op, Stack<Integer> stack) {
        int n1;
        try {
            n1 = stack.pop();
        } catch (EmptyStackException ese) {
            error = true;
            return;
        }
        switch (op) {
            case "POP":
                break;
            case "DUP":
                stack.push(n1);
                stack.push(n1);
                break;
        }
    }

    private static void binary(String op, Stack<Integer> stack) {
        int n1, n2;
        try {
            n2 = stack.pop();
            n1 = stack.pop();
        } catch (EmptyStackException ese) {
            error = true;
            return;
        }
        switch (op) {
            case "ADD":
                stack.push(n1 + n2);
                break;
            case "SUB":
                stack.push(n1 - n2);
                break;
            case "MUL":
                stack.push(n1 * n2);
                break;
            case "DIV":
                try {
                    stack.push(n1 / n2);
                } catch (ArithmeticException ae) {
                    error = true;
                }
                break;
            case "MOD":
                try {
                    stack.push(n1 % n2);
                } catch (ArithmeticException ae) {
                    error = true;
                }
                break;
            case "SWP":
                stack.push(n2);
                stack.push(n1);
                break;
        }
    }

    private static void quaternary(String op, Stack<Integer> stack) {
        int n1, n2, n3;
        try {
            stack.pop();
            n3 = stack.pop();
            n2 = stack.pop();
            n1 = stack.pop();
        } catch (EmptyStackException ese) {
            error = true;
            return;
        }
        switch (op) {
            case "ROL":
                stack.push(n2);
                stack.push(n3);
                stack.push(n1);
                break;
        }
    }

    private static void doOp(String op, Stack<Integer> stack) {
        switch (op) {
            case "POP":
            case "DUP":
                unary(op, stack);
                break;
            case "ADD":
            case "SUB":
            case "MUL":
            case "DIV":
            case "MOD":
            case "SWP":
                binary(op, stack);
                break;
            case "ROL":
                quaternary(op, stack);
                break;
            default:
                error = true;
                break;
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Stack<Integer> s = new Stack<>();
        int N = in.nextInt();
        for (int i = 0; i < N && !error; i++) {
            String ins = in.next();
            try {
                s.push(Integer.parseInt(ins));
            } catch (NumberFormatException nfe) {
                doOp(ins, s);
            }
        }

        // Print resulting stack
        for (int i = 0; i < s.size(); i++) {
            System.out.print(s.get(i));
            if (i != s.size() - 1 || error)
                System.out.print(" ");
        }
        if (error)
            System.out.print("ERROR");
        System.out.println();
    }
}
