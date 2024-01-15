import java.util.Scanner;
/**
 * Menu para usar la radio
 * @author Ultimate-Truth-Seeker SaintPage
 * @version 15 - 01 - 2024
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            System.out.println("Bienvenido. Seleccione una opción:\n1. Prende el radio\n" + //
                    "2. Cambia de AM a FM a AM\n" + //
                    "3. Avanzar en el dial de las emisoras. Al llegar al final del dial inicia nuevamente.\n" + //
                    "4. Permite guardar una emisora en uno de los 12 botones\n" + //
                    "5. Permite seleccionar la emisora puesta en un botón\n" + //
                    "6. Apagar el radio\n" +
                    "7. Salir");
            int op = s.nextInt();
            switch (op) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    menu = false;
                    break;
                default:
                    break;
            }
        }
    }
    
}