import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

class Solution {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList();
        }
        StringBuilder sb = new StringBuilder(digits);
        String reversed = sb.reverse().toString();
        Map<Character, String[]> nMap = new Hashtable<>();
        nMap.put('2', "a b c".split(" "));
        nMap.put('3', "d e f".split(" "));
        nMap.put('4', "g h i".split(" "));
        nMap.put('5', "j k l".split(" "));
        nMap.put('6', "m n o".split(" "));
        nMap.put('7', "p q r s".split(" "));
        nMap.put('8', "t u v".split(" "));
        nMap.put('9', "w x y z".split(" "));
        List<String> cmb = new ArrayList<>();
        cmb.addAll(Arrays.asList(nMap.get(reversed.charAt(0))));

        for (int l = 1; l < reversed.length(); l++) { // n
            String[] letters = nMap.get(reversed.charAt(l));
            List<String> cmbTmp = new ArrayList<>();

            for (int i = 0; i < letters.length; i++) { //4
                for (int j = 0; j < cmb.size(); j++) { //
                    cmbTmp.add(letters[i] + cmb.get(j));
                }
            }
            cmb = cmbTmp;
        }
        return cmb;
    }
}
