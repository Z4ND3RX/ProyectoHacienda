/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.sun.awt.AWTUtilities;
import excepciones.DatosErroneosException;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import modelo.Administrador;
import modelo.CriadorCerdos;
import modelo.EncargadoCaballos;
import modelo.EncargadoGanado;
import modelo.Usuario;
import modelo.Veterinario;

/**
 *
 * @author andre
 */
public class VistaLogin extends javax.swing.JFrame {

    VistaHome vistaHome;
    int verPass;

    /**
     * Creates new form VistaLogin
     *
     * @param vistaHome
     */
    public VistaLogin(VistaHome vistaHome) {
        initComponents();
        setLocationRelativeTo(this);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);
        this.vistaHome = vistaHome;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        panelLogin = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        labelOlvidaste = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelOjo = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtUser = new javax.swing.JTextField();
        btnIniciarSesion = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLogin.setBackground(new java.awt.Color(255, 255, 255));
        panelLogin.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelLoginMouseDragged(evt);
            }
        });
        panelLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelLoginMousePressed(evt);
            }
        });
        panelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRefresh.png"))); // NOI18N
        btnRefresh.setToolTipText("Refresh");
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRefreshPressed.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        panelLogin.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 30, 30));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVolverPressed.png"))); // NOI18N
        btnVolver.setToolTipText("Volver");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVolver.png"))); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        panelLogin.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 30));

        jLabel4.setFont(new java.awt.Font("Duralith", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Dile al Admin que te registre. ");
        panelLogin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, -1, -1));

        labelOlvidaste.setFont(new java.awt.Font("Duralith", 0, 10)); // NOI18N
        labelOlvidaste.setForeground(new java.awt.Color(0, 11, 26));
        labelOlvidaste.setText("¿olvidaste tu contraseña?");
        labelOlvidaste.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelOlvidaste.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                labelOlvidasteMouseDragged(evt);
            }
        });
        labelOlvidaste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelOlvidasteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelOlvidasteMouseEntered(evt);
            }
        });
        panelLogin.add(labelOlvidaste, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, -1, 20));

        jLabel8.setFont(new java.awt.Font("Duralith", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("¿No tienes una cuenta?");
        panelLogin.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, -1, -1));

        labelOjo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/verDisable.png"))); // NOI18N
        labelOjo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelOjo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelOjoMouseClicked(evt);
            }
        });
        panelLogin.add(labelOjo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 355, 30, 30));

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setFont(new java.awt.Font("Duralith", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setText("Contraseña");
        txtPassword.setBorder(null);
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
        });
        panelLogin.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 355, 180, 30));

        txtUser.setBackground(new java.awt.Color(255, 255, 255));
        txtUser.setFont(new java.awt.Font("Duralith", 0, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(0, 0, 0));
        txtUser.setText("Nombre de Usuario");
        txtUser.setBorder(null);
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserMouseClicked(evt);
            }
        });
        panelLogin.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 305, 220, 30));

        btnIniciarSesion.setBackground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setFont(new java.awt.Font("Duralith", 1, 10)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(0, 0, 0));
        btnIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciar_HOME.png"))); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIniciarSesion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciarPressed_HOME.png"))); // NOI18N
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        panelLogin.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 110, 35));

        jLabel5.setFont(new java.awt.Font("Duralith", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 11, 26));
        jLabel5.setText("BIENVENIDO");
        panelLogin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoWhite_LOGIN.png"))); // NOI18N
        panelLogin.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 180, 110));

        jLabel6.setFont(new java.awt.Font("Duralith", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 11, 26));
        jLabel6.setText("Ingresa con tu cuenta");
        panelLogin.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/interfaz_LOGIN.png"))); // NOI18N
        panelLogin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, -1));

        getContentPane().add(panelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 278, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMouseClicked
        txtUser.setText("");
    }//GEN-LAST:event_txtUserMouseClicked

    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
        txtPassword.setText("");
    }//GEN-LAST:event_txtPasswordMouseClicked

    private void labelOjoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOjoMouseClicked
        if (verPass == 0) {
            txtPassword.setEchoChar((char) 0);
            labelOjo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/verEnable.png")));
            verPass = 1;
        } else {
            txtPassword.setEchoChar('*');
            labelOjo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/verDisable.png")));
            verPass = 0;
        }
    }//GEN-LAST:event_labelOjoMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        txtUser.setText("Nombre de Usuario");
        txtPassword.setText("Contraseña");
    }//GEN-LAST:event_btnRefreshActionPerformed
    int xx, xy;
    private void panelLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLoginMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_panelLoginMousePressed

    private void panelLoginMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLoginMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - xx, y - xy);
    }//GEN-LAST:event_panelLoginMouseDragged

    private void labelOlvidasteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOlvidasteMouseEntered

    }//GEN-LAST:event_labelOlvidasteMouseEntered

    private void labelOlvidasteMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOlvidasteMouseDragged

    }//GEN-LAST:event_labelOlvidasteMouseDragged

    private void labelOlvidasteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOlvidasteMouseClicked
        JOptionPane.showMessageDialog(this, "Paila, se jodió.");
    }//GEN-LAST:event_labelOlvidasteMouseClicked

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        vistaHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        try {
            String usuario = txtUser.getText();
            String password = txtPassword.getText();
            Usuario user = vistaHome.getControladorHacienda().buscarUsuario(usuario, password);
            if (user != null) {
                if (user instanceof Administrador) {
                    vistaHome.ID_Login = vistaHome.ADMINISTRADOR;
                    VistaAdmin vistaAdmin = new VistaAdmin(vistaHome);
                    vistaAdmin.setVisible(true);
                } else if (user instanceof Veterinario) {
                    vistaHome.ID_Login = vistaHome.VETERINARIO;
                    VistaVeterinario vistaVeterinario = new VistaVeterinario(vistaHome);
                    vistaVeterinario.setVisible(true);
                } else {
                    if (user instanceof CriadorCerdos) {
                        vistaHome.ID_Login = vistaHome.PORCINO;
                        vistaHome.terreno = vistaHome.POCILGA;
                    } else if (user instanceof EncargadoGanado) {
                        vistaHome.ID_Login = vistaHome.BOVINO;
                        vistaHome.terreno = vistaHome.LOTE;
                    } else if (user instanceof EncargadoCaballos) {
                        vistaHome.ID_Login = vistaHome.EQUINO;
                        vistaHome.terreno = vistaHome.PESEBRERA;
                    }
                    VistaTerreno vistaTerreno = new VistaTerreno(vistaHome);
                    vistaTerreno.setVisible(true);
                }
                this.dispose();
            } else {
                throw new DatosErroneosException();
            }
        } catch (DatosErroneosException ex) {
            mostrarMensaje(ex.getMessage(), "Datos Erróneos");
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    public void mostrarMensaje(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE,
                new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoBlack_Pequeño.png")));
    }

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
    //            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (InstantiationException ex) {
    //            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (IllegalAccessException ex) {
    //            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        }
    //        //</editor-fold>
    //
    //        /* Create and display the form */
    ////        java.awt.EventQueue.invokeLater(new Runnable() {
    ////            public void run() {
    ////                new VistaLogin().setVisible(true);
    ////            }
    ////        });
    //    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel labelOjo;
    private javax.swing.JLabel labelOlvidaste;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}