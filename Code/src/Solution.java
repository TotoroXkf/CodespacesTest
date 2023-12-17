import java.util.LinkedList;

public class Solution {
    private LinkedList<Character> symbolStack = new LinkedList<>();
    private LinkedList<Integer> numStack = new LinkedList<>();
    private int index = 0;

    public int calculate(String s) {
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                numStack.push(getNum(s));
            } else if (c == ' ') {
                index++;
            } else {
                int currentSymbolLevel = getSymbolLevel(c);
                while (!symbolStack.isEmpty() && getSymbolLevel(symbolStack.peek()) >= currentSymbolLevel) {
                    calculateOnce();
                }
                symbolStack.push(c);
                index++;
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
        switch (symbol) {
            case '+':
                numStack.push(numLeft + numRight);
                break;
            case '-':
                numStack.push(numLeft - numRight);
                break;
            case '*':
                numStack.push(numLeft * numRight);
                break;
            case '/':
                numStack.push(numLeft / numRight);
                break;
            default:
                break;
        }
    }

    private int getSymbolLevel(char symbol) {
        switch (symbol) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}