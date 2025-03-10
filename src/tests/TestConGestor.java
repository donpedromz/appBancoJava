/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;
import services.GestorCuentas;
import services.ControladorBancario;
import domain.CuentaBancaria;
import java.util.ArrayList;
/**
 * Clase para testear el controlador Bancario, con un numero de cuentas
 * ya creado usando un bucle.
 * @author juanp
 */
public class TestConGestor {
    /**
     * Método para generar cuentas usando un ciclo, que itera desde 1 hasta 20, lo
     * que nos generará 20 cuentas para crear el controlador.
     * @return Una lista con 20 cuentas generadas por el ciclo
     */
    public static ArrayList<CuentaBancaria> crearCuentas() {
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            String user = "user" + i;
            String password = "pass" + i;
            double saldo = Math.random() * 10000; // Saldo aleatorio entre 0 y 10000
            cuentas.add(new CuentaBancaria(user, password, saldo));
            
        }

        return cuentas;
    }
    /**
     * Test de la aplicación. Se llama al metodo crearCuentas, y se le pasa la lsita
     * generada como argumento al controlador, para que se ejecute el programa.
     * @param args 
     */
    public static void main(String[] args) {
        GestorCuentas gestor = new GestorCuentas(crearCuentas());
        ControladorBancario controlador = new ControladorBancario(gestor);
    }
}
