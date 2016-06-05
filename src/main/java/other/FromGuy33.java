package other;

/**
 * Created by Sergii_Zelenin on 6/5/2016.
 * https://www.youtube.com/watch?v=POhZrKbJ7y0
 * Reverse words in a phrase without additional memory
 */
public class FromGuy33 {

    public static String reverseWords(String sentence) {
        char[] chars = sentence.toCharArray();
        //Hello world
        //wHello orld
        //woHello rld ...
        //world Hello

        //Hi I'm here
        //hHi I'm ere...
        //hereHi I'm
        // need to know how many words in the sentcence. Need to swap total words - 1 times;
        int totalWords = wordsCount(chars);
        int processed = 0;
        int lastInsertedEnd = 0;
        while (processed < totalWords) {
            int lastWordBegin = findLastWordBegin(chars); //without space
            // move last word to the position after last word was inserted
            for (int i = lastWordBegin; i < chars.length; i++) {
                char wordChar = chars[i];
                shift(lastInsertedEnd, i, chars);
                chars[lastInsertedEnd] = wordChar;
                lastInsertedEnd++;
            }
            //space handling
            if (chars[chars.length - 1] == ' ') {
                shift(lastInsertedEnd, chars.length - 1, chars);
                chars[lastInsertedEnd] = ' ';
                lastInsertedEnd++;
            }
            processed++;
        }
        return new String(chars);
    }

    //assumption: only one space between words
    private static int wordsCount(char[] chars) {
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                result ++;
            }
        }
        return result;
    }

    private static int findLastWordBegin(char[] chars) {
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                return i + 1;
            }
        }
        return 0;
    }

    private static void shift(int from, int to, char[] chars) {
        //shift all chars starting from last inserted word to the right
        // from lastInsertedEnd till i
        char prev = chars[from];
        for (int j = from + 1; j <= to; j++) {
            char tmp = chars[j];
            chars[j] = prev;
            prev = tmp;
        }
    }
}
