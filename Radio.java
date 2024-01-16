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
    public void saveStation(int buttonId, double station) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveStation'");
    }

    @Override
    public double selectStation(int buttonId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectStation'");
    }

    @Override
    public void switchAMFM() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'switchAMFM'");
    }

    @Override
    public double nextStation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nextStation'");
    }
}
