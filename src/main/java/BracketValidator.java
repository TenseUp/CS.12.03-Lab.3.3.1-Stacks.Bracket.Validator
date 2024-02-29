import java.util.Stack;

public class BracketValidator {

    public static boolean checkValidParentheses(String expression) {
        String[] brackets = expression.split("");
        Stack<String> stack = new Stack<>();

        for (String bracket : brackets) {
            String reversedBracket = getReversedBracket(bracket);

            if (isLeftBracket(bracket)) {
                stack.push(bracket);
            } else {
                if (stack.isEmpty() || !stack.pop().equals(reversedBracket)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isLeftBracket(String bracket) {
        return bracket.equals("(") || bracket.equals("[") || bracket.equals("{");
    }

    private static String getReversedBracket(String bracket) {
        if (bracket.equals(")")) {
            return "(";
        } else if (bracket.equals("]")) {
            return "[";
        } else if (bracket.equals("}")) {
            return "{";
        }
        return null;
    }
}