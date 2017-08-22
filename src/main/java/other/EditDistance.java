package other;

import java.util.Stack;

/**
 * Created by Sergii_Zelenin on 8/22/2017.
 */
public class EditDistance {
    public static int distance(String a, String b) {
        return calculateDistanceArray(a, b)[a.length()][b.length()];
    }

    public static String[] backtracking(String a, String b) {
        int[][] d = calculateDistanceArray(a, b);
        Stack<Character> aStack = new Stack<>();
        Stack<Character> bStack = new Stack<>();
        backtrack(a, b, d, a.length(), b.length(), aStack, bStack);
        return new String[]{toString(aStack), toString(bStack)};
    }

    private static String toString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private static void backtrack(String a, String b, int[][] d, int i, int j, Stack<Character> aStack, Stack<Character> bStack) {
        if (i == 0 && j == 0) {
            return;
        }
        int current = d[i][j];
        //if was insertion backtrack(..,i, j-1)
        if (j > 0 && d[i][j - 1] < current) {
            aStack.push('-');
            bStack.push(b.charAt(j - 1));
            backtrack(a, b, d, i, j - 1, aStack, bStack);
        } else if (i > 0 && d[i - 1][j] < current) {//if deletion backtrack(..,i - 1, j,...)
            aStack.push(a.charAt(i - 1));
            bStack.push('-');
            backtrack(a, b, d, i - 1, j, aStack, bStack);
        } else if (i > 0 && j > 0) {
            aStack.push(a.charAt(i - 1));
            bStack.push(b.charAt(j - 1));
            backtrack(a, b, d, i - 1, j - 1, aStack, bStack);
        }
        //if match/mismatch backtrack (..,i-1,j-1,..)

    }

    private static int[][] calculateDistanceArray(String a, String b) {
        //a[1..n], b[1...m]
        //d(i,j) - min distance of a(1..i) and b(1..j)
        //d(i,j) = min(insertion score,deletion score, match score, mismatch score)
        // insertion score = d(i, j - 1) + 1
        // deletion score = d(i - 1, j) + 1
        // match score = d(i - 1, j - 1) - if a(i) == b(j)
        // mismatch score = d(i - 1, j - 1) + 1 - if a(i) <> b(j)
        int[][] d = new int[a.length() + 1][b.length() + 1];

        //insertion scores for a[1..n] and empty string
        for (int i = 0; i <= a.length(); i++) {
            d[i][0] = i;
        }
        //deletion scores for empty string and b[1..m]
        for (int j = 0; j <= b.length(); j++) {
            d[0][j] = j;
        }
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                int insertionScore = d[i][j - 1] + 1;
                int deletionScore = d[i - 1][j] + 1;
                int matchScore = d[i - 1][j - 1];
                if (a.charAt(i - 1) != b.charAt(j - 1)) {
                    matchScore++;
                }
                d[i][j] = Math.min(insertionScore, Math.min(deletionScore, matchScore));
            }
        }
        return d;
    }
}
