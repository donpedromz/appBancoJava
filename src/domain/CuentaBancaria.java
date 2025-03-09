/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 * CLASE PARA GESTIONAR EL SALDO DEL USUARIO
 * @author Juan Pablo
 */
import excepciones.SaldoInsuficienteException;
public class CuentaBancaria {
    /**
     * Atributo que almacena el saldo del usuario, con valores decimales.
     */
    private double saldo;
    /**
     * Constructor vacío con el que se inicializa el saldo en 0
     */
    public CuentaBancaria(){
        this.saldo = 0;
    }
    /**
     * Constructor con el que se inicializa el saldo con un valor personalizado
     * @param saldo saldo con el que se inicializará la cuenta
     */
    public CuentaBancaria(double saldo){
        this.saldo = saldo;
    }
    /**
     * Método para obtener el valor del saldo de la cuenta
     * @return saldo de la cuenta
     */
    public double getSaldo() {
        return saldo;
    }
    /**
     * Método para establecer un nuevo saldo a la cuenta
     * @param saldo => saldo nuevo de la cuenta.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    /**
     * Actualiza el saldo de la cuenta, sumandole al saldo actual un saldo ingresado
     * por el usuario
     * @param dinero => saldo a depositar ingresado por el usuario.
     */
    public void depositarDinero(double dinero){
        this.saldo += dinero;
    }
    /**
     * Actualiza el saldo de la cuenta, restándole un saldo a retirar ingresado por el
     * usuario.
     * @param saldoRetiro saldo a retirar ingresado por el usuario
     * @throws SaldoInsuficienteException si el saldo a retirar excede el saldo actual
     */
    public void retirarDinero(double saldoRetiro)throws SaldoInsuficienteException{
        if(this.saldo < saldoRetiro){
            throw new SaldoInsuficienteException();
        }
        this.saldo -= saldoRetiro;
    }
    /**
     * Formatea el saldo de la cuenta a una cadena.
     * @return String con un formato estándar del saldo de la cuenta
     */
    @Override
    public String toString() {
        return "$"+this.saldo;
    }
    
}
