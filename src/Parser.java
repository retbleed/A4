import java.util.Scanner;

public class Parser {
    private String input;
    private int position;

    public Parser(String input) {
        this.input = input;
        this.position = 0;
    }

    public void parse() {
        E();
        if (position != input.length()) {
            System.out.println("Error: input has not been fully parsed.");
        } else {
            System.out.println("Input parsed successfully!");
        }
    }

    private void E() {
        T();
        while (position < input.length() && input.charAt(position) == '+') {
            position++;
            T();
        }
    }

    private void T() {
        F();
        while (position < input.length() && input.charAt(position) == '*') {
            position++;
            F();
        }
    }

    private void F() {
        if (position < input.length() && input.charAt(position) == '(') {
            position++;
            E();
            if (position >= input.length() || input.charAt(position) != ')') {
                System.out.println("Error: expected ')' at position " + position);
            } else {
                position++;
            }
        } else if (position < input.length() && Character.isLetterOrDigit(input.charAt(position))) {
            position++;
        } else {
            System.out.println("Error: expected '(' or a variable at position " + position);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input to parse: ");
        String input = scanner.nextLine();
        Parser parser = new Parser(input);
        parser.parse();
    }
}