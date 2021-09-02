package leetcode.google;

import java.util.*;


//https://leetcode.com/problems/brace-expansion-ii/
//BraceExpression, failed : input: "{a,b}{c,{d,e}}", expected ["ac","ad","ae","bc","bd","be"]
class Grammar {
    public List<String> braceExpansionII(String expression) {
        //if letter - add it to current word
        //if ,
        //    - add current word to set
        //    - add all possible expressions starting from , to the set
        //if {
        //   - combine current word with all possible expressions starting from { to the set

        //function: all possible expressions starting from idx
        // - stop at }
        Set<String> uniqueExpressions = allPossibleExpressions(0, expression);
        ArrayList<String> result = new ArrayList<>();
        result.addAll(uniqueExpressions);
        Collections.sort(result);
        return result;
    }

    private Set<String> allPossibleExpressions(int idx, String expression) {
        if (idx >= expression.length()) {
            return new HashSet<>();
        }
        Set<String> result = new HashSet<>();
        String word = "";

        while (idx < expression.length() && isAlphabetic(expression.charAt(idx))) {
            word = word + expression.charAt(idx);
            idx++;
        }
        if (idx >= expression.length() || expression.charAt(idx) == '}') {
            result.add(word);
            return result;
        }

        if (expression.charAt(idx) == ',') {
            result.add(word);
            result.addAll(allPossibleExpressions(idx + 1, expression));
        }
        if (expression.charAt(idx) == '{') {
            Set<String> allSubExpressions = allPossibleExpressions(idx + 1, expression);
            for (String s : allSubExpressions) {
                result.add(word + s);
            }
        }
        return result;
    }

    private boolean isAlphabetic(char c) {
        return c >= 'a' && c <= 'z';
    }
}