package easy;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        int expectedOutput = 1994;
        assert expectedOutput == new RomanToInteger().wowThatsCrazy("MCMXCIV");
        assert expectedOutput == new RomanToInteger().hashMapSituaciya("MCMXCIV");
        assert expectedOutput == new RomanToInteger().howToDoBetterThanTHIS("MCMXCIV");
    }

    public int hashMapSituaciya(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i > -1; i--) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }

    public int howToDoBetterThanTHIS(String s) {
        int ans = 0;
        int num;
        for (int i = s.length() - 1; i > -1; i--) {
            switch (s.charAt(i)) {
                case 'I' -> num = 1;
                case 'V' -> num = 5;
                case 'X' -> num = 10;
                case 'L' -> num = 50;
                case 'C' -> num = 100;
                case 'D' -> num = 500;
                case 'M' -> num = 1000;
                default -> throw new IllegalArgumentException("WRONG");
            }
            ans = (4 * num < ans) ? ans - num : ans + num;
        }
        return ans;
    }

    public int wowThatsCrazy(String s) {
        int i = 0;
        int result = 0;
        while (i < s.length()) {
            switch (s.charAt(i)) {
                case 'I' -> {
                    if (i != s.length() - 1) {
                        if (s.charAt(i + 1) == 'V') {
                            result += 4;
                            i++;
                        } else if (s.charAt(i + 1) == 'X') {
                            result += 9;
                            i++;
                        } else {
                            result += 1;
                        }
                    } else {
                        result += 1;
                    }
                }
                case 'V' -> {
                    result += 5;
                }
                case 'X' -> {
                    if (i != s.length() - 1) {
                        if (s.charAt(i + 1) == 'L') {
                            result += 40;
                            i++;
                        } else if (s.charAt(i + 1) == 'C') {
                            result += 90;
                            i++;
                        } else {
                            result += 10;
                        }
                    } else {
                        result += 10;
                    }
                }
                case 'L' -> {
                    result += 50;
                }
                case 'C' -> {
                    if (i != s.length() - 1) {
                        if (s.charAt(i + 1) == 'D') {
                            result += 400;
                            i++;
                        } else if (s.charAt(i + 1) == 'M') {
                            result += 900;
                            i++;
                        } else {
                            result += 100;
                        }
                    } else {
                        result += 100;
                    }
                }
                case 'D' -> {
                    result += 500;
                }
                case 'M' -> {
                    result += 1000;
                }
                default -> {
                    throw new IllegalArgumentException("WRONG");
                }
            }
            i++;
        }
        return result;
    }
}
