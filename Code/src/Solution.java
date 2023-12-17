import java.util.LinkedList;

class Solution {
    private LinkedList<String> symbolStack = new LinkedList<>();
    private LinkedList<Integer> numStack = new LinkedList<>();
    private int index = 0;

    public int calculate(String s) {
        while (index < s.length()) {
            switch (s.charAt(index)) {
                case '+':
                    break;
                case '-':
                    break;
                case '(':
                    break;
                case ')':
                    break;
                case ' ':
                    index++;
                    break;
                default:
                    break;
            }
        }
        return numStack.peek();
    }

    private int getNum(String s) {
        int result = 0;
        for (; index < s.length(); index++) {
            char c = s.charAt(index);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                result = result * 10 + (c - '0');
            }
        }
        return result;
    }

    private void calculateOnce() {
        if (numStack.size() < 2 || symbolStack.isEmpty()) {
            return;
        }
        int num1 = numStack.pop();
        int num2 = numStack.pop();
        String symbol = symbolStack.pop();
        if (symbol.equals("+")) {
            numStack.push(num1 + num2);
        } else if (symbol.equals("-")) {
            numStack.push(num1 - num2);
        }
    }
}