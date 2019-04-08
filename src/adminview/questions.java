package adminview;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class questions {
   int q_id;
   String q_string;
   String q_cat;
   String q_opt1;
   String q_opt2;
   String q_opt3;
   String q_opt4;
   int level;
   String ans;
   //constructor 
   questions(){
       q_id=0;
       q_string="";
       q_cat="";
       q_opt1="";
       q_opt2="";
       q_opt3="";
       q_opt4="";
       level=0;
       ans="";
   }
}


