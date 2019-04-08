package adminview;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author root
 */
public class student {
    public int std_id;
    public String std_name;
    public String  std_roll;
    //default constrcutor 
    public student(){
        std_id=0;
        std_name="";
        std_roll="";
        
    }
   
    
}

class studentdao{
    
    
    public studentdao(){
        
    }
    
    
    
    
    
    
    
    
    public void insert(student a) throws SQLException{
        connection c=new connection();
   
    studentdao b=new studentdao();
    c.connect();
    String qry="insert into student (sname,sroll) values (?,?)";
  PreparedStatement ps=c.preparedquery(qry);
  ps.setString(1,a.std_name);
  ps.setString(2, a.std_roll);
  ps.executeUpdate();
  c.closeconnection();
    }
    
    
    
    public void update(student a) throws SQLException{
         connection c=new connection();
   
    studentdao b=new studentdao();
    c.connect();
    String qry="update student set sname=?, sroll=? where sid=?";
  PreparedStatement ps=c.preparedquery(qry);
  ps.setString(1,a.std_name);
  ps.setString(2, a.std_roll);
  ps.setInt(3, a.std_id);
  ps.executeUpdate();
  c.closeconnection();
    }
    
    
    
    public void delete(student a) throws SQLException{
         connection c=new connection();
   
    studentdao b=new studentdao();
    c.connect();
    String qry="delete from student where sid=?";
  PreparedStatement ps=c.preparedquery(qry);
    ps.setInt(1, a.std_id);
    ps.executeUpdate();
    c.closeconnection();
    }
    
    
    
    
}