package databaseDAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseDAO {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    String username = "root";
    String userpassword = "none";
    String jbclocation = "jdbc:mysql//localhost:3306/kioskdb";
    Logger loggit;


    public void DBConnection() throws SQLException {
        try{
            conn = DriverManager
                    .getConnection(jbclocation, username,userpassword);
        } catch (SQLException sqe){
            Object logger = null;
            loggit.log(Level.CONFIG,"Error Connecting to Database!");
        }
    }

    public void DBCloseConnection()throws SQLException{
        try{
            if(conn!= null && !conn.isClosed()){
                conn.close();
            }
        }catch(Exception e){
            throw e;
        }
    }

    public String summary(String guestName) throws SQLException {
        DBConnection();
    Statement stmt =  conn.createStatement();
    String q1 ="select  stay_summary from reservations\n" +
            "where guest_name = qrResultsTA ";

     String query = " update reservations, hotelrooms" +
                    " set isQrActivated=true " +
                    " where reservation_id= guest_name";
     ResultSet rs= stmt.executeQuery(query);
     return  rs.toString();

    }
    
}
