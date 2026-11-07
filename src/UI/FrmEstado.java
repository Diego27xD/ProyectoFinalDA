package UI;

import BEAN.Estado;
import DAO.EstadoDAO;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmEstado extends javax.swing.JFrame {
    private int idEstado;
    private EstadoDAO estDao;
    private DefaultTableModel dtm;

    public FrmEstado() {
        initComponents();
        estDao = new EstadoDAO();
        dtm = (DefaultTableModel)this.tblEstados.getModel();

        llenaTblEstados("");
    }

    private void llenaTblEstados(String cad){
        Vector<Estado> listaEstados;
        try{
            listaEstados = estDao.listaEstados(cad);
            dtm.setRowCount(0);
            for(int i=0;i<listaEstados.size();i++){
                Vector vec = new Vector();
                vec.addElement(listaEstados.get(i).getIdEstado());
                vec.addElement(listaEstados.get(i).getDescEstado());

                dtm.addRow(vec);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo listar Estados.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mantenimiento Estado - BD_RRHH");
        getContentPane().setLayout(null);
        lblIdEstado = new javax.swing.JLabel("Id estado");
        getContentPane().add(lblIdEstado); lblIdEstado.setBounds(20,55,140,25);
        txtIdEstado = new javax.swing.JTextField();
        getContentPane().add(txtIdEstado); txtIdEstado.setBounds(170,55,245,25);
        txtIdEstado.setEnabled(false);
        lblDescEstado = new javax.swing.JLabel("Descripción");
        getContentPane().add(lblDescEstado); lblDescEstado.setBounds(20,93,140,25);
        txtDescEstado = new javax.swing.JTextField();
        getContentPane().add(txtDescEstado); txtDescEstado.setBounds(170,93,245,25);
        lblTitulo = new javax.swing.JLabel("MANTENIMIENTO Estado");
        getContentPane().add(lblTitulo); lblTitulo.setBounds(20,15,600,25);
        lblBuscar = new javax.swing.JLabel("Buscar");
        getContentPane().add(lblBuscar); lblBuscar.setBounds(445,55,70,25);
        txtBuscar = new javax.swing.JTextField();
        getContentPane().add(txtBuscar); txtBuscar.setBounds(520,55,630,25);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) { txtBuscarKeyReleased(evt); }
        });
        tblEstados = new javax.swing.JTable();
        tblEstados.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
            new String[]{"Id","Descripción"}) {
            public boolean isCellEditable(int rowIndex,int columnIndex) { return false; }
        });
        tblEstados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { tblEstadosMouseClicked(evt); }
        });
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportView(tblEstados);
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
            this.llenaTblEstados("");
        }else{
            this.llenaTblEstados(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(valida()==true){
            Estado est = new Estado();
            est.setDescEstado(this.txtDescEstado.getText());

            try{
                if(this.btnGrabar.getText().equals("Grabar")){
                    this.estDao.insertaEstado(est);
                }else{
                    est.setIdEstado(idEstado);
                    this.estDao.actualizaEstado(est);
                }
                limpia();
                this.llenaTblEstados("");
                JOptionPane.showMessageDialog(this, "Estado registrado satisfactoriamente");
            }catch(java.sql.SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "No se pudo guardar. Revise los datos, las fechas y las relaciones seleccionadas.");
            }
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void tblEstadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstadosMouseClicked
        int idx;
        idx = this.tblEstados.getSelectedRow();
        if(idx<0){
            return;
        }
        this.idEstado = Integer.parseInt(dtm.getValueAt(idx,0).toString());
        this.txtIdEstado.setText(dtm.getValueAt(idx,0) == null ? "" : dtm.getValueAt(idx,0).toString());
        this.txtDescEstado.setText(dtm.getValueAt(idx,1) == null ? "" : dtm.getValueAt(idx,1).toString());

        this.btnGrabar.setText("Actualiza");
    }//GEN-LAST:event_tblEstadosMouseClicked

    private void limpia(){
        this.idEstado = 0;
        this.txtIdEstado.setText("");
        this.txtDescEstado.setText("");

        this.txtBuscar.setText("");
        this.btnGrabar.setText("Grabar");
        this.tblEstados.clearSelection();
    }

    private boolean valida(){
        boolean sw = false;
        String cad = "";
        if(this.txtDescEstado.getText().trim().isEmpty()){
            cad += "\nDebe registrar Descripción.";
        }
        if(this.txtDescEstado.getText().length()>50){
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
        this.llenaTblEstados("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(this.tblEstados.getSelectedRow()<0){
            JOptionPane.showMessageDialog(this,"Debe seleccionar un registro.");
            return;
        }
        try{
            this.estDao.eliminaEstado(idEstado);
            limpia();
            this.llenaTblEstados("");
            JOptionPane.showMessageDialog(this,"Estado eliminado satisfactoriamente");
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
            public void run() { new FrmEstado().setVisible(true); }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIdEstado;
    private javax.swing.JTextField txtIdEstado;
    private javax.swing.JLabel lblDescEstado;
    private javax.swing.JTextField txtDescEstado;

    private javax.swing.JLabel lblTitulo,lblBuscar;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTable tblEstados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton btnGrabar,btnLimpiar,btnEliminar,btnSalir;
    // End of variables declaration//GEN-END:variables
}