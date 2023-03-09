package easy;

import java.util.Arrays;
import java.util.HashMap;

public class IsomorphicStrings {

    public static void main(String[] args) {
        boolean output = new IsomorphicStrings().isIsomorphic1("paper", "title");
        boolean output1 = new IsomorphicStrings().isIsomorphic2("paper", "title");
        assert output && output1;
    }

    public boolean isIsomorphic1(String s, String t) {
        return transformString(s).equals(transformString(t));
    }

    private String transformString(String s) {
        var indexMapping = new HashMap<Character, Integer>();
        var builder = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);

            indexMapping.putIfAbsent(c1, i);
            builder.append(indexMapping.get(c1));
            builder.append(" ");
        }
        return builder.toString();
    }

    public boolean isIsomorphic2(String s, String t) {

        var mappingDictStoT = new int[256];
        Arrays.fill(mappingDictStoT, -1);

        var mappingDictTtoS = new int[256];
        Arrays.fill(mappingDictTtoS, -1);

        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
                mappingDictStoT[c1] = c2;
                mappingDictTtoS[c2] = c1;
            } else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
                return false;
            }
        }
        return true;
    }
}
