import java.util.Scanner;

public class Parser {
    private String entrada;
    private int posicion;

    public Parser(String entrada) {
        this.entrada = entrada;
        this.posicion = 0;
    }

    public void parse() {
        E();
        if (posicion != entrada.length()) {
            System.out.println("Error: la entrada no se ha analizado por completo.");
        } else {
            System.out.println("¡Entrada analizada con éxito!");
        }
    }

    private void E() {
        T();
        while (posicion < entrada.length() && entrada.charAt(posicion) == '+') {
            posicion++;
            T();
        }
    }

    private void T() {
        F();
        while (posicion < entrada.length() && entrada.charAt(posicion) == '*') {
            posicion++;
            F();
        }
    }

    private void F() {
        if (posicion < entrada.length() && entrada.charAt(posicion) == '(') {
            posicion++;
            E();
            if (posicion >= entrada.length() || entrada.charAt(posicion) != ')') {
                System.out.println("Error: esperado ')' en la posición" + posicion);
            } else {
                posicion++;
            }
        } else if (posicion < entrada.length() && Character.isLetterOrDigit(entrada.charAt(posicion))) {
            posicion++;
        } else {
            System.out.println("Error: se esperaba '(' o una variable en la posición " + posicion);
        }
    }
}
