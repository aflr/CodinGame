import java.util.*;

class Solution {

    private static final List<String> ELEMS = Arrays.asList("H He Li Be B C N O F Ne Na Mg Al Si P S Cl Ar K Ca Sc Ti V Cr Mn Fe Co Ni Cu Zn Ga Ge As Se Br Kr Rb Sr Y Zr Nb Mo Tc Ru Rh Pd Ag Cd In Sn Sb Te I Xe Cs Ba La Ce Pr Nd Pm Sm Eu Gd Tb Dy Ho Er Tm Yb Lu Hf Ta W Re Os Ir Pt Au Hg Tl Pb Bi Po At Rn Fr Ra Ac Th Pa U Np Pu Am Cm Bk Cf Es Fm Md No Lr Rf Db Sg Bh Hs Mt Ds Rg Cn Nh Fl Mc Lv Ts Og".split(" "));
    private static List<String> spellings = new ArrayList<>();

    public static void main(String args[]) {
        search("", (new Scanner(System.in)).nextLine());
        if (spellings.isEmpty())
            System.out.println("none");
        else {
            spellings.sort(null);
            spellings.forEach(System.out::println);
        }
    }

    private static void search(String word, String remaining) {
        if (remaining.isEmpty())
            spellings.add(word);
        else if (remaining.length() >= 1) {
            String sub = remaining.substring(0, 1).toUpperCase();
            if (ELEMS.contains(sub))
                search(word + sub, remaining.substring(1));
            if (remaining.length() >= 2) {
                sub += remaining.charAt(1);
                if (ELEMS.contains(sub))
                    search(word + sub, remaining.substring(2));
            }
        }
    }
}
