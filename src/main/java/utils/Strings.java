package utils;

public class Strings {
    private boolean found = false;
    private int pos = -1;

    public int bf(String tag, String pth) {
        int tagL = tag.length();
        int pthL = pth.length();
        char[] tagArray = tag.toCharArray();
        char[] pthArray = pth.toCharArray();
        if (tag.length() < pth.length()) {
            return -1;
        }
        for (int i = 0; i < tagL - pthL + 1; i++) {
            found = true;
            for (int j = 0; j < pthL; j++) {
                if (tagArray[i + j] != pthArray[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}
