import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String[] words = in.nextLine().split(" ");
        // Find out which alphabet we are using
        List<Integer> cands = new ArrayList<>(){{addAll(List.of(0, 1, 2, 3));}};
        for (int i = 0; cands.size() > 1 && i < words.length; i++)
            for (var it = cands.iterator(); it.hasNext();)
                if (!abc[it.next()][words[i].codePointAt(0) - 'A'].equals(words[i]))
                    it.remove();
        // Print words from next alphabet
        for (int i = 0; i < words.length; i++)
            System.out.print(abc[(cands.get(0) + 1) % abc.length][words[i].codePointAt(0) - 'A']
                    + (i == words.length - 1 ? "" : " "));
    }

    private static final String[][] abc = {
            { "Authority", "Bills", "Capture", "Destroy", "Englishmen", "Fractious", "Galloping", "High", "Invariably",
                    "Juggling", "Knights", "Loose", "Managing", "Never", "Owners", "Play", "Queen", "Remarks",
                    "Support", "The", "Unless", "Vindictive", "When", "Xpeditiously", "Your", "Zigzag" },
            { "Apples", "Butter", "Charlie", "Duff", "Edward", "Freddy", "George", "Harry", "Ink", "Johnnie", "King",
                    "London", "Monkey", "Nuts", "Orange", "Pudding", "Queenie", "Robert", "Sugar", "Tommy", "Uncle",
                    "Vinegar", "Willie", "Xerxes", "Yellow", "Zebra" },
            { "Amsterdam", "Baltimore", "Casablanca", "Denmark", "Edison", "Florida", "Gallipoli", "Havana", "Italia",
                    "Jerusalem", "Kilogramme", "Liverpool", "Madagascar", "New-York", "Oslo", "Paris", "Quebec", "Roma",
                    "Santiago", "Tripoli", "Uppsala", "Valencia", "Washington", "Xanthippe", "Yokohama", "Zurich" },
            { "Alfa", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliett", "Kilo",
                    "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform",
                    "Victor", "Whiskey", "X-ray", "Yankee", "Zulu" }
    };
}
