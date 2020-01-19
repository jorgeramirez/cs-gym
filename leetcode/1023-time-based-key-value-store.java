import java.util.Collections;
import java.util.HashMap;

class TimeMap {
    HashMap<String, TimeMapEntry> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TimeMapEntry());
        }
        TimeMapEntry vCache = map.get(key);
        vCache.times.add(timestamp);
        vCache.values.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TimeMapEntry vCache = map.getOrDefault(key, null);
        if (vCache == null) {
            return "";
        }
        int n = vCache.times.size();
        int pos = Collections.binarySearch(vCache.times, timestamp);
        if (pos < 0) {
            pos = Math.abs(pos) - 1; // insertion point
        }
        String out = "";
        while (out.isEmpty() && pos >= 0) {
            if (pos == n || vCache.times.get(pos) > timestamp) {
                --pos;
                continue;
            }
            out = vCache.values.get(vCache.times.get(pos));
        }
        return out;
    }

    static class TimeMapEntry {
        List<Integer> times = new ArrayList<>();
        HashMap<Integer, String> values = new HashMap<>();
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
