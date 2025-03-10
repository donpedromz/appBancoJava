/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * EXCEPCION PARA GESTIONAR INICIOS DE SESIÓN NO PERMITIDOS
 * @author juanp
 */
public class LoginException extends Exception{
    /**
     * Se inicializa la excepción con un mensaje estandar.
     */
    public LoginException(){
        super("ERROR AL INICIAR SESIÓN");
    }
    /**
     * Se inicializa la excepción con un mensaje personalizado.
     * @param msg Mensaje personalizado.
     */
    public LoginException(String msg){
        super(msg);
    }
}
