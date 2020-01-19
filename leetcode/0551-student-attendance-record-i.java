class Solution {

    public boolean checkRecord(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                ++count;
            }
        }
        if (count >= 2) {
            return false;
        }
        int pos = s.indexOf("LLL");
        if (pos != -1) {
            return false;
        }
        return true;
    }
}
