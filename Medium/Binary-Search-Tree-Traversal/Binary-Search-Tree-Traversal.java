class Solution {

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);

        // Create and fill binary tree
        int n = in.nextInt();
        TreeNode root = n > 0 ? new TreeNode(in.nextInt()) : null;
        for (int i = 1; i < n; i++)
            root.addNode(new TreeNode(in.nextInt()));

        /* PRE-ORDER TRAVERSAL */
        System.out.println(root.preOrderTraversal().stripTrailing());

        /* IN-ORDER TRAVERSAL */
        System.out.println(root.inOrderTraversal().stripTrailing());

        /* POST-ORDER TRAVERSAL */
        System.out.println(root.postOrderTraversal().stripTrailing());

        /* LEVEL-ORDER TRAVERSAL */
        var sb = new StringBuilder();
        var queue = new java.util.ArrayDeque<TreeNode>(java.util.List.of(root));
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            sb.append(curr);
            if (curr.left != null)
                queue.offer(curr.left);
            if (curr.right != null)
                queue.offer(curr.right);
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }

    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public void addNode(TreeNode n) {
            if (n.val < this.val) {
                if (this.left == null) {
                    this.left = n;
                } else {
                    left.addNode(n);
                }
            } else {
                if (this.right == null) {
                    this.right = n;
                } else {
                    right.addNode(n);
                }
            }
        }

        public String preOrderTraversal() {
            return this.toString()
                    + (this.left == null ? "" : this.left.preOrderTraversal())
                    + (this.right == null ? "" : this.right.preOrderTraversal());
        }

        public String inOrderTraversal() {
            return (this.left == null ? "" : this.left.inOrderTraversal())
                    + this.toString()
                    + (this.right == null ? "" : this.right.inOrderTraversal());
        }

        public String postOrderTraversal() {
            return (this.left == null ? "" : this.left.postOrderTraversal())
                    + (this.right == null ? "" : this.right.postOrderTraversal())
                    + this.toString();
        }

        @Override
        public String toString() {
            return Integer.toString(this.val) + " ";
        }
    }
}
