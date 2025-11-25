import java.util.*;

class Solution {
    public static boolean F_SHOW_HIDDEN = false;
    public static boolean F_DIR_ONLY = false;
    public static int F_DEPTH = -1;

    public static StringBuilder sb = new StringBuilder();
    public static int dirCount = 0;
    public static int fileCount = 0;

    public static void main(String args[]) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);

        final String INPUT_PATH = in.nextLine(); // path
        String S = INPUT_PATH;
        // Make sure path is absolute, with dot (.) as root directory
        if (S.length() > 1 && S.charAt(1) != '/')
            S = "./" + S;

        String[] F = in.nextLine().split(","); // flags
        for (String flag : F) {
            if (flag.equals("-a")) {
                F_SHOW_HIDDEN = true;
            } else if (flag.equals("-d")) {
                F_DIR_ONLY = true;
            } else if (flag.startsWith("-L")) {
                try {
                    String str_depth = flag.split(" ")[1];
                    F_DEPTH = Integer.parseInt(str_depth);
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    // If depth value is missing or invalid, ignore it
                }
            }
        }

        // Create and fill the file system's tree structure
        FileSystemNode root = new FileSystemNode(".");
        int N = in.nextInt();
        in.nextLine();
        for (int i = 0; i < N; i++)
            root.addPath(in.nextLine());

        // Move to the directory where we start printing
        root = root.changeDirectory(S);

        // Special case: Error opening dir
        if (root == null || root.type != TYPE.DIR) {
            System.out.println(INPUT_PATH
                    + " [error opening dir]\n\n0 directories"
                    + (F_DIR_ONLY ? "" : ", 0 files"));
            return;
        }

        // Print tree and counters, taking flags into account
        sb.append(INPUT_PATH).append('\n');
        traverseTree(root, "", 0);
        System.out.print(sb.toString());

        System.out.printf("\n%d %s" + (F_DIR_ONLY ? "" : ", %d %s") + "\n",
                dirCount, dirCount == 1 ? "directory" : "directories",
                fileCount, fileCount == 1 ? "file" : "files");
    }

    /**
     * DFS the tree structure, adding lines to the StringBuilder
     * The current node, previous padding, and current depth are passed as well
     */
    private static void traverseTree(FileSystemNode node, String padding, int currDepth) {
        if (node.directoryContents != null) {
            Iterator<FileSystemNode> it = node.directoryContents.stream()
                    .filter(n -> isPrintable(n, currDepth + 1)).iterator();
            while (it.hasNext()) {
                FileSystemNode next = it.next();
                boolean notLast = it.hasNext();
                sb.append(padding)
                        .append(notLast ? "|-- " : "`-- ")
                        .append(next.name)
                        .append('\n');
                if (next.type == TYPE.FILE) {
                    fileCount++;
                } else if (next.type == TYPE.DIR) {
                    dirCount++;
                    traverseTree(next, padding.replaceAll("(`|-)", " ")
                            + (notLast ? "|   " : "    "), currDepth + 1);
                }
            }
        }
    }

    private static boolean isPrintable(FileSystemNode node, int currDepth) {
        // Hidden
        if (!F_SHOW_HIDDEN && node.hidden) {
            System.err.println(node.name + " not printable: Hidden");
            return false;
        }
        // Dir only
        if (F_DIR_ONLY && node.type != TYPE.DIR) {
            System.err.println(node.name + " not printable: Not directory");
            return false;
        }
        // Depth
        if (F_DEPTH != -1 && currDepth > F_DEPTH) {
            System.err.println(node.name + " not printable: Too deep");
            return false;
        }
        return true;
    }

    private static enum TYPE {
        DIR, FILE
    }

    private static class FileSystemNode implements Comparable<Object> {
        String name;

        private String ordering_name; // lowercase, without dot (.) for hidden files
        private boolean hidden;

        private TYPE type; // DIR or FILE
        private SortedSet<FileSystemNode> directoryContents;

        public FileSystemNode(String name) {
            this.name = name;
            this.ordering_name = getOrderingName(name);
            this.hidden = name.length() > 1 && name.charAt(0) == '.';

            this.type = TYPE.FILE;
            directoryContents = null;
        }

        public void addPath(String path) {
            path = removeFirstDirFromPath(path);
            if (path.isEmpty())
                return;
            if (type == TYPE.FILE) {
                type = TYPE.DIR;
                directoryContents = new TreeSet<>();
            }
            String newFsnName = getFirstDirFromPath(path);
            directoryContents.add(new FileSystemNode(newFsnName));
            FileSystemNode addedFsn = directoryContents.stream()
                    .filter(fsn -> fsn.name.equals(newFsnName))
                    .findAny().orElse(null);
            addedFsn.addPath(path);
        }

        public FileSystemNode changeDirectory(String path) {
            if (path.equals(this.name))
                return this;
            path = removeFirstDirFromPath(path);
            String nextFsnName = getFirstDirFromPath(path);
            FileSystemNode nextFsn = directoryContents.stream()
                    .filter(fsn -> fsn.name.equals(nextFsnName))
                    .findAny().orElse(null);
            if (nextFsn == null)
                return null;
            return nextFsn.changeDirectory(path);
        }

        private static String getOrderingName(String name) {
            return (name.charAt(0) == '.' ? name.substring(1) : name).toLowerCase();
        }

        @Override
        public int compareTo(Object o) {
            FileSystemNode other = (FileSystemNode) o;
            return this.ordering_name.compareTo(other.ordering_name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.name);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof FileSystemNode)) {
                return false;
            }
            FileSystemNode other = (FileSystemNode) obj;
            return this.name.equals(other.name);
        }
    }

    private static String getFirstDirFromPath(String path) {
        if (path == null)
            return null;
        int separatorIdx = path.indexOf('/');
        if (separatorIdx == -1)
            return path;
        return path.substring(0, separatorIdx);
    }

    private static String removeFirstDirFromPath(String path) {
        if (path == null)
            return null;
        int separatorIdx = path.indexOf('/');
        if (separatorIdx == -1)
            return "";
        return path.substring(separatorIdx + 1);
    }
}
