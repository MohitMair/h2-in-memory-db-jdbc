package h2;

import org.junit.*;

import java.sql.*;

public class H2FactoryTest {

    @Test
     public void testLocalDBCreation() {

        Connection h2DBConnection = H2Factory.createH2Database("~/", "My_DB1", "", "" );
        Assert.assertTrue(h2DBConnection!=null);
        try {
            h2DBConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
     public void testLocalMemoryCreation() {

        Connection h2DBConnection = H2Factory.createH2Database("My_DB1", "", "" );
        Assert.assertTrue(h2DBConnection!=null);
        try {
            h2DBConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}