package cms;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class ProjectRecord extends javax.swing.JFrame {
Connection con=null;
ResultSet rs=null;
PreparedStatement pst=null;
    
    public ProjectRecord() {
        initComponents();
         con= Connect.ConnectDB();
        Get_Data();
        setLocationRelativeTo(null);
    }
 private void Get_Data(){
           String sql="select PatientID as 'Patient ID', PatientName as 'Patient Name',FatherName as 'Guardian Name',Email as 'Email ID',ContactNo as 'Contact No',Age as 'Age',Date as 'Reg Date',Remarks as 'Remarks',Gen as 'Gender',BG as 'Blood Group',Address as 'Address' from Patientregistration";
           try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         jTable1.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          
}
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Patient Registration Record");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      try{
            con=Connect.ConnectDB();
            int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            String sql= "select * from patientregistration where PatientID = '" + table_click + "'";
            pst=con.prepareStatement(sql);
            rs=  pst.executeQuery();
            if(rs.next()){
                this.hide();
                Projects frm = new Projects();
                frm.setVisible(true);
                String add1=rs.getString("PatientID");
                frm.txtPatientID.setText(add1);
                String add2=rs.getString("Patientname");
                frm.txtPatientName.setText(add2);
                
                
                String add5=rs.getString("Email");
                frm.txtEmailID.setText(add5);
                
                
                
                String add7=rs.getString("Remarks");
                frm.txtRemarks.setText(add7);
                
                
                
                
                String add15=rs.getString("Address");
                frm.txtAddress.setText(add15);
                String add16=rs.getString("ContactNo");
                frm.txtContactNo.setText(add16);
                 
                
                frm.btnUpdate.setEnabled(true);
                frm.btnDelete.setEnabled(true);
                frm.btnSave.setEnabled(false);
             
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    this.hide();
    Projects frm = new Projects();
    frm.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectRecord().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
