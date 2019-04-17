/*
 * To change this license header, choose License Headers in Project Properties
    @Override
    public Rectangle bounds() {
        return super.bounds(); //To change body of generated methods, choose Tools | Templates.
    }
.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentview;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import adminview.connection;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asd
 */
public class testgui extends javax.swing.JInternalFrame {

    /**
     * Creates new form testgui
     */
    //global declerations
    DefaultTableModel model = new DefaultTableModel();
boolean doubleskipped=false;
    int selectflag = 0;
    String studentname = "";
    int studentid = 0;
    String studentroll = "";
    int pionts = 0;
    int randomid = 0;
    int totalquestions = 0;
    String questionanswer = "";
    int correctanswers = 0;
    int difficultylevel;
    static int counttimer = 0;
    ArrayList qid_array = new ArrayList();
    String globalcategory=null;
    int closeformcounter=0;
    connection c = new connection();

    //end of global declerations
    public testgui() {
        initComponents();
        mytable.setModel(model);

        model.addColumn("QUESTION");
        model.addColumn("SELECTED OPTION");

    }
    
    
   
    
    public void nothingselecteddisablesubmit(){
        if(c1.isSelected()==false && c2.isSelected()==false && c3.isSelected()==false && c4.isSelected()==false){
            submit.setEnabled(false);
            re.setEnabled(false);
        }
        else{
            submit.setEnabled(true);
        }
    }

    //getdate and time 
    public String getdate() {
        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        String resultdate = localDate.format(formatter);
        return resultdate;
    }

