class Solution {

    static String[] hangman = {
            "+--+\n|\n|\n|\\\n",
            "+--+\n|  o\n|\n|\\\n",
            "+--+\n|  o\n|  |\n|\\\n",
            "+--+\n|  o\n| /|\n|\\\n",
            "+--+\n|  o\n| /|\\\n|\\\n",
            "+--+\n|  o\n| /|\\\n|\\/\n",
            "+--+\n|  o\n| /|\\\n|\\/ \\\n"
    };

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        String word = in.nextLine();
        String unguessed = word.toLowerCase();
        char[] chars = in.nextLine().replaceAll(" ", "").toLowerCase().toCharArray();
        int mistakes = 0;
        for (int i = 0; i < chars.length && mistakes < 6; i++)
            if (!unguessed.contains(Character.toString(chars[i])))
                mistakes++;
            else
                unguessed = unguessed.replaceAll(Character.toString(chars[i]), "_");
        System.out.print(hangman[mistakes]);
        for (int i = 0; i < word.length(); i++)
            if (Character.isWhitespace(word.charAt(i)))
                System.out.print(word.charAt(i));
            else if (unguessed.charAt(i) == '_')
                System.out.print(word.charAt(i));
            else
                System.out.print('_');
        System.out.println();
    }
}
