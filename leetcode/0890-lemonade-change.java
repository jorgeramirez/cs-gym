class Solution {

    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[] { 0, 0 }; // 5s and 10s

        for (int i = 0; i < bills.length; i++) {
            int b = bills[i];
            if (b == 5) {
                ++change[0];
            } else if (b == 10) {
                if (change[0] == 0) {
                    return false;
                }
                ++change[1];
                --change[0];
            } else { // 20s
                if (change[1] >= 1 && change[0] >= 1) { // 1 $10 1 $5
                    --change[0];
                    --change[1];
                } else if (change[0] >= 3) { // 3 $5
                    change[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
