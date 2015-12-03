package arraysAndStrings;

/**
 * Created by szelenin on 12/4/2015.
 */
public class Task1 {
    public static boolean allUnique(String text) {
        CharBits bits = new CharBits();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (bits.set(c)) {
                return false;
            }
        }
        return true;
    }

    public static class CharBits {
        private byte[] bits = new byte[8192];

        public boolean set(char c) {
            int byteNo = c / 8;
            int bitNo = c % 8;
            boolean isSet = (bits[byteNo] & (0x80 >> bitNo)) > 0;
            bits[byteNo] |= 0x80 >> bitNo;
            return isSet;
        }
    }
}

