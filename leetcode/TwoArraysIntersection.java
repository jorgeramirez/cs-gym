import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TwoArraysIntersection {

    public int[] intersect(int[] nums1, int[] nums2) {
        // 1) setup a hashtable using the smallest array. The keys of this hashtable are the
        //    elements in the array and the values are simply a count of the elements.
        // 2) iterate the elements on the largest array and check whether they exists in the hashtable
        //    if an element exists, add it to the intersect and decrement the counter
        // 3) return intersect
        // Time: O(n)
        // Space: O(n)
        int[] largest;
        int[] smallest;
        if(nums1.length > nums2.length) {
            largest = nums1;
            smallest = nums2;
        }else {
            smallest = nums1;
            largest = nums2;
        }
        List<Integer> intersect = new ArrayList<>();
        HashMap<Integer, Integer> counts = new HashMap<>();

        for(int i = 0; i < smallest.length; i++) {
            if(counts.containsKey(smallest[i])) {
                counts.put(smallest[i], counts.get(smallest[i]) + 1);
            }else{
                counts.put(smallest[i], 1);
            }
        }

        for(int i = 0; i < largest.length; i++) {
            if(counts.containsKey(largest[i]) && counts.get(largest[i]) > 0) {
                intersect.add(largest[i]);
                counts.put(largest[i], counts.get(largest[i]) - 1);
            }
        }
        return intersect.stream().mapToInt(i -> i).toArray();
    }
}
