/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.sun.awt.AWTUtilities;
import java.awt.Frame;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.table.DefaultTableModel;
import modelo.Bovino;
import modelo.CuidadoEquino;
import modelo.DiagnosticoClinico;
import modelo.Equino;
import modelo.FacturaVenta;
import modelo.Porcino;
import modelo.Premio;
import modelo.RazonEliminacion;
import modelo.pila.AccionRealizadaCuidado;
import modelo.pila.AccionRealizadaPremio;

/**
 *
 * @author andre
 */
public class VistaInformativa extends javax.swing.JFrame {

    VistaHome vistaHome;
    int desicion;
    int codigoAnimal;
    boolean equinoPC;
    int numeroTerreno;
    int fila;
    int columna;
    DefaultTableModel modeloEliminados;
    DefaultTableModel modeloVendidos;
    DefaultTableModel modeloPremios;
    DefaultTableModel modeloCuidados;
    DefaultTableModel modeloHistorialClinico;

    /**
     * Creates new form VistaVYE
     */
    public VistaInformativa(VistaHome vistaHome, int desicion, int codigoAnimal, boolean equinoPC, int numeroTerreno, int fila, int columna) {
        initComponents();
        setLocationRelativeTo(this);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 20, 20);
        AWTUtilities.setWindowShape(this, forma);
        this.vistaHome = vistaHome;
        this.desicion = desicion;
        this.codigoAnimal = codigoAnimal;
        this.equinoPC = equinoPC;
        this.numeroTerreno = numeroTerreno;
        this.fila = fila;
        this.columna = columna;
        if (desicion == 0) {
            titulo.setText("Registro de Eliminaciones");
            btnAñadir.setVisible(false);
            modeloEliminados = new DefaultTableModel();
            modeloEliminados.addColumn("Tipo");
            modeloEliminados.addColumn("Código");
            modeloEliminados.addColumn("Género");
            modeloEliminados.addColumn("Razón");
            tablaInformativa.setModel(modeloEliminados);
            btnAtras.setVisible(false);
            btnAdelante.setVisible(false);
            llenarTablaEliminados();
        } else if (desicion == 1) {
            btnAñadir.setVisible(false);
            btnAtras.setVisible(false);
            btnAdelante.setVisible(false);
            titulo.setText("Registro de Ventas");
            modeloVendidos = new DefaultTableModel();
            modeloVendidos.addColumn("Tipo");
            modeloVendidos.addColumn("Código");
            modeloVendidos.addColumn("Género");
            modeloVendidos.addColumn("Valor");
            modeloVendidos.addColumn("Cédula Comprador");
            tablaInformativa.setModel(modeloVendidos);
            llenarTablaVendidos();
        } else if (desicion == 2) {
            btnAtras.setVisible(true);
            btnAdelante.setVisible(true);
            btnAñadir.setVisible(true);
            titulo.setText("Registro de Premios");
            modeloPremios = new DefaultTableModel();
            modeloPremios.addColumn("Código Equino");
            modeloPremios.addColumn("Tipo");
            modeloPremios.addColumn("Título");
            modeloPremios.addColumn("Año");
            tablaInformativa.setModel(modeloPremios);
            llenarTablaPremios();
        } else if (desicion == 3) {
            btnAtras.setVisible(true);
            btnAdelante.setVisible(true);
            btnAñadir.setVisible(true);
            titulo.setText("Registro de Cuidados");
            modeloCuidados = new DefaultTableModel();
            modeloCuidados.addColumn("Código Equino");
            modeloCuidados.addColumn("Cuidado Realizado");
            modeloCuidados.addColumn("Año");
            tablaInformativa.setModel(modeloCuidados);
            llenarTablaCuidados();
        } else if (desicion == 4) {
            btnAtras.setVisible(false);
            btnAdelante.setVisible(false);
            btnAñadir.setVisible(false);
            titulo.setText("Historial Clínico");
            modeloHistorialClinico = new DefaultTableModel();
            modeloHistorialClinico.addColumn("Código");
            modeloHistorialClinico.addColumn("Fecha");
            modeloHistorialClinico.addColumn("Hora");
            modeloHistorialClinico.addColumn("Tipo de Observación");
            modeloHistorialClinico.addColumn("Observación");
            tablaInformativa.setModel(modeloHistorialClinico);
            llenarTablaHistorialClinico();
        }
    }

    public void llenarTablaEliminados() {
// Tipo, Código, Género, Razón
        int totalEliminaciones = vistaHome.getControladorVYE().getSizeRazon();
        for (int i = 0; i < totalEliminaciones; i++) {
            RazonEliminacion razonEliminacion = vistaHome.getControladorVYE().getRazon(i);
            String[] info = new String[4];
            if (vistaHome.terreno.equals(vistaHome.LOTE)) {
                if (razonEliminacion.getAnimalEliminado() instanceof Bovino) {
                    Bovino bovino = (Bovino) razonEliminacion.getAnimalEliminado();
                    info[0] = "Bovino";
                    info[1] = "BO" + String.valueOf(bovino.getCodigo());
                    info[2] = bovino.getSexo();
                    info[3] = razonEliminacion.getRazon();
                    modeloEliminados.addRow(info);
                }
            } else if (vistaHome.terreno.equals(vistaHome.PESEBRERA)) {
                if (razonEliminacion.getAnimalEliminado() instanceof Equino) {
                    Equino equino = (Equino) razonEliminacion.getAnimalEliminado();
                    info[0] = "Equino";
                    info[1] = "EQ" + String.valueOf(equino.getCodigo());
                    info[2] = equino.getSexo();
                    info[3] = razonEliminacion.getRazon();
                    modeloEliminados.addRow(info);
                }
            } else {
                if (razonEliminacion.getAnimalEliminado() instanceof Porcino) {
                    Porcino porcino = (Porcino) razonEliminacion.getAnimalEliminado();
                    info[0] = "Porcino";
                    info[1] = "PO" + String.valueOf(porcino.getCodigo());
                    info[2] = porcino.getSexo();
                    info[3] = razonEliminacion.getRazon();
                    modeloEliminados.addRow(info);
                }
            }
        }
    }

    public void llenarTablaVendidos() {
// Tipo, Código, Género, Valor, Cédula Comprador
        int totalFacturas = vistaHome.getControladorVYE().getSizeFactura();
        for (int i = 0; i < totalFacturas; i++) {
            FacturaVenta facturaVenta = vistaHome.getControladorVYE().getFactura(i);
            String[] info = new String[5];
            if (vistaHome.terreno.equals(vistaHome.LOTE)) {
                if (facturaVenta.getAnimalVendido() instanceof Bovino) {
                    Bovino bovino = (Bovino) facturaVenta.getAnimalVendido();
                    info[0] = "Bovino";
                    info[1] = "BO" + String.valueOf(bovino.getCodigo());
                    info[2] = bovino.getSexo();
                    info[3] = String.valueOf(facturaVenta.getValor());
                    info[4] = facturaVenta.getComprador().getDocumento();
                    modeloVendidos.addRow(info);
                }
            } else if (vistaHome.terreno.equals(vistaHome.PESEBRERA)) {
                if (facturaVenta.getAnimalVendido() instanceof Equino) {
                    Equino equino = (Equino) facturaVenta.getAnimalVendido();
                    info[0] = "Equino";
                    info[1] = "EQ" + String.valueOf(equino.getCodigo());
                    info[2] = equino.getSexo();
                    info[3] = String.valueOf(facturaVenta.getValor());
                    info[4] = facturaVenta.getComprador().getDocumento();
                    modeloVendidos.addRow(info);
                }
            } else {
                if (facturaVenta.getAnimalVendido() instanceof Porcino) {
                    Porcino porcino = (Porcino) facturaVenta.getAnimalVendido();
                    info[0] = "Porcino";
                    info[1] = "PO" + String.valueOf(porcino.getCodigo());
                    info[2] = porcino.getSexo();
                    info[3] = String.valueOf(facturaVenta.getValor());
                    info[4] = facturaVenta.getComprador().getDocumento();
                    modeloVendidos.addRow(info);
                }
            }
        }
    }

    public void llenarTablaPremios() {
        //Código, Tipo, Título, Año
        int totalPremios = vistaHome.getControladorDPC().getSizePremios();
        for (int i = 0; i < totalPremios; i++) {
            Premio premio = vistaHome.getControladorDPC().getPremio(i);
            if (premio.getCodigoEquino() == codigoAnimal) {
                String[] info = new String[4];
                info[0] = "EQ" + premio.getCodigoEquino();
                info[1] = premio.getTipo();
                info[2] = premio.getTitulo();
                info[3] = premio.getYear();
                modeloPremios.addRow(info);
            }
        }
    }

    public void limpiarTablaPremios() {
        for (int i = 0; i < modeloPremios.getRowCount(); i++) {
            modeloPremios.setRowCount(0);
        }
    }

    public void llenarTablaCuidados() {
        //Código, Cuidad, Año
        int totalCuidados = vistaHome.getControladorDPC().getSizeCuidados();
        for (int i = 0; i < totalCuidados; i++) {
            CuidadoEquino cuidado = vistaHome.getControladorDPC().getCuidado(i);
            if (cuidado.getCodigoEquino() == codigoAnimal) {
                String[] info = new String[3];
                info[0] = "EQ" + cuidado.getCodigoEquino();
                info[1] = cuidado.getCuidadoRealizado();
                info[2] = cuidado.getYear();
                modeloCuidados.addRow(info);
            }
        }
    }

    public void llenarTablaHistorialClinico() {
        //Codigo, Fecha, Hora, TipoObservación, Observación
        int totalDiagnosticos = vistaHome.getControladorVeterinario().getSizeDiagnosticos();
        for (int i = 0; i < totalDiagnosticos; i++) {
            DiagnosticoClinico diagnostico = vistaHome.getControladorVeterinario().obtenerDiagnostico(i);
            if (diagnostico.getCodigoAnimal() == codigoAnimal) {
                String[] info = new String[5];
                if (vistaHome.terreno.equals(vistaHome.LOTE)) {
                    info[0] = "BO" + diagnostico.getCodigoAnimal();
                } else if (vistaHome.terreno.equals(vistaHome.PESEBRERA)) {
                    info[0] = "EQ" + diagnostico.getCodigoAnimal();
                } else {
                    info[0] = "PO" + diagnostico.getCodigoAnimal();
                }
                info[1] = diagnostico.getFecha();
                info[2] = diagnostico.getHora();
                info[3] = diagnostico.getTipoObservacion();
                info[4] = diagnostico.getObservacion();
                modeloHistorialClinico.addRow(info);
            }
        }
    }

    public void limpiarTablaCuidados() {
        for (int i = 0; i < modeloCuidados.getRowCount(); i++) {
            modeloCuidados.setRowCount(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInformativa = new javax.swing.JTable();
        btnAñadir = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnAdelante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCerrar.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCerrar_Click.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMinimizar.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMinimizar_Click.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 465, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 20));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVolverDos.png"))); // NOI18N
        btnVolver.setToolTipText("Volver");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVolverPressedDos.png"))); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        titulo.setFont(new java.awt.Font("Duralith", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Registro de");
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablaInformativa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaInformativa);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 470, 290));

        btnAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAñadir.png"))); // NOI18N
        btnAñadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAñadir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAñadir_Pressed.png"))); // NOI18N
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });
        jPanel1.add(btnAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 30, 30));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRetroceder.png"))); // NOI18N
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRetroceder_Pressed.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 30, 30));

        btnAdelante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAdelantar.png"))); // NOI18N
        btnAdelante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdelante.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAdelantar_Pressed.png"))); // NOI18N
        btnAdelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdelanteActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdelante, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 510, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jButton2ActionPerformed
    int xx, xy;
    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if (desicion >= 2) {
            vistaHome.getControladorPila().resetPremioAction();
            vistaHome.getControladorPila().resetPremioActionDos();
            vistaHome.getControladorPila().resetCuidadoAction();
            vistaHome.getControladorPila().resetCuidadoActionDos();
            VistaGestionAnimales vistaGestionAnimales = new VistaGestionAnimales(vistaHome, numeroTerreno, fila, columna);
            vistaGestionAnimales.setVisible(true);
            this.dispose();
        } else {
            VistaTerreno vistaTerreno = new VistaTerreno(vistaHome);
            vistaTerreno.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        if (desicion == 2) {
            VistaFormularioPremioCuidado dialog = new VistaFormularioPremioCuidado(new javax.swing.JFrame(), true, vistaHome, codigoAnimal, 0);
            dialog.setVisible(true);
            limpiarTablaPremios();
            llenarTablaPremios();
        } else {
            VistaFormularioPremioCuidado dialog = new VistaFormularioPremioCuidado(new javax.swing.JFrame(), true, vistaHome, codigoAnimal, 1);
            dialog.setVisible(true);
            limpiarTablaCuidados();
            llenarTablaCuidados();
        }

    }//GEN-LAST:event_btnAñadirActionPerformed

    public void eliminar() {

    }

    public void registrar(AccionRealizadaPremio x) {

    }

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        if (desicion == 2) {
            if (vistaHome.getControladorPila().isEmptyPremioAction() == false) {
                AccionRealizadaPremio x = vistaHome.getControladorPila().popPremioAction();
                if (x.getAction().equals(AccionRealizadaPremio.actionRegistrar)) {
                    Premio premioEliminar = vistaHome.getControladorDPC().getPremio(vistaHome.getControladorDPC().getSizePremios() - 1);
                    vistaHome.getControladorDPC().eliminarPremio(vistaHome.getControladorDPC().getSizePremios() - 1);
                    AccionRealizadaPremio accion = new AccionRealizadaPremio(premioEliminar, AccionRealizadaPremio.actionEliminar);
                    vistaHome.getControladorPila().pushPremioActionDos(accion);
                    limpiarTablaPremios();
                    llenarTablaPremios();
                } else if (x.getAction().equals(AccionRealizadaPremio.actionEliminar)) {
                    Premio premioRegistrar = x.getPremio();
                    vistaHome.getControladorDPC().añadirPremio(premioRegistrar);
                    AccionRealizadaPremio accion = new AccionRealizadaPremio(premioRegistrar, AccionRealizadaPremio.actionRegistrar);
                    vistaHome.getControladorPila().pushPremioActionDos(accion);
                    limpiarTablaPremios();
                    llenarTablaPremios();
                }
            }
        } else if (desicion == 3) {
            if (vistaHome.getControladorPila().isEmptyCuidadoAction() == false) {
                AccionRealizadaCuidado x = vistaHome.getControladorPila().popCuidadoAction();
                if (x.getAccion().equals(AccionRealizadaCuidado.actionRegistrar)) {
                    CuidadoEquino cuidadoEliinar = vistaHome.getControladorDPC().getCuidado(vistaHome.getControladorDPC().getSizeCuidados() - 1);
                    vistaHome.getControladorDPC().eliminarCuidado(vistaHome.getControladorDPC().getSizeCuidados() - 1);
                    AccionRealizadaCuidado accion = new AccionRealizadaCuidado(cuidadoEliinar, AccionRealizadaCuidado.actionEliminar);
                    vistaHome.getControladorPila().pushCuidadoActionDos(accion);
                    limpiarTablaCuidados();
                    llenarTablaCuidados();
                } else if (x.getAccion().equals(AccionRealizadaCuidado.actionEliminar)) {
                    CuidadoEquino cuidadoRegistrar = x.getCuidado();
                    vistaHome.getControladorDPC().añadirCuidado(cuidadoRegistrar);
                    AccionRealizadaCuidado accion = new AccionRealizadaCuidado(cuidadoRegistrar, AccionRealizadaCuidado.actionRegistrar);
                    vistaHome.getControladorPila().pushCuidadoActionDos(accion);
                    limpiarTablaCuidados();
                    llenarTablaCuidados();
                }
            }
        }
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdelanteActionPerformed
        if (desicion == 2) {
            if (vistaHome.getControladorPila().isEmptyPremioActionDos() == false) {
                AccionRealizadaPremio x = vistaHome.getControladorPila().popPremioActionDos();
                if (x.getAction().equals(AccionRealizadaPremio.actionEliminar)) {
                    Premio premioRegistrar = x.getPremio();
                    vistaHome.getControladorDPC().añadirPremio(premioRegistrar);
                    AccionRealizadaPremio accion = new AccionRealizadaPremio(premioRegistrar, AccionRealizadaPremio.actionRegistrar);
                    vistaHome.getControladorPila().pushPremioAction(accion);
                    limpiarTablaPremios();
                    llenarTablaPremios();
                } else if (vistaHome.getControladorPila().equals(AccionRealizadaPremio.actionRegistrar)) {
                    Premio premioEliminar = vistaHome.getControladorDPC().getPremio(vistaHome.getControladorDPC().getSizePremios() - 1);
                    vistaHome.getControladorDPC().eliminarPremio(vistaHome.getControladorDPC().getSizePremios() - 1);
                    AccionRealizadaPremio accion = new AccionRealizadaPremio(premioEliminar, AccionRealizadaPremio.actionEliminar);
                    vistaHome.getControladorPila().pushPremioAction(accion);
                    limpiarTablaPremios();
                    llenarTablaPremios();
                }
            }
        } else if (desicion == 3) {
            if (vistaHome.getControladorPila().isEmptyCuidadoActionDos() == false) {
                AccionRealizadaCuidado x = vistaHome.getControladorPila().popCuidadoActionDos();
                if (x.getAccion().equals(AccionRealizadaCuidado.actionRegistrar)) {
                    CuidadoEquino cuidadoEliinar = vistaHome.getControladorDPC().getCuidado(vistaHome.getControladorDPC().getSizeCuidados() - 1);
                    vistaHome.getControladorDPC().eliminarCuidado(vistaHome.getControladorDPC().getSizeCuidados() - 1);
                    AccionRealizadaCuidado accion = new AccionRealizadaCuidado(cuidadoEliinar, AccionRealizadaCuidado.actionEliminar);
                    vistaHome.getControladorPila().pushCuidadoAction(accion);
                    limpiarTablaCuidados();
                    llenarTablaCuidados();
                } else if (x.getAccion().equals(AccionRealizadaCuidado.actionEliminar)) {
                    CuidadoEquino cuidadoRegistrar = x.getCuidado();
                    vistaHome.getControladorDPC().añadirCuidado(cuidadoRegistrar);
                    AccionRealizadaCuidado accion = new AccionRealizadaCuidado(cuidadoRegistrar, AccionRealizadaCuidado.actionRegistrar);
                    vistaHome.getControladorPila().pushCuidadoAction(accion);
                    limpiarTablaCuidados();
                    llenarTablaCuidados();
                }
            }
        }
    }//GEN-LAST:event_btnAdelanteActionPerformed

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
//            java.util.logging.Logger.getLogger(VistaInformativa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VistaInformativa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VistaInformativa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VistaInformativa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VistaInformativa().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdelante;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaInformativa;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
