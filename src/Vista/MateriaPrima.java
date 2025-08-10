/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Controllers.ControllersMateriaPrima;
import Controllers.ControllersProveedor;
import Modelo.conexionMP;
import static Vista.Inicio.principal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

//A
public class MateriaPrima extends javax.swing.JInternalFrame {
    private ArrayList<ControllersMateriaPrima> listaMateriaPrima = new ArrayList<>();
    private DefaultTableModel modeloTabla;

public MateriaPrima(String nombre, String codigo, String unidad, String medida, int cantidad, String tipo, String proveedor, String fechaingreso) {
        
}   
    public MateriaPrima(){
        
        super("Materia Prima", true, true, true, true);
        initComponents();
        
        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String []{"Codigo", "Nombre", "Unidad", "Medida", "Cantidad", "Tipo", "Proveedor"});
        existenciasmp.setModel(modeloTabla);
        
        existenciasmp.getColumnModel().getColumn(0).setMinWidth(0);
        existenciasmp.getColumnModel().getColumn(0).setMaxWidth(0);
        existenciasmp.getColumnModel().getColumn(0).setWidth(0);
        
        cargarProveedores();
        cargarMateriaPrima();
        
        existenciasmp.getSelectionModel().addListSelectionListener(e -> {
           if (!e.getValueIsAdjusting()) {
            int fila = existenciasmp.getSelectedRow();
            if (fila != -1) {
                namemp.setText(modeloTabla.getValueAt(fila, 1).toString());
                unitmp.setSelectedItem(modeloTabla.getValueAt(fila, 2).toString());
                medmp.setSelectedItem(modeloTabla.getValueAt(fila, 3).toString());
                cantmp.setText(modeloTabla.getValueAt(fila, 4).toString());
                typemp.setSelectedItem(modeloTabla.getValueAt(fila, 5).toString());
                provmp.setSelectedItem(modeloTabla.getValueAt(fila, 6).toString());
            }
        }
        });
        filtroProveedormp.removeAllItems();
cargarProveedores();
        filtroTipomp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "Filtrar por Tipo", "Termoestables", "Termoplasticos"
        }));
        unitmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "Liquido", "Laminas", "Granulos", "Pellets", "Pasta", "Polvo", "Preformas"
        }));
        typemp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
             "Termoestables", "Termoplasticos"
        }));
        
    }
    public void listaMateriaPrima() {
        modeloTabla.setRowCount(0);
        
        for (ControllersMateriaPrima m : listaMateriaPrima) {
            modeloTabla.addRow(m.toRow());
        }
    }
    private void cargarMateriaPrima() {
        //List<ControllersMateriaPrima> lista = new ArrayList<>();
        
        listaMateriaPrima.clear();
        
            String sql = "SELECT mp.codigo, mp.nombre, mp.unidad, mp.medida, mp.cantidad, mp.tipo, p.nombre AS proveedor " + 
                    "FROM materia_prima mp " +
                    "JOIN proveedor p ON mp.idProveedor = p.idProveedor ";
try (Connection conn = conexionMP.getConnection()) {            
PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            modeloTabla.setRowCount(0);
            
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String unidad = rs.getString("unidad");
                String medida = rs.getString("medida");
                int cantidad = rs.getInt("cantidad");
                String tipo = rs.getString("tipo");
                String proveedor = rs.getString("proveedor");
                
                ControllersMateriaPrima mp = new ControllersMateriaPrima(codigo, nombre, unidad, medida, cantidad, tipo, proveedor);
                listaMateriaPrima.add(mp);
                modeloTabla.addRow(mp.toRow());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los materiales desde la base de datos");
        }
    }
    private void Filtros(){
        Object proveedorObj = filtroProveedormp.getSelectedItem();
        Object tipoObj = filtroTipomp.getSelectedItem();
        
        if (proveedorObj == null || tipoObj == null) {
            return;
        }
            String proveedorFiltro = String.valueOf(proveedorObj);
            String tipoFiltro = String.valueOf(tipoObj);
            
            modeloTabla.setRowCount(0);
            
            for (ControllersMateriaPrima m : listaMateriaPrima) {
                boolean coincideProveedor = proveedorFiltro.equals("Filtrar por Proveedor") || m.getProveedor().equals(proveedorFiltro);
                boolean coincideTipo = tipoFiltro.equals("Filtrar por Tipo") || m.getTipo().equals(tipoFiltro);
                
                if (coincideProveedor && coincideTipo) {
                modeloTabla.addRow(m.toRow());
            
            }
        }
    }
    private void cargarProveedores() {
        ControllersProveedor proveedorDAO = new ControllersProveedor();
        List<ControllersProveedor> listProveedores = proveedorDAO.listarProveedor();
        
        System.out.println("Proveedores encontrados" +listProveedores.size());
        
        provmp.removeAllItems();
        provmp.addItem("Seleccionar proveedor");
        
        filtroProveedormp.removeAllItems();
        filtroProveedormp.addItem("Filtrar por Proveedor");
        
        for (ControllersProveedor p : listProveedores) {
            provmp.addItem(p.getNombre());
            filtroProveedormp.addItem(p.getNombre());
        }
    }
    private int obtenerIdProveedor(String nombreProveedor) {
    int id = -1;
    String sql = "SELECT idProveedor FROM proveedor WHERE nombre = ?";
    
    try (Connection conn = conexionMP.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
        ps.setString(1, nombreProveedor.trim());
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            id = rs.getInt("idProveedor");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
     return id;
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        namemp = new javax.swing.JTextField();
        cantmp = new javax.swing.JTextField();
        provmp = new javax.swing.JComboBox<>();
        medmp = new javax.swing.JComboBox<>();
        unitmp = new javax.swing.JComboBox<>();
        typemp = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        existenciasmp = new javax.swing.JTable();
        filtroTipomp = new javax.swing.JComboBox<>();
        Todomp = new javax.swing.JButton();
        filtroProveedormp = new javax.swing.JComboBox<>();
        actualizarmp = new javax.swing.JButton();
        deletemp = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        entermp = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(46, 54, 79));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 3, 36)); // NOI18N
        jLabel17.setText("M a t e r i a   P r i m a");

        jLabel18.setText(" ");

        jPanel18.setBackground(new java.awt.Color(125, 125, 157));

        jLabel115.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel115.setText("Nombre:");

        namemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namempjTextField3ActionPerformed(evt);
            }
        });

        provmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Plasticos polinesios", "Fernan el plasticrack", "Plasticos peligrosos", "Fentanilo PLastico" }));

        unitmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitmpActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(10, 12, 91));

        existenciasmp.setBackground(new java.awt.Color(204, 204, 204));
        existenciasmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Unidad", "Medida", "Cantidad", "Tipo", "Proveedor"
            }
        ));
        jScrollPane1.setViewportView(existenciasmp);

        filtroTipomp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroTipompActionPerformed(evt);
            }
        });

        Todomp.setText("Todo");
        Todomp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TodompActionPerformed(evt);
            }
        });

        filtroProveedormp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroProveedormpActionPerformed(evt);
            }
        });

        actualizarmp.setText("Actualizar");
        actualizarmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarmpActionPerformed(evt);
            }
        });

        deletemp.setText("Eliminar");
        deletemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletempActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(actualizarmp)
                        .addGap(52, 52, 52)
                        .addComponent(deletemp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Todomp, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(filtroProveedormp, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(filtroTipomp, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroTipomp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Todomp)
                    .addComponent(filtroProveedormp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizarmp)
                    .addComponent(deletemp))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTextField1.setText("ID empleado");

        jLabel125.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel125.setText("Unidad: ");

        jLabel126.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel126.setText("Medida: ");

        jLabel127.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel127.setText("Cantidad: ");

        jLabel128.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel128.setText("Tipo: ");

        jLabel129.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel129.setText("Proveedor: ");

        jLabel130.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel130.setText("Solicitó: ");

        entermp.setBackground(new java.awt.Color(121, 145, 168));
        entermp.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        entermp.setForeground(new java.awt.Color(7, 16, 24));
        entermp.setText("Entrada");
        entermp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entermpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel129, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jLabel130, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel125, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel126, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel127, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel128, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typemp, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantmp, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(medmp, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unitmp, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(provmp, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(namemp)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(entermp, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel115)
                            .addComponent(namemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel125)
                            .addComponent(unitmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel126)
                            .addComponent(medmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cantmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel127))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(typemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel128))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel129)
                            .addComponent(provmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel130)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(entermp))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel18)
                .addGap(224, 224, 224)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namempjTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namempjTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namempjTextField3ActionPerformed

    private void unitmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitmpActionPerformed
        String seleccion = unitmp.getSelectedItem().toString();
        medmp.removeAllItems();
        switch (seleccion) {
            case "Liquido":
            medmp.addItem("Litros");
            break;
            case "Laminas":
            medmp.addItem("Lamina (10x10)");
            break;
            case "Granulos":
            case "Pellets":
            case "Pasta":
            case "Polvo":
            case "Preformas":
            medmp.addItem("Kilos");
            break;
        }
    }//GEN-LAST:event_unitmpActionPerformed

    private void filtroTipompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroTipompActionPerformed
        Filtros();
    }//GEN-LAST:event_filtroTipompActionPerformed

    private void entermpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entermpActionPerformed

        try {
            String nombre = namemp.getText().trim();
            String unidad = unitmp.getSelectedItem().toString();
            String medida = medmp.getSelectedItem().toString();
            int cantidad = Integer.parseInt(cantmp.getText().trim());
            String tipo = typemp.getSelectedItem().toString();
            String proveedor = provmp.getSelectedItem().toString();
            
            ControllersMateriaPrima mp = new ControllersMateriaPrima(
            nombre, unidad, medida, cantidad, tipo, proveedor
            );
            listaMateriaPrima.add(mp);
            
            modeloTabla.addRow(mp.toRow());
            
            Connection conn = conexionMP.getConnection();
            String sql = "INSERT INTO materia_prima (nombre, unidad, medida, cantidad, tipo, idProveedor, idEmpleado) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, nombre);
                ps.setString(2, unidad);
                ps.setString(3, medida);
                ps.setInt(4, cantidad);
                ps.setString(5, tipo);
                
                int idProveedor = obtenerIdProveedor(proveedor);
                if (idProveedor == -1){
                    JOptionPane.showMessageDialog(null, "Error: el proveedor" + proveedor + "no existe en la base de datos");
                    return; 
                }
                int idEmpleado = 1;
                
                ps.setInt(6, idProveedor);
                ps.setInt(7, idEmpleado);
                
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Materia Prima registrada correctamente");
                
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al guardar en la base de datos");
            }
            namemp.setText("");
            cantmp.setText("");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos");
        }
    }//GEN-LAST:event_entermpActionPerformed

    private void TodompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TodompActionPerformed
        filtroProveedormp.setSelectedItem("Filtrar por Proveedor");
        filtroTipomp.setSelectedItem("Filtrar por Tipo");
        cargarMateriaPrima();
    }//GEN-LAST:event_TodompActionPerformed

    private void filtroProveedormpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroProveedormpActionPerformed
        Filtros();
    }//GEN-LAST:event_filtroProveedormpActionPerformed

    private void actualizarmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarmpActionPerformed
      int filaSeleccionada = existenciasmp.getSelectedRow();
      if (filaSeleccionada == -1) {
          JOptionPane.showMessageDialog(null, "Seleccione una fila para actualizar");
          return;
      }
      try {
          String nombre = namemp.getText().trim();
          String unidad = unitmp.getSelectedItem().toString();
          String medida = medmp.getSelectedItem().toString();
          int cantidad = Integer.parseInt(cantmp.getText().trim());
          String tipo = typemp.getSelectedItem().toString();
          String proveedor = provmp.getSelectedItem().toString();
          
          int idProveedor = obtenerIdProveedor(proveedor);
          int idEmpleado = 1;
          
          int codigo = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
          
          Connection conn = conexionMP.getConnection();
          String sql = "UPDATE materia_prima SET nombre = ?, unidad = ?, medida = ?, cantidad = ?, tipo = ?, idProveedor = ?, idEmpleado = ? WHERE codigo = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, nombre);
          ps.setString(2, unidad);
          ps.setString(3, medida);
          ps.setInt(4, cantidad);
          ps.setString(5, tipo);
          ps.setInt(6, idProveedor);
          ps.setInt(7, idEmpleado);
          ps.setInt(8, codigo);
          
          ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "Materia Prima acualizada correctamente");
          
          cargarMateriaPrima(); 
      } catch (Exception e) {
          e.printStackTrace();
          JOptionPane.showMessageDialog(null, "Error al actualizar la Materia Prima");
      }
    }//GEN-LAST:event_actualizarmpActionPerformed

    private void deletempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletempActionPerformed
       int filaSeleccionada = existenciasmp.getSelectedRow();
       if (filaSeleccionada == -1) {
           JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
           return;
       }
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar esta materia prima?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION){
            try {
                int codigo = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
                Connection conn = conexionMP.getConnection();
                String sql = "DELETE FROM materia_prima WHERE codigo = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, codigo);
                ps.executeUpdate();
                modeloTabla.removeRow(filaSeleccionada);
                listaMateriaPrima.removeIf(mp -> mp.getCodigo() == codigo);
                JOptionPane.showMessageDialog(null, "Materia Prima eliminada correctamente");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar la materia prima");
            }
        }
    }//GEN-LAST:event_deletempActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Todomp;
    private javax.swing.JButton actualizarmp;
    private javax.swing.JTextField cantmp;
    private javax.swing.JButton deletemp;
    private javax.swing.JButton entermp;
    private javax.swing.JTable existenciasmp;
    private javax.swing.JComboBox<String> filtroProveedormp;
    private javax.swing.JComboBox<String> filtroTipomp;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> medmp;
    private javax.swing.JTextField namemp;
    private javax.swing.JComboBox<String> provmp;
    private javax.swing.JComboBox<String> typemp;
    private javax.swing.JComboBox<String> unitmp;
    // End of variables declaration//GEN-END:variables

    
}
