/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * EXCEPCION CREADA PARA GESTIONAR OPERACIONES QUE INVOLUCRAN SALDOS INSUFICIENTES
 * @author Juan Pablo
 */
public class SaldoInsuficienteException extends Exception{
    /**
     * Constructor vacio, con el cual se inicializa el mensaje de la excepción con 
     * un mensaje estándar
     */
    public SaldoInsuficienteException(){
        super("SALDO INSUFICIENTE EN SU CUENTA");
    }
    /**
     * Constructor para inicializar el mensaje de la excepción, con un mensaje
     * personalizado
     * @param msg mensaje Personalizado
     */
    public SaldoInsuficienteException(String msg){
        super(msg);
    }
}
