import java.util.HashMap;

class Solution {

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);

            if (!sMap.containsKey(sch)) {
                sMap.put(sch, tch);
            }

            if (!tMap.containsKey(tch)) {
                tMap.put(tch, sch);
            }

            // s -> t check
            if (sMap.get(sch) != tch) {
                return false;
            }

            // t -> s check
            if (tMap.get(tch) != sch) {
                return false;
            }
        }
        return true;
    }
}