    //end of get date and time 
    public void displaysubmitetd() {
        try {
            String question = t1.getText();
            String option;
            if (c1.isSelected()) {
                option = t2.getText();

            } else if (c2.isSelected()) {
                option = t3.getText();

            } else if (c3.isSelected()) {
                option = t4.getText();

            } else if (c4.isSelected()) {
                option = t5.getText();

            } else {
                option = "SKIPPED QUESTION";
            }

            if(question.equals("")){
                JOptionPane.showMessageDialog(this,"Question Already Skipped Press Next For the Next Question ");
           doubleskipped=true;
           
            }
            else{
                String st[] = {question, option};
            model.addRow(st);
            }
            

        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void clearall() {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");

    }

    public void disableradio() {
        c1.setEnabled(false);
        c2.setEnabled(false);
        c3.setEnabled(false);
        c4.setEnabled(false);
    }

    public void enableradio() {
        c1.setEnabled(true);
        c2.setEnabled(true);
        c3.setEnabled(true);
        c4.setEnabled(true);
    }

    public void setresult() throws SQLException {

        result a = new result();
        resultdao b = new resultdao();
        studentlogin d = new studentlogin();
        //values sent by student login 
        studentid = d.gstudentid;
        studentname = d.gstudentname;

        //values sent by student login 
        a.date = getdate();
        a.correctanswers = correctanswers;
        a.totalpionts = pionts;
        a.studentid = studentid;
        a.totalquestions = counttimer;
        a.studentname = studentname;
        double marks = correctanswers;
        marks = marks + pionts;
        a.marks = marks;
        b.insert(a);
    }

    public void generatequeestion() {
        try {

            //int id=randomid();
            int id = generatequestionarray();

            ResultSet rs = c.select("select * from questions where q_id=" + id);

            while (rs.next()) {
                t1.setText(rs.getString(2));
                t2.setText(rs.getString(4));
                t3.setText(rs.getString(5));
                t4.setText(rs.getString(6));
                t5.setText(rs.getString(7));

                studentid = rs.getInt(1);
                String cat = rs.getString(3);
                questionanswer = rs.getString(8);
                difficultylevel = rs.getInt(9);

                //set labels on gui 
                df.setText("Difficulty Level = " + difficultylevel);
                l1.setText("Question Id = " + id + "  counter = " + counttimer);
                // JOptionPane.showMessageDialog(this,"succesfull");

            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "ex");

        }

    }

    public void rechoose() {
      
           
       submit.setEnabled(false);
        c1.setEnabled(true);
        c2.setEnabled(true);
        c3.setEnabled(true);
        c4.setEnabled(true);
        c1.setSelected(false);
        c2.setSelected(false);
        c3.setSelected(false);
        c4.setSelected(false);
       
    }

    public void chooseoption() {
        int option = 0;
        if (c1.isSelected()) {
            // JOptionPane.showMessageDialog(this,"option 1 is selected");

            if (questionanswer.equals("chioce 1")) {
                // JOptionPane.showMessageDialog(this,"Yes matched");
                pionts = pionts + difficultylevel;
                correctanswers++;
                //generatequeestion();
                option = 1;
            } else {
                //generatequeestion();
            }

        } else if (c2.isSelected()) {
            //JOptionPane.showMessageDialog(this,"option 2 is selected");
            if (questionanswer.equals("chioce 2")) {
                // JOptionPane.showMessageDialog(this,"Yes matched");
                pionts = pionts + difficultylevel;
                correctanswers++;
                //generatequeestion();

            } else {
                // generatequeestion();
            }
        } else if (c3.isSelected()) {
            // JOptionPane.showMessageDialog(this,"option 3 is selected");
            if (questionanswer.equals("chioce 3")) {
                // JOptionPane.showMessageDialog(this,"Yes matched");
                pionts = pionts + difficultylevel;
                correctanswers++;
                // generatequeestion();
            } else {
                // generatequeestion();
            }
        } else if (c4.isSelected()) {
            //JOptionPane.showMessageDialog(this,"option 4 is selected");
            if (questionanswer.equals("chioce 4")) {
                // JOptionPane.showMessageDialog(this,"Yes matched");
                pionts = pionts + difficultylevel;
                correctanswers++;
                // generatequeestion();
            } else {
                // generatequeestion();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please Select a Option first");

        }
    }
//save all question ids in array 
    public ArrayList populatequestionarray() {
        try {
            c.connect();
            ResultSet rs = c.select("select q_id from questions where q_cat='"+globalcategory+"'");
            while (rs.next()) {
                qid_array.add(rs.getInt(1));

            }
            qid_array.trimToSize();
            if(qid_array.size()<10){
                 JOptionPane.showMessageDialog(this, "At Least 10 Questions are Requuired In Database for Category = "+globalcategory);
                setVisible(false);
                dispose();
            }
          
            else{
            
           
            JOptionPane.showMessageDialog(this, "Test Of Category = "+globalcategory);
            return qid_array;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        return null;
    }

    
    //genearate a random question  
    public int generatequestionarray() {

        totalquestions = qid_array.size();
        Random rand = new Random();
        int id = (int) qid_array.get(rand.nextInt(qid_array.size()));
        int index = qid_array.indexOf(id);
        qid_array.remove(index);
        //JOptionPane.showMessageDialog(this, "deleted question = " + id);
        return id;

    }

    
    public void selectcategory(){
       while(globalcategory==null)
        { 
      closeformcounter++;
         Object[] catObjects = null;
            ArrayList catnames=new ArrayList();
            c.connect();
            ResultSet rs=c.select("select cat_name from category");
            try {
                while(rs.next())
                {
                    catnames.add(rs.getString(1));  
                }
                catnames.trimToSize();
              catObjects= catnames.toArray();
            } catch (SQLException ex) {
                Logger.getLogger(testgui.class.getName()).log(Level.SEVERE, null, ex);
            }
            globalcategory= (String) JOptionPane.showInputDialog(null,  
                "Select Category For The Test :\n\from Categories Given Below", "ShowInputDialog",  
               JOptionPane.PLAIN_MESSAGE,null, catObjects, "Categories"); 
           
              if(closeformcounter>=3){
                 
                  setVisible(false);
                  dispose();
              }
               
            }
       
       
     }
     
  

    public int totalquestion() throws SQLException {
        c.connect();

        ResultSet rs = c.select("select COUNT(*) from questions");

        while (rs.next()) {
            totalquestions = rs.getInt(1);

        }

        return totalquestions;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        start = new javax.swing.JButton();
        end = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t1 = new javax.swing.JTextArea();
        l1 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        t5 = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        c1 = new javax.swing.JRadioButton();
        c2 = new javax.swing.JRadioButton();
        c3 = new javax.swing.JRadioButton();
        c4 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        df = new javax.swing.JLabel();
        re = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        mytable = new javax.swing.JTable();
        skip = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        start.setText("Start Test");
        start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startMouseClicked(evt);
            }
        });
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        end.setText("End Test ");
        end.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endMouseClicked(evt);
            }
        });
        end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Question");

