import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import h2.H2Factory;

public class Main {

    public static void main(String[] args) {

        try {

            //Create in-memory database and open connection
            Connection h2DBConnection = H2Factory.createH2Database("My_DB", "", "");

            //Initialize Statement
            Statement h2BDStatement = h2DBConnection.createStatement();

            //Create a table
            h2BDStatement.executeUpdate("CREATE TABLE IF NOT EXISTS CUSTOMERS (ID INT NOT NULL, NAME VARCHAR (20) NOT NULL)");

            //Insert some records
            h2BDStatement.executeUpdate("insert into CUSTOMERS values(1,'MOHIT')");
            h2BDStatement.executeUpdate("insert into CUSTOMERS values(1,'MOHIT')");
            h2BDStatement.executeUpdate("insert into CUSTOMERS values(1,'MOHIT')");

            //Get recordset
            ResultSet h2DBResultset = h2BDStatement.executeQuery("Select count(*) as COUNT from CUSTOMERS");

            //Print count
            while (h2DBResultset.next()) {
                System.out.println(h2DBResultset.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
