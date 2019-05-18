

import java.sql.*;

public class H2 {


    public static void main(String[] args) {

        try {

            //Create in-memory database and open connection
            Connection h2DBConnection = getDBConnection("Test_DB");

            //Initialize Statement
            Statement h2BDStatement = h2DBConnection.createStatement();

            //Create a table
            h2BDStatement.executeUpdate("CREATE TABLE CUSTOMERS (ID INT NOT NULL, NAME VARCHAR (20) NOT NULL)");

            //Insert some records
            h2BDStatement.executeUpdate("insert into CUSTOMERS values(1,'MOHIT')");
            h2BDStatement.executeUpdate("insert into CUSTOMERS values(1,'MOHIT')");
            h2BDStatement.executeUpdate("insert into CUSTOMERS values(1,'MOHIT')");

            //Get recordset
            ResultSet h2DBResultset=h2BDStatement.executeQuery("Select count(*) as COUNT from CUSTOMERS");

            //Print values
            while(h2DBResultset.next()){
                System.out.println(h2DBResultset.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //Make a connection to the H2 Database
    private static Connection getDBConnection(String DBName) {

        Connection conn;

        try {
            Class.forName("org.h2.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:h2:mem:"+DBName);

        } catch (Exception e) {

            e.printStackTrace();
            conn = null;

        }

        return conn;
    }

}