        t1.setEditable(false);
        t1.setColumns(20);
        t1.setRows(5);
        jScrollPane1.setViewportView(t1);

        l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l1.setText("Question # ( )");

        t2.setEditable(false);

        t3.setEditable(false);

        t4.setEditable(false);

        t5.setEditable(false);

        submit.setText("SUBMIT ANSWER");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        c1.setText("Option 1");
        c1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                c1StateChanged(evt);
            }
        });
        c1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c1MouseClicked(evt);
            }
        });
        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });
        c1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                c1PropertyChange(evt);
            }
        });

        c2.setText("Option 2");
        c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c2ActionPerformed(evt);
            }
        });

        c3.setText("Option 3");
        c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c3ActionPerformed(evt);
            }
        });

        c4.setText("Option 4");
        c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c4ActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Difficulty Level");

        df.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        df.setText("Difficulty Level");

        re.setText("RECHOOSE");
        re.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reActionPerformed(evt);
            }
        });

        next.setText("NEXT QUESTION");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        mytable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(mytable);

        skip.setText("SKIP QUESTION");
        skip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(c2)
                                            .addComponent(c1))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(c3)
                                                .addGap(18, 18, 18)
                                                .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(c4)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(t5, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(53, 53, 53))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(29, 29, 29)))))
                                        .addGap(18, 18, 18)))
                                .addComponent(re, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(skip, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(df, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(start, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(end, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(df, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(re, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(c2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(c3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(t5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(c4))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(submit, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(skip, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        studentlogin d = new studentlogin();
        studentid = d.gstudentid;
        studentname = d.gstudentname;
        if (studentid == 0 || studentname == null) {
            JOptionPane.showMessageDialog(this, "Login is Required For Test  ");
            setVisible(false);
            dispose();

        } 
           else{
              
                   selectcategory();
               
           
            end.setEnabled(false);
            submit.setEnabled(false);
            disableradio();
            re.setEnabled(false);
            next.setEnabled(false);
            skip.setEnabled(false);
            populatequestionarray();
        }
        
    }//GEN-LAST:event_formInternalFrameActivated

    private void startMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMouseClicked


    }//GEN-LAST:event_startMouseClicked

    private void endMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endMouseClicked
        start.setEnabled(true);
        end.setEnabled(false);

        submit.setEnabled(false);
        re.setEnabled(false);

        next.setEnabled(false);

    }//GEN-LAST:event_endMouseClicked

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
          
        end.setEnabled(false);
        submit.setEnabled(true);
        re.setEnabled(true);
        c1.setEnabled(true);
        c2.setEnabled(true);
        c3.setEnabled(true);
        c4.setEnabled(true);
        next.setEnabled(false);
        start.setEnabled(false);
        generatequeestion();
        counttimer++;
        // re.setEnabled(false);
        nothingselecteddisablesubmit();
        skip.setEnabled(true);
    }//GEN-LAST:event_startActionPerformed

    private void c1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_c1StateChanged


    }//GEN-LAST:event_c1StateChanged

    private void c1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_c1PropertyChange
    }//GEN-LAST:event_c1PropertyChange

    private void c1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1MouseClicked

    }//GEN-LAST:event_c1MouseClicked

    private void c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1ActionPerformed
        if (c1.isSelected()) {
            c2.setEnabled(false);
            c3.setEnabled(false);
            c4.setEnabled(false);
            skip.setEnabled(false);
            selectflag = 1;
            submit.setEnabled(true);
             re.setEnabled(true);
        } else {
            c2.setEnabled(true);
            c3.setEnabled(true);
            c4.setEnabled(true);
            
        }

    }//GEN-LAST:event_c1ActionPerformed

    private void c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c2ActionPerformed
        if (c2.isSelected()) {
            c1.setEnabled(false);
            c3.setEnabled(false);
            c4.setEnabled(false);
             skip.setEnabled(false);
             submit.setEnabled(true);
              re.setEnabled(true);
            selectflag = 1;
        } else {
            c1.setEnabled(true);
            c3.setEnabled(true);
            c4.setEnabled(true);
                        

        }
    }//GEN-LAST:event_c2ActionPerformed

    private void c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c3ActionPerformed
        if (c3.isSelected()) {
            c2.setEnabled(false);
            c1.setEnabled(false);
            c4.setEnabled(false);
             skip.setEnabled(false);
             submit.setEnabled(true);
              re.setEnabled(true);
            selectflag = 1;
        } else {
            c2.setEnabled(true);
            c1.setEnabled(true);
            c4.setEnabled(true);
            

        }
    }//GEN-LAST:event_c3ActionPerformed

    private void c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c4ActionPerformed
        if (c4.isSelected()) {
            c2.setEnabled(false);
            c3.setEnabled(false);
            c1.setEnabled(false);
             skip.setEnabled(false);
             submit.setEnabled(true);
              re.setEnabled(true);
            selectflag = 1;
        } else {
            c2.setEnabled(true);
            c3.setEnabled(true);
            c1.setEnabled(true);
           
        }
    }//GEN-LAST:event_c4ActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        if (selectflag == 1) {
            displaysubmitetd();
            chooseoption();
            rechoose();
            next.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Answer Sumbitted Proceeding To Next Question");
            submit.setEnabled(false);
            re.setEnabled(false);
            clearall();
            disableradio();

        } else {
            JOptionPane.showMessageDialog(this, "Please Select a Option To Sumbmit");
        }


    }//GEN-LAST:event_submitActionPerformed

    private void reActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reActionPerformed
        rechoose();
        selectflag = 0;
          skip.setEnabled(true);
    }//GEN-LAST:event_reActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed

        if (counttimer < 10) {
            generatequeestion();
            
            counttimer++;
            next.setEnabled(false);
            re.setEnabled(true);
            submit.setEnabled(true);
            enableradio();
            skip.setEnabled(true);
            nothingselecteddisablesubmit();
           
        } else {
            JOptionPane.showMessageDialog(this, "QUIZ COMPLETED ");
            start.setEnabled(false);
            skip.setEnabled(false);
end.setEnabled(true);
            submit.setEnabled(false);
            re.setEnabled(false);
            next.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Press End Test ");
        }
    }//GEN-LAST:event_nextActionPerformed

    private void endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endActionPerformed
        try {
            setresult();
            JOptionPane.showMessageDialog(null, "Result Saved ");
            counttimer = 0;
            pionts = 0;
            correctanswers = 0;
            setVisible(false);
            dispose();

        } catch (SQLException ex) {
            Logger.getLogger(testgui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_endActionPerformed

    private void skipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipActionPerformed
        selectflag = 0;
        displaysubmitetd();
        rechoose();
        clearall();
        next.setEnabled(true);
        if(doubleskipped==false){
            JOptionPane.showMessageDialog(this, "Question Skipped");
        submit.setEnabled(false);
        re.setEnabled(false);
        disableradio();
        }
        else{
            disableradio();
        }
        


    }//GEN-LAST:event_skipActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton c1;
    private javax.swing.JRadioButton c2;
    private javax.swing.JRadioButton c3;
    private javax.swing.JRadioButton c4;
    private javax.swing.JLabel df;
    private javax.swing.JButton end;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel l1;
    private javax.swing.JTable mytable;
    private javax.swing.JButton next;
    private javax.swing.JButton re;
    private javax.swing.JButton skip;
    private javax.swing.JButton start;
    private javax.swing.JButton submit;
    private javax.swing.JTextArea t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTextField t5;
    // End of variables declaration//GEN-END:variables

    private void getquestionsids() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
