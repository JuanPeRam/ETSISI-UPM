import java.util.Scanner;
public class Principal {
    public static void main(String[] agrs) {
        int numero;
        Divisores divisores = new Divisores();
        Scanner lectura = new Scanner(System.in);
        do {
            System.out.print(
                    "Introduzca un valor entero positivo (0 para terminar): ");
            numero = lectura.nextInt();
            if (numero < 0) {
                System.out.println("Número no válido");
            } else {
                if (numero > 0) {
                    divisores.visualizarDivisores(numero);
                }
            }
        } while (numero != 0);
    }
}