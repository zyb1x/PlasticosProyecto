
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
    
    public void categoria1(){
        ArrayList<String> Items = new ArrayList<>();
//Termoestables
        Items.add("Limpieza");
        Items.add("Hogar y cocina");
        
        categoria.removeAllItems();
        
        for (String categorias: Items) {
            categoria.addItem(categorias);
        }
    }
    public void categoria2(){
        ArrayList<String> Items = new ArrayList<>();
//Termoplasticos
        Items.add("Bolsas y empaques");
        Items.add("Descartables y alimentos");
        
        categoria.removeAllItems();
        
        for (String categorias: Items) {
            categoria.addItem(categorias);
        }
    }
    public void nombre1(){
        ArrayList<String> Items = new ArrayList<>();
  /*
  Limpieza
  -cubeta()
  •5 galones
  •2 galones
  •1/4 de galón
-recojedores
-escobas con mango plástico 
-bote de basura
  •10 galones
  •7 galones
  •3 galones
  •tapa balancín 
  •flowell
*/
        Items.add("Cubeta");
        Items.add("Recojedores");
        Items.add("Escobas con mango de plastico");
        Items.add("Bote de basura");
        
        nombre.removeAllItems();
        
        for (String categorias: Items) {
            nombre.addItem(categorias);
        }
    }
    
    public void nombre2(){
         ArrayList<String> Items = new ArrayList<>();
  /*
  Hogar y cocina       
  -contenedores con tapa
  •Chico
  •Mediano
  •Grande
-coladores
  •Chico
  •Mediano
  •Grande
-organizadores
-cajas multiuso
  •Chica
  •Mediana
  •Grande
*/
        Items.add("Contenedores con tapa");
        Items.add("Coladores");
        Items.add("Organizadores");
        Items.add("Cajas multiusos");
        
        nombre.removeAllItems();
        
        for (String categorias: Items) {
            nombre.addItem(categorias);
        }
    }
    
    public void nombre3(){
        ArrayList<String> Items = new ArrayList<>();
        //termoplasticos
        /*
  Bolsas y empaques
  -Bolsas camiseta
  •Chica
  •Mediana
  •Grande
-bolsa de basura
  •Chica
  •Mediana
  •Grande
  •Jumbo
-rollo de polietileno
-rollo de bolsa
*/
        Items.add("Bolsa de camiseta");
        Items.add("Bolsa de basura");
        Items.add("Rollo de polietileno");
        Items.add("Rollo de bolsa");
        
        nombre.removeAllItems();
        
        for (String categorias: Items) {
            nombre.addItem(categorias);
        }
    }
    
    public void nombre4(){
        ArrayList<String> Items = new ArrayList<>();
        /*
        Descartables alimentos
        -vasos térmicos
  •VT4A
  •VT6
  •VT12
  •VT16
  •VT1LT
  •VT60
-tenedores, cucharas y cuchillos
-platos y Charolas 
 •CH8535
 •CH066MA
  •CH007
  •CH8S
  •CH5D
  •PT006
  •PH6
  •PH10
-vaso plástico 
  •VP8
  •VP10
  •VP12
  •VP14
  •VP16A
  •VP16L
  •ENV1/4LT
  •ENV1/2LT
  •ENV1LT
        */
        Items.add("Vasos termicos");
        Items.add("Tenedores, cucharas y cuchillos");
        Items.add("Platos y charolas");
        Items.add("Vawso plastico");
        
        nombre.removeAllItems();
        
        for (String categorias: Items) {
            nombre.addItem(categorias);
        }
    }

    public Productos() {
        initComponents();
        p.CargarDatos(tabla, model);
        
        switch(seleccionar.getSelectedIndex()){
            case 0:
                //seleccionar
                JOptionPane.showMessageDialog(null, "Elige una opcion");
                break;
            case 1:
                //Crear
                break;
            case 2:
                precio.setEnabled(false);
                existencia.setEnabled(false);
                costo.setEnabled(false);
                ganancia.setEnabled(false);
                break;
            case 3:
                //Actualizar
                idProducto.setEnabled(false);
                tipo.setEnabled(false);
                categoria.setEnabled(false);
                nombre.setEnabled(false);
                break;
            case 4:
                //Eliminar
                break;
            case 5:
                //ActivarProducto
                JOptionPane.showMessageDialog(null, "Ingresa el id del producto que quieres activar y el numero de productos");
                tipo.setEnabled(false);
                categoria.setEnabled(false);
                nombre.setEnabled(false);
                tamanio.setEnabled(false);
                precio.setEnabled(false);
                costo.setEnabled(false);
                ganancia.setEnabled(false);
                break;
        }
    }
    /*public void listarProveedor() { empezar desde aqui**
    List<ControllersProveedor> ListarPr = pr.listarProveedor();
    DefaultTableModel modelo = (DefaultTableModel) TablaProveedor.getModel();
    Object[] ob = new Object[5];
    
    modelo.setRowCount(0); // limpia la tabla antes de llenarla
    
    for (int i = 0; i < ListarPr.size(); i++) {
    ob[0] = ListarPr.get(i).getId();
    ob[1] = ListarPr.get(i).getNombre();
    ob[2] = ListarPr.get(i).getRfc();
    ob[3] = ListarPr.get(i).getDireccion();
    ob[4] = ListarPr.get(i).getTelefono();
    modelo.addRow(ob);
    }
    
    TablaProveedor.setModel(modelo);
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

        seleccionar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "CREAR", "BUSCAR", "ACTUALIZAR", "ELIMINAR" }));

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
                            .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idProducto)
                            .addComponent(tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nombre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(existencia)
                            .addComponent(precio)
                            .addComponent(costo)
                            .addComponent(tamanio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ganancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(guardar)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(121, 145, 168));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
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
                .addContainerGap(172, Short.MAX_VALUE))
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idProductoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
   
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
    
     switch(seleccionar.getSelectedIndex()){
            case 0:
                //seleccionar
                JOptionPane.showMessageDialog(null, "Elige una opcion");
                break;
            case 1:
                //Crear
        p.registrarProducto(id,idCat,type,name,price,stock,cost,tam,gan);                
                break;
            case 2:
                p.buscar(id, model, tabla);
                break;
            case 3:
                //Actualizar
                p.actualizarProducto(price, stock, cost, tam, id);
                break;
            case 4:
                //Eliminar
                p.desactivarProducto(id);
                break;
            case 5:
                //ActivarProducto
                JOptionPane.showMessageDialog(null, "Ingresa el id del producto que quieres activar y el numero de productos");
                p.activar(id, stock);
                break;
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void tipoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tipoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoPropertyChange

    private void tipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED ){
            if(this.categoria.getSelectedIndex()>0){
                System.out.println(categoria.getSelectedItem().toString());
            }
        }
        
        switch(tipo.getSelectedIndex()){
            case 0:
                this.categoria.removeAllItems();
                break;
            case 1:
                categoria1();
                if(categoria.getSelectedIndex()==1){
                    nombre1();
                }else if(categoria.getSelectedIndex()==2){
                    nombre2();
                }
                break;

            case 2:
                categoria2();
                if(categoria.getSelectedIndex()==1){
                    nombre3();
                }else if(categoria.getSelectedIndex()==2){
                    nombre4();
                }
                break;
        }
    }//GEN-LAST:event_tipoItemStateChanged

    private void categoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoriaItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED ){
            if(this.nombre.getSelectedIndex()>0){
                System.out.println(nombre.getSelectedItem().toString());
            }
        }
        
        switch(categoria.getSelectedIndex()){
            case 0:
                this.nombre.removeAllItems();
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }//GEN-LAST:event_categoriaItemStateChanged


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
