package adminview;



import java.sql.PreparedStatement;
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
public class cat {
    int cat_id;
    String cat_name="";
    
}



 class catdao {
    
    connection c=new connection();
    
    
    
    public void insert(cat a) throws SQLException{
        c.connect();
        String qry="insert into category (cat_name) values (?)";
        PreparedStatement ps=c.preparedquery(qry);
        ps.setString(1,a.cat_name);
        ps.executeUpdate();
        
    }
    public void update(cat a) throws SQLException{
        c.connect();
        String qry="UPDATE category SET cat_name=?  WHERE cat_id=?";
        PreparedStatement ps=c.preparedquery(qry);
        ps.setString(1,a.cat_name);
        ps.setInt(2, a.cat_id);
        ps.executeUpdate();
        
    }
    public void delete(cat a) throws SQLException{
        c.connect();
        String qry="DELETE FROM category WHERE cat_id=?";
        PreparedStatement ps=c.preparedquery(qry);
        ps.setInt(1, a.cat_id);
        ps.executeUpdate();
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}