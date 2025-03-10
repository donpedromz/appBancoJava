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
public class GestorCuentas {
    private List<CuentaBancaria> cuentasBanco;
    public GestorCuentas(){
        this.cuentasBanco = new ArrayList<CuentaBancaria>();
    }
    public GestorCuentas(List<CuentaBancaria> cuentas){
        this.cuentasBanco = cuentas;
    }
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
