class Solution {

    public String nextClosestTime(String time) {
        List<String> options = getCombinations(time);
        Collections.sort(options);
        int pos = Collections.binarySearch(options, time);
        if (pos == options.size() - 1) {
            return options.get(0);
        }
        return options.get(pos + 1);
    }

    List<String> getCombinations(String time) {
        List<String> options = new ArrayList<>();
        char[] chars = time.toCharArray();

        Set<Integer> dSet = new HashSet<>();
        dSet.add(chars[0] - '0');
        dSet.add(chars[1] - '0');
        dSet.add(chars[3] - '0');
        dSet.add(chars[4] - '0');
        Integer[] digits = dSet.toArray(new Integer[dSet.size()]);
        int n = digits.length;

        for (int i = 0; i < n; i++) {
            Integer d1 = digits[i];

            if (d1 > 2) {
                continue;
            }

            for (int j = 0; j < n; j++) {
                Integer d2 = digits[j];

                if (d1 == 2 && d2 > 3) {
                    continue;
                }

                for (int k = 0; k < n; k++) {
                    Integer d3 = digits[k];

                    if (d3 > 5) {
                        continue;
                    }

                    for (int l = 0; l < n; l++) {
                        Integer d4 = digits[l];

                        String t =
                            d1.toString() +
                            d2.toString() +
                            ":" +
                            d3.toString() +
                            d4.toString();
                        options.add(t);
                    }
                }
            }
        }

        return options;
    }
}
