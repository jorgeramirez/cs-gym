import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

// https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/778/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        return groupAnagramsV2(strs);
    }



    public List<List<String>> groupAnagramsV1(String[] strs) {
        // Options #1: iterate over all pairs of words and build the result list
        // define isAnagram(word1, word2) that returns true if word2 is anagram of word1
        // Time: O(n^3)
        // Space: O(n)
        // this solution gets TLE on leetcode.
        // 1) initialize the List<List<String>>
        // 2) build a hashmap that will store whether a word is an anagram
        // 3) add strs[0] to the first List of the results and start the double for loop for the second element
        List<List<String>> groups = new ArrayList<>();
        List<String> currentGroup = new ArrayList<>();
        Hashtable<String, Boolean> anagrams = new Hashtable<>();
        anagrams.put(strs[0], false);

        for (int i = 0; i < strs.length; i++) {

            if (anagrams.get(strs[i])) {
                continue;
            } else {
                currentGroup = new ArrayList<>();
                currentGroup.add(strs[i]);
            }

            for (int j = i + 1; j < strs.length; j++) {

                if (isAnagram(strs[i], strs[j])) {
                    currentGroup.add(strs[j]);
                    anagrams.put(strs[j], true);
                } else if (!anagrams.containsKey(strs[j])) {
                    anagrams.put(strs[j], false);
                }
            }
            groups.add(currentGroup);
        }
        return groups;
    }

    // just a quick, hacky and not-so-efficient implementation of isAnagram
    public Boolean isAnagram(String subject, String word) {
        subject = subject.replaceAll("\\s", "");
        word = word.replaceAll("\\s", "");

        if (subject.length() != word.length()) {
            return false;
        }
        char[] subjectChars = subject.toCharArray();
        char[] wordChars = word.toCharArray();
        Arrays.sort(subjectChars);
        Arrays.sort(wordChars);
        subject = new String(subjectChars);
        word = new String(wordChars);
        return subject.equals(word);
    }


    public List<List<String>> groupAnagramsV2(String[] strs) {
        // 1) we create a function getGroupId (it sorts a string and replaces whitespaces)
        // 2) we create a hash map <String, List<String>>. key=group id, value the members of the group
        // 3) we iterate over the input list to build the hashmap
        // 4) we return the values of the hashmap
        // Time: O(N log N) because we sort
        // Space: O(N)
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


    public static void printGroups(List<List<String>> groups) {
        System.out.println("groups: " + groups.size());

        for (List<String> group : groups) {
            for (String w : group) {
                System.out.print(w + ",");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        GroupAnagrams s = new GroupAnagrams();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        printGroups(s.groupAnagrams(strs));
    }
}
