import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 1) we create a function getGroupId (it sorts a string and replaces whitespaces)
        // 2) we create a hash map <String, List<String>>. key=group id, value the members of the group
        // 3) we iterate over the input list to build the hashmap
        // 4) we return the values of the hashmap
        // Time: O(n log n) because we sort
        // Space: O(n)
        Hashtable<String, List<String>> groups = new Hashtable<>();

        for (String str : strs) {
            String id = getGroupId(str);

            if (!groups.containsKey(id)) {
                groups.put(id, new ArrayList<>());
            }
            groups.get(id).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        groups.values().forEach(g -> result.add(g));
        return result;
    }

    public String getGroupId(String member) {
        member = member.replaceAll("\\s", "");
        char[] memberChars = member.toCharArray();
        Arrays.sort(memberChars);
        return new String(memberChars);
    }
}
