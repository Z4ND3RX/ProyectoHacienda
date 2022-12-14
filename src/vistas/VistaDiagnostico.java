/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.sun.awt.AWTUtilities;
import excepciones.CampoVacioException;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.DiagnosticoClinico;
import modelo.pila.AccionRealizadaDiagnostico;

/**
 *
 * @author andre
 */
public class VistaDiagnostico extends javax.swing.JDialog {

    VistaHome vistaHome;
    int codigoAnimal;

    /**
     * Creates new form VistaDiagnostico
     */
    public VistaDiagnostico(java.awt.Frame parent, boolean modal, VistaHome vistaHome, int codigoAnimal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 20, 20);
        AWTUtilities.setWindowShape(this, forma);
        this.vistaHome = vistaHome;
        this.codigoAnimal = codigoAnimal;
//        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }

    public static String horaActual() {
        LocalTime horaActual = LocalTime.now();
        String hora = String.valueOf(horaActual);
        return hora;
    }

    public void mostrarMensaje(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE,
                new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoBlack_Pequeño.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAtender = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        jcbTipo = new javax.swing.JComboBox<>();
        titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAtender.setBackground(new java.awt.Color(255, 255, 255));
        btnAtender.setFont(new java.awt.Font("Duralith", 0, 12)); // NOI18N
        btnAtender.setForeground(new java.awt.Color(0, 0, 0));
        btnAtender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnFondoDark.png"))); // NOI18N
        btnAtender.setText("Aceptar");
        btnAtender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtender.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAtender.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnFondoDark_Pressed.png"))); // NOI18N
        btnAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtenderActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 110, 30));

        txtObservacion.setBackground(new java.awt.Color(255, 255, 255));
        txtObservacion.setColumns(20);
        txtObservacion.setFont(new java.awt.Font("Duralith", 0, 12)); // NOI18N
        txtObservacion.setForeground(new java.awt.Color(0, 0, 0));
        txtObservacion.setRows(5);
        txtObservacion.setText("Escriba aquí la observación clínica");
        txtObservacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtObservacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txtObservacion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 120, 220, 130));

        jcbTipo.setBackground(new java.awt.Color(255, 255, 255));
        jcbTipo.setFont(new java.awt.Font("Duralith", 0, 12)); // NOI18N
        jcbTipo.setForeground(new java.awt.Color(0, 0, 0));
        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Tipo", "Enfermedad", "Lesión", "Intoxicación" }));
        jcbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoActionPerformed(evt);
            }
        });
        jPanel1.add(jcbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 170, 30));

        titulo.setFont(new java.awt.Font("Duralith", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Diagnóstico Clínico");
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/interfaz_Eliminar.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoActionPerformed

    private void btnAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtenderActionPerformed
        try {
            if (txtObservacion.getText().isEmpty() || jcbTipo.getSelectedIndex() == 0
                    || txtObservacion.getText().equals("Observación")) {
                throw new CampoVacioException();
            }
            String observacion = txtObservacion.getText();
            String tipoObservacion = jcbTipo.getSelectedItem().toString();
            DiagnosticoClinico diagnostico = new DiagnosticoClinico(codigoAnimal, observacion, tipoObservacion, fechaActual(), horaActual());
            vistaHome.getControladorVeterinario().añadirDiagnostico(diagnostico);
            AccionRealizadaDiagnostico accion = new AccionRealizadaDiagnostico(diagnostico, AccionRealizadaDiagnostico.actionRegistrar);
            vistaHome.getControladorPila().pushDiagnosticoAction(accion);
            mostrarMensaje("Diagnóstico Registrado Correctamente", "Información");
            this.dispose();
        } catch (CampoVacioException ex) {
            mostrarMensaje(ex.getMessage(), "Error");
        }
    }//GEN-LAST:event_btnAtenderActionPerformed

    private void txtObservacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtObservacionMouseClicked
        txtObservacion.setText("");
    }//GEN-LAST:event_txtObservacionMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VistaDiagnostico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VistaDiagnostico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VistaDiagnostico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VistaDiagnostico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VistaDiagnostico().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipo;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextArea txtObservacion;
    // End of variables declaration//GEN-END:variables
}
