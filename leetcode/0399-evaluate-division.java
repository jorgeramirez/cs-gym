class Solution {

    public double[] calcEquation(
        List<List<String>> equations,
        double[] values,
        List<List<String>> queries
    ) {
        HashMap<String, Double> valuesMap = new HashMap<>();
        HashMap<String, List<String>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            double val = values[i];

            String u = eq.get(0);
            String v = eq.get(1);
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
            valuesMap.put(u + v, val);
            valuesMap.put(v + u, 1.0 / val);
        }
        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            results[i] = bfs(graph, valuesMap, query);
        }
        return results;
    }

    double bfs(
        HashMap<String, List<String>> graph,
        HashMap<String, Double> valuesMap,
        List<String> query
    ) {
        Set<String> keys = graph.keySet();
        String source = query.get(0);
        String target = query.get(1);

        if (source.equals(target) && keys.contains(source)) {
            return 1.0;
        }

        if (!keys.contains(source) || !keys.contains(target)) {
            return -1.0;
        }

        Set<String> seen = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(source, 1.0));

        while (!q.isEmpty()) {
            int len = q.size();
            while (len-- > 0) {
                Node node = q.poll();
                String u = node.key;
                if (u.equals(target)) {
                    return node.val;
                }
                if (seen.contains(u)) {
                    continue;
                }
                seen.add(u);

                for (String v : graph.get(node.key)) {
                    if (seen.contains(v)) {
                        continue;
                    }
                    double edgeVal = valuesMap.get(u + v);
                    q.add(new Node(v, edgeVal * node.val));
                }
            }
        }
        return -1.0;
    }

    class Node {
        String key;
        double val;

        Node(String k, double v) {
            key = k;
            val = v;
        }
    }
}
