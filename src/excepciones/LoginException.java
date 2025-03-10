/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author juanp
 */
public class LoginException extends Exception{
    public LoginException(){
        super("ERROR AL INICIAR SESIÓN");
    }
    public LoginException(String msg){
        super(msg);
    }
}
