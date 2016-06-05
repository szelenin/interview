package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergii_Zelenin on 5/26/2016.
 */
public class FromAmazonInterview {

    static void printSentences(String input) {
        if (isAllWords(input)){
            System.out.println(input);
        }
        List<String> allCases = createList(input);
        System.out.println("allCases = " + allCases);
        for (String sentence : allCases){
            if (isAllWords(sentence)){
                System.out.println(sentence);
            }
        }
    }

    static List<String> createList(String input){
        List<String> result = new ArrayList<>();
        if (input.length() == 1){
            result.add(input);
            return result;
        }

        for (int i = 1; i < input.length(); i++){
            String first  = input.substring(0, i);
            String second = input.substring(i, input.length());
            result.add(first + " " + second);

            //s ome
            //first + all for second
            List<String> allForSecond = createList(second); //ome: o me; o m e; o me;

            for (String words : allForSecond){
                result.add(first + " " + words);
            }
/*
            //all for first + second
            List<String> allForFirst = createList(first); //
            for (String words : allForFirst){
                result.add(words + " " + second);
            }
*/
        }
        return result;
    }

    static boolean isAllWords(String input){
        String words[] = input.split(" ");
        for (int i = 0; i<words.length;i++) {
            if (!Dict.isWord(words[i])){
                return false;
            }
        }
        return true;
    }

    private static class Dict {
        private static List<String> words = Arrays.asList("this", "is", "awesome", "awe", "some", "so", "me");
        public static boolean isWord(String word) {
            return words.contains(word);
        }
    }
}
