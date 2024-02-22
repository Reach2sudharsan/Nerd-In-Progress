import java.util.Stack;

public class SyntaxCheckRunner {
    public static void main(String[] args) {
        SyntaxCheck run = new SyntaxCheck();
        run.syntaxCheck("(abc(*def)");
        run.syntaxCheck("[{}]");
        run.syntaxCheck("[");
        run.syntaxCheck("[{<()>}]");
        run.syntaxCheck("{<html[value=4]*(12)>{$x}}");
        run.syntaxCheck("[one]<two>{three}(four)");
        run.syntaxCheck("car(cdr(a)(b)))");
        run.syntaxCheck("car(cdr(a)(b)");
    }
}

class SyntaxCheck {
    Stack<Character> stack;

    public void syntaxCheck(String exp) {
        stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '{' || exp.charAt(i) == '[' || exp.charAt(i) == '(' || exp.charAt(i) == '<') {
                stack.push(exp.charAt(i));
            }

            else if (exp.charAt(i) == '}' || exp.charAt(i) == ']' || exp.charAt(i) == ')' || exp.charAt(i) == '>' ) {
                if (!stack.isEmpty()) {
                    char chr = stack.pop();
                    if (!((exp.charAt(i) == '}' && chr == '{') || (exp.charAt(i) == ']' && chr == '[') || (exp.charAt(i) == ')' && chr == '(') || (exp.charAt(i) == '>' && chr == '<'))) {
                        break;
                    }
                }

                else {
                    break;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println(exp + " is correct");
        }
        else {
            System.out.println(exp + " is incorrect");
        }
    }
}
