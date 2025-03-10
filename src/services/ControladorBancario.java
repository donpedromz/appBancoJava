/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author Juan Pablo
 */
import domain.CuentaBancaria;
import excepciones.LoginException;
import excepciones.OperacionInvalidaException;
import excepciones.SaldoInsuficienteException;
import java.awt.event.ActionEvent;
import ui.CajeroAutomatico;
import ui.Login;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ControladorBancario {

    private CajeroAutomatico cajeroUi;
    private Login loginBancario;
    private GestorCuentas gestor;
    private CuentaBancaria cuentaSesion;
    public ControladorBancario() {
        this.gestor = new GestorCuentas();
        this.loginBancario = new Login();
        this.loginBancario.addLoginButtonListener(new ButtonClickListener());
    }

    public ControladorBancario(GestorCuentas gestor) {
        this.gestor = gestor;
        this.loginBancario = new Login();
        this.loginBancario.addLoginButtonListener(new ButtonClickListener());
    }

    private void handleLogin() {
        String user = this.loginBancario.getjTextField1().getText();
        String password = this.loginBancario.getjTextField2().getText();
        try {
            CuentaBancaria cuentaSesion = gestor.loginCuenta(user, password);
            this.cuentaSesion = cuentaSesion;
            this.cajeroUi = new CajeroAutomatico(cuentaSesion);
            this.cajeroUi.addDepositarButtonListener(new ButtonClickListener());
            this.cajeroUi.addRetirarButtonListener(new ButtonClickListener());
            this.cajeroUi.mostrarInterfaz();
        } catch (LoginException e) {
            this.loginBancario.getErrorLabel().setText(e.getMessage());
        }
    }
    private double obtenerMonto() throws OperacionInvalidaException {
        double saldo = 0;
        try {
            saldo = Double.parseDouble(this.cajeroUi.getjTextField1().getText());
        } catch (Exception e) {
            throw new OperacionInvalidaException("VALOR INGRESADO INCORRECTO");
        }
        if (saldo < 0) {
            throw new OperacionInvalidaException("VALOR NEGATIVO INVALIDO");
        }
        return saldo;
    }
    private void handleRetiro() {
        double saldo = 0;
        try {
            saldo = this.obtenerMonto();
            this.cuentaSesion.retirarDinero(saldo);
        } catch (OperacionInvalidaException e) {
            this.cajeroUi.getLabelError().setText(e.getMessage());
            return;
        } catch (SaldoInsuficienteException e1) {
            this.cajeroUi.getLabelError().setText(e1.getMessage());
            return;
        }
        this.cajeroUi.getLabelError().setText(null);
        this.cajeroUi.getLabelSaldo().setText(this.cuentaSesion.toString());
    }

    private void handleDeposito() {
        double saldo = 0;
        try {
            saldo = this.obtenerMonto();
            this.cuentaSesion.depositarDinero(saldo);
        } catch (OperacionInvalidaException e) {
            this.cajeroUi.getLabelError().setText(e.getMessage());
            return;
        }
        this.cajeroUi.getLabelError().setText(null);
        this.cajeroUi.getLabelSaldo().setText(this.cuentaSesion.toString());
    }

    private class ButtonClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if (source == loginBancario.getLoginButton()) {
                handleLogin();
            }
            if (source == cajeroUi.getRetirarButton()) {
                handleRetiro();
            }
            if (source == cajeroUi.getDepositarButton()) {
                handleDeposito();
            }
        }

    }

}
