import java.util.*;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[!?',;.]", " ");
        String words[] = paragraph.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll(" ", "");
        }

        // we could build a hashset here to make the check O(1)
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));

        HashMap<String, Integer> freq = new HashMap<>();
        int max = 0;
        String maxWord = null;

        for (int i = 0; i < words.length; i++) {
            if (!bannedWords.contains(words[i]) && !words[i].equals("")) {
                freq.put(words[i], freq.getOrDefault(words[i], 0) + 1);
                if (freq.get(words[i]) > max) {
                    max = freq.get(words[i]);
                    maxWord = words[i];
                }
            }
        }
        return maxWord;
    }
}
