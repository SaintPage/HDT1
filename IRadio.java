/**
 * Interfaz de métodos para una radio
 * NOTA IMPORTANTE: escribimos los métodos tal y como estaban escritos en el pizarrón, en cuanto a mayusculas y minusculas orden. 
 * El programa solo funciona si en la clase que implementa los métodos estan bien escritos como en el pizarrón.
 * @author Colaborativo en Algoritmos y Estructuras de datos
 */
public interface IRadio {
    /**
     * Método para guardar estaciones
     */
    public void saveStation(int buttonId, double station);
    /**
     * Retorna verdadero si es AM, falso si es FM
     */
    public boolean isAM();
    /**
     * retorna verdadero si la radio está encendida, falso si está apagada
     */
    public boolean isON();
    /**
     * selecciona una estación en base al botton seleccionado
     */
    public double selectStation(int buttonId);
    /**
     * enciende y apaga la radio
     */
    public void switchOnOff();
    /**
     * cambia la radio entre AM y FM
     */
    public void switchAMFM();
    /**
     * avanza a la siguiente frequencia 
     */
    public double nextStation();

}