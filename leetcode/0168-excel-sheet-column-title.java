class Solution {

    public String convertToTitle(int n) {
        if (n <= 26) {
            return Character.toString((char) ((n - 1) + 'A'));
        }
        char remainder = (char) (((n - 1) % 26) + 'A');
        return convertToTitle((n - 1) / 26) + Character.toString(remainder);
    }
}
