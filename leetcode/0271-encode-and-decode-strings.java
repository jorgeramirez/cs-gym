public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        List<String> escapedStrs = new ArrayList<>();
        for (String s : strs) {
            escapedStrs.add(escape(s));
        }
        String encodedStr = "";
        for (String esc : escapedStrs) {
            encodedStr += esc + ",";
        }
        return encodedStr; // trailing , at the end
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decodedStrs = new ArrayList<>();
        if (s.length() == 0) {
            return decodedStrs;
        }
        int i = 0;
        int n = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i < n) { // we ignore the trailing ,
            char ch = s.charAt(i);
            if (ch == ',') {
                decodedStrs.add(sb.toString());
                sb = new StringBuilder();
            } else if (ch == '/' && (i + 1) < n) {
                char next = s.charAt(i + 1);
                if (next == ',' || next == '/') {
                    sb.append(next);
                    ++i;
                } else {
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
            ++i;
        }
        decodedStrs.add(sb.toString());
        return decodedStrs;
    }

    // ,\ are escaped using \ before it.
    private String escape(String raw) {
        return raw.replaceAll("/", "//").replaceAll(",", "/,");
    }
}
