class Solution {

    public int expressiveWords(String S, String[] words) {
        List<String> groups = buildGroup(S);
        int ans = 0;
        for (String query : words) {
            List<String> qGroups = buildGroup(query);
            if (groups.size() != qGroups.size()) {
                continue;
            }
            boolean good = true;
            for (int i = 0; i < groups.size(); i++) {
                String sG = groups.get(i);
                String qG = qGroups.get(i);
                if (sG.equals(qG)) {
                    continue;
                }

                if (
                    sG.charAt(0) != qG.charAt(0) ||
                    sG.length() < qG.length() ||
                    sG.length() < 3
                ) {
                    good = false;
                    break;
                }
            }
            if (good) {
                ++ans;
            }
        }
        return ans;
    }

    List<String> buildGroup(String word) {
        List<String> groups = new ArrayList<>();
        StringBuilder g = new StringBuilder();
        g.append(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == g.charAt(0)) {
                g.append(word.charAt(i));
            } else {
                groups.add(g.toString());
                g = new StringBuilder();
                g.append(word.charAt(i));
            }
        }
        if (g.length() > 0) {
            groups.add(g.toString());
        }
        return groups;
    }
}
