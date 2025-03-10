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

    /**
     * Atributo que almacenará la ventana del cajero una vez se inicie sesión.
     */
    private CajeroAutomatico cajeroUi;
    /**
     * Atributo que almacena la ventana Login, la cual se desplegará primero al
     * ejecutar la APP.
     */
    private Login loginBancario;
    /**
     * Atributo que nos permitirá administrar todas las cuentas del banco
     * mediante la clase GestorCuentas.
     */
    private GestorCuentas gestor;
    /**
     * Almacena la cuenta que ha iniciado sesión, y cuyos datos serán
     * desplegados en la UI.
     */
    private CuentaBancaria cuentaSesion;

    /**
     * Constructor que despliega la ventana login de la aplicación, y añade un
     * listener al botón Login.
     *
     * @param gestor gestor de cuentas ya creado, con una lista de cuentas
     * predefinidas
     */
    public ControladorBancario(GestorCuentas gestor) {
        this.gestor = gestor;
        this.loginBancario = new Login();
        this.loginBancario.addLoginButtonListener(new ButtonClickListener());
    }

    /**
     * Método que nos permite manejar el login una vez el usuario haya dado
     * click al boton "Iniciar Sesión". Se leen la información ingresada por el
     * usuario en la UI de Login, y se llama al metodo login del gestor. Si
     * ocurre una excepción, se actualizará el labelError de la ventana Login.
     */
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

    /**
     * Función auxiliar que nos permitirá leer valores númericos (double)
     * ingresados por el usuario en la UI
     *
     * @return double con el valor numerico ingresado por el usuario.
     * @throws OperacionInvalidaException si el usuario no ingresa un valor
     * numerico.
     */
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

    /**
     * Método que nos permite manejar el retiro una vez el usuario haya dado
     * click al boton "Retirar" en la UI CajeroAutomatico. Se lee el valor a
     * retirar por el usuario usando la función obtenerMonto(), y se llama al
     * metodo retirar de la cuenta. Si ocurre una excepción, se actualizará el
     * labelError. de lo contrario, se actualizará el labelSaldo con el nuevo
     * saldo de la cuenta.
     */
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

    /**
     * Método que nos permite manejar el deposito una vez el usuario haya dado
     * click al boton "Depositar" en la UI CajeroAutomatico. Se lee el valor a
     * depositar por el usuario usando la función obtenerMonto(), y se llama al
     * metodo depositar de la cuenta. Si ocurre una excepción, se actualizará el
     * labelError. de lo contrario, se actualizará el labelSaldo con el nuevo
     * saldo de la cuenta.
     */
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

    /**
     * Clase privada que nos ayudará a crear Listener para los botones de las UI
     * de la APP. una vez se presione el botón, se llama al método indicado para
     * realizar la operación del botón.
     */
    private class ButtonClickListener implements ActionListener {

        @Override
        /**
         * Método con el cual llamaremos a los métodos apropiados del
         * controlador, dependiendo de cual botón haya sido oprimido.
         * LoginButton => handleLogin RetirarButton => handleRetiro
         * DepositarButton => handleDeposito
         */
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if (source == loginBancario.getLoginButton()) {
                handleLogin();
            }
            if (cajeroUi != null) {
                if (source == cajeroUi.getRetirarButton()) {
                    handleRetiro();
                }
                if (source == cajeroUi.getDepositarButton()) {
                    handleDeposito();
                }
            }
        }

    }

}
