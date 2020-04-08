package string;

/**
 * @Author: zjumic
 * @Date: created at 13:41 2020/3/6
 */
public class PatternMatch {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        if ((patternIndex + 1 < patternIndex) && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && str[strIndex] == pattern[patternIndex]) ||
                    (strIndex != str.length && pattern[patternIndex] == '.')) {
                return matchCore(str, strIndex + 1, pattern, patternIndex) ||
                        matchCore(str, strIndex + 1, pattern, patternIndex + 2) ||
                        matchCore(str, strIndex, pattern, patternIndex + 2);
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        if ((strIndex != str.length && str[strIndex] == pattern[patternIndex]) || (strIndex != str.length && pattern[patternIndex] == '.')) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        PatternMatch patternMatch = new PatternMatch();

        System.out.println(patternMatch.matchCore("aaa".toCharArray(), 0, "a1a".toCharArray(), 0));
    }
}
