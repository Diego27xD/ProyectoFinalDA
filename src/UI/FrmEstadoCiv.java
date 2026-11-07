package UI;

import BEAN.EstadoCiv;
import DAO.EstadoCivDAO;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmEstadoCiv extends javax.swing.JFrame {
    private int idEstadoCiv;
    private EstadoCivDAO estDao;
    private DefaultTableModel dtm;

    public FrmEstadoCiv() {
        initComponents();
        estDao = new EstadoCivDAO();
        dtm = (DefaultTableModel)this.tblEstadosCiviles.getModel();

        llenaTblEstadosCiviles("");
    }

    private void llenaTblEstadosCiviles(String cad){
        Vector<EstadoCiv> listaEstadosCiviles;
        try{
            listaEstadosCiviles = estDao.listaEstadosCiviles(cad);
            dtm.setRowCount(0);
            for(int i=0;i<listaEstadosCiviles.size();i++){
                Vector vec = new Vector();
                vec.addElement(listaEstadosCiviles.get(i).getIdEstCiv());
                vec.addElement(listaEstadosCiviles.get(i).getDescrip());

                dtm.addRow(vec);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo listar EstadosCiviles.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mantenimiento EstadoCiv - BD_RRHH");
        getContentPane().setLayout(null);
        lblIdEstCiv = new javax.swing.JLabel("Id estado civil");
        getContentPane().add(lblIdEstCiv); lblIdEstCiv.setBounds(20,55,140,25);
        txtIdEstCiv = new javax.swing.JTextField();
        getContentPane().add(txtIdEstCiv); txtIdEstCiv.setBounds(170,55,245,25);
        txtIdEstCiv.setEnabled(false);
        lblDescrip = new javax.swing.JLabel("Descripción");
        getContentPane().add(lblDescrip); lblDescrip.setBounds(20,93,140,25);
        txtDescrip = new javax.swing.JTextField();
        getContentPane().add(txtDescrip); txtDescrip.setBounds(170,93,245,25);
        lblTitulo = new javax.swing.JLabel("MANTENIMIENTO EstadoCiv");
        getContentPane().add(lblTitulo); lblTitulo.setBounds(20,15,600,25);
        lblBuscar = new javax.swing.JLabel("Buscar");
        getContentPane().add(lblBuscar); lblBuscar.setBounds(445,55,70,25);
        txtBuscar = new javax.swing.JTextField();
        getContentPane().add(txtBuscar); txtBuscar.setBounds(520,55,630,25);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) { txtBuscarKeyReleased(evt); }
        });
        tblEstadosCiviles = new javax.swing.JTable();
        tblEstadosCiviles.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
            new String[]{"Id","Descripción"}) {
            public boolean isCellEditable(int rowIndex,int columnIndex) { return false; }
        });
        tblEstadosCiviles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { tblEstadosCivilesMouseClicked(evt); }
        });
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportView(tblEstadosCiviles);
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
            this.llenaTblEstadosCiviles("");
        }else{
            this.llenaTblEstadosCiviles(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(valida()==true){
            EstadoCiv est = new EstadoCiv();
            est.setDescrip(this.txtDescrip.getText());

            try{
                if(this.btnGrabar.getText().equals("Grabar")){
                    this.estDao.insertaEstadoCiv(est);
                }else{
                    est.setIdEstCiv(idEstadoCiv);
                    this.estDao.actualizaEstadoCiv(est);
                }
                limpia();
                this.llenaTblEstadosCiviles("");
                JOptionPane.showMessageDialog(this, "EstadoCiv registrado satisfactoriamente");
            }catch(java.sql.SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "No se pudo guardar. Revise los datos, las fechas y las relaciones seleccionadas.");
            }
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void tblEstadosCivilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstadosCivilesMouseClicked
        int idx;
        idx = this.tblEstadosCiviles.getSelectedRow();
        if(idx<0){
            return;
        }
        this.idEstadoCiv = Integer.parseInt(dtm.getValueAt(idx,0).toString());
        this.txtIdEstCiv.setText(dtm.getValueAt(idx,0) == null ? "" : dtm.getValueAt(idx,0).toString());
        this.txtDescrip.setText(dtm.getValueAt(idx,1) == null ? "" : dtm.getValueAt(idx,1).toString());

        this.btnGrabar.setText("Actualiza");
    }//GEN-LAST:event_tblEstadosCivilesMouseClicked

    private void limpia(){
        this.idEstadoCiv = 0;
        this.txtIdEstCiv.setText("");
        this.txtDescrip.setText("");

        this.txtBuscar.setText("");
        this.btnGrabar.setText("Grabar");
        this.tblEstadosCiviles.clearSelection();
    }

    private boolean valida(){
        boolean sw = false;
        String cad = "";
        if(this.txtDescrip.getText().trim().isEmpty()){
            cad += "\nDebe registrar Descripción.";
        }
        if(this.txtDescrip.getText().length()>50){
            cad += "\nDescripción admite hasta 50 caracteres.";
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
        this.llenaTblEstadosCiviles("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(this.tblEstadosCiviles.getSelectedRow()<0){
            JOptionPane.showMessageDialog(this,"Debe seleccionar un registro.");
            return;
        }
        try{
            this.estDao.eliminaEstadoCiv(idEstadoCiv);
            limpia();
            this.llenaTblEstadosCiviles("");
            JOptionPane.showMessageDialog(this,"EstadoCiv eliminado satisfactoriamente");
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
            public void run() { new FrmEstadoCiv().setVisible(true); }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIdEstCiv;
    private javax.swing.JTextField txtIdEstCiv;
    private javax.swing.JLabel lblDescrip;
    private javax.swing.JTextField txtDescrip;

    private javax.swing.JLabel lblTitulo,lblBuscar;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTable tblEstadosCiviles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton btnGrabar,btnLimpiar,btnEliminar,btnSalir;
    // End of variables declaration//GEN-END:variables
}