package adminview;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mysql.jdbc.Connection;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author root
 */
public class adminview extends javax.swing.JFrame {

   

    /**
     * Creates new form adminview
     */
    public adminview() {
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        
    }
    
    
    

    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        dp = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        loginmenu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenu7.setText("jMenu7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMIN VIEW");
        setAlwaysOnTop(true);
        setSize(new java.awt.Dimension(900, 1000));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        dp.setAutoscrolls(true);

        javax.swing.GroupLayout dpLayout = new javax.swing.GroupLayout(dp);
        dp.setLayout(dpLayout);
        dpLayout.setHorizontalGroup(
            dpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 787, Short.MAX_VALUE)
        );
        dpLayout.setVerticalGroup(
            dpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );

        loginmenu.setText("Login");

        jMenuItem2.setText("Login Now");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        loginmenu.add(jMenuItem2);

        jMenuBar1.add(loginmenu);

        jMenu2.setText("Admin Details");

        jMenuItem1.setText("Add Admin");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem7.setText("Update/Delete");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu8.setText("Category");

        jMenuItem3.setText("Add Category");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem3);

        jMenuItem6.setText("UPDATE/DELETE");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem6);

        jMenuBar1.add(jMenu8);

        jMenu5.setText("Questions");

        jMenuItem4.setText("Add Questions");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuItem5.setText("UPDATE/DELETE");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Student");

        jMenuItem8.setText("Add Student");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dp, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dp)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        addadmin a=new addadmin();
        
        a.setSize(500,500);
        
        a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        a.setMaximizable(true);
        a.setIconifiable(true);
        a.setClosable(true);
        a.setVisible(true);
          dp.add(a);
          try{
               a.setMaximum(true);
    }
    
    catch(PropertyVetoException ex){
    
    JOptionPane.showMessageDialog(dp, ex);
    }
      
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
      
    }//GEN-LAST:event_formMouseEntered

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       loginform a=new loginform();
        
        a.setSize(500,500);
        
        a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        a.setMaximizable(true);
        a.setIconifiable(true);
        a.setClosable(true);
        a.setVisible(true);
          dp.add(a);
              a.pack();
          try{
               a.setMaximum(true);
    }

    catch(PropertyVetoException ex){
    
    JOptionPane.showMessageDialog(dp, ex);
    }
           
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
     
        
            catgui a=new catgui();
        
        a.setSize(500,500);
        
        a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        a.setMaximizable(true);
        a.setIconifiable(true);
        a.setClosable(true);
        a.setVisible(true);
          dp.add(a);
          try{
               a.setMaximum(true);
    }
    
    catch(PropertyVetoException ex){
    
    JOptionPane.showMessageDialog(dp, ex);
    }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       questionsgui a=new questionsgui();
        
        a.setSize(500,500);
        
        a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        a.setMaximizable(true);
        a.setIconifiable(true);
        a.setClosable(true);
        a.setVisible(true);
          dp.add(a);
          try{
               a.setMaximum(true);
    }
    
    catch(PropertyVetoException ex){
    
    JOptionPane.showMessageDialog(dp, ex);
    }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       questionsguiupdate a=new questionsguiupdate();
        
        a.setSize(500,500);
        
        a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        a.setMaximizable(true);
        a.setIconifiable(true);
        a.setClosable(true);
        a.setVisible(true);
          dp.add(a);
          try{
               a.setMaximum(true);
    }
    
    catch(PropertyVetoException ex){
    
    JOptionPane.showMessageDialog(dp, ex);
    }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       catguiupdate a=new catguiupdate();
        
        a.setSize(500,500);
        
        a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        a.setMaximizable(true);
        a.setIconifiable(true);
        a.setClosable(true);
        a.setVisible(true);
          dp.add(a);
          try{
               a.setMaximum(true);
    }
    
    catch(PropertyVetoException ex){
    
    JOptionPane.showMessageDialog(dp, ex);
    }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
                addadminupdate a=new addadminupdate();
        
        a.setSize(500,500);
        
        a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        a.setMaximizable(true);
        a.setIconifiable(true);
        a.setClosable(true);
        a.setVisible(true);
          dp.add(a);
          try{
               a.setMaximum(true);
    }
    
    catch(PropertyVetoException ex){
    
    JOptionPane.showMessageDialog(dp, ex);
    }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
studentgui a=new studentgui();
        
        a.setSize(500,500);
        
        a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        a.setMaximizable(true);
        a.setIconifiable(true);
        a.setClosable(true);
        a.setVisible(true);
          dp.add(a);
          try{
               a.setMaximum(true);
    }
    
    catch(PropertyVetoException ex){
    
    JOptionPane.showMessageDialog(dp, ex);
    }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new adminview().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dp;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    public static javax.swing.JMenu loginmenu;
    // End of variables declaration//GEN-END:variables

    private void ClassforName(String commysqljdbcDriver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
