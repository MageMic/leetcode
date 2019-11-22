package string;

public class ReplaceSpace {
    public String replaceSpace(String iniString, int length) {
        // write code here
        int spaceCount = 0;
        char[] charArray = iniString.toCharArray();
        for (int i = 0; i < length; i++) {
            if (charArray[i] == ' ') {
                spaceCount++;
            }
        }
        char[] newStr = new char[length + spaceCount * 2];
        int newIndex = newStr.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (charArray[i] != ' ') {
                newStr[newIndex--] = charArray[i];
            } else {
                newStr[newIndex--] = '0';
                newStr[newIndex--] = '2';
                newStr[newIndex--] = '%';
            }
        }
        return String.valueOf(newStr);
    }
}
