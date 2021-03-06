
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class actorview extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pstmnt = null;
    PreparedStatement pstmnt1=null;
    Statement stmnt = null;
    ResultSet rs = null;
    DefaultTableModel dm;
    
    public actorview() throws ClassNotFoundException, SQLException {
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String curr = System.getProperty("user.dir");
         con =DriverManager.getConnection("jdbc:derby:"+curr+"/tvseries","root","sujithmenon");
        initComponents();
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
        jLabel30 = new javax.swing.JLabel();
        actorsrb = new javax.swing.JRadioButton();
        connectionrb = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 1, 1));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Select the table whose all records should be displayed.");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        actorsrb.setBackground(new java.awt.Color(102, 102, 102));
        actorsrb.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        actorsrb.setForeground(new java.awt.Color(254, 254, 254));
        actorsrb.setText("Actors");
        actorsrb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actorsrbActionPerformed(evt);
            }
        });
        jPanel1.add(actorsrb, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        connectionrb.setBackground(new java.awt.Color(102, 102, 102));
        connectionrb.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        connectionrb.setForeground(new java.awt.Color(254, 254, 254));
        connectionrb.setText("Connection");
        connectionrb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionrbActionPerformed(evt);
            }
        });
        jPanel1.add(connectionrb, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("GO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 63, -1));

        table.setBackground(new java.awt.Color(0, 0, 0));
        table.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        table.setForeground(new java.awt.Color(0, 204, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(table);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 137, 495, 220));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/suits(1).jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 140));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 519, 455));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actorsrbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actorsrbActionPerformed
        if(actorsrb.isSelected())
        { 
            connectionrb.setSelected(false);
                    }
    }//GEN-LAST:event_actorsrbActionPerformed

    private void connectionrbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionrbActionPerformed
        if(connectionrb.isSelected())
        { actorsrb.setSelected(false);
           
        }
    }//GEN-LAST:event_connectionrbActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try
        { dm=(DefaultTableModel)table.getModel();
            dm.setColumnCount(0);
            dm.setRowCount(0);

                        if(actorsrb.isSelected())
            {
                dm = (DefaultTableModel) table.getModel();
                dm.addColumn("Actor ID");
                dm.addColumn("Actor Name");
                dm.addColumn("DOB");
                dm.addColumn("Age");
                stmnt = con.createStatement();
                rs = stmnt.executeQuery("select * from Actors");
                while(rs.next())
                { String aarray[]= {rs.getString("actor_id"),rs.getString("Actor_name"),rs.getString("DOB"),rs.getString("age")};
                    dm.addRow(aarray);
                }
            }
            
            if(connectionrb.isSelected())
            {
                dm = (DefaultTableModel) table.getModel();
                dm.addColumn("Actor ID");
                dm.addColumn("Series ID");
                dm.addColumn("No. Of Episodes");
                stmnt = con.createStatement();
                rs = stmnt.executeQuery("select * from connectiontable");
                while(rs.next())
                { String aarray[]= {rs.getString("aid"),rs.getString("sid"),rs.getString("noe")};
                    dm.addRow(aarray);
                }
            }
            
        }        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(actorview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(actorview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(actorview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(actorview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new actorview().setVisible(true);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(actorview.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton actorsrb;
    private javax.swing.JRadioButton connectionrb;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
