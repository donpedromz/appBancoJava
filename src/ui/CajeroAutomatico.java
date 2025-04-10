/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

/**
 * UI DE CAJERO AUTOMATICO, USANDO COMO CLASE PLANTILLA CUENTABANCARIA
 *
 * @author Juan Pablo
 */
import domain.CuentaBancaria;
import excepciones.OperacionInvalidaException;
import excepciones.SaldoInsuficienteException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CajeroAutomatico extends javax.swing.JFrame {

    /**
     * INICIALIZAMOS LA CUENTA CON UN SALDO 0, USANDO UN CONSTRUCTOR VACIO Y
     * SETEAMOS UN TEXTO ESTANDAR PARA UN SALDO IGUAL A 0. SETEAMOS LA UBICACIÓN
     * DE LA VENTANA EN EL CENTRO DE LA PANTALLA Creates new form
     * CajeroAutomatico
     */
    private CuentaBancaria cuenta;

    public CajeroAutomatico(CuentaBancaria cuentaSesion) {
        this.cuenta = cuentaSesion;
        initComponents();
        this.setLocationRelativeTo(null);
        this.labelSaldo.setText(cuentaSesion.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelSaldo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        retirarButton = new javax.swing.JButton();
        depositarButton = new javax.swing.JButton();
        labelError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("POR FAVOR INGRESE UN MONTO:");

        jLabel3.setText("TU SALDO ACTUAL:");

        retirarButton.setText("RETIRAR");
        retirarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retirarButtonActionPerformed(evt);
            }
        });

        depositarButton.setText("DEPOSITAR");
        depositarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositarButtonActionPerformed(evt);
            }
        });

        labelError.setForeground(new java.awt.Color(255, 0, 0));
        labelError.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(labelSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(depositarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(retirarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depositarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(retirarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getDepositarButton() {
        return depositarButton;
    }

    public void setDepositarButton(JButton depositarButton) {
        this.depositarButton = depositarButton;
    }

    public JButton getRetirarButton() {
        return retirarButton;
    }

    public void setRetirarButton(JButton retirarButton) {
        this.retirarButton = retirarButton;
    }

    public void addRetirarButtonListener(java.awt.event.ActionListener listener) {
        this.retirarButton.addActionListener(listener);
    }

    public void addDepositarButtonListener(java.awt.event.ActionListener listener) {
        this.depositarButton.addActionListener(listener);
    }

    /**
     * Obtenemos el valor que el usuario haya ingresada en el jTextField1
     *
     * @return double con el valor del saldo ingresado en el campo de texto
     * jTextField1
     * @throws OperacionInvalidaException si no se ingresa un numero o si se
     * ingresa un numero negativo
     */
    /**
     * MÉTODO PARA MANEJAR EL RETIRO DE DINERO. Obtenemos el saldo ingresado por
     * el usuario usando el metodo getMonto() Si el usuario ingresa valores
     * invalidos, se genera una OperacionInvalidaException, con la cual, se
     * setea un mensaje de error en labelError Si el usuario ingresa un monto
     * mayor al del saldo actual de la cuenta, se genera un
     * SaldoInsuficienteException, con el cual, seteamos un mensaje de error en
     * labelError Si no se genera un error, se limpia el labelError, y se
     * muestra el nuevo saldo en la UI.
     *
     * @param evt evento generado al presionar el botón.
     */
    public JLabel getLabelError() {
        return labelError;
    }

    public void setLabelError(JLabel labelError) {
        this.labelError = labelError;
    }

    public JLabel getLabelSaldo() {
        return labelSaldo;
    }

    public void setLabelSaldo(JLabel labelSaldo) {
        this.labelSaldo = labelSaldo;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }
    private void retirarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retirarButtonActionPerformed
        

    }//GEN-LAST:event_retirarButtonActionPerformed

    public void mostrarInterfaz() {
        this.setVisible(true);
    }
    private void depositarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositarButtonActionPerformed

    }//GEN-LAST:event_depositarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton depositarButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelError;
    private javax.swing.JLabel labelSaldo;
    private javax.swing.JButton retirarButton;
    // End of variables declaration//GEN-END:variables
}
