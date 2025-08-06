package Vista;

import Controllers.ControllersProductos;
import Controllers.ControllersProveedor;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Productos extends javax.swing.JInternalFrame {

    ControllersProductos p = new ControllersProductos();
    DefaultTableModel model = new DefaultTableModel();

    private void limpiarCampos() {
    idProducto.setText("");
    existencia.setText("");
    precio.setText("");
    costo.setText("");
    ganancia.setText("");
    tipo.setSelectedIndex(0);
    categoria.setSelectedIndex(0);
    nombre.setSelectedIndex(0);
    tamanio.setSelectedIndex(0);
}
    public void categoria1() {
        ArrayList<String> Items = new ArrayList<>();
//Termoestables
        Items.add("Limpieza");
        Items.add("Hogar y cocina");

        categoria.removeAllItems();

        for (String categorias : Items) {
            categoria.addItem(categorias);
        }
    }
    public void categoria2() {
        ArrayList<String> Items = new ArrayList<>();
//Termoplasticos
        Items.add("Bolsas y empaques");
        Items.add("Descartables y alimentos");

        categoria.removeAllItems();

        for (String categorias : Items) {
            categoria.addItem(categorias);
        }
    }
    public void nombre1() {
        ArrayList<String> Items = new ArrayList<>();
        Items.add("Cubeta");
        Items.add("Recojedores");
        Items.add("Escobas con mango de plastico");
        Items.add("Bote de basura");

        nombre.removeAllItems();

        for (String categorias : Items) {
            nombre.addItem(categorias);
        }
    }
    public void nombre2() {
        ArrayList<String> Items = new ArrayList<>();
        Items.add("Contenedores con tapa");
        Items.add("Coladores");
        Items.add("Organizadores");
        Items.add("Cajas multiuso");

        nombre.removeAllItems();

        for (String categorias : Items) {
            nombre.addItem(categorias);
        }
    }
    public void nombre3() {
        ArrayList<String> Items = new ArrayList<>();
        Items.add("Bolsa camiseta");
        Items.add("Bolsa de basura");
        Items.add("Rollo de polietileno");
        Items.add("Rollo de bolsa");

        nombre.removeAllItems();

        for (String categorias : Items) {
            nombre.addItem(categorias);
        }
    }
    public void nombre4() {
        ArrayList<String> Items = new ArrayList<>();
        Items.add("Vasos termicos");
        Items.add("Tenedores, cucharas y cuchillos");
        Items.add("Platos y charolas");
        Items.add("Vaso plastico");

        nombre.removeAllItems();

        for (String categorias : Items) {
            nombre.addItem(categorias);
        }
    }
    public void cubeta() {
ArrayList<String> Items = new ArrayList<>();
        Items.add("5 galones");
        Items.add("2 galones");
        Items.add("1/4 de galon");

        nombre.removeAllItems();

        for (String categorias : Items) {
            nombre.addItem(categorias);
        }
    }
    public void boteBasura() {
        ArrayList<String> Items = new ArrayList<>();
        Items.add("10 galones");
        Items.add("7 galones");
        Items.add("3 galones");
        Items.add("1/4 de galon");

        nombre.removeAllItems();

        for (String categorias : Items) {
            nombre.addItem(categorias);
        }
    }
    public void vasoTermico(){
       ArrayList<String> Items = new ArrayList<>();
        Items.add("VT4A");
        Items.add("VT6");
        Items.add("VT12");
        Items.add("VT16");
        Items.add("VT1LT");
        Items.add("VT60");
        tamanio.removeAllItems();

        for (String nombres : Items) {
            tamanio.addItem(nombres);
        } 
    }
    public void TamannioNormal() {
        ArrayList<String> Items = new ArrayList<>();
        Items.add("Chico");
        Items.add("Mediano");
        Items.add("Grande");
       
        tamanio.removeAllItems();

        for (String nombres : Items) {
            tamanio.addItem(nombres);
        }
    }
    public void vasoPlastico() {
ArrayList<String> Items = new ArrayList<>();
        Items.add("VP8");
        Items.add("VP10");
        Items.add("VP12");
        Items.add("VP14");
        Items.add("VP16A");
        Items.add("ENV1/4LT");
        Items.add("ENV1/2LT");
        Items.add("ENV1LT");
        tamanio.removeAllItems();

        for (String nombres : Items) {
            tamanio.addItem(nombres);
        }
    }
    public void platos(){
        ArrayList<String> Items = new ArrayList<>();
        Items.add("CH8535");
        Items.add("CH066MA");
        Items.add("CH007");
        Items.add("CH8S");
        Items.add("CH5D");
        Items.add("PT006");
        Items.add("PH6");
        Items.add("PH10");
        tamanio.removeAllItems();

        for (String nombres : Items) {
            tamanio.addItem(nombres);
        }
    }
    private boolean validarCampos() {
        if (idProducto.getText().isEmpty() || existencia.getText().isEmpty()
                || precio.getText().isEmpty() || costo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            return false;
        }
        return true;
    }
    public Productos() {
        initComponents();
        p.CargarDatos(tabla, model);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        idProducto = new javax.swing.JTextField();
        existencia = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        costo = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        seleccionar = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tipo = new javax.swing.JComboBox<>();
        categoria = new javax.swing.JComboBox<>();
        nombre = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tamanio = new javax.swing.JComboBox<>();
        ganancia = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel2.setBackground(new java.awt.Color(7, 16, 24));

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO PRODUCTOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(56, 80, 106));

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CÓDIGO");

        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TIPO");

        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PRECIO VENTA");

        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("EXISTENCIA");

        jLabel7.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("GANANCIA");

        jLabel8.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("COSTO ARTÍCULO");

        idProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idProductoActionPerformed(evt);
            }
        });

        guardar.setBackground(new java.awt.Color(7, 16, 24));
        guardar.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        seleccionar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "CREAR", "BUSCAR", "ACTUALIZAR", "ELIMINAR", "ACTIVAR" }));

        jLabel10.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("NOMBRE");

        jLabel11.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CATEGORIA");

        tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Termoestable", "Termoplasticos" }));
        tipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoItemStateChanged(evt);
            }
        });
        tipo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tipoPropertyChange(evt);
            }
        });

        categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Limpieza", "Hogar", "Bolsas", "Descartables" }));
        categoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoriaItemStateChanged(evt);
            }
        });

        nombre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        nombre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nombreItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TAMAÑO");

        tamanio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ganancia.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)))
                    .addComponent(seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7))
                        .addGap(120, 120, 120)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idProducto)
                            .addComponent(tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nombre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(existencia)
                            .addComponent(precio)
                            .addComponent(costo)
                            .addComponent(tamanio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ganancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(existencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tamanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ganancia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guardar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(121, 145, 168));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOMBRE", "TIPO", "CATEGORÍA", "EXISTENCIA", "PRECIO ", "COSTO", "TAMAÑO"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idProductoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed

        switch (seleccionar.getSelectedIndex()) {
            case 0:
                //seleccionar
                JOptionPane.showMessageDialog(null, "Elige una opcion");
                break;
            case 1:
                //Crear
                int id = Integer.parseInt(idProducto.getText());
                int idCat = categoria.getSelectedIndex();
                String name = nombre.getSelectedItem().toString();
                String type = tipo.getSelectedItem().toString();
                int stock = Integer.parseInt(existencia.getText());
                double price = Double.parseDouble(precio.getText());
                double cost = Double.parseDouble(costo.getText());
                String tam = tamanio.getSelectedItem().toString();
                Double gan = price - cost;
                ganancia.setText(String.valueOf(gan));
                validarCampos();
                p.registrarProducto(id, idCat, type, name, price, stock, cost, tam, gan);
                limpiarCampos();
                break;
            case 2:
                //Buscar
                int idBuscar = Integer.parseInt(idProducto.getText());
                p.buscar(idBuscar, model, tabla);
                break;
            case 3:
                //Actualizar
                double newPrice = Double.parseDouble(precio.getText());
                int newStock = Integer.parseInt(existencia.getText());
                double newCosto = Double.parseDouble(costo.getText());
                String tama = tamanio.getSelectedItem().toString();
                Double newGanancia = newPrice - newCosto;
                int Id = Integer.parseInt(idProducto.getText());
                p.actualizarProducto(newPrice, newStock, newCosto, tama,newGanancia, Id);
                break;
            case 4:
                //Eliminar
                int idDesactivar = Integer.parseInt(idProducto.getText());
                p.desactivarProducto(idDesactivar);
                break;
            case 5:
                //ActivarProducto
                int idActivar = Integer.parseInt(idProducto.getText());
                int stockActivar = Integer.parseInt(existencia.getText());
                JOptionPane.showMessageDialog(null, "Ingresa el id del producto que quieres activar y el numero de productos");
                p.activar(idActivar, stockActivar);
                break;
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void tipoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tipoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoPropertyChange

    private void tipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (this.categoria.getSelectedIndex() > 0) {
                System.out.println(categoria.getSelectedItem().toString());
            }
        }

        switch (tipo.getSelectedIndex()) {
            case 0:
                this.categoria.removeAllItems();
                break;
            case 1:
                categoria1();
                break;

            case 2:
                categoria2();
                break;
        }
    }//GEN-LAST:event_tipoItemStateChanged

    private void categoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoriaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (this.categoria.getSelectedIndex() > 0) {
                System.out.println(categoria.getSelectedItem().toString());
            }
        }

        switch (categoria.getSelectedItem().toString().toUpperCase()) {
            case "LIMPIEZA":
                nombre1();
                break;
            case "HOGAR Y COCINA":
                nombre2();
                break;
            case "BOLSAS Y EMPAQUES":
                nombre3();
                break;
            case "DESCARTABLES Y ALIMENTOS":
                nombre4();
                break;
        }
    }//GEN-LAST:event_categoriaItemStateChanged

    private void nombreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nombreItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(this.nombre.getSelectedIndex()> 0 ){
                System.out.println(categoria.getSelectedItem().toString());
            }
        }
        switch (nombre.getSelectedItem().toString().toUpperCase()) {
            case "CUBETA":
                cubeta();
                break;
            case "RECOJEDORES":
                 this.tamanio.addItem("Sin tamannio");
                break;
            case "ESCOBAS CON MANGO DE PLASTICO":
                 this.tamanio.addItem("Sin tamannio");                
                break;
            case "BOTE DE BASURA":
                boteBasura();
                break;
            case "CONTENEDORES CON TAPA":
                TamannioNormal();
                break;
            case "COLADORES":
                TamannioNormal();
                break;
            case "ORGANIZADOREZ":
                this.tamanio.addItem("Sin tamannio");
                break;
            case "CAJAS MULTIUSO":
                TamannioNormal();
                break;
            case "BOLSAS CAMISETA":
                TamannioNormal();
                break;
            case "BOLSA DE BASURA":
                TamannioNormal();
                break;
            case "ROLLO DE POLIETILENO":
                 this.tamanio.addItem("Sin tamannio");
                break;
            case "ROLLO DE BOLSA":
                 this.tamanio.addItem("Sin tamannio");
                break;
            case "VASOS TERMICOS":
                vasoTermico();
                break;
            case "TENEDORES, CUCHARAS Y CUCHILLOS":
                this.tamanio.addItem("Sin tamannio");
                break;
            case "PLATOS Y CHAROLAS":
                platos();
                break;
            case "VASO PLASTICO":
                vasoPlastico();
                break;
        }
    }//GEN-LAST:event_nombreItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> categoria;
    private javax.swing.JTextField costo;
    private javax.swing.JTextField existencia;
    private javax.swing.JLabel ganancia;
    private javax.swing.JButton guardar;
    private javax.swing.JTextField idProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> nombre;
    private javax.swing.JTextField precio;
    private javax.swing.JComboBox<String> seleccionar;
    private javax.swing.JTable tabla;
    private javax.swing.JComboBox<String> tamanio;
    private javax.swing.JComboBox<String> tipo;
    // End of variables declaration//GEN-END:variables
}
