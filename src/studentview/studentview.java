/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentview;

import java.beans.PropertyVetoException;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import project1.studentgui;

/**
 *
 * @author asd
 */
public class studentview extends javax.swing.JFrame {

    /**
     * Creates new form studentview
     */
    public studentview() {
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

        dp = new javax.swing.JDesktopPane();
        menu = new javax.swing.JMenuBar();
        m1 = new javax.swing.JMenu();
        m2 = new javax.swing.JMenuItem();
        m3 = new javax.swing.JMenu();
        m4 = new javax.swing.JMenuItem();
        m5 = new javax.swing.JMenu();
        m6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout dpLayout = new javax.swing.GroupLayout(dp);
        dp.setLayout(dpLayout);
        dpLayout.setHorizontalGroup(
            dpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 961, Short.MAX_VALUE)
        );
        dpLayout.setVerticalGroup(
            dpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );

        menu.setBackground(javax.swing.UIManager.getDefaults().getColor("FormattedTextField.selectionForeground"));

        m1.setBackground(java.awt.Color.white);
        m1.setText("Student Login");
        m1.setIconTextGap(50);
        m1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m1MouseClicked(evt);
            }
        });

        m2.setText("Login In");
        m2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        m2.setIconTextGap(8);
        m2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m2MouseClicked(evt);
            }
        });
        m2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m2ActionPerformed(evt);
            }
        });
        m1.add(m2);

        menu.add(m1);

        m3.setBackground(java.awt.Color.white);
        m3.setText("Test");
        m3.setIconTextGap(50);

        m4.setText("Start Test");
        m4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m4ActionPerformed(evt);
            }
        });
        m3.add(m4);

        menu.add(m3);

        m5.setBackground(java.awt.Color.white);
        m5.setText("Results");
        m5.setIconTextGap(50);

        m6.setText("See Results");
        m6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m6ActionPerformed(evt);
            }
        });
        m5.add(m6);

        menu.add(m5);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dp)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dp)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void m4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m4ActionPerformed
            testgui a=new testgui();
        
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

    }//GEN-LAST:event_m4ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

      // m3.setEnabled(false);       
    }//GEN-LAST:event_formWindowActivated

    private void m2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m2ActionPerformed
  
        studentlogin a=new studentlogin();
        
       
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
    }//GEN-LAST:event_m2ActionPerformed

    private void m6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m6ActionPerformed
        resultgui a=new resultgui();
        
       
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
    }//GEN-LAST:event_m6ActionPerformed

    private void m1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m1MouseClicked
         // TODO add your handling code here:
    }//GEN-LAST:event_m1MouseClicked

    private void m2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m2MouseClicked
   
// TODO add your handling code here:
    }//GEN-LAST:event_m2MouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(studentview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dp;
    public static javax.swing.JMenu m1;
    public javax.swing.JMenuItem m2;
    public static javax.swing.JMenu m3;
    public javax.swing.JMenuItem m4;
    public static javax.swing.JMenu m5;
    public javax.swing.JMenuItem m6;
    public static javax.swing.JMenuBar menu;
    // End of variables declaration//GEN-END:variables

    void setEnabled(JMenu m2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
