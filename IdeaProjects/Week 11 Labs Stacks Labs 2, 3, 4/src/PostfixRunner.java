import java.util.Stack;

public class PostfixRunner {
    public static void main(String[] args) {
        Postfix run = new Postfix();
        System.out.println(run.syntaxCheck("2 7 + 1 2 + +"));
        System.out.println(run.syntaxCheck("1 2 3 4 + + +"));
        System.out.println(run.syntaxCheck("9 3 * 8 / 4 +"));
        System.out.println(run.syntaxCheck("3 3 + 7 * 9 2 / +"));
        System.out.println(run.syntaxCheck("9 3 / 2 * 7 9 * + 4 –"));
        System.out.println(run.syntaxCheck("5 5 + 2 * 4 / 9 +"));
    }
}

class Postfix {
    Stack<Double> stack = new Stack<>();

    public String syntaxCheck(String exp) {
        int i = 0;
        while (exp.length()-i-1 >= 0 ) {
            char chr = exp.charAt(i);
            if (Character.isDigit(chr)) {
                double num = Integer.parseInt(Character.toString(chr));
                stack.push(num);
            }

            else if (chr == '+' || chr == '-' || chr == '*' || chr == '/' || chr == '%') {
                double num1 = stack.pop();
                double num2 = stack.pop();
                double result = 0;
                if (chr == '+') {
                    result = num2+num1;
                }
                else if (chr == '-') {
                    result = num2-num1;
                }
                else if (chr == '*') {
                    result = num2*num1;
                }
                else if (chr == '/') {
                    result = num2/num1;
                }
                else {
                    result = num2%num1;
                }
                stack.push(result);
            }
            i += 1;
        }

        return exp + " = " + stack.peek();
    }
}
