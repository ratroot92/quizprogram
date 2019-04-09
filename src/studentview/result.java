/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentview;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import adminview.connection;

/**
 *
 * @author asd
 */
public class result {

    int studentid;
    String studentname;
    int totalquestions;
    int correctanswers;
    int totalpionts;
    double marks;
    String date;

    //default constructor 
    public result() {
        studentname = "";
        marks = 0.0;
        studentid = 0;
        totalpionts = 0;
        totalquestions = 0;
        correctanswers = 0;
        date = "";
    }

}

class resultdao {

    connection c = new connection();

    public void insert(result r) throws SQLException {
        c.connect();
        PreparedStatement ps = c.preparedquery("INSERT INTO result (date,studentid,studentname,totalquestions,correctanswers,totalpionts,marks) VALUES (?,?,?,?,?,?,?)");
        ps.setString(1, r.date);
        ps.setInt(2, r.studentid);
        ps.setString(3, r.studentname);
        ps.setInt(4, r.totalquestions);
        ps.setInt(5, r.correctanswers);
        ps.setInt(6, r.totalpionts);
        ps.setDouble(7, r.marks);
        ps.executeUpdate();

    }
}
