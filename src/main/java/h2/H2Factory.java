
package h2;

import java.sql.*;

public class H2Factory {

    /**
     * Creates local H2 database
     *
     * @param path     local path where database will be created
     * @param dbname   local database name
     * @param username database username
     * @param password database password
     * @return connection object
     */
    public static Connection createH2Database(String path, String dbname, String username, String password) {

        Connection h2conn;

        try {
            Class.forName("org.h2.Driver").newInstance();
            h2conn = DriverManager.getConnection("jdbc:h2:" + path + "/" + dbname, username, password);

        } catch (Exception e) {

            e.printStackTrace();
            h2conn = null;

        }

        return h2conn;
    }

    /**
     * Creates in memory database
     *
     * @param dbname   in memory database
     * @param username database username
     * @param password database password
     * @return connection object
     */
    public static Connection createH2Database(String dbname, String username, String password) {

        Connection h2conn;

        try {
            Class.forName("org.h2.Driver").newInstance();
            //conn = DriverManager.getConnection("jdbc:h2:mem:"+DBName);
            h2conn = DriverManager.getConnection("jdbc:h2:mem:" + dbname, username, password);

        } catch (Exception e) {

            e.printStackTrace();
            h2conn = null;

        }

        return h2conn;

    }

}
