package UI;

import BEAN.Empleado;
import DAO.EmpleadoDAO;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmEmpleado extends javax.swing.JFrame {
    private int idEmpleado;
    private EmpleadoDAO empDao;
    private DefaultTableModel dtm;
    private Vector<Vector> listaEtnias;
    private Vector<Vector> listaEstadosCiviles;
    private Vector<Vector> listaGeneros;
    private Vector<Vector> listaEstados;

    public FrmEmpleado() {
        initComponents();
        empDao = new EmpleadoDAO();
        dtm = (DefaultTableModel)this.tblEmpleados.getModel();
        llenaCmbIdEtnia();
        llenaCmbIdEstCivil();
        llenaCmbIdGenero();
        llenaCmbIdEstado();

        llenaTblEmpleados("");
    }

    private void llenaTblEmpleados(String cad){
        Vector<Empleado> listaEmpleados;
        try{
            listaEmpleados = empDao.listaEmpleados(cad);
            dtm.setRowCount(0);
            for(int i=0;i<listaEmpleados.size();i++){
                Vector vec = new Vector();
                vec.addElement(listaEmpleados.get(i).getIdEmpleado());
                vec.addElement(listaEmpleados.get(i).getIdEtnia());
                vec.addElement(listaEmpleados.get(i).getIdEstCivil());
                vec.addElement(listaEmpleados.get(i).getIdGenero());
                vec.addElement(listaEmpleados.get(i).getApellidos());
                vec.addElement(listaEmpleados.get(i).getNombres());
                vec.addElement(listaEmpleados.get(i).getFechNac());
                vec.addElement(listaEmpleados.get(i).getIdEstado());

                dtm.addRow(vec);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo listar Empleados.");
        }
    }

    private void llenaCmbIdEtnia(){
        this.cmbIdEtnia.addItem("");
        try{
            this.listaEtnias = empDao.listaEtnias();
            for(int i=0;i<this.listaEtnias.size();i++){
                this.cmbIdEtnia.addItem(this.listaEtnias.get(i).get(0).toString() +" - "+ this.listaEtnias.get(i).get(1).toString());
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo cargar Etnia.");
        }
    }

    private void llenaCmbIdEstCivil(){
        this.cmbIdEstCivil.addItem("");
        try{
            this.listaEstadosCiviles = empDao.listaEstadosCiviles();
            for(int i=0;i<this.listaEstadosCiviles.size();i++){
                this.cmbIdEstCivil.addItem(this.listaEstadosCiviles.get(i).get(0).toString() +" - "+ this.listaEstadosCiviles.get(i).get(1).toString());
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo cargar Estado civil.");
        }
    }

    private void llenaCmbIdGenero(){
        this.cmbIdGenero.addItem("");
        try{
            this.listaGeneros = empDao.listaGeneros();
            for(int i=0;i<this.listaGeneros.size();i++){
                this.cmbIdGenero.addItem(this.listaGeneros.get(i).get(0).toString() +" - "+ this.listaGeneros.get(i).get(1).toString());
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo cargar Género.");
        }
    }

    private void llenaCmbIdEstado(){
        this.cmbIdEstado.addItem("");
        try{
            this.listaEstados = empDao.listaEstados();
            for(int i=0;i<this.listaEstados.size();i++){
                this.cmbIdEstado.addItem(this.listaEstados.get(i).get(0).toString() +" - "+ this.listaEstados.get(i).get(1).toString());
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo cargar Estado.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mantenimiento Empleado - BD_RRHH");
        getContentPane().setLayout(null);
        lblIdEmpleado = new javax.swing.JLabel("Id empleado");
        getContentPane().add(lblIdEmpleado); lblIdEmpleado.setBounds(20,55,140,25);
        txtIdEmpleado = new javax.swing.JTextField();
        getContentPane().add(txtIdEmpleado); txtIdEmpleado.setBounds(170,55,245,25);
        txtIdEmpleado.setEnabled(false);
        lblIdEtnia = new javax.swing.JLabel("Etnia");
        getContentPane().add(lblIdEtnia); lblIdEtnia.setBounds(20,93,140,25);
        cmbIdEtnia = new javax.swing.JComboBox();
        getContentPane().add(cmbIdEtnia); cmbIdEtnia.setBounds(170,93,245,25);
        lblIdEstCivil = new javax.swing.JLabel("Estado civil");
        getContentPane().add(lblIdEstCivil); lblIdEstCivil.setBounds(20,131,140,25);
        cmbIdEstCivil = new javax.swing.JComboBox();
        getContentPane().add(cmbIdEstCivil); cmbIdEstCivil.setBounds(170,131,245,25);
        lblIdGenero = new javax.swing.JLabel("Género");
        getContentPane().add(lblIdGenero); lblIdGenero.setBounds(20,169,140,25);
        cmbIdGenero = new javax.swing.JComboBox();
        getContentPane().add(cmbIdGenero); cmbIdGenero.setBounds(170,169,245,25);
        lblApellidos = new javax.swing.JLabel("Apellidos");
        getContentPane().add(lblApellidos); lblApellidos.setBounds(20,207,140,25);
        txtApellidos = new javax.swing.JTextField();
        getContentPane().add(txtApellidos); txtApellidos.setBounds(170,207,245,25);
        lblNombres = new javax.swing.JLabel("Nombres");
        getContentPane().add(lblNombres); lblNombres.setBounds(20,245,140,25);
        txtNombres = new javax.swing.JTextField();
        getContentPane().add(txtNombres); txtNombres.setBounds(170,245,245,25);
        lblFechNac = new javax.swing.JLabel("Fecha nacimiento");
        getContentPane().add(lblFechNac); lblFechNac.setBounds(20,283,140,25);
        txtFechNac = new javax.swing.JTextField();
        getContentPane().add(txtFechNac); txtFechNac.setBounds(170,283,245,25);
        lblIdEstado = new javax.swing.JLabel("Estado");
        getContentPane().add(lblIdEstado); lblIdEstado.setBounds(20,321,140,25);
        cmbIdEstado = new javax.swing.JComboBox();
        getContentPane().add(cmbIdEstado); cmbIdEstado.setBounds(170,321,245,25);

        lblTitulo = new javax.swing.JLabel("MANTENIMIENTO Empleado");
        getContentPane().add(lblTitulo); lblTitulo.setBounds(20,15,600,25);
        lblBuscar = new javax.swing.JLabel("Buscar");
        getContentPane().add(lblBuscar); lblBuscar.setBounds(445,55,70,25);
        txtBuscar = new javax.swing.JTextField();
        getContentPane().add(txtBuscar); txtBuscar.setBounds(520,55,630,25);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) { txtBuscarKeyReleased(evt); }
        });
        tblEmpleados = new javax.swing.JTable();
        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
            new String[]{"Id empleado","Etnia","Estado civil","Género","Apellidos","Nombres","Fecha nacimiento","Estado"}) {
            public boolean isCellEditable(int rowIndex,int columnIndex) { return false; }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { tblEmpleadosMouseClicked(evt); }
        });
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportView(tblEmpleados);
        getContentPane().add(jScrollPane1); jScrollPane1.setBounds(445,95,705,300);
        btnGrabar = new javax.swing.JButton("Grabar");
        getContentPane().add(btnGrabar); btnGrabar.setBounds(80,430,130,30);
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnGrabarActionPerformed(evt); }
        });
        btnLimpiar = new javax.swing.JButton("Limpiar");
        getContentPane().add(btnLimpiar); btnLimpiar.setBounds(300,430,130,30);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnLimpiarActionPerformed(evt); }
        });
        btnEliminar = new javax.swing.JButton("Eliminar");
        getContentPane().add(btnEliminar); btnEliminar.setBounds(520,430,130,30);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnEliminarActionPerformed(evt); }
        });
        btnSalir = new javax.swing.JButton("Salir");
        getContentPane().add(btnSalir); btnSalir.setBounds(740,430,130,30);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnSalirActionPerformed(evt); }
        });
        setSize(1200,540);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(this.txtBuscar.getText().isEmpty()){
            this.llenaTblEmpleados("");
        }else{
            this.llenaTblEmpleados(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(valida()==true){
            Empleado emp = new Empleado();
            if(this.cmbIdEtnia.getSelectedIndex()<=0){
                emp.setIdEtnia("");
            }else{
                emp.setIdEtnia(this.listaEtnias.get(this.cmbIdEtnia.getSelectedIndex()-1).get(0).toString());
            }
            if(this.cmbIdEstCivil.getSelectedIndex()<=0){
                emp.setIdEstCivil("");
            }else{
                emp.setIdEstCivil(this.listaEstadosCiviles.get(this.cmbIdEstCivil.getSelectedIndex()-1).get(0).toString());
            }
            if(this.cmbIdGenero.getSelectedIndex()<=0){
                emp.setIdGenero("");
            }else{
                emp.setIdGenero(this.listaGeneros.get(this.cmbIdGenero.getSelectedIndex()-1).get(0).toString());
            }
            emp.setApellidos(this.txtApellidos.getText());
            emp.setNombres(this.txtNombres.getText());
            emp.setFechNac(this.txtFechNac.getText());
            if(this.cmbIdEstado.getSelectedIndex()<=0){
                emp.setIdEstado("");
            }else{
                emp.setIdEstado(this.listaEstados.get(this.cmbIdEstado.getSelectedIndex()-1).get(0).toString());
            }

            try{
                if(this.btnGrabar.getText().equals("Grabar")){
                    this.empDao.insertaEmpleado(emp);
                }else{
                    emp.setIdEmpleado(idEmpleado);
                    this.empDao.actualizaEmpleado(emp);
                }
                limpia();
                this.llenaTblEmpleados("");
                JOptionPane.showMessageDialog(this, "Empleado registrado satisfactoriamente");
            }catch(java.sql.SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "No se pudo guardar. Revise los datos, las fechas y las relaciones seleccionadas.");
            }
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        int idx;
        idx = this.tblEmpleados.getSelectedRow();
        if(idx<0){
            return;
        }
        this.idEmpleado = Integer.parseInt(dtm.getValueAt(idx,0).toString());
        this.txtIdEmpleado.setText(dtm.getValueAt(idx,0) == null ? "" : dtm.getValueAt(idx,0).toString());
        this.cmbIdEtnia.setSelectedIndex(0);
        if(dtm.getValueAt(idx,1) != null && this.listaEtnias != null){
            for(int i=0;i<this.listaEtnias.size();i++){
                if(this.listaEtnias.get(i).get(0).toString().equals(dtm.getValueAt(idx,1).toString())){
                    this.cmbIdEtnia.setSelectedIndex(i+1);
                }
            }
        }
        this.cmbIdEstCivil.setSelectedIndex(0);
        if(dtm.getValueAt(idx,2) != null && this.listaEstadosCiviles != null){
            for(int i=0;i<this.listaEstadosCiviles.size();i++){
                if(this.listaEstadosCiviles.get(i).get(0).toString().equals(dtm.getValueAt(idx,2).toString())){
                    this.cmbIdEstCivil.setSelectedIndex(i+1);
                }
            }
        }
        this.cmbIdGenero.setSelectedIndex(0);
        if(dtm.getValueAt(idx,3) != null && this.listaGeneros != null){
            for(int i=0;i<this.listaGeneros.size();i++){
                if(this.listaGeneros.get(i).get(0).toString().equals(dtm.getValueAt(idx,3).toString())){
                    this.cmbIdGenero.setSelectedIndex(i+1);
                }
            }
        }
        this.txtApellidos.setText(dtm.getValueAt(idx,4) == null ? "" : dtm.getValueAt(idx,4).toString());
        this.txtNombres.setText(dtm.getValueAt(idx,5) == null ? "" : dtm.getValueAt(idx,5).toString());
        this.txtFechNac.setText(dtm.getValueAt(idx,6) == null ? "" : dtm.getValueAt(idx,6).toString());
        this.cmbIdEstado.setSelectedIndex(0);
        if(dtm.getValueAt(idx,7) != null && this.listaEstados != null){
            for(int i=0;i<this.listaEstados.size();i++){
                if(this.listaEstados.get(i).get(0).toString().equals(dtm.getValueAt(idx,7).toString())){
                    this.cmbIdEstado.setSelectedIndex(i+1);
                }
            }
        }

        this.btnGrabar.setText("Actualiza");
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void limpia(){
        this.idEmpleado = 0;
        this.txtIdEmpleado.setText("");
        this.cmbIdEtnia.setSelectedIndex(0);
        this.cmbIdEstCivil.setSelectedIndex(0);
        this.cmbIdGenero.setSelectedIndex(0);
        this.txtApellidos.setText("");
        this.txtNombres.setText("");
        this.txtFechNac.setText("");
        this.cmbIdEstado.setSelectedIndex(0);

        this.txtBuscar.setText("");
        this.btnGrabar.setText("Grabar");
        this.tblEmpleados.clearSelection();
    }

    private boolean valida(){
        boolean sw = false;
        String cad = "";
        if(this.txtApellidos.getText().trim().isEmpty()){
            cad += "\nDebe registrar Apellidos.";
        }
        if(this.txtApellidos.getText().length()>100){
            cad += "\nApellidos admite hasta 100 caracteres.";
        }
        if(this.txtNombres.getText().trim().isEmpty()){
            cad += "\nDebe registrar Nombres.";
        }
        if(this.txtNombres.getText().length()>100){
            cad += "\nNombres admite hasta 100 caracteres.";
        }
        if(this.txtFechNac.getText().length()>10){
            cad += "\nFecha nacimiento admite hasta 10 caracteres.";
        }
        if(!this.txtFechNac.getText().isEmpty() && !this.txtFechNac.getText().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")){
            cad += "\nUse yyyy-MM-dd en Fecha nacimiento.";
        }

        if(cad.isEmpty()){
            sw = true;
        }else{
            JOptionPane.showMessageDialog(this,cad);
        }
        return sw;
    }

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpia();
        this.llenaTblEmpleados("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(this.tblEmpleados.getSelectedRow()<0){
            JOptionPane.showMessageDialog(this,"Debe seleccionar un registro.");
            return;
        }
        try{
            this.empDao.eliminaEmpleado(idEmpleado);
            limpia();
            this.llenaTblEmpleados("");
            JOptionPane.showMessageDialog(this,"Empleado eliminado satisfactoriamente");
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"No se pudo eliminar. El registro puede estar relacionado con otros datos.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { new FrmEmpleado().setVisible(true); }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIdEmpleado;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JLabel lblIdEtnia;
    private javax.swing.JComboBox cmbIdEtnia;
    private javax.swing.JLabel lblIdEstCivil;
    private javax.swing.JComboBox cmbIdEstCivil;
    private javax.swing.JLabel lblIdGenero;
    private javax.swing.JComboBox cmbIdGenero;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JLabel lblFechNac;
    private javax.swing.JTextField txtFechNac;
    private javax.swing.JLabel lblIdEstado;
    private javax.swing.JComboBox cmbIdEstado;

    private javax.swing.JLabel lblTitulo,lblBuscar;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton btnGrabar,btnLimpiar,btnEliminar,btnSalir;
    // End of variables declaration//GEN-END:variables
}