import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la entrada para analizar: ");
        String entrada = scanner.nextLine();
        Parser parser = new Parser(entrada);
        parser.parse();
    }
}