import java.util.LinkedList;

public class Solution {
    private LinkedList<Character> symbolStack = new LinkedList<>();
    private LinkedList<Integer> numStack = new LinkedList<>();
    private int index = 0;

    public int calculate(String s) {
        s = s.replace(" ", "");
        while (index < s.length()) {
            switch (s.charAt(index)) {
                case '+':
                    while (!symbolStack.isEmpty() && symbolStack.peek() == '-') {
                        calculateOnce();
                    }
                    symbolStack.push('+');
                    index++;
                    break;
                case '-':
                    if (index == 0 || s.charAt(index - 1) == '(') {
                        numStack.push(0);
                    }
                    while (!symbolStack.isEmpty() && symbolStack.peek() != '(') {
                        calculateOnce();
                    }
                    symbolStack.push('-');
                    index++;
                    break;
                case '(':
                    symbolStack.push('(');
                    index++;
                    break;
                case ')':
                    while (symbolStack.peek() != '(') {
                        calculateOnce();
                    }
                    symbolStack.pop();
                    index++;
                    break;
                case ' ':
                    index++;
                    break;
                default:
                    numStack.push(getNum(s));
                    break;
            }
        }
        while (!symbolStack.isEmpty()) {
            calculateOnce();
        }
        return numStack.peek();
    }

    private int getNum(String s) {
        int result = 0;
        for (; index < s.length(); index++) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                result = result * 10 + (c - '0');
            } else {
                break;
            }
        }
        return result;
    }

    private void calculateOnce() {
        if (numStack.size() < 2 || symbolStack.isEmpty()) {
            return;
        }
        int numRight = numStack.pop();
        int numLeft = numStack.pop();
        char symbol = symbolStack.pop();
        if (symbol == '+') {
            numStack.push(numLeft + numRight);
        } else if (symbol == '-') {
            numStack.push(numLeft - numRight);
        }
    }
}