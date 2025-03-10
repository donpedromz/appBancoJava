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
 *
 * @author juanp
 */
public class TestConGestor {
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
    public static void main(String[] args) {
        GestorCuentas gestor = new GestorCuentas(crearCuentas());
        ControladorBancario controlador = new ControladorBancario(gestor);
    }
}
