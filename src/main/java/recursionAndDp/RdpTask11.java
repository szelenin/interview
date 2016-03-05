package recursionAndDp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by szelenin on 3/2/2016.
 */
public class RdpTask11 {
    public static int count(String expression, boolean expected) {
        List<String> expressions = insertParenthesis(expression, 0, 2);
        return 0;
    }

    private static List<String> insertParenthesis(String expression, int openPosition, int operands) {
        int closePosition = findClosePosition(expression, openPosition, operands);
        ArrayList<String> result = new ArrayList<>();
        if (closePosition == -1) {
            return result;
        }
        result.addAll(insertParenthesis(expression, openPosition, operands + 1));
        int nextOpenPosition = findClosePosition(expression, openPosition, 1);
        result.addAll(insertParenthesis(expression, nextOpenPosition, operands));
        String newExpression = expression.substring(0, openPosition) +
                "(" + expression.substring(openPosition, closePosition) +
                ")" + expression.substring(closePosition);
        result.add(newExpression);
        result.addAll(insertParenthesis(newExpression, openPosition, operands + 1));
        return result;
    }

    private static int findClosePosition(String expression, int openPosition, int operands) {
        String remaining = expression.substring(openPosition);
        Pattern pattern = Pattern.compile("(1|0)+");
        Matcher matcher = pattern.matcher(remaining);
        return 0;
    }
}
