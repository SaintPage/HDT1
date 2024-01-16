import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class Pruebas {

    private Radio radio;
    @BeforeEach
    public void loadRadio() {
        radio = new Radio();
    }

    @Test
    public void testSwitchOnOff() {
        boolean prev = radio.isON();
        radio.switchOnOff();
        assertNotEquals(prev, radio.isON());
    }    

    @Test
    public void testSwitchAMFM() {
        boolean prev = radio.isAM();
        radio.switchAMFM();
        assertNotEquals(prev, radio.isAM());
    }

    @Test
    public void testSaveStation() {
        double frec = 87.9;
        int button = 1;
        radio.saveStation(button, frec);
        assertEquals(frec, radio.selectStation(button));

    }
}
