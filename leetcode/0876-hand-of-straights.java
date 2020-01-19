class Solution {

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }

        // ordered map
        TreeMap<Integer, Integer> counts = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            counts.put(hand[i], counts.getOrDefault(hand[i], 0) + 1);
        }
        while (counts.size() > 0) {
            int lowest = counts.firstKey();
            for (int card = lowest; card < lowest + W; card++) {
                if (!counts.containsKey(card)) {
                    return false;
                }
                int curCount = counts.get(card);
                if (curCount == 1) {
                    counts.remove(card);
                } else {
                    counts.put(card, curCount - 1);
                }
            }
        }
        return true;
    }
}
