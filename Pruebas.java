import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
/**
 * Clase de pruebas de Junit para la radio
 * @author Ultimate-Truth-Seeker
 * @version 16 - 01 - 2024
 */
public class Pruebas {

    private Radio radio = new Radio();
    /**
     * inicializa una radio para cada prueba
     */
    @BeforeEach
    public void loadRadio() {
        radio = new Radio();
    }
    
    /**
     * prueba para encender y apagar la radio
     */
    @Test
    public void testSwitchOnOff() {
        boolean prev = radio.isON();
        radio.switchOnOff();
        assertNotEquals(prev, radio.isON());
    }    
    

    /**
     * prueba para cambiar de AM a FM
     */
    @Test
    public void testSwitchAMFM() {
        boolean prev = radio.isAM();
        radio.switchOnOff();
        radio.switchAMFM();
        assertNotEquals(prev, radio.isAM());
    }

    /**
     * prueba para guardar la estación
     */
    @Test
    public void testSaveStation() {
        double frec = 88.9;
        int button = 1;
        radio.switchOnOff();
        radio.saveStation(button, frec);
        assertEquals(frec, radio.selectStation(button));

    }
}
