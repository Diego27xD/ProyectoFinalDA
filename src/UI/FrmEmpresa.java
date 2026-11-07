package UI;

import BEAN.Empresa;
import DAO.EmpresaDAO;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmEmpresa extends javax.swing.JFrame {
    private int idEmpresa;
    private EmpresaDAO emprDao;
    private DefaultTableModel dtm;

    public FrmEmpresa() {
        initComponents();
        emprDao = new EmpresaDAO();
        dtm = (DefaultTableModel)this.tblEmpresas.getModel();

        llenaTblEmpresas("");
    }

    private void llenaTblEmpresas(String cad){
        Vector<Empresa> listaEmpresas;
        try{
            listaEmpresas = emprDao.listaEmpresas(cad);
            dtm.setRowCount(0);
            for(int i=0;i<listaEmpresas.size();i++){
                Vector vec = new Vector();
                vec.addElement(listaEmpresas.get(i).getIdEmpresa());
                vec.addElement(listaEmpresas.get(i).getDescrip());
                vec.addElement(listaEmpresas.get(i).getTipoEmp());
                vec.addElement(listaEmpresas.get(i).getDireccion());
                vec.addElement(listaEmpresas.get(i).getTlf());
                vec.addElement(listaEmpresas.get(i).getPersContacto());
                vec.addElement(listaEmpresas.get(i).getWeb());

                dtm.addRow(vec);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo listar Empresas.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mantenimiento Empresa - BD_RRHH");
        getContentPane().setLayout(null);
        lblIdEmpresa = new javax.swing.JLabel("Id empresa");
        getContentPane().add(lblIdEmpresa); lblIdEmpresa.setBounds(20,55,140,25);
        txtIdEmpresa = new javax.swing.JTextField();
        getContentPane().add(txtIdEmpresa); txtIdEmpresa.setBounds(170,55,245,25);
        txtIdEmpresa.setEnabled(false);
        lblDescrip = new javax.swing.JLabel("Descripción");
        getContentPane().add(lblDescrip); lblDescrip.setBounds(20,93,140,25);
        txtDescrip = new javax.swing.JTextField();
        getContentPane().add(txtDescrip); txtDescrip.setBounds(170,93,245,25);
        lblTipoEmp = new javax.swing.JLabel("Tipo empresa");
        getContentPane().add(lblTipoEmp); lblTipoEmp.setBounds(20,131,140,25);
        txtTipoEmp = new javax.swing.JTextField();
        getContentPane().add(txtTipoEmp); txtTipoEmp.setBounds(170,131,245,25);
        lblDireccion = new javax.swing.JLabel("Dirección");
        getContentPane().add(lblDireccion); lblDireccion.setBounds(20,169,140,25);
        txtDireccion = new javax.swing.JTextField();
        getContentPane().add(txtDireccion); txtDireccion.setBounds(170,169,245,25);
        lblTlf = new javax.swing.JLabel("Teléfono");
        getContentPane().add(lblTlf); lblTlf.setBounds(20,207,140,25);
        txtTlf = new javax.swing.JTextField();
        getContentPane().add(txtTlf); txtTlf.setBounds(170,207,245,25);
        lblPersContacto = new javax.swing.JLabel("Persona contacto");
        getContentPane().add(lblPersContacto); lblPersContacto.setBounds(20,245,140,25);
        txtPersContacto = new javax.swing.JTextField();
        getContentPane().add(txtPersContacto); txtPersContacto.setBounds(170,245,245,25);
        lblWeb = new javax.swing.JLabel("Web");
        getContentPane().add(lblWeb); lblWeb.setBounds(20,283,140,25);
        txtWeb = new javax.swing.JTextField();
        getContentPane().add(txtWeb); txtWeb.setBounds(170,283,245,25);

        lblTitulo = new javax.swing.JLabel("MANTENIMIENTO Empresa");
        getContentPane().add(lblTitulo); lblTitulo.setBounds(20,15,600,25);
        lblBuscar = new javax.swing.JLabel("Buscar");
        getContentPane().add(lblBuscar); lblBuscar.setBounds(445,55,70,25);
        txtBuscar = new javax.swing.JTextField();
        getContentPane().add(txtBuscar); txtBuscar.setBounds(520,55,630,25);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) { txtBuscarKeyReleased(evt); }
        });
        tblEmpresas = new javax.swing.JTable();
        tblEmpresas.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
            new String[]{"Id empresa","Descripción","Tipo empresa","Dirección","Teléfono","Persona contacto","Web"}) {
            public boolean isCellEditable(int rowIndex,int columnIndex) { return false; }
        });
        tblEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { tblEmpresasMouseClicked(evt); }
        });
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportView(tblEmpresas);
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
            this.llenaTblEmpresas("");
        }else{
            this.llenaTblEmpresas(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(valida()==true){
            Empresa empr = new Empresa();
            empr.setDescrip(this.txtDescrip.getText());
            empr.setTipoEmp(this.txtTipoEmp.getText());
            empr.setDireccion(this.txtDireccion.getText());
            empr.setTlf(this.txtTlf.getText());
            empr.setPersContacto(this.txtPersContacto.getText());
            empr.setWeb(this.txtWeb.getText());

            try{
                if(this.btnGrabar.getText().equals("Grabar")){
                    this.emprDao.insertaEmpresa(empr);
                }else{
                    empr.setIdEmpresa(idEmpresa);
                    this.emprDao.actualizaEmpresa(empr);
                }
                limpia();
                this.llenaTblEmpresas("");
                JOptionPane.showMessageDialog(this, "Empresa registrado satisfactoriamente");
            }catch(java.sql.SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "No se pudo guardar. Revise los datos, las fechas y las relaciones seleccionadas.");
            }
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void tblEmpresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpresasMouseClicked
        int idx;
        idx = this.tblEmpresas.getSelectedRow();
        if(idx<0){
            return;
        }
        this.idEmpresa = Integer.parseInt(dtm.getValueAt(idx,0).toString());
        this.txtIdEmpresa.setText(dtm.getValueAt(idx,0) == null ? "" : dtm.getValueAt(idx,0).toString());
        this.txtDescrip.setText(dtm.getValueAt(idx,1) == null ? "" : dtm.getValueAt(idx,1).toString());
        this.txtTipoEmp.setText(dtm.getValueAt(idx,2) == null ? "" : dtm.getValueAt(idx,2).toString());
        this.txtDireccion.setText(dtm.getValueAt(idx,3) == null ? "" : dtm.getValueAt(idx,3).toString());
        this.txtTlf.setText(dtm.getValueAt(idx,4) == null ? "" : dtm.getValueAt(idx,4).toString());
        this.txtPersContacto.setText(dtm.getValueAt(idx,5) == null ? "" : dtm.getValueAt(idx,5).toString());
        this.txtWeb.setText(dtm.getValueAt(idx,6) == null ? "" : dtm.getValueAt(idx,6).toString());

        this.btnGrabar.setText("Actualiza");
    }//GEN-LAST:event_tblEmpresasMouseClicked

    private void limpia(){
        this.idEmpresa = 0;
        this.txtIdEmpresa.setText("");
        this.txtDescrip.setText("");
        this.txtTipoEmp.setText("");
        this.txtDireccion.setText("");
        this.txtTlf.setText("");
        this.txtPersContacto.setText("");
        this.txtWeb.setText("");

        this.txtBuscar.setText("");
        this.btnGrabar.setText("Grabar");
        this.tblEmpresas.clearSelection();
    }

    private boolean valida(){
        boolean sw = false;
        String cad = "";
        if(this.txtDescrip.getText().trim().isEmpty()){
            cad += "\nDebe registrar Descripción.";
        }
        if(this.txtDescrip.getText().length()>150){
            cad += "\nDescripción admite hasta 150 caracteres.";
        }
        if(this.txtTipoEmp.getText().length()>50){
            cad += "\nTipo empresa admite hasta 50 caracteres.";
        }
        if(this.txtDireccion.getText().length()>200){
            cad += "\nDirección admite hasta 200 caracteres.";
        }
        if(this.txtTlf.getText().length()>20){
            cad += "\nTeléfono admite hasta 20 caracteres.";
        }
        if(this.txtPersContacto.getText().length()>100){
            cad += "\nPersona contacto admite hasta 100 caracteres.";
        }
        if(this.txtWeb.getText().length()>150){
            cad += "\nWeb admite hasta 150 caracteres.";
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
        this.llenaTblEmpresas("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(this.tblEmpresas.getSelectedRow()<0){
            JOptionPane.showMessageDialog(this,"Debe seleccionar un registro.");
            return;
        }
        try{
            this.emprDao.eliminaEmpresa(idEmpresa);
            limpia();
            this.llenaTblEmpresas("");
            JOptionPane.showMessageDialog(this,"Empresa eliminado satisfactoriamente");
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
            public void run() { new FrmEmpresa().setVisible(true); }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIdEmpresa;
    private javax.swing.JTextField txtIdEmpresa;
    private javax.swing.JLabel lblDescrip;
    private javax.swing.JTextField txtDescrip;
    private javax.swing.JLabel lblTipoEmp;
    private javax.swing.JTextField txtTipoEmp;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JLabel lblTlf;
    private javax.swing.JTextField txtTlf;
    private javax.swing.JLabel lblPersContacto;
    private javax.swing.JTextField txtPersContacto;
    private javax.swing.JLabel lblWeb;
    private javax.swing.JTextField txtWeb;

    private javax.swing.JLabel lblTitulo,lblBuscar;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTable tblEmpresas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton btnGrabar,btnLimpiar,btnEliminar,btnSalir;
    // End of variables declaration//GEN-END:variables
}