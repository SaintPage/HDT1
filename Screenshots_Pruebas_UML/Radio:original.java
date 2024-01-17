public class Radio implements IRadio {
    private boolean isOn;
    private boolean isAM;
    private double currentStation;
    private double[] amStations = new double[12];
    private double[] fmStations = new double[12];

    public Radio() {
        isOn = false;
        isAM = true;
        currentStation = isAM ? 530 : 87.9;
    }

    @Override
    public void switchOnOff() {
        isOn = !isOn;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void switchAMFM() {
        isAM = !isAM;
    }

    @Override
    public boolean isAM() {
        return isAM;
    }

    @Override
    public double nextStation() {
        if (isAM) {
            currentStation += 10;
            if (currentStation > 1610) {
                currentStation = 530;
            }
        } else {
            currentStation += 0.2;
            if (currentStation > 107.9) {
                currentStation = 87.9;
            }
        }
        return currentStation;
    }

    @Override
    public void saveStation(int buttonId, double station) {
        if (isAM) {
            amStations[buttonId - 1] = station;
        } else {
            fmStations[buttonId - 1] = station;
        }
    }

    @Override
    public double selectStation(int button) {
        if (isAM) {
            currentStation = amStations[button - 1];
        } else {
            currentStation = fmStations[button - 1];
        }
        return currentStation;
    }
}