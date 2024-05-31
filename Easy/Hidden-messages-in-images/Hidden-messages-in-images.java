class Solution {

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int w = in.nextInt(), h = in.nextInt();
        var bytes = new java.util.ArrayList<String>();
        for (int i = 0; i < w * h >> 3; i++)
            bytes.add("");
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                bytes.set(i * w + j >> 3, bytes.get(i * w + j >> 3)
                        .concat(Integer.toString(in.nextInt() & 1)));
        System.out.println(bytes.stream()
                .mapToInt(s -> Integer.parseInt(s, 2))
                .mapToObj(n -> Character.toString(n))
                .reduce(String::concat).orElse(""));
    }
}
