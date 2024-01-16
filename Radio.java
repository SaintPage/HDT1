/**
 * Clase para implementar una radio. Se puede sustituir por otra clase funcional
 * @author SaintPage Ultimate-Truth-Seeker
 * @version 16 - 01 - 2024
 */
public class Radio implements IRadio {
    private boolean isOn;
    private boolean isAM;
    private double currentStation;
    private int currentButton;
    private double[] savedStations;
    /*
     * constructor
     */
    public Radio() {
        isOn = false;
        // Comienza en AM por defecto
        isAM = true; 
        currentButton = 1;
        savedStations = new double[12];
        // Inicializar currentStation a un valor específico
        currentStation = isAM ? 530.0 : 87.9; 
    }
    
    // Javadoc de los métodos override en la interfaz

    @Override
    public boolean isAM() {
        return isAM;
    }

    @Override
    public boolean isON() {
        return isOn;
    }

    @Override
    public void switchOnOff() {
        isOn = !isOn;
        if (isOn) {
            System.out.println("Radio encendida.");
        } else {
            System.out.println("Radio apagada.");
        }
    }

    @Override
    public void switchAMFM() {
        if (!isON()) {
            System.out.println("Encienda primero la radio");
            return;
        }
        if (isAM() == false) {
            // Limitar la frecuencia AM antes de cambiar a FM
            currentStation = Math.max(currentStation, 530.0);
            currentStation = Math.min(currentStation, 1610.0);
            isAM = true;
            System.out.println("Cambiando a AM.");
        } else {
            // Limitar la frecuencia FM antes de cambiar a AM
            currentStation = Math.min(currentStation, 87.9);
            currentStation = Math.min(currentStation, 107.9);
            isAM = false;
            System.out.println("Cambiando a FM.");
        }
    }

    @Override
    public double nextStation() {
        if (!isON()) {
            System.out.println("Encienda primero la radio");
            return currentStation;
        }
        if (isAM) {
            // Incrementar en 10 para AM
            currentStation += 10.0;
            if (currentStation > 1610.0) {
                // Valor inicial de AM
                currentStation = 530.0;
            }
        } else {
            // Incrementar en 0.2 para FM
            currentStation += 0.2;
            if (currentStation > 107.9) {
                // Valor inicial de FM
                currentStation = 87.9;
            }
        }
        System.out.println("Cambiando a la siguiente emisora: " + currentStation);
        return currentStation;
    }

    @Override
    public void saveStation(int buttonId, double station) {
        if (!isON()) {
            System.out.println("Encienda primero la radio");
            return;
        }
        if (buttonId >= 1 && buttonId <= 12) {
            savedStations[buttonId - 1] = station;
            System.out.println("Emisora guardada en el botón " + buttonId);
        } else {
            System.out.println("Número de botón no válido.");
        }
    }

    @Override
    public double selectStation(int buttonId) {
        if (!isON()) {
            System.out.println("Encienda primero la radio");
            return currentStation;
        }
        if (buttonId >= 1 && buttonId <= 12) {
            if (savedStations[buttonId -1] != 0.0) {
                currentStation = savedStations[buttonId - 1];
            } 
            if (currentStation >= 530.0 && !isAM()) {
                switchAMFM();
            }
            if (currentStation <= 108.0 && isAM()) {
                switchAMFM();
            }
            currentStation = savedStations[buttonId - 1];
            System.out.println("Emisora seleccionada desde el botón " + buttonId);
            return currentStation;
        } else {
            System.out.println("Número de botón no válido.");
            return currentStation;
        }
    }
}
