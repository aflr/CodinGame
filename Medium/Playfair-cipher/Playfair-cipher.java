class Solution {

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        char[][] keyTable = new char[5][];
        for (int i = 0; i < 5; i++)
            keyTable[i] = in.nextLine().replaceAll(" ", "").toCharArray();
        String action = in.nextLine();
        int N = in.nextInt(); in.nextLine();
        String[] messages = new String[N];
        for (int i = 0; i < N; i++)
            messages[i] = in.nextLine();
        for (int i = 0; i < N; i++) {
            String str = messages[i].toUpperCase().chars()
                    .filter(c -> posInKeyTable((char) c, keyTable) != null)
                    .mapToObj(Character::toString).reduce(String::concat).get();
            if (str.length() % 2 != 0) {
                System.out.println("DUD"); continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j += 2) {
                int[] pos1 = posInKeyTable(str.charAt(j), keyTable);
                int[] pos2 = posInKeyTable(str.charAt(j + 1), keyTable);
                int inc = action.equals("ENCRYPT") ? 1 : 4;
                if (pos1[0] == pos2[0]) // Same row
                    sb.append(keyTable[pos1[0]][(pos1[1] + inc) % 5])
                            .append(keyTable[pos2[0]][(pos2[1] + inc) % 5]);
                else if (pos1[1] == pos2[1]) // Same col
                    sb.append(keyTable[(pos1[0] + inc) % 5][pos1[1]])
                            .append(keyTable[(pos2[0] + inc) % 5][pos2[1]]);
                else
                    sb.append(keyTable[pos1[0]][pos2[1]])
                            .append(keyTable[pos2[0]][pos1[1]]);
            }
            System.out.println(sb.toString());
        }
    }

    private static int[] posInKeyTable(char c, char[][] keyTable) {
        for (int i = 0; i < keyTable.length; i++)
            for (int j = 0; j < keyTable[i].length; j++)
                if (keyTable[i][j] == c)
                    return new int[] { i, j };
        return null;
    }
}
