import java.util.*;

class Player {

    private static class Node {
        int num;
        boolean gateway;
        List<Node> paths;

        public Node(int num) {
            this.num = num;

            gateway = false;
            paths = new ArrayList<>();
        }

        public void setGateway() {
            gateway = true;
        }

        public void addPath(Node n) {
            paths.add(n);
        }

        public int gatewayDistance() {
            if (gateway)
                return 0;
            for (Node n : paths)
                if (n.gateway)
                    return 1;
            int min = 500;
            for (Node n : paths)
                min = Math.min(min, n.gatewayDistance());
            return 1 + min;
        }

    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        // Create nodes
        List<Node> nodes = new ArrayList<>(N);
        for (int i = 0; i < N; i++)
            nodes.add(new Node(i));

        int L = in.nextInt();
        int E = in.nextInt();
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt();
            int N2 = in.nextInt();
            nodes.get(N1).addPath(nodes.get(N2));
            nodes.get(N2).addPath(nodes.get(N1));
        }
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt();
            nodes.get(EI).setGateway();
        }

        while (true) {
            int SI = in.nextInt();
            int min = 500, sever = -1;
            for (Node n : nodes.get(SI).paths)
                if (n.gatewayDistance() < min) {
                    sever = n.num;
                    min = n.gatewayDistance();
                }
            System.out.println(SI + " " + sever);
        }
    }
}
