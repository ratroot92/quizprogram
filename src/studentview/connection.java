package studentview;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import adminview.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author asd
 */
public final class connection {
static final String Driver="com.mysql.jdbc.Driver";
static final String url="jdbc:mysql://localhost/projrct1";
static final String dbuser="root";
static final String db_pass="";
Connection conn;
//default constructor 

public connection(){
    connect();
}


public void connect(){
    try{
    Class.forName(Driver);
    conn=DriverManager.getConnection(url,dbuser,db_pass);
    }
    catch(ClassNotFoundException | SQLException  ex ){
       System.out.println(ex);
    }
}





public int Insert(String qry){
    try{
        Statement st=conn.createStatement();
       int rows_affected =st.executeUpdate(qry);
       return rows_affected;
    }
    catch(SQLException ex){
        JOptionPane.showMessageDialog(null, ex);
    return -1;
    }
}



public ResultSet select(String qry ){
    try{
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        return rs;
    }
    catch(SQLException ex){
        JOptionPane.showMessageDialog(null, ex);
        return null;
    }
}

public int delete(String qry){
    
    try{
        Statement st=conn.createStatement();
    
    return st.executeUpdate(qry);
    }
    catch(SQLException ex){
        JOptionPane.showMessageDialog(null, ex);
        return -1;
    }
}


public int update(String qry){
    try{
        Statement st=conn.createStatement();
        return st.executeUpdate(qry);
    }
    catch(SQLException ex){
        JOptionPane.showMessageDialog(null, ex);
        return -1;
    }
}

public void closeconnection(){
    try{
        conn.close();
    }
    catch(SQLException ex){
        JOptionPane.showMessageDialog(null, ex);
    }
}

public PreparedStatement preparedquery(String qry){
    try{
       PreparedStatement ps=conn.prepareStatement(qry);
       return ps;
    }
    catch(SQLException ex){
        JOptionPane.showMessageDialog(null, ex);
       return null;
    }
}

}
