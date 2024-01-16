public class Radio implements IRadio {
    private boolean isOn;
    private boolean isAM;
    private double currentStation;
    private int currentButton;
    private double[] savedStations;

    public Radio() {
        isOn = false;
        // Comienza en AM por defecto
        isAM = true; 
        currentButton = 1;
        savedStations = new double[12];
        // Inicializar currentStation a un valor específico
        currentStation = isAM ? 530.0 : 87.9; 
    }
    
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
        if (isAM) {
            // Limitar la frecuencia AM antes de cambiar a FM
            currentStation = Math.max(currentStation, 530.0);
            currentStation = Math.min(currentStation, 1610.0);
            isAM = false;
            System.out.println("Cambiando a FM.");
        } else {
            // Limitar la frecuencia FM antes de cambiar a AM
            currentStation = Math.max(currentStation, 87.9);
            currentStation = Math.min(currentStation, 107.9);
            isAM = true;
            System.out.println("Cambiando a AM.");
        }
    }

    @Override
    public double nextStation() {
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
        if (buttonId >= 1 && buttonId <= 12) {
            savedStations[buttonId - 1] = station;
            System.out.println("Emisora guardada en el botón " + buttonId);
        } else {
            System.out.println("Número de botón no válido.");
        }
    }

    @Override
    public double selectStation(int buttonId) {
        if (buttonId >= 1 && buttonId <= 12) {
            currentStation = savedStations[buttonId - 1];
            System.out.println("Emisora seleccionada desde el botón " + buttonId);
            return currentStation;
        } else {
            System.out.println("Número de botón no válido.");
            return currentStation;
        }
    }
}
