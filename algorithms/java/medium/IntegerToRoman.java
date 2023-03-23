package medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("SpellCheckingInspection")
public class IntegerToRoman {
    public static void main(String[] args) {
        String expectedOutput = "MCMXCIV";
        assert expectedOutput.equals(new IntegerToRoman().intToRoman(1994));
    }

    public String intToRoman(int num) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        for (Map.Entry<String, Integer> val : map.entrySet()) {
            while (num - map.get(val.getKey()) >= 0) {
                sb.append(val.getKey());
                num = num - map.get(val.getKey());
            }
        }
        return sb.toString();
    }
}
