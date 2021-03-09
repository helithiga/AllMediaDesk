import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {

    public String BracesCal(String numberArgument) {

        while (numberArgument.contains("(") && numberArgument.contains(")")) {
            int StartBracketIndex = numberArgument.indexOf("(");
            int FinishBracketIndex = numberArgument.indexOf(")");
            String Num_in_Brackets = numberArgument.substring(StartBracketIndex + 1, FinishBracketIndex);
            numberArgument = numberArgument.substring(0, StartBracketIndex)
                    + calculate(Num_in_Brackets)
                    + numberArgument.substring(FinishBracketIndex + 1,
                            numberArgument.length());
        }
        return calculate(numberArgument);

    }

    public String calculate(String Sub_number_argument) {

        while (Sub_number_argument.contains("(") && Sub_number_argument.contains(")")) {
            BracesCal(Sub_number_argument);
        }
        while (!isNum(Sub_number_argument)) {
            List<Integer> positions = getOperandPosition(Sub_number_argument);
            int pos = positions.get(0);
            if (positions.size() >= 2 && positions.get(1) != null) {
                int nxtPos = positions.get(1);
                Sub_number_argument = getValue(Sub_number_argument.substring(0, nxtPos), pos)
                        + Sub_number_argument.substring(nxtPos, Sub_number_argument.length());
            } else {
                Sub_number_argument = getValue(
                        Sub_number_argument.substring(0, Sub_number_argument.length()), pos);
            }
        }
        return Sub_number_argument;

    }

    public static boolean isNum(String str) {
        if (str.contains("+") || str.contains("-") || str.contains("*")
                || str.contains("/")) {
            return false;
        }
        return true;
    }

    public static List<Integer> getOperandPosition(String str) {

        List<Integer> integers = new ArrayList<Integer>();

        if (str.contains("+")) {
            integers.add(str.indexOf("+"));
        }

        if (str.contains("-")) {
            integers.add(str.indexOf("-"));
        }

        if (str.contains("*")) {
            integers.add(str.indexOf("*"));
        }

        if (str.contains("/")) {
            integers.add(str.indexOf("/"));
        }

        Collections.sort(integers);
        return integers;
    }

    public String getValue(String str, int pos) {
        double finalVal = 0;
        double firstNum = Double.parseDouble(str.substring(0, pos));
        double secondNum = Double.parseDouble(str.substring(pos + 1, str.length()));
        char operation = str.charAt(pos);

        if (operation == '*') {
            finalVal = firstNum * secondNum;
        } else if (operation == '/') {
            finalVal = firstNum / secondNum;
        } else if (operation == '+') {
            finalVal = firstNum + secondNum;
        } else if (operation == '-') {
            finalVal = firstNum - secondNum;
        }
        return String.valueOf(finalVal);
    }
}