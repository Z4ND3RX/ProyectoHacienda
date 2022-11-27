/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.sun.awt.AWTUtilities;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import excepciones.BovinoNoSeleccionadoException;
import excepciones.CitaPendienteVeterinario;
import excepciones.PorcinoNoLiberadoException;
import excepciones.CriaNoSeleccionadaException;
import excepciones.EquinoNoSeleccionadoException;
import excepciones.LoteLlenoException;
import excepciones.PesebreraLlenaException;
import excepciones.PesoNoValidoException;
import excepciones.PocilgaLlenaException;
import excepciones.PocilgaSoloParaCriasException;
import excepciones.PorcinoAmamantandoException;
import excepciones.PorcinoNoSeleccionadoException;
import java.awt.Frame;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Animal;
import modelo.Bovino;
import modelo.CuidadoEquino;
import modelo.DiagnosticoClinico;
import modelo.Equino;
import modelo.FacturaVenta;
import modelo.Lote;
import modelo.Pesebrera;
import modelo.Pocilga;
import modelo.Porcino;
import modelo.Premio;
import modelo.RazonEliminacion;
import modelo.pila.AccionRealizadaAnimal;
import modelo.pila.AccionRealizadaCuidado;
import modelo.pila.AccionRealizadaDiagnostico;
import modelo.pila.AccionRealizadaEliminacion;
import modelo.pila.AccionRealizadaPremio;
import modelo.pila.AccionRealizadaVenta;

/**
 *
 * @author andre
 */
public class VistaGestionAnimales extends javax.swing.JFrame {

    VistaHome vistaHome;
    DefaultTableModel modeloBovino;
    DefaultTableModel modeloEquino;
    DefaultTableModel modeloPorcino;
    DefaultTableModel modeloMasLecheras;
    DefaultTableModel modeloMenosLecheras;
    int fila;
    int columna;
    int numeroTerreno;

    /**
     * Creates new form VistaGestionAnimales
     */
    public VistaGestionAnimales(VistaHome vistaHome, int numeroTerreno, int fila, int columna) {
        initComponents();
        setLocationRelativeTo(this);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 20, 20);
        AWTUtilities.setWindowShape(this, forma);
        this.vistaHome = vistaHome;
        this.fila = fila;
        this.columna = columna;
        this.numeroTerreno = numeroTerreno;
        if (vistaHome.terreno.equals(vistaHome.LOTE)) {
            titulo.setText("Gestión de Lote");
            Lote lote = vistaHome.getControladorTerreno().obtenerLote(fila, columna);
            btnPremios.setVisible(false);
            btnCuidados.setVisible(false);
            btnLiberarCrias.setVisible(false);
            if (lote.getSexoAnimales().equals(Bovino.HEMBRA)) {
                btnOrdeño.setVisible(true);
                panelMasLecheras.setVisible(true);
                panelMenosLecheras.setVisible(true);
                modeloMasLecheras = new DefaultTableModel();
                modeloMasLecheras.addColumn("Lote");
                modeloMasLecheras.addColumn("Nombre");
                modeloMasLecheras.addColumn("Código");
                modeloMasLecheras.addColumn("Total Leche Producida");
                this.tablaMasLecheras.setModel(modeloMasLecheras);
                llenarTablaMasLecheras();
                modeloMenosLecheras = new DefaultTableModel();
                modeloMenosLecheras.addColumn("Lote");
                modeloMenosLecheras.addColumn("Nombre");
                modeloMenosLecheras.addColumn("Código");
                modeloMenosLecheras.addColumn("Total Leche Producida");
                this.tablaMenosLecheras.setModel(modeloMenosLecheras);
                llenarTablaMenosLecheras();
            } else {
                btnOrdeño.setVisible(false);
                panelMasLecheras.setVisible(false);
                panelMenosLecheras.setVisible(false);
            }
            modeloBovino = new DefaultTableModel();
            modeloBovino.addColumn("index");
            modeloBovino.addColumn("Nombre");
            modeloBovino.addColumn("Código");
            modeloBovino.addColumn("Género");
            modeloBovino.addColumn("Peso (Kg)");
            modeloBovino.addColumn("Edad (años)");
            modeloBovino.addColumn("Leche producidad (L)");
            modeloBovino.addColumn("Total Leche Producida");
            this.tablaAnimales.setModel(modeloBovino);
            llenarTablaBonivos();
        } else if (vistaHome.terreno.equals(vistaHome.POCILGA)) {
            btnPremios.setVisible(false);
            btnCuidados.setVisible(false);
            btnOrdeño.setVisible(false);
            panelMasLecheras.setVisible(false);
            panelMenosLecheras.setVisible(false);
            Pocilga pocilga = vistaHome.getControladorTerreno().obtenerPocilga(fila, columna);
            if (pocilga.isCrias()) {
                btnLiberarCrias.setVisible(true);
                btnAñadir.setVisible(false);
            } else {
                btnLiberarCrias.setVisible(false);
            }
            titulo.setText("Gestión de Pocilga");
            modeloPorcino = new DefaultTableModel();
            modeloPorcino.addColumn("index");
            modeloPorcino.addColumn("Nombre");
            modeloPorcino.addColumn("Código");
            modeloPorcino.addColumn("Tipo");
            modeloPorcino.addColumn("Peso (kg)");
            modeloPorcino.addColumn("Edad (años)");
            modeloPorcino.addColumn("Amamanta");
            this.tablaAnimales.setModel(modeloPorcino);
            llenarTablaPorcinos();
        } else if (vistaHome.terreno.equals(vistaHome.PESEBRERA)) {
            btnPremios.setVisible(true);
            btnCuidados.setVisible(true);
            btnOrdeño.setVisible(false);
            btnLiberarCrias.setVisible(false);
            panelMasLecheras.setVisible(false);
            panelMenosLecheras.setVisible(false);
            titulo.setText("Gestión de Pesebrera");
            modeloEquino = new DefaultTableModel();
            modeloEquino.addColumn("index");
            modeloEquino.addColumn("Nombre");
            modeloEquino.addColumn("Código");
            modeloEquino.addColumn("Género");
            modeloEquino.addColumn("Peso (kg)");
            modeloEquino.addColumn("Edad (años)");
            modeloEquino.addColumn("Premiado");
            this.tablaAnimales.setModel(modeloEquino);
            llenarTablaEquinos();
        }
    }

    public int ValidarSeleccion() throws BovinoNoSeleccionadoException, EquinoNoSeleccionadoException, PorcinoNoSeleccionadoException {
        int select = -1;
        select = tablaAnimales.getSelectedRow();
        if (select == -1) {
            if (vistaHome.terreno.equals(vistaHome.LOTE)) {
                throw new BovinoNoSeleccionadoException();
            } else if (vistaHome.terreno.equals(vistaHome.PESEBRERA)) {
                throw new EquinoNoSeleccionadoException();
            } else {
                throw new PorcinoNoSeleccionadoException();
            }
        }
        return select;
    }

    public void llenarTablaBonivos() {
// index, Nombre, Código, Género, Peso, Edad, Litros LP (Leche Producida), TLP 
        int totalAnimales = vistaHome.getControladorTerreno().getSize();
        for (int i = 0; i < totalAnimales; i++) {
            if (vistaHome.getControladorTerreno().getAnimal(i) instanceof Bovino) {
                Bovino bovino = (Bovino) vistaHome.getControladorTerreno().getAnimal(i);
                if (bovino.getNumeroLote() == numeroTerreno) {
                    String[] info = new String[8];
                    info[0] = String.valueOf(i);
                    info[1] = bovino.getNombre();
                    info[2] = Bovino.INDICATIVO + String.valueOf(bovino.getCodigo());
                    info[3] = bovino.getSexo();
                    info[4] = String.valueOf(bovino.getPeso());
                    info[5] = String.valueOf(bovino.getEdad());
                    info[6] = String.valueOf(bovino.getLitrosLecheProducida());
                    info[7] = String.valueOf(bovino.getLitrosLecheTotalProducida());
                    modeloBovino.addRow(info);
                }
            }
        }
        tablaAnimales.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaAnimales.getColumnModel().getColumn(0).setMinWidth(0);
        tablaAnimales.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tablaAnimales.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        if (vistaHome.getControladorTerreno().obtenerLote(fila, columna).getSexoAnimales().equals(Bovino.MACHO)) {
            tablaAnimales.getColumnModel().getColumn(6).setMaxWidth(0);
            tablaAnimales.getColumnModel().getColumn(6).setMinWidth(0);
            tablaAnimales.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
            tablaAnimales.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
            tablaAnimales.getColumnModel().getColumn(7).setMaxWidth(0);
            tablaAnimales.getColumnModel().getColumn(7).setMinWidth(0);
            tablaAnimales.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
            tablaAnimales.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
        }
    }

    public int obtenerTotalVacas() {
        int total = 0;
        for (int i = 0; i < vistaHome.getControladorTerreno().getSize(); i++) {
            if (vistaHome.getControladorTerreno().getAnimal(i) instanceof Bovino
                    && vistaHome.getControladorTerreno().getAnimal(i).getSexo().equals(Bovino.HEMBRA)) {
                total++;
            }
        }
        return total;
    }

    public void llenarTablaMasLecheras() {
        //Lote, Nombre, Código, Leche TotalProducida
        int totalAnimales = vistaHome.getControladorTerreno().getSize();
        for (int i = 0; i < totalAnimales; i++) {
            if (vistaHome.getControladorTerreno().getAnimal(i) instanceof Bovino) {
                Bovino bovino = (Bovino) vistaHome.getControladorTerreno().getAnimal(i);
                if (bovino.getSexo().equals(Bovino.HEMBRA)) {
                    String[] info = new String[4];
                    info[0] = String.valueOf(bovino.getNumeroLote());
                    info[1] = bovino.getNombre();
                    info[2] = Bovino.INDICATIVO + String.valueOf(bovino.getCodigo());
                    info[3] = String.valueOf(bovino.getLitrosLecheTotalProducida());
                    modeloMasLecheras.addRow(info);
                }
            }
        }
    }

    public void llenarTablaMenosLecheras() {
        //Lote, Nombre, Código, Leche TotalProducida
        int totalAnimales = vistaHome.getControladorTerreno().getSize();
        for (int i = totalAnimales -1; i >= 0; i--) {
            if (vistaHome.getControladorTerreno().getAnimal(i) instanceof Bovino) {
                Bovino bovino = (Bovino) vistaHome.getControladorTerreno().getAnimal(i);
                if (bovino.getSexo().equals(Bovino.HEMBRA)) {
                    String[] info = new String[4];
                    info[0] = String.valueOf(bovino.getNumeroLote());
                    info[1] = bovino.getNombre();
                    info[2] = Bovino.INDICATIVO + String.valueOf(bovino.getCodigo());
                    info[3] = String.valueOf(bovino.getLitrosLecheTotalProducida());
                    modeloMenosLecheras.addRow(info);
                }
            }
        }
    }

    public void llenarTablaEquinos() {
// index, nombre, Código, Género, Peso, Edad, Premiado
        int totalAnimales = vistaHome.getControladorTerreno().getSize();
        for (int i = 0; i < totalAnimales; i++) {
            if (vistaHome.getControladorTerreno().getAnimal(i) instanceof Equino) {
                Equino equino = (Equino) vistaHome.getControladorTerreno().getAnimal(i);
                if (equino.getNumeroPesebrera() == numeroTerreno) {
                    String[] info = new String[7];
                    info[0] = String.valueOf(i);
                    info[1] = equino.getNombre();
                    info[2] = Equino.INDICATIVO + String.valueOf(equino.getCodigo());
                    info[3] = equino.getSexo();
                    info[4] = String.valueOf(equino.getPeso());
                    info[5] = String.valueOf(equino.getEdad());
                    if (equino.isPremiado()) {
                        info[6] = "Si";
                    } else {
                        info[6] = "No";
                    }
                    modeloEquino.addRow(info);
                }
            }
        }
        tablaAnimales.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaAnimales.getColumnModel().getColumn(0).setMinWidth(0);
        tablaAnimales.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tablaAnimales.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    }

    public void llenarTablaPorcinos() {
// index, nombre, Código, Tipo, Peso, Edad, Amamanta
        int totalAnimales = vistaHome.getControladorTerreno().getSize();
        for (int i = 0; i < totalAnimales; i++) {
            if (vistaHome.getControladorTerreno().getAnimal(i) instanceof Porcino) {
                Porcino porcino = (Porcino) vistaHome.getControladorTerreno().getAnimal(i);
                if (porcino.getNumeroPocilga() == numeroTerreno) {
                    String[] info = new String[7];
                    info[0] = String.valueOf(i);
                    info[1] = porcino.getNombre();
                    info[2] = Porcino.INDICATIVO + String.valueOf(porcino.getCodigo());
                    info[3] = porcino.getSexo();
                    info[4] = String.valueOf(porcino.getPeso());
                    info[5] = String.valueOf(porcino.getEdad());
                    if (porcino.isAmamanta()) {
                        info[6] = "Si";
                    } else {
                        info[6] = "No";
                    }
                    modeloPorcino.addRow(info);
                }
            }
        }
        tablaAnimales.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaAnimales.getColumnModel().getColumn(0).setMinWidth(0);
        tablaAnimales.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tablaAnimales.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        if (vistaHome.getControladorTerreno().obtenerPocilga(fila, columna).isCrias()) {
            btnAñadir.setEnabled(false);
        }
    }

    public void limpiarTablaBovinos() {
        for (int i = 0; i < modeloBovino.getRowCount(); i++) {
            modeloBovino.setRowCount(0);
        }
    }

    public void limpiarTablaEquinos() {
        for (int i = 0; i < modeloEquino.getRowCount(); i++) {
            modeloEquino.setRowCount(0);
        }
    }

    public void limpiarTablaPorcinos() {
        for (int i = 0; i < modeloPorcino.getRowCount(); i++) {
            modeloPorcino.setRowCount(0);
        }
    }

    public void mostrarMensaje(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE,
                new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoBlack_Pequeño.png")));
    }

    public int mensajeConfirmacion(String mensaje) {
        return JOptionPane.showConfirmDialog(this, mensaje, "Confirmación",
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.OK_CANCEL_OPTION, new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoBlack_Pequeño.png")));
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAnimales = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnAñadir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVeterinario = new javax.swing.JButton();
        btnHistorialClinico = new javax.swing.JButton();
        panelMenosLecheras = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaMenosLecheras = new javax.swing.JTable();
        panelMasLecheras = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMasLecheras = new javax.swing.JTable();
        titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCuidados = new javax.swing.JButton();
        btnPremios = new javax.swing.JButton();
        btnOrdeño = new javax.swing.JButton();
        btnLiberarCrias = new javax.swing.JButton();
        btnAdelantar = new javax.swing.JButton();
        btnRetroceder = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(519, 510));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablaAnimales.setBackground(new java.awt.Color(255, 255, 255));
        tablaAnimales.setForeground(new java.awt.Color(0, 0, 0));
        tablaAnimales.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaAnimales);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 71, 480, -1));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVolverDos.png"))); // NOI18N
        btnVolver.setToolTipText("Volver");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVolverPressedDos.png"))); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setFont(new java.awt.Font("Duralith", 0, 11)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciar_HOME.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciarPressed_HOME.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel4.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 60, 110, 35));

        btnAñadir.setBackground(new java.awt.Color(255, 255, 255));
        btnAñadir.setFont(new java.awt.Font("Duralith", 0, 11)); // NOI18N
        btnAñadir.setForeground(new java.awt.Color(0, 0, 0));
        btnAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciar_HOME.png"))); // NOI18N
        btnAñadir.setText("Añadir");
        btnAñadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAñadir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAñadir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciarPressed_HOME.png"))); // NOI18N
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });
        jPanel4.add(btnAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 10, 110, 35));

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Duralith", 0, 11)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciar_HOME.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciarPressed_HOME.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel4.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 110, 110, 35));

        btnVeterinario.setBackground(new java.awt.Color(255, 255, 255));
        btnVeterinario.setFont(new java.awt.Font("Duralith", 0, 11)); // NOI18N
        btnVeterinario.setForeground(new java.awt.Color(0, 0, 0));
        btnVeterinario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciar_HOME.png"))); // NOI18N
        btnVeterinario.setText("Veterinaria");
        btnVeterinario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVeterinario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVeterinario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciarPressed_HOME.png"))); // NOI18N
        btnVeterinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVeterinarioActionPerformed(evt);
            }
        });
        jPanel4.add(btnVeterinario, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 160, 110, 35));

        btnHistorialClinico.setBackground(new java.awt.Color(255, 255, 255));
        btnHistorialClinico.setFont(new java.awt.Font("Duralith", 0, 11)); // NOI18N
        btnHistorialClinico.setForeground(new java.awt.Color(0, 0, 0));
        btnHistorialClinico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciar_HOME.png"))); // NOI18N
        btnHistorialClinico.setText("Historial Clínico");
        btnHistorialClinico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistorialClinico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHistorialClinico.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIniciarPressed_HOME.png"))); // NOI18N
        btnHistorialClinico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialClinicoActionPerformed(evt);
            }
        });
        jPanel4.add(btnHistorialClinico, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 210, 110, 35));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 140, 260));

        panelMenosLecheras.setBackground(new java.awt.Color(255, 255, 255));
        panelMenosLecheras.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Las menos Lecheras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Duralith", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        panelMenosLecheras.setForeground(new java.awt.Color(0, 0, 0));

        tablaMenosLecheras.setBackground(new java.awt.Color(255, 255, 255));
        tablaMenosLecheras.setForeground(new java.awt.Color(0, 0, 0));
        tablaMenosLecheras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablaMenosLecheras);

        javax.swing.GroupLayout panelMenosLecherasLayout = new javax.swing.GroupLayout(panelMenosLecheras);
        panelMenosLecheras.setLayout(panelMenosLecherasLayout);
        panelMenosLecherasLayout.setHorizontalGroup(
            panelMenosLecherasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenosLecherasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMenosLecherasLayout.setVerticalGroup(
            panelMenosLecherasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenosLecherasLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanel1.add(panelMenosLecheras, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, 430, 160));

        panelMasLecheras.setBackground(new java.awt.Color(255, 255, 255));
        panelMasLecheras.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Las más Lecheras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Duralith", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        panelMasLecheras.setForeground(new java.awt.Color(0, 0, 0));

        tablaMasLecheras.setBackground(new java.awt.Color(255, 255, 255));
        tablaMasLecheras.setForeground(new java.awt.Color(0, 0, 0));
        tablaMasLecheras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaMasLecheras);

        javax.swing.GroupLayout panelMasLecherasLayout = new javax.swing.GroupLayout(panelMasLecheras);
        panelMasLecheras.setLayout(panelMasLecherasLayout);
        panelMasLecherasLayout.setHorizontalGroup(
            panelMasLecherasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMasLecherasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMasLecherasLayout.setVerticalGroup(
            panelMasLecherasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMasLecherasLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanel1.add(panelMasLecheras, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 430, 160));

        titulo.setFont(new java.awt.Font("Duralith", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Gestion de");
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGO_HOME.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 440, -1));

        btnCuidados.setBackground(new java.awt.Color(255, 255, 255));
        btnCuidados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCuidados.png"))); // NOI18N
        btnCuidados.setToolTipText("Cuidados");
        btnCuidados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCuidados.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCuidados_Pressed.png"))); // NOI18N
        btnCuidados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuidadosActionPerformed(evt);
            }
        });
        jPanel1.add(btnCuidados, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 40, 40));

        btnPremios.setBackground(new java.awt.Color(255, 255, 255));
        btnPremios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnPremios.png"))); // NOI18N
        btnPremios.setToolTipText("Premios");
        btnPremios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPremios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnPremios_Pressed.png"))); // NOI18N
        btnPremios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPremiosActionPerformed(evt);
            }
        });
        jPanel1.add(btnPremios, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 40, 40));

        btnOrdeño.setBackground(new java.awt.Color(255, 255, 255));
        btnOrdeño.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnLeche.png"))); // NOI18N
        btnOrdeño.setToolTipText("Mandar a Ordeño");
        btnOrdeño.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrdeño.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnLeche_Pressed.png"))); // NOI18N
        btnOrdeño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdeñoActionPerformed(evt);
            }
        });
        jPanel1.add(btnOrdeño, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 40, 40));

        btnLiberarCrias.setBackground(new java.awt.Color(255, 255, 255));
        btnLiberarCrias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnLiberarCrias.png"))); // NOI18N
        btnLiberarCrias.setToolTipText("Liberar Cria");
        btnLiberarCrias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLiberarCrias.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnLiberarCrias_Pressed.png"))); // NOI18N
        btnLiberarCrias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiberarCriasActionPerformed(evt);
            }
        });
        jPanel1.add(btnLiberarCrias, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 40, 40));

        btnAdelantar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAdelantar.png"))); // NOI18N
        btnAdelantar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdelantar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAdelantar_Pressed.png"))); // NOI18N
        btnAdelantar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdelantarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdelantar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 30, 30));

        btnRetroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRetroceder.png"))); // NOI18N
        btnRetroceder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRetroceder.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnRetroceder_Pressed.png"))); // NOI18N
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });
        jPanel1.add(btnRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1140, 400));

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
                .addGap(0, 1095, Short.MAX_VALUE)
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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel2MouseDragged
    int xx, xy;
    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        vistaHome.getControladorPila().resetAnimalAction();
        vistaHome.getControladorPila().resetAnimalActionDos();
        vistaHome.getControladorPila().resetDiagnosticoActionGestion();
        vistaHome.getControladorPila().resetEliminacionAction();
        vistaHome.getControladorPila().resetPremioActionGestion();
        vistaHome.getControladorPila().resetCuidadoActionGestion();
        VistaTerreno vistaTerreno = new VistaTerreno(vistaHome);
        vistaTerreno.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        try {
            int desicion = mensajeConfirmacion("¿Desea agregar un animal?");
            if (desicion == 0) {
                int size = vistaHome.getControladorTerreno().getSize();
                size++;
                if (vistaHome.terreno.equals(vistaHome.LOTE)) {
                    Lote lote = vistaHome.getControladorTerreno().obtenerLote(fila, columna);
                    Bovino bovino;
                    if (lote.getSexoAnimales().equals(Bovino.MACHO)) {
                        bovino = new Bovino(Bovino.MACHO, size, numeroTerreno);
                    } else {
                        bovino = new Bovino(Bovino.HEMBRA, size, numeroTerreno);
                    }
                    vistaHome.getControladorTerreno().añadirAnimal(fila, columna, vistaHome.LOTE, bovino, false);
                    AccionRealizadaAnimal accion = new AccionRealizadaAnimal(bovino, AccionRealizadaAnimal.actionRegistrar, fila, columna);
                    vistaHome.getControladorPila().pushAnimalAction(accion);
                    limpiarTablaBovinos();
                    llenarTablaBonivos();
                } else if (vistaHome.terreno.equals(vistaHome.PESEBRERA)) {
                    Pesebrera pesebrera = vistaHome.getControladorTerreno().obtenerPesebrera(fila, columna);
                    Equino equino;
                    if (pesebrera.getSexoAnimales().equals(Equino.MACHO)) {
                        equino = new Equino(false, numeroTerreno, Equino.MACHO, size);
                    } else {
                        equino = new Equino(false, numeroTerreno, Equino.HEMBRA, size);
                    }
                    vistaHome.getControladorTerreno().añadirAnimal(fila, columna, vistaHome.PESEBRERA, equino, false);
                    AccionRealizadaAnimal accion = new AccionRealizadaAnimal(equino, AccionRealizadaAnimal.actionRegistrar, fila, columna);
                    vistaHome.getControladorPila().pushAnimalAction(accion);
                    limpiarTablaEquinos();
                    llenarTablaEquinos();
                } else {
                    Porcino porcino;
                    String[] botonesPregunta = {"Macho", "Hembra", "Cancelar"};
                    int respuesta = JOptionPane.showOptionDialog(this, "Seleccione Sexo", "Selección Sexo", JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoBlack_Pequeño.png")),
                            botonesPregunta, botonesPregunta[0]);
                    if (respuesta == 0) {
                        porcino = new Porcino(false, numeroTerreno, Porcino.MACHO, size);
                    } else {
                        porcino = new Porcino(false, numeroTerreno, Porcino.HEMBRA, size);
                    }
                    vistaHome.getControladorTerreno().añadirAnimal(fila, columna, vistaHome.POCILGA, porcino, false);
                    AccionRealizadaAnimal accion = new AccionRealizadaAnimal(porcino, AccionRealizadaAnimal.actionRegistrar, fila, columna);
                    vistaHome.getControladorPila().pushAnimalAction(accion);
                    limpiarTablaPorcinos();
                    llenarTablaPorcinos();
                }
            }
        } catch (PocilgaSoloParaCriasException | LoteLlenoException | PesebreraLlenaException | PocilgaLlenaException ex) {
            mostrarMensaje(ex.getMessage(), "Error");
        }
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            int index;
            int select = ValidarSeleccion();
            int desicion = mensajeConfirmacion("¿Desea eliminar al animal de código " + String.valueOf(tablaAnimales.getValueAt(select, 2)) + " ?");
            if (desicion == 0) {
                index = Integer.parseInt(String.valueOf(tablaAnimales.getValueAt(select, 0)));
                Animal animalEliminar = vistaHome.getControladorTerreno().getAnimal(index);
                if (vistaHome.getControladorTerreno().getAnimal(index).getPeso() <= 0) {
                    throw new PesoNoValidoException();
                }
                if (vistaHome.terreno.equals(vistaHome.LOTE)) {
                    VistaFormularioEliminar dialog = new VistaFormularioEliminar(new javax.swing.JFrame(), true, vistaHome,
                            animalEliminar);
                    dialog.setVisible(true);
                    vistaHome.getControladorTerreno().eliminarAnimal(fila, columna, vistaHome.LOTE, index);
                    limpiarTablaBovinos();
                    llenarTablaBonivos();
                    if (tablaAnimales.getRowCount() == 0) {
                        vistaHome.getControladorTerreno().cambiarEstadoTerreno(fila, columna, 1, vistaHome.LOTE);
                        VistaTerreno vistaTerreno = new VistaTerreno(vistaHome);
                        vistaTerreno.setVisible(true);
                        this.dispose();
                    }
                } else if (vistaHome.terreno.equals(vistaHome.PESEBRERA)) {
                    VistaFormularioEliminar dialog = new VistaFormularioEliminar(new javax.swing.JFrame(), true, vistaHome, animalEliminar);
                    dialog.setVisible(true);
                    vistaHome.getControladorTerreno().eliminarAnimal(fila, columna, vistaHome.PESEBRERA, index);
                    int indexEliminaciones = 0;
                    while (indexEliminaciones != -1) {
                        indexEliminaciones = indexPremioEliminado(animalEliminar.getCodigo());
                        if (indexEliminaciones != -1) {
                            Premio premioEliminar = vistaHome.getControladorDPC().getPremio(indexEliminaciones);
                            AccionRealizadaPremio accionPremio = new AccionRealizadaPremio(premioEliminar, AccionRealizadaPremio.actionEliminar);
                            vistaHome.getControladorPila().pushPremioActionGestion(accionPremio);
                            vistaHome.getControladorDPC().eliminarPremio(indexEliminaciones);
                        }
                    }
                    indexEliminaciones = 0;
                    while (indexEliminaciones != -1) {
                        indexEliminaciones = indexCuidadoEliminado(animalEliminar.getCodigo());
                        if (indexEliminaciones != -1) {
                            CuidadoEquino CuidadoEliminar = vistaHome.getControladorDPC().getCuidado(indexEliminaciones);
                            AccionRealizadaCuidado accionCuidado = new AccionRealizadaCuidado(CuidadoEliminar, AccionRealizadaCuidado.actionEliminar);
                            vistaHome.getControladorPila().pushCuidadoActionGestion(accionCuidado);
                            vistaHome.getControladorDPC().eliminarCuidado(indexEliminaciones);
                        }
                    }
                    limpiarTablaEquinos();
                    llenarTablaEquinos();
                    if (tablaAnimales.getRowCount() == 0) {
                        vistaHome.getControladorTerreno().cambiarEstadoTerreno(fila, columna, 1, vistaHome.PESEBRERA);
                        VistaTerreno vistaTerreno = new VistaTerreno(vistaHome);
                        vistaTerreno.setVisible(true);
                        vistaHome.getControladorPila().resetAnimalAction();
                        vistaHome.getControladorPila().resetAnimalActionDos();
                        vistaHome.getControladorPila().resetDiagnosticoActionGestion();
                        vistaHome.getControladorPila().resetEliminacionAction();
                        vistaHome.getControladorPila().resetPremioAction();
                        this.dispose();
                    }
                } else {
                    Animal animal = vistaHome.getControladorTerreno().getAnimal(index);
                    Porcino porcino = null;
                    if (animal instanceof Porcino) {
                        porcino = (Porcino) animal;
                    }
                    if (porcino.isAmamanta() == false) {
                        VistaFormularioEliminar dialog = new VistaFormularioEliminar(new javax.swing.JFrame(), true, vistaHome, vistaHome.getControladorTerreno().getAnimal(index));
                        dialog.setVisible(true);
                    }
                    vistaHome.getControladorTerreno().eliminarAnimal(fila, columna, vistaHome.POCILGA, index);
                    limpiarTablaPorcinos();
                    llenarTablaPorcinos();
                    if (tablaAnimales.getRowCount() == 0) {
                        vistaHome.getControladorTerreno().cambiarEstadoTerreno(fila, columna, 1, vistaHome.POCILGA);
                        VistaTerreno vistaTerreno = new VistaTerreno(vistaHome);
                        vistaTerreno.setVisible(true);
                        this.dispose();
                    }
                }
                AccionRealizadaAnimal accion = new AccionRealizadaAnimal(animalEliminar, AccionRealizadaAnimal.actionEliminar, fila, columna);
                vistaHome.getControladorPila().pushAnimalAction(accion);
                int indexDiagnosticos = 0;
                do {
                    indexDiagnosticos = indexDiagnosticoEliminado(animalEliminar.getCodigo());
                    if (indexDiagnosticos != -1) {
                        DiagnosticoClinico diagnosticoEliminar = vistaHome.getControladorVeterinario().obtenerDiagnostico(indexDiagnosticos);
                        vistaHome.getControladorVeterinario().eliminarDiagnostico(indexDiagnosticos);
                        AccionRealizadaDiagnostico accionD = new AccionRealizadaDiagnostico(diagnosticoEliminar, AccionRealizadaDiagnostico.actionEliminar);
                        vistaHome.getControladorPila().pushDiagnosticoActionGestion(accionD);
                    }
                } while (indexDiagnosticos != -1);

            }
        } catch (BovinoNoSeleccionadoException | EquinoNoSeleccionadoException | PorcinoNoSeleccionadoException
                | PorcinoAmamantandoException | PesoNoValidoException ex) {
            mostrarMensaje(ex.getMessage(), "Error");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private int indexPremioEliminado(int codigo) {
        for (int i = 0; i < vistaHome.getControladorDPC().getSizePremios(); i++) {
            if (vistaHome.getControladorDPC().getPremio(i).getCodigoEquino() == codigo) {
                return i;
            }
        }
        return -1;
    }

    private int indexCuidadoEliminado(int codigo) {
        for (int i = 0; i < vistaHome.getControladorDPC().getSizeCuidados(); i++) {
            if (vistaHome.getControladorDPC().getCuidado(i).getCodigoEquino() == codigo) {
                return i;
            }
        }
        return -1;
    }

    private int indexDiagnosticoEliminado(int codigo) {
        for (int i = 0; i < vistaHome.getControladorVeterinario().getSizeDiagnosticos(); i++) {
            if (vistaHome.getControladorVeterinario().obtenerDiagnostico(i).getCodigoAnimal() == codigo) {
                return i;
            }
        }
        return -1;
    }


    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            int index;
            int select = ValidarSeleccion();
            int desicion = mensajeConfirmacion("¿Desea editar al animal de código " + String.valueOf(tablaAnimales.getValueAt(select, 2)) + " ?");
            if (desicion == 0) {
                index = Integer.parseInt(String.valueOf(tablaAnimales.getValueAt(select, 0)));
                String nombre = String.valueOf(tablaAnimales.getValueAt(select, 1));
                int peso = Integer.parseInt(String.valueOf(tablaAnimales.getValueAt(select, 4)));
                int edad = Integer.parseInt(String.valueOf(tablaAnimales.getValueAt(select, 5)));
                Animal animal = vistaHome.getControladorTerreno().getAnimal(index);
                if (animal instanceof Porcino) {
                    if (((Porcino) animal).isAmamanta() == false && animal.getSexo().equals("Hembra")) {
                        String valido = String.valueOf(tablaAnimales.getValueAt(select, 6));
                        if (valido.equals("Si")) {
                            vistaHome.getControladorTerreno().habilitarCrias(fila, columna);
                            if (tablaAnimales.getRowCount() > 1) {
                                mostrarMensaje("Los Porcinos de esta Pocilga (excepto la mamá), \nserán enviados a otras pocilgas", "Information");
                                for (int i = 0; i < tablaAnimales.getRowCount(); i++) {
                                    if (index != Integer.parseInt(String.valueOf(tablaAnimales.getValueAt(i, 0)))) {
                                        Porcino porcinoLiberar = (Porcino) vistaHome.getControladorTerreno().getAnimal(Integer.parseInt(String.valueOf(tablaAnimales.getValueAt(i, 0))));
                                        vistaHome.getControladorTerreno().liberarPorcino(fila, columna, Integer.parseInt(String.valueOf(tablaAnimales.getValueAt(i, 0))), porcinoLiberar.getSexo());
                                    }
                                }
                            }
                            ((Porcino) animal).setAmamanta(true);
                            int size = vistaHome.getControladorTerreno().getSize();
                            size++;
                            int numeroCrias = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la cantidad de crías"));
                            for (int i = 0; i < numeroCrias; i++) {
                                Porcino porcinoCria = new Porcino(false, numeroTerreno, Porcino.CRIA, size);
                                vistaHome.getControladorTerreno().añadirAnimal(fila, columna, vistaHome.POCILGA, porcinoCria, true);
                            }
                        }
                    }
                }
                animal.setNombre(nombre);
                animal.setPeso(peso);
                animal.setEdad(edad);
                vistaHome.getControladorTerreno().editarAnimal(index, animal);
                if (vistaHome.terreno.equals(vistaHome.LOTE)) {
                    limpiarTablaBovinos();
                    llenarTablaBonivos();
                } else if (vistaHome.terreno.equals(vistaHome.PESEBRERA)) {
                    limpiarTablaEquinos();
                    llenarTablaEquinos();
                } else {
                    limpiarTablaPorcinos();
                    llenarTablaPorcinos();
                }
                mostrarMensaje("El animal se ha editado correctamente", "Information");
            }
        } catch (BovinoNoSeleccionadoException | EquinoNoSeleccionadoException | PorcinoNoSeleccionadoException
                | LoteLlenoException | PesebreraLlenaException | PocilgaLlenaException | PorcinoNoLiberadoException ex) {
            mostrarMensaje(ex.getMessage(), "Error");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPremiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPremiosActionPerformed
        try {
            int index;
            int select = ValidarSeleccion();
            index = Integer.parseInt(String.valueOf(tablaAnimales.getValueAt(select, 0)));
            Equino equino = (Equino) vistaHome.getControladorTerreno().getAnimal(index);
            if (equino.isPremiado() == false) {
                VistaFormularioPremioCuidado dialog = new VistaFormularioPremioCuidado(new javax.swing.JFrame(), true, vistaHome, equino.getCodigo(), 0);
                dialog.setVisible(true);
                equino.setPremiado(true);
                vistaHome.getControladorTerreno().editarAnimal(index, equino);
            }
            VistaInformativa vistaInformativa = new VistaInformativa(vistaHome, 2, equino.getCodigo(), true, numeroTerreno, fila, columna);
            vistaInformativa.setVisible(true);
            this.dispose();
        } catch (BovinoNoSeleccionadoException | PorcinoNoSeleccionadoException | EquinoNoSeleccionadoException ex) {
            mostrarMensaje(ex.getMessage(), "Error");
        }
    }//GEN-LAST:event_btnPremiosActionPerformed

    private void btnCuidadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuidadosActionPerformed
        try {
            int index;
            int select = ValidarSeleccion();
            index = Integer.parseInt(String.valueOf(tablaAnimales.getValueAt(select, 0)));
            Equino equino = (Equino) vistaHome.getControladorTerreno().getAnimal(index);
            VistaInformativa vistaInformativa = new VistaInformativa(vistaHome, 3, equino.getCodigo(), true, numeroTerreno, fila, columna);
            vistaInformativa.setVisible(true);
            this.dispose();
        } catch (BovinoNoSeleccionadoException | PorcinoNoSeleccionadoException | EquinoNoSeleccionadoException ex) {
            mostrarMensaje(ex.getMessage(), "Error");
        }
    }//GEN-LAST:event_btnCuidadosActionPerformed

    private void btnOrdeñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdeñoActionPerformed
        if (vistaHome.getControladorTerreno().getSizeOrdeño() == 0) {
            Bovino vaca;
            for (int i = 0; i < vistaHome.getControladorTerreno().getSize(); i++) {
                if (vistaHome.getControladorTerreno().getAnimal(i) instanceof Bovino) {
                    vaca = (Bovino) vistaHome.getControladorTerreno().getAnimal(i);
                    if (vaca.getNumeroLote() == numeroTerreno) {
                        vistaHome.getControladorTerreno().encolar(vaca);
                    }
                }
            }
        }
        VistaOrdeño vistaOrdeño = new VistaOrdeño(vistaHome, numeroTerreno, fila, columna);
        vistaOrdeño.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnOrdeñoActionPerformed

    private void btnLiberarCriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiberarCriasActionPerformed
        try {
            int index;
            int select = -1;
            select = tablaAnimales.getSelectedRow();
            if (select == -1) {
                throw new CriaNoSeleccionadaException();
            }
            index = Integer.parseInt(String.valueOf(tablaAnimales.getValueAt(select, 0)));
            Porcino porcino = (Porcino) vistaHome.getControladorTerreno().getAnimal(index);
            if (porcino.getSexo().equals(Porcino.HEMBRA)) {
                throw new CriaNoSeleccionadaException();
            }
            mostrarMensaje("Tenga en cuenta que al realizar esta acción, se ubicará\nal porcino aleatoriamente en otra pocilga", "info");
            String[] botonesPregunta = {"Macho", "Hembra", "Cancelar"};
            int respuesta = JOptionPane.showOptionDialog(this, "Seleccione Sexo", "Selección Sexo", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoBlack_Pequeño.png")),
                    botonesPregunta, botonesPregunta[0]);
            if (respuesta == 0) {
                vistaHome.getControladorTerreno().liberarPorcino(fila, columna, index, Porcino.MACHO);
            } else if (respuesta == 1) {
                vistaHome.getControladorTerreno().liberarPorcino(fila, columna, index, Porcino.HEMBRA);
            }
            if (tablaAnimales.getRowCount() == 2) {
                index = Integer.parseInt(String.valueOf(tablaAnimales.getValueAt(0, 0)));
                Porcino porcinoDos = (Porcino) vistaHome.getControladorTerreno().getAnimal(index);
                porcinoDos.setAmamanta(false);
                vistaHome.getControladorTerreno().editarAnimal(index, porcinoDos);
                vistaHome.getControladorTerreno().deshabilitarCrias(fila, columna);
                btnLiberarCrias.setVisible(false);
            }
            limpiarTablaPorcinos();
            llenarTablaPorcinos();
        } catch (CriaNoSeleccionadaException | PorcinoNoLiberadoException ex) {
            mostrarMensaje(ex.getMessage(), "Error");
        }
    }//GEN-LAST:event_btnLiberarCriasActionPerformed

    private void btnVeterinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVeterinarioActionPerformed
        try {
            int select = ValidarSeleccion();
            int desicion = mensajeConfirmacion("¿Desea agendar una cita con el veterinario?");
            if (desicion == 0) {
                int index;
                index = Integer.parseInt(String.valueOf(tablaAnimales.getValueAt(select, 0)));
                Animal animal = vistaHome.getControladorTerreno().getAnimal(index);
                vistaHome.getControladorVeterinario().encolar(animal);
                mostrarMensaje("Cita con el veterinario Agendada", "Information");
            }
        } catch (BovinoNoSeleccionadoException | EquinoNoSeleccionadoException | PorcinoNoSeleccionadoException | CitaPendienteVeterinario ex) {
            mostrarMensaje(ex.getMessage(), "Error");
        }
    }//GEN-LAST:event_btnVeterinarioActionPerformed

    private void btnHistorialClinicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialClinicoActionPerformed
        try {
            int index;
            int select = ValidarSeleccion();
            index = Integer.parseInt(String.valueOf(tablaAnimales.getValueAt(select, 0)));
            Animal animal = vistaHome.getControladorTerreno().getAnimal(index);
            VistaInformativa vistaInformativa = new VistaInformativa(vistaHome, 4, animal.getCodigo(), false, numeroTerreno, fila, columna);
            vistaInformativa.setVisible(true);
            this.dispose();
        } catch (BovinoNoSeleccionadoException | PorcinoNoSeleccionadoException | EquinoNoSeleccionadoException ex) {
            mostrarMensaje(ex.getMessage(), "Error");
        }
    }//GEN-LAST:event_btnHistorialClinicoActionPerformed

    private void agregar(AccionRealizadaAnimal x, Animal animal) {

    }

    public void eliminar(AccionRealizadaAnimal x, Animal animal) {

    }

    private void btnAdelantarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdelantarActionPerformed
        try {
            if (vistaHome.getControladorPila().isEmptyAnimalActionDos() == false) {
                AccionRealizadaAnimal x = vistaHome.getControladorPila().popAnimalActionDos();
                Animal animal = x.getAnimal();
                if (x.getAction().equals(AccionRealizadaAnimal.actionEliminar)) {
                    if (animal instanceof Bovino) {
                        vistaHome.getControladorTerreno().añadirAnimal(x.getFila(), x.getColumna(), vistaHome.terreno, animal, false);
                        if (animal.getSexo().equals(Bovino.MACHO)) {
                            vistaHome.getControladorTerreno().asignarSexoTerreno(x.getFila(), x.getColumna(), 2, vistaHome.LOTE);
                        } else {
                            vistaHome.getControladorTerreno().asignarSexoTerreno(x.getFila(), x.getColumna(), 1, vistaHome.LOTE);
                        }
                        vistaHome.getControladorTerreno().cambiarEstadoTerreno(x.getFila(), x.getColumna(), 3, vistaHome.LOTE);
                        limpiarTablaBovinos();
                        llenarTablaBonivos();
                    } else if (animal instanceof Equino) {
                        vistaHome.getControladorTerreno().añadirAnimal(x.getFila(), x.getColumna(), vistaHome.terreno, animal, false);
                        if (animal.getSexo().equals(Equino.MACHO)) {
                            vistaHome.getControladorTerreno().asignarSexoTerreno(x.getFila(), x.getColumna(), 2, vistaHome.PESEBRERA);
                        } else {
                            vistaHome.getControladorTerreno().asignarSexoTerreno(x.getFila(), x.getColumna(), 1, vistaHome.PESEBRERA);
                        }
                        vistaHome.getControladorTerreno().cambiarEstadoTerreno(x.getFila(), x.getColumna(), 3, vistaHome.PESEBRERA);
                        limpiarTablaEquinos();
                        llenarTablaEquinos();
                    } else {
                        if (animal.getSexo().equals(Porcino.CRIA)) {
                            vistaHome.getControladorTerreno().añadirAnimal(x.getFila(), x.getColumna(), vistaHome.terreno, animal, true);
                        } else {
                            vistaHome.getControladorTerreno().añadirAnimal(x.getFila(), x.getColumna(), vistaHome.terreno, animal, false);
                        }
                        vistaHome.getControladorTerreno().cambiarEstadoTerreno(x.getFila(), x.getColumna(), 3, vistaHome.POCILGA);
                        limpiarTablaPorcinos();
                        llenarTablaPorcinos();
                    }
                    AccionRealizadaAnimal action = new AccionRealizadaAnimal(animal, AccionRealizadaAnimal.actionRegistrar, x.getFila(), x.getColumna());
                    vistaHome.getControladorPila().pushAnimalAction(action);
                    for (int i = 0; i < vistaHome.getControladorPila().getSizeDiagnosticoActionGestion(); i++) {
                        AccionRealizadaDiagnostico accionDiag = vistaHome.getControladorPila().popDiagnosticoActionGestion();
                        if (accionDiag.getDiagnostico().getCodigoAnimal() == animal.getCodigo()) {
                            vistaHome.getControladorVeterinario().añadirDiagnostico(accionDiag.getDiagnostico());
                        } else {
                            vistaHome.getControladorPila().pushDiagnosticoActionGestion(accionDiag);
                        }
                    }
                    for (int i = 0; i < vistaHome.getControladorPila().getSizePremioActionGestion(); i++) {
                        AccionRealizadaPremio accionPre = vistaHome.getControladorPila().popPremioActionGestion();
                        if (accionPre.getPremio().getCodigoEquino() == animal.getCodigo()) {
                            vistaHome.getControladorDPC().añadirPremio(accionPre.getPremio());
                        } else {
                            vistaHome.getControladorPila().pushPremioActionGestion(accionPre);
                        }
                    }
                    for (int i = 0; i < vistaHome.getControladorPila().getSizeCuidadoActionGestion(); i++) {
                        AccionRealizadaCuidado accionCui = vistaHome.getControladorPila().popCuidadoActionGestion();
                        if (accionCui.getCuidado().getCodigoEquino() == animal.getCodigo()) {
                            vistaHome.getControladorDPC().añadirCuidado(accionCui.getCuidado());
                        } else {
                            vistaHome.getControladorPila().pushCuidadoActionGestion(accionCui);
                        }
                    }
                    int indexRazonEliminacion = vistaHome.getControladorVYE().obtenerIndexRazonEliminar(animal.getCodigo());
                    if (indexRazonEliminacion != -1) {
                        RazonEliminacion razon = vistaHome.getControladorVYE().getRazon(indexRazonEliminacion);
                        vistaHome.getControladorVYE().eliminarRazonEliminar(indexRazonEliminacion);
                        AccionRealizadaEliminacion accion = new AccionRealizadaEliminacion(razon, AccionRealizadaEliminacion.actionEliminar);
                        vistaHome.getControladorPila().pushEliminacionAction(accion);
                    }
                    int indexVenta = vistaHome.getControladorVYE().obtenerIndexFacturaVenta(animal.getCodigo());
                    if (indexVenta != -1) {
                        FacturaVenta factura = vistaHome.getControladorVYE().getFactura(indexVenta);
                        vistaHome.getControladorVYE().eliminarFacturaVenta(indexVenta);
                        AccionRealizadaVenta accionVenta = new AccionRealizadaVenta(factura, AccionRealizadaVenta.actionEliminar);
                        vistaHome.getControladorPila().pushVentaAction(accionVenta);
                    }

                } else if (x.getAction().equals(AccionRealizadaAnimal.actionRegistrar)) {
                    int index = vistaHome.getControladorTerreno().getIndexAnimalCodigo(x.getAnimal().getCodigo());
                    vistaHome.getControladorTerreno().eliminarAnimal(x.getFila(), x.getColumna(), vistaHome.terreno, index);
                    AccionRealizadaAnimal accionDos = new AccionRealizadaAnimal(x.getAnimal(), AccionRealizadaAnimal.actionEliminar, x.getFila(), x.getColumna());
                    vistaHome.getControladorPila().pushAnimalAction(accionDos);
                    int indexDiagnosticos = 0;
                    do {
                        indexDiagnosticos = indexDiagnosticoEliminado(x.getAnimal().getCodigo());
                        if (indexDiagnosticos != -1) {
                            DiagnosticoClinico diagnosticoEliminar = vistaHome.getControladorVeterinario().obtenerDiagnostico(indexDiagnosticos);
                            vistaHome.getControladorVeterinario().eliminarDiagnostico(indexDiagnosticos);
                            AccionRealizadaDiagnostico accionD = new AccionRealizadaDiagnostico(diagnosticoEliminar, AccionRealizadaDiagnostico.actionEliminar);
                            vistaHome.getControladorPila().pushDiagnosticoActionGestion(accionD);
                        }
                    } while (indexDiagnosticos != -1);
                    int indexEliminaciones = 0;
                    while (indexEliminaciones != -1) {
                        indexEliminaciones = indexPremioEliminado(x.getAnimal().getCodigo());
                        if (indexEliminaciones != -1) {
                            Premio premioEliminar = vistaHome.getControladorDPC().getPremio(indexEliminaciones);
                            vistaHome.getControladorDPC().eliminarPremio(indexEliminaciones);
                            AccionRealizadaPremio accionPremio = new AccionRealizadaPremio(premioEliminar, AccionRealizadaPremio.actionEliminar);
                            vistaHome.getControladorPila().pushPremioActionGestion(accionPremio);
                        }
                    }
                    indexEliminaciones = 0;
                    while (indexEliminaciones != -1) {
                        indexEliminaciones = indexCuidadoEliminado(x.getAnimal().getCodigo());
                        if (indexEliminaciones != -1) {
                            CuidadoEquino CuidadoEliminar = vistaHome.getControladorDPC().getCuidado(indexEliminaciones);
                            AccionRealizadaCuidado accionCuidado = new AccionRealizadaCuidado(CuidadoEliminar, AccionRealizadaCuidado.actionEliminar);
                            vistaHome.getControladorPila().pushCuidadoActionGestion(accionCuidado);
                            vistaHome.getControladorDPC().eliminarCuidado(indexEliminaciones);
                        }
                    }
                    if (vistaHome.getControladorPila().isEmptyEliminacionAction() == false) {
                        AccionRealizadaEliminacion accion = vistaHome.getControladorPila().popEliminacionAction();
                        vistaHome.getControladorVYE().añadirRazonEliminar(accion.getRazon());
                    }
                    if (vistaHome.getControladorPila().isEmptyVentaAction() == false) {
                        AccionRealizadaVenta accionVenta = vistaHome.getControladorPila().popVentaAction();
                        vistaHome.getControladorVYE().añadirFacturaVenta(accionVenta.getFacturaVenta());
                    }
                    if (vistaHome.terreno.equals(vistaHome.PESEBRERA)) {
                        limpiarTablaEquinos();
                        llenarTablaEquinos();
                        if (tablaAnimales.getRowCount() == 0) {
                            vistaHome.getControladorTerreno().cambiarEstadoTerreno(x.getFila(), x.getColumna(), 1, vistaHome.PESEBRERA);
                            vistaHome.getControladorPila().resetAnimalAction();
                            vistaHome.getControladorPila().resetAnimalActionDos();
                            vistaHome.getControladorPila().resetDiagnosticoActionGestion();
                            vistaHome.getControladorPila().resetEliminacionAction();
                            vistaHome.getControladorPila().resetPremioAction();
                            VistaTerreno vistaTerreno = new VistaTerreno(vistaHome);
                            vistaTerreno.setVisible(true);
                            this.dispose();
                        }
                    } else if (vistaHome.terreno.equals(vistaHome.LOTE)) {
                        limpiarTablaBovinos();
                        llenarTablaBonivos();
                        if (tablaAnimales.getRowCount() == 0) {
                            vistaHome.getControladorTerreno().cambiarEstadoTerreno(x.getFila(), x.getColumna(), 1, vistaHome.LOTE);
                            vistaHome.getControladorPila().resetAnimalAction();
                            vistaHome.getControladorPila().resetAnimalActionDos();
                            vistaHome.getControladorPila().resetDiagnosticoActionGestion();
                            vistaHome.getControladorPila().resetEliminacionAction();
                            vistaHome.getControladorPila().resetPremioAction();
                            VistaTerreno vistaTerreno = new VistaTerreno(vistaHome);
                            vistaTerreno.setVisible(true);
                            this.dispose();
                        }

                    } else {
                        limpiarTablaPorcinos();
                        llenarTablaPorcinos();
                        if (tablaAnimales.getRowCount() == 0) {
                            vistaHome.getControladorTerreno().cambiarEstadoTerreno(x.getFila(), x.getColumna(), 1, vistaHome.POCILGA);
                            vistaHome.getControladorPila().resetAnimalAction();
                            vistaHome.getControladorPila().resetAnimalActionDos();
                            vistaHome.getControladorPila().resetDiagnosticoActionGestion();
                            vistaHome.getControladorPila().resetEliminacionAction();
                            vistaHome.getControladorPila().resetPremioAction();
                            VistaTerreno vistaTerreno = new VistaTerreno(vistaHome);
                            vistaTerreno.setVisible(true);
                            this.dispose();
                        }
                    }
                }
            }
        } catch (PocilgaLlenaException ex) {
        }
    }//GEN-LAST:event_btnAdelantarActionPerformed

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        try {
            if (vistaHome.getControladorPila().isEmptyAnimalAction() == false) {
                AccionRealizadaAnimal x = vistaHome.getControladorPila().popAnimalAction();
                Animal animal = x.getAnimal();
                if (x.getAction().equals(AccionRealizadaAnimal.actionRegistrar)) {
                    int index = vistaHome.getControladorTerreno().getIndexAnimalCodigo(x.getAnimal().getCodigo());
                    vistaHome.getControladorTerreno().eliminarAnimal(x.getFila(), x.getColumna(), vistaHome.terreno, index);
                    AccionRealizadaAnimal accionDos = new AccionRealizadaAnimal(x.getAnimal(), AccionRealizadaAnimal.actionEliminar, x.getFila(), x.getColumna());
                    vistaHome.getControladorPila().pushAnimalActionDos(accionDos);
                    int indexDiagnosticos = 0;
                    do {
                        indexDiagnosticos = indexDiagnosticoEliminado(x.getAnimal().getCodigo());
                        if (indexDiagnosticos != -1) {
                            DiagnosticoClinico diagnosticoEliminar = vistaHome.getControladorVeterinario().obtenerDiagnostico(indexDiagnosticos);
                            vistaHome.getControladorVeterinario().eliminarDiagnostico(indexDiagnosticos);
                            AccionRealizadaDiagnostico accionD = new AccionRealizadaDiagnostico(diagnosticoEliminar, AccionRealizadaDiagnostico.actionEliminar);
                            vistaHome.getControladorPila().pushDiagnosticoActionGestion(accionD);
                        }
                    } while (indexDiagnosticos != -1);
                    int indexEliminaciones = 0;
                    while (indexEliminaciones != -1) {
                        indexEliminaciones = indexPremioEliminado(x.getAnimal().getCodigo());
                        if (indexEliminaciones != -1) {
                            Premio premioEliminar = vistaHome.getControladorDPC().getPremio(indexEliminaciones);
                            vistaHome.getControladorDPC().eliminarPremio(indexEliminaciones);
                            AccionRealizadaPremio accionPremio = new AccionRealizadaPremio(premioEliminar, AccionRealizadaPremio.actionEliminar);
                            vistaHome.getControladorPila().pushPremioActionGestion(accionPremio);
                        }
                    }
                    indexEliminaciones = 0;
                    while (indexEliminaciones != -1) {
                        indexEliminaciones = indexCuidadoEliminado(x.getAnimal().getCodigo());
                        if (indexEliminaciones != -1) {
                            CuidadoEquino CuidadoEliminar = vistaHome.getControladorDPC().getCuidado(indexEliminaciones);
                            AccionRealizadaCuidado accionCuidado = new AccionRealizadaCuidado(CuidadoEliminar, AccionRealizadaCuidado.actionEliminar);
                            vistaHome.getControladorPila().pushCuidadoActionGestion(accionCuidado);
                            vistaHome.getControladorDPC().eliminarCuidado(indexEliminaciones);
                        }
                    }
                    if (vistaHome.getControladorPila().isEmptyEliminacionAction() == false) {
                        AccionRealizadaEliminacion accion = vistaHome.getControladorPila().popEliminacionAction();
                        vistaHome.getControladorVYE().añadirRazonEliminar(accion.getRazon());
                    }
                    if (vistaHome.getControladorPila().isEmptyVentaAction() == false) {
                        AccionRealizadaVenta accionVenta = vistaHome.getControladorPila().popVentaAction();
                        vistaHome.getControladorVYE().añadirFacturaVenta(accionVenta.getFacturaVenta());
                    }
                    if (vistaHome.terreno.equals(vistaHome.PESEBRERA)) {
                        limpiarTablaEquinos();
                        llenarTablaEquinos();
                        if (tablaAnimales.getRowCount() == 0) {
                            vistaHome.getControladorTerreno().cambiarEstadoTerreno(x.getFila(), x.getColumna(), 1, vistaHome.PESEBRERA);
                            vistaHome.getControladorPila().resetAnimalAction();
                            vistaHome.getControladorPila().resetAnimalActionDos();
                            vistaHome.getControladorPila().resetDiagnosticoActionGestion();
                            vistaHome.getControladorPila().resetEliminacionAction();
                            vistaHome.getControladorPila().resetPremioAction();
                            vistaHome.getControladorPila().resetVentaAction();
                            VistaTerreno vistaTerreno = new VistaTerreno(vistaHome);
                            vistaTerreno.setVisible(true);
                            this.dispose();
                        }
                    } else if (vistaHome.terreno.equals(vistaHome.LOTE)) {
                        limpiarTablaBovinos();
                        llenarTablaBonivos();
                        if (tablaAnimales.getRowCount() == 0) {
                            vistaHome.getControladorTerreno().cambiarEstadoTerreno(x.getFila(), x.getColumna(), 1, vistaHome.LOTE);
                            vistaHome.getControladorPila().resetAnimalAction();
                            vistaHome.getControladorPila().resetAnimalActionDos();
                            vistaHome.getControladorPila().resetDiagnosticoActionGestion();
                            vistaHome.getControladorPila().resetEliminacionAction();
                            vistaHome.getControladorPila().resetPremioAction();
                            vistaHome.getControladorPila().resetVentaAction();
                            VistaTerreno vistaTerreno = new VistaTerreno(vistaHome);
                            vistaTerreno.setVisible(true);
                            this.dispose();
                        }

                    } else {
                        limpiarTablaPorcinos();
                        llenarTablaPorcinos();
                        if (tablaAnimales.getRowCount() == 0) {
                            vistaHome.getControladorTerreno().cambiarEstadoTerreno(x.getFila(), x.getColumna(), 1, vistaHome.POCILGA);
                            vistaHome.getControladorPila().resetAnimalAction();
                            vistaHome.getControladorPila().resetAnimalActionDos();
                            vistaHome.getControladorPila().resetDiagnosticoActionGestion();
                            vistaHome.getControladorPila().resetEliminacionAction();
                            vistaHome.getControladorPila().resetPremioAction();
                            vistaHome.getControladorPila().resetVentaAction();
                            VistaTerreno vistaTerreno = new VistaTerreno(vistaHome);
                            vistaTerreno.setVisible(true);
                            this.dispose();
                        }
                    }
                } else if (x.getAction().equals(AccionRealizadaAnimal.actionEliminar)) {
                    if (animal instanceof Bovino) {
                        vistaHome.getControladorTerreno().añadirAnimal(x.getFila(), x.getColumna(), vistaHome.terreno, animal, false);
                        if (animal.getSexo().equals(Bovino.MACHO)) {
                            vistaHome.getControladorTerreno().asignarSexoTerreno(x.getFila(), x.getColumna(), 2, vistaHome.LOTE);
                        } else {
                            vistaHome.getControladorTerreno().asignarSexoTerreno(x.getFila(), x.getColumna(), 1, vistaHome.LOTE);
                        }
                        vistaHome.getControladorTerreno().cambiarEstadoTerreno(x.getFila(), x.getColumna(), 3, vistaHome.LOTE);
                        limpiarTablaBovinos();
                        llenarTablaBonivos();
                    } else if (animal instanceof Equino) {
                        vistaHome.getControladorTerreno().añadirAnimal(x.getFila(), x.getColumna(), vistaHome.terreno, animal, false);
                        if (animal.getSexo().equals(Equino.MACHO)) {
                            vistaHome.getControladorTerreno().asignarSexoTerreno(x.getFila(), x.getColumna(), 2, vistaHome.PESEBRERA);
                        } else {
                            vistaHome.getControladorTerreno().asignarSexoTerreno(x.getFila(), x.getColumna(), 1, vistaHome.PESEBRERA);
                        }
                        vistaHome.getControladorTerreno().cambiarEstadoTerreno(x.getFila(), x.getColumna(), 3, vistaHome.PESEBRERA);
                        limpiarTablaEquinos();
                        llenarTablaEquinos();
                    } else {
                        if (animal.getSexo().equals(Porcino.CRIA)) {
                            vistaHome.getControladorTerreno().añadirAnimal(x.getFila(), x.getColumna(), vistaHome.terreno, animal, true);
                        } else {
                            vistaHome.getControladorTerreno().añadirAnimal(x.getFila(), x.getColumna(), vistaHome.terreno, animal, false);
                        }
                        vistaHome.getControladorTerreno().cambiarEstadoTerreno(x.getFila(), x.getColumna(), 3, vistaHome.POCILGA);
                        limpiarTablaPorcinos();
                        llenarTablaPorcinos();
                    }
                    AccionRealizadaAnimal action = new AccionRealizadaAnimal(animal, AccionRealizadaAnimal.actionRegistrar, x.getFila(), x.getColumna());
                    vistaHome.getControladorPila().pushAnimalActionDos(action);
                    for (int i = 0; i < vistaHome.getControladorPila().getSizeDiagnosticoActionGestion(); i++) {
                        AccionRealizadaDiagnostico accionDiag = vistaHome.getControladorPila().popDiagnosticoActionGestion();
                        if (accionDiag.getDiagnostico().getCodigoAnimal() == animal.getCodigo()) {
                            vistaHome.getControladorVeterinario().añadirDiagnostico(accionDiag.getDiagnostico());
                        } else {
                            vistaHome.getControladorPila().pushDiagnosticoActionGestion(accionDiag);
                        }
                    }
                    for (int i = 0; i < vistaHome.getControladorPila().getSizePremioActionGestion(); i++) {
                        AccionRealizadaPremio accionPre = vistaHome.getControladorPila().popPremioActionGestion();
                        if (accionPre.getPremio().getCodigoEquino() == animal.getCodigo()) {
                            vistaHome.getControladorDPC().añadirPremio(accionPre.getPremio());
                        } else {
                            vistaHome.getControladorPila().pushPremioActionGestion(accionPre);
                        }
                    }
                    for (int i = 0; i < vistaHome.getControladorPila().getSizeCuidadoActionGestion(); i++) {
                        AccionRealizadaCuidado accionCui = vistaHome.getControladorPila().popCuidadoActionGestion();
                        if (accionCui.getCuidado().getCodigoEquino() == animal.getCodigo()) {
                            vistaHome.getControladorDPC().añadirCuidado(accionCui.getCuidado());
                        } else {
                            vistaHome.getControladorPila().pushCuidadoActionGestion(accionCui);
                        }
                    }
                    int indexRazonEliminacion = vistaHome.getControladorVYE().obtenerIndexRazonEliminar(animal.getCodigo());
                    if (indexRazonEliminacion != -1) {
                        RazonEliminacion razon = vistaHome.getControladorVYE().getRazon(indexRazonEliminacion);
                        vistaHome.getControladorVYE().eliminarRazonEliminar(indexRazonEliminacion);
                        AccionRealizadaEliminacion accion = new AccionRealizadaEliminacion(razon, AccionRealizadaEliminacion.actionEliminar);
                        vistaHome.getControladorPila().pushEliminacionAction(accion);
                    }
                    int indexVenta = vistaHome.getControladorVYE().obtenerIndexFacturaVenta(animal.getCodigo());
                    if (indexVenta != -1) {
                        FacturaVenta factura = vistaHome.getControladorVYE().getFactura(indexVenta);
                        vistaHome.getControladorVYE().eliminarFacturaVenta(indexVenta);
                        AccionRealizadaVenta accionVenta = new AccionRealizadaVenta(factura, AccionRealizadaVenta.actionEliminar);
                        vistaHome.getControladorPila().pushVentaAction(accionVenta);
                    }
                }

            }
        } catch (PorcinoAmamantandoException ex) {

        }
    }//GEN-LAST:event_btnRetrocederActionPerformed

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
//            java.util.logging.Logger.getLogger(VistaGestionAnimales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VistaGestionAnimales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VistaGestionAnimales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VistaGestionAnimales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VistaGestionAnimales().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdelantar;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnCuidados;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnHistorialClinico;
    private javax.swing.JButton btnLiberarCrias;
    private javax.swing.JButton btnOrdeño;
    private javax.swing.JButton btnPremios;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JButton btnVeterinario;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelMasLecheras;
    private javax.swing.JPanel panelMenosLecheras;
    private javax.swing.JTable tablaAnimales;
    private javax.swing.JTable tablaMasLecheras;
    private javax.swing.JTable tablaMenosLecheras;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
