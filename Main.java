import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la clase Radio
        IRadio myRadio = new Radio();

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            // Imprimir el menú
            System.out.println("----- Menú -----");
            System.out.println("1. Prende el radio");
            System.out.println("2. Cambia de AM a FM a AM");
            System.out.println("3. Avanzar en el dial de las emisoras");
            System.out.println("4. Permite guardar una emisora en uno de los 12 botones");
            System.out.println("5. Permite seleccionar la emisora puesta en un botón");
            System.out.println("6. Apagar el radio");
            System.out.println("0. Salir");

            // Leer la opción del usuario
            System.out.print("Ingresa tu elección: ");
            choice = scanner.nextInt();

            // Ejecutar la opción seleccionada
            switch (choice) {
                case 1:
                    myRadio.switchOnOff();
                    break;
                case 2:
                    myRadio.switchAMFM();
                    break;
                case 3:
                    myRadio.nextStation();
                    break;
                case 4:
                    saveStation(myRadio, scanner);
                    break;
                case 5:
                    selectStation(myRadio, scanner);
                    break;
                case 6:
                    myRadio.switchOnOff();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Ingresa un número correctamente");
                    break;
            }

        } while (choice != 0);
        
        // Cerrar el scanner al finalizar
        scanner.close();
    }

    private static void saveStation(IRadio radio, Scanner scanner) {
        System.out.print("Ingresa un número del 1-12: ");
        int buttonId = scanner.nextInt();

        System.out.print("Ingresa la emisora a guardar: ");
        double station = scanner.nextDouble();

        radio.saveStation(buttonId, station);
    }

    private static void selectStation(IRadio radio, Scanner scanner) {
        System.out.print("Ingresa el número de botón que hayas guardado (1-12): ");
        int buttonId = scanner.nextInt();

        double selectedStation = radio.selectStation(buttonId);
        System.out.println("Emisora seleccionada: " + selectedStation);
    }
}