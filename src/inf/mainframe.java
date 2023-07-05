
package inf;

import codes.DBconect;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.Connection;

import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class mainframe extends javax.swing.JFrame {

    Connection  conn = null;
    PreparedStatement pst = null;
    
    ResultSet rs = null;
    
    public mainframe() {   
        initComponents();
        conn =  (Connection) DBconect.connect();
        
        tableload();
    }
    
    public void tableload(){
        try {
           String sql = "SELECT id AS ID,sname AS Name,sage AS Age,sgrade AS Grade FROM student";
           pst = conn.prepareStatement(sql);
           rs = pst.executeQuery();
           table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void tabledata(){
        int r = table1.getSelectedRow();
        
        String id = table1.getValueAt(r,0).toString();
        String name = table1.getValueAt(r,1).toString();
        String age = table1.getValueAt(r,2).toString();
        String grade = table1.getValueAt(r,3).toString();
        
        idbox.setText(id);
        namebox.setText(name);
        agebox.setText(age);
        gradebox.setSelectedItem(grade);
    }
    
    public void search(){
        String srch = searchbox.getText();
        
        try {
            String sql = "SELECT id,sname,sage,sgrade FROM student WHERE sname LIKE '%"+srch+"%' OR id LIKE '%"+srch+"%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void update(){
        String id = idbox.getText();
        String name = namebox.getText();
        String age = agebox.getText();
        String grade = gradebox.getSelectedItem().toString();
        
        try {
            String sql = "UPDATE student SET sname = '"+name+"',sage = '"+age+"',sgrade = '"+grade+"'WHERE id = '"+id+"' ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Updated!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"not Updated!");
        }
    }
    
    public void clear(){
        searchbox.setText("");
        idbox.setText("ID");
        namebox.setText("");
        agebox.setText("");
        gradebox.setSelectedIndex(0);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        namebox = new javax.swing.JTextField();
        agebox = new javax.swing.JTextField();
        gradebox = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        insertbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        idbox = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("search"));

        searchbox.setBackground(new java.awt.Color(255, 255, 153));
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(searchbox, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(searchbox)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 60));

        jPanel4.setBackground(new java.awt.Color(0, 0, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Name");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Age");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 50, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Grade");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 50, -1));

        namebox.setBackground(new java.awt.Color(255, 255, 153));
        namebox.setToolTipText("Enter your name");
        jPanel4.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 100, -1));

        agebox.setBackground(new java.awt.Color(255, 255, 153));
        agebox.setToolTipText("Enter your Age");
        jPanel4.add(agebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 100, -1));

        gradebox.setForeground(new java.awt.Color(255, 255, 153));
        gradebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jPanel4.add(gradebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 100, 80, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 190, 140));

        jPanel5.setBackground(new java.awt.Color(0, 0, 153));

        insertbtn.setBackground(new java.awt.Color(51, 51, 51));
        insertbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insertbtn.setForeground(new java.awt.Color(204, 204, 204));
        insertbtn.setText("Insert");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });

        updatebtn.setBackground(new java.awt.Color(51, 51, 51));
        updatebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updatebtn.setForeground(new java.awt.Color(204, 204, 204));
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        deletebtn.setBackground(new java.awt.Color(51, 51, 51));
        deletebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deletebtn.setForeground(new java.awt.Color(204, 204, 204));
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        clearbtn.setBackground(new java.awt.Color(51, 51, 51));
        clearbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clearbtn.setForeground(new java.awt.Color(204, 204, 204));
        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });

        exitbtn.setBackground(new java.awt.Color(51, 51, 51));
        exitbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exitbtn.setForeground(new java.awt.Color(204, 204, 204));
        exitbtn.setText("Exit");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(insertbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deletebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearbtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updatebtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(exitbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 190, 140));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("ID");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        idbox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        idbox.setText("ID");
        jPanel2.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 420));

        table1.setBackground(new java.awt.Color(255, 255, 153));
        table1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(table1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 370, 420));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
       String name;
       int age;
       int grade;
       
       name = namebox.getText();
       age = Integer.parseInt(agebox.getText());
       grade = Integer.parseInt(gradebox.getSelectedItem().toString());
       
        try {
            String sql = "INSERT INTO student(sname,sage,sgrade)VALUES('"+name+"','"+age+"','"+grade+"')";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Inserted!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
        tableload();
    }//GEN-LAST:event_insertbtnActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        tabledata();
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
        tabledata();
    }//GEN-LAST:event_table1KeyReleased

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        search();
    }//GEN-LAST:event_searchboxKeyReleased

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        update();
        tableload();
    }//GEN-LAST:event_updatebtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        int check = JOptionPane.showConfirmDialog(null,"Do you want to delete this!");
        
        if(check == 0){  //Press Yes = 0, No = 1 ,Clear = 2
            String id = idbox.getText();
            try {
                String sql = "DELETE FROM student WHERE id = '"+id+"' ";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Deleted!");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Not Deleted!");
            }
        }
        tableload();
        
        clear();
    }//GEN-LAST:event_deletebtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

  
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
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agebox;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JComboBox<String> gradebox;
    private javax.swing.JLabel idbox;
    private javax.swing.JButton insertbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField namebox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTable table1;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
