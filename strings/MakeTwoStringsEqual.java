package strings;
import java.util.*;

public class MakeTwoStringsEqual {
    static final Set<Character> atcoderSet = new HashSet<>(
        Arrays.asList('a', 't', 'c', 'o', 'd', 'e', 'r'));

    public static String canWin(String s, String t) {
        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();

        for (char ch : s.toCharArray()) {
            countS.put(ch, countS.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            countT.put(ch, countT.getOrDefault(ch, 0) + 1);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (c == '@') continue;

            int sCount = countS.getOrDefault(c, 0);
            int tCount = countT.getOrDefault(c, 0);

            if (sCount == tCount) continue;

            if (atcoderSet.contains(c)) {
                int diff = Math.abs(sCount - tCount);
                if (sCount > tCount) {
                    int tAt = countT.getOrDefault('@', 0);
                    if (tAt < diff) return "No";
                    countT.put('@', tAt - diff);
                } else {
                    int sAt = countS.getOrDefault('@', 0);
                    if (sAt < diff) return "No";
                    countS.put('@', sAt - diff);
                }
            } else {
                return "No";
            }
        }

        return "Yes";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(canWin(s, t));
    }
}

//need to replace characters @ with a,t,c,o,d,e,r and check if we can make them equal two strings.
