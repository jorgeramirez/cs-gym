class Solution {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;

        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                ++i;
                ++j;
            } else {
                ++j;
            }
        }
        return i == name.length();
    }
}
