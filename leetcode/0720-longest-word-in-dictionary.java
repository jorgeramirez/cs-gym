class Solution {

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }

        Set<String> wordsSet = new HashSet<>();

        for (String w : words) {
            wordsSet.add(w);
        }

        String answer = "";

        Arrays.sort(words, (w1, w2) -> -(w1.length() - w2.length()));

        for (String word : words) {
            boolean isPossible = true;

            for (int i = 1; i < word.length(); i++) {
                String preffix = word.substring(0, i);

                if (!wordsSet.contains(preffix)) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                if (answer.isEmpty()) {
                    answer = word;
                } else if (
                    answer.length() == word.length() &&
                    word.compareTo(answer) < 0
                ) {
                    answer = word;
                } else if (answer.length() < word.length()) {
                    answer = word;
                }
            }
        }

        return answer;
    }
}
