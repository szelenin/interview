package fbcodelab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sergii_Zelenin on 12/31/2016.
 * https://codelab.interviewbit.com/problems/prefix/
 */
public class Prefix {
    private class Vertex {
        public int count = 0;
        public Map<Character, Vertex> next = new HashMap<>();
    }

    public ArrayList<String> prefix(List<String> a) {
        Vertex root = new Vertex();
        //build prefix trie
        for (String word: a){
            Vertex current = root;
            for (int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                Vertex nextLevel = current.next.get(c);
                if (nextLevel == null){
                    nextLevel = new Vertex();
                }
                nextLevel.count++;
                current.next.put(c, nextLevel);
                current = nextLevel;
            }
        }

        ArrayList<String> result = new ArrayList<>();
        for (String word: a){
            String prefix = "";
            Vertex current = root;
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                prefix+=c;
                Vertex next = current.next.get(c);
                if (next.count <=1 && next.next.size()<=1) {
                    break;
                }
                current = next;
            }
            result.add(prefix);
        }
        return result;
    }
}

