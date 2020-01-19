class Solution {

    public String[] expand(String S) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            List<String> bf = new ArrayList<>();
            if (ch == '{') {
                while (S.charAt(i) != '}') {
                    bf.add(Character.toString(S.charAt(++i)));
                    ++i; // skip ','
                }
            } else {
                bf.add(Character.toString(ch));
            }
            res = combine(res, bf);
        }
        Collections.sort(res);
        return res.toArray(new String[res.size()]);
    }

    List<String> combine(List<String> currentRes, List<String> buffer) {
        if (currentRes.isEmpty()) {
            return buffer;
        }
        List<String> newRes = new ArrayList<>();
        for (String c : currentRes) {
            for (String b : buffer) {
                newRes.add(c + b);
            }
        }
        return newRes;
    }
}
