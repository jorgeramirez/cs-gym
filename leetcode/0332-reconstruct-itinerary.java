class Solution {
    HashMap<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> itinerary = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!map.containsKey(from)) {
                map.put(from, new PriorityQueue<>());
            }
            map.get(from).add(to);
        }
        dfs("JFK");
        return itinerary;
    }

    void dfs(String from) {
        PriorityQueue<String> q = map.get(from);
        while (q != null && !q.isEmpty()) {
            dfs(q.poll());
        }
        itinerary.add(0, from);
    }
}
