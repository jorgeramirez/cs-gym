class Solution {

    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        Set<String> deadSet = new HashSet<>();
        for (String d : deadends) {
            deadSet.add(d);
        }
        q.add("0000");
        seen.add("0000");
        int depth = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            while (len-- > 0) {
                String node = q.poll();
                if (node.equals(target)) {
                    return depth;
                }

                if (deadSet.contains(node)) {
                    continue;
                }

                for (String nei : getNeighbors(node)) {
                    if (!seen.contains(nei) && !deadSet.contains(nei)) {
                        q.add(nei);
                        seen.add(nei);
                    }
                }
            }
            ++depth;
        }
        return -1;
    }

    int[] dirs = { -1, 1 };

    List<String> getNeighbors(String node) {
        List<String> neis = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int d : dirs) {
                Integer newDigit = ((node.charAt(i) - '0') + d + 10) % 10;
                String newNei =
                    node.substring(0, i) +
                    newDigit.toString() +
                    node.substring(i + 1);
                neis.add(newNei);
            }
        }
        return neis;
    }
}
