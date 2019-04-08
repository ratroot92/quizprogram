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
public class questiondao {
    
    connection obj=new connection();
    public int insertquestions(questions a){
        try{
            
        
        obj.connect();
        String qry="insert into questions (q_string,q_cat,q_opt1,q_opt2,q_opt3,q_opt4,qanswer,level) values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps=obj.preparedquery(qry);
            ps.setString(1,a.q_string);
            ps.setString(2,a.q_cat);
            ps.setString(3,a.q_opt1);
            ps.setString(4,a.q_opt2);
            ps.setString(5,a.q_opt3);
            ps.setString(6,a.q_opt4);
            ps.setString(7,a.ans);
            ps.setInt(8,a.level);
            int rowsaffected=ps.executeUpdate();
       obj.closeconnection();
       return rowsaffected;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            return -1;
        }
    }
    
    
    
    public int updatequestions(questions a){
        try{
            
        
        obj.connect();
        String qry="UPDATE questions SET q_string=?, q_cat=?, q_opt1=?, q_opt2=?, q_opt3=?, q_opt4=?, qanswer=?, level=?  WHERE q_id=?";
        PreparedStatement ps=obj.preparedquery(qry);
            ps.setString(1,a.q_string);
            ps.setString(2,a.q_cat);
            ps.setString(3,a.q_opt1);
            ps.setString(4,a.q_opt2);
            ps.setString(5,a.q_opt3);
            ps.setString(6,a.q_opt4);
            ps.setString(7,a.ans);
            ps.setInt(8,a.level);
            ps.setInt(9,a.q_id);
         
            int rowsaffected=ps.executeUpdate();
       //obj.closeconnection();
       return rowsaffected;
        }
        catch(SQLException ex){
           // JOptionPane.showMessageDialog(null, ex);
            System.out.println("Failed"+ex);
            return -1;
        }
    }
    
    public int deletequestion(questions a){
        try{
            
        
        obj.connect();
        String qry="DELETE FROM questions WHERE q_id=?";
        PreparedStatement ps=obj.preparedquery(qry);
           
            ps.setInt(1,a.q_id);
         
            int rowsaffected=ps.executeUpdate();
       //obj.closeconnection();
       return rowsaffected;
        }
        catch(SQLException ex){
           // JOptionPane.showMessageDialog(null, ex);
            System.out.println("Failed"+ex);
            return -1;
        }
    }
    
   
    
    
    
    
    
    
    
    public ResultSet loadcombobox(){
        obj.connect();
        ResultSet rs=obj.select("select cat_name from category");
        return rs;
}
    
}
