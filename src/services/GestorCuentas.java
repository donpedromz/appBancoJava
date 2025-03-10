/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author juanp
 */
import domain.CuentaBancaria;
import excepciones.LoginException;
import java.util.ArrayList;
import java.util.List;
/**
 * Gestor que nos permitirá administrar las cuentas del Banco
 * mediante una Lista de cuentas (CuentaBancaria)
 * @author juanp
 */
public class GestorCuentas {
    /**
     * Atributo que almacena las cuentas del Banco
     */
    private List<CuentaBancaria> cuentasBanco;
    /**
     * Constructor para inicializar las cuentas del banco como una lista
     * vacía
     */
    public GestorCuentas(){
        this.cuentasBanco = new ArrayList<CuentaBancaria>();
    }
    /**
     * Constructor para inicializar las cuentas del banco con una lista
     * predifinida
     * @param cuentas => Lista predefinida de cuentas.
     */
    public GestorCuentas(List<CuentaBancaria> cuentas){
        this.cuentasBanco = cuentas;
    }
    /**
     * Método para iniciar sesión.
     * Itera sobre las cuentas del banco, comparando el texto de la contraseña de la cuenta y el usuario
     * con los valores ingresados por el usuario (No es la mejor práctica)
     * Si hay una coincidencia, se retorna la cuenta que ha iniciado sesión.
     * @param user => Usuario ingresado en la UI
     * @param password => Contraseña ingresada en la UI
     * @return Cuenta que ha iniciado sesión
     * @throws LoginException Si no hay cuentas en el banco, o si no hay ninguna coincidencia.
     */ 
    public CuentaBancaria loginCuenta(String user, String password)throws LoginException{
        if(this.cuentasBanco.isEmpty()){
            throw new LoginException("NO HAY CUENTAS REGISTRADAS EN EL SISTEMA");
        }
        for(CuentaBancaria c : this.cuentasBanco){
            if(c.getUser().equals(user) && c.getPassword().equals(password)){
                return c;
            }
        }
        throw new LoginException("DATOS INCORRECTOS");
    }
    
}
