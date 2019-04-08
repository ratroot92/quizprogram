package adminview;



import javax.swing.JOptionPane;
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class admin {
    int admin_id;
    String admin_name;
    String admin_pass;
    String confirm_pass;
    public admin() {
admin_id=0;
admin_name="";
admin_pass="";
confirm_pass="";

    }
    
        
    
}
 class admindao {
    admin a=new admin();
    connection c=new connection();
    public void updateadmin(admin a) throws SQLException{
        c.connect();
        String qry="UPDATE addadmin SET adminname=?, adminpassword=?, adminconfirm=? WHERE adminid=?";
        PreparedStatement ps=c.preparedquery(qry);
        ps.setString(1,a.admin_name);
        ps.setString(2,a.admin_pass);
        ps.setString(3,a.confirm_pass);
        ps.setInt(4,a.admin_id);
        ps.executeUpdate();
        
    }
    
    
    
    
    
    public void insert(admin a) throws SQLException{
        c.connect();
        String qry="INSERT  INTO addadmin (adminname,adminpassword,adminconfirm)  VALUES (?,?,?)";
        PreparedStatement ps=c.preparedquery(qry);
        ps.setString(1,a.admin_name);
        ps.setString(2,a.admin_pass);
        ps.setString(3,a.confirm_pass);
        ps.executeUpdate();
        
    }
    
    
    public void delete(admin a) throws SQLException{
        c.connect();
        String qry="DELETE  FROM addadmin  WHERE adminid=?";
        PreparedStatement ps=c.preparedquery(qry);
        ps.setInt(1,a.admin_id);
        ps.executeUpdate();
        
    }
    
    
}