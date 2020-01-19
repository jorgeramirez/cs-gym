class SnapshotArray {
    HashMap<Integer, Integer> map;
    HashMap<Integer, HashMap<Integer, Integer>> snaps;
    int snapsCount;
    int len;

    public SnapshotArray(int length) {
        map = new HashMap<>();
        snaps = new HashMap<>();
        len = length;
    }

    public void set(int index, int val) {
        map.put(index, val);
    }

    public int snap() {
        ++snapsCount;
        int id = snapsCount - 1;
        snaps.put(id, createSnapshot());
        return id;
    }

    public int get(int index, int snap_id) {
        return snaps.get(snap_id).getOrDefault(index, 0);
    }

    private HashMap<Integer, Integer> createSnapshot() {
        HashMap<Integer, Integer> snapshot = new HashMap<>();
        for (int key : map.keySet()) {
            snapshot.put(key, map.get(key));
        }
        return snapshot;
    }
}
/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
