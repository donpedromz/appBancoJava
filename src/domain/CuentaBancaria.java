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
    private String user;
    private String password;
    private double saldo;
    /**
     * Constructor vacío con el que se inicializa el saldo en 0, y
     * el usuario y la contraseña en vacío.
     */
    public CuentaBancaria(){
        this.user = null;
        this.password = null;
        this.saldo = 0;
    }
    /**
     * Se inicializa la cuenta con valores predefinidos
     * @param user usuario predefinido
     * @param password contraseña predefinida
     * @param saldo  saldo predefinido
     */
    public CuentaBancaria(String user, String password, double saldo) {
        this.user = user;
        this.password = password;
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
     * Obtener el usuario de la cuenta
     * @return Usuario de la cuenta
     */
    public String getUser() {
        return user;
    }
    /**
     * Establecer un nuevo usuario a la cuenta
     * @param user => nuevo nombre de usuario de la cuenta.
     */
    public void setUser(String user) {
        this.user = user;
    }
    /**
     * Obtener la contraseña de la cuenta
     * @return Contraseña de la cuenta.
     */
    public String getPassword() {
        return password;
    }
    /**
     * Establecer una nueva contraseña a la cuenta
     * @param password => Nueva contraseña de la cuenta.
     */
    public void setPassword(String password) {
        this.password = password;
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
        if(this.saldo == 0){
            return "POR FAVOR DEPOSITE DINERO A SU CUENTA";
        }
        return "$"+this.saldo;
    }
    
}
