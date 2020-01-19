class Solution {

    public boolean areSentencesSimilarTwo(
        String[] words1,
        String[] words2,
        List<List<String>> pairs
    ) {
        if (words1 == null && words2 == null) {
            return true;
        }
        if (words1 == null || words2 == null) {
            return false;
        }
        if (words1.length != words2.length) {
            return false;
        }

        HashMap<String, List<String>> graph = new HashMap<>();

        for (List<String> edge : pairs) {
            String u = edge.get(0);
            String v = edge.get(1);
            graph.computeIfAbsent(
                u,
                k -> graph.put(u, new ArrayList<String>())
            );
            graph.computeIfAbsent(
                v,
                k -> graph.put(v, new ArrayList<String>())
            );
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        HashMap<String, Integer> colors = getColorOfWords(graph);

        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i];
            String w2 = words2[i];

            if (w1.equals(w2)) {
                continue;
            }
            if (
                !colors.containsKey(w1) ||
                !colors.containsKey(w2) ||
                colors.get(w1) != colors.get(w2)
            ) {
                return false;
            }
        }
        return true;
    }

    HashMap<String, Integer> getColorOfWords(
        HashMap<String, List<String>> graph
    ) {
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> seen = new HashSet<>();
        int currentColor = 0;

        for (String node : graph.keySet()) {
            if (seen.contains(node)) {
                continue;
            }
            Queue<String> q = new LinkedList<>();
            q.add(node);

            while (!q.isEmpty()) {
                int len = q.size();
                while (len-- > 0) {
                    String current = q.poll();

                    if (seen.contains(current)) {
                        continue;
                    }
                    seen.add(current);
                    map.put(current, currentColor);

                    for (String nei : graph.get(current)) {
                        if (seen.contains(nei)) {
                            continue;
                        }
                        q.add(nei);
                    }
                }
            }
            ++currentColor;
        }
        return map;
    }
}
