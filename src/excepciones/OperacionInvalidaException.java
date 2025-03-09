/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * EXCEPCION PARA GESTIONAR OPERACIONES INVALIDAS EN LA UI
 * @author Juan Pablo
 */
public class OperacionInvalidaException extends Exception{
    /**
     * Constructor vacio para inicializa el mensaje de la excepcion
     * con un mensaje estandar
     */
    public OperacionInvalidaException(){
        super("OPERACION INVALIDA DETECTADA");
    }
    /**
     * Constructor para inicializar el mensaje de la excepcion
     * con un mensaje personalizado.
     * @param msg mensaje Personalizado de la excepción
     */
    public OperacionInvalidaException(String msg){
        super(msg);
    }
    
}
