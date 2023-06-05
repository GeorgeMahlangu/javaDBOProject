package POE3;

// STEP 1:  Import the required JDBC package
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
public class DatabaseUtility {
    private static Connection conn = null;

    public static void dbConnect() throws SQLException, ClassNotFoundException {
        //2.2 Declare and Register JDBC driver
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }

        System.out.println("JDBC Driver Registered!");

        //2.3 Enter database credentials and establish connection
        try {

            //NB! Check the path to where your Database is stored.

            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Program Files\\SQLiteStudio\\ABCorporationDB");
        } catch (SQLException e) {
            System.out.println("Connection Failed! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    //2.4 Close database  Connection
    public static void dbDisconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e){
            throw e;
        }
    }

    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        try {
            //b) Connect to DB
            dbConnect();
            System.out.println("Select statement: " + queryStmt + "\n"); // helpful: print select statement in console

            //c)Create statement
            stmt = conn.createStatement();

            RowSetFactory rowSetFactory = RowSetProvider.newFactory();

            CachedRowSet crs = rowSetFactory.createCachedRowSet();

            stmt = conn.createStatement();
            try (ResultSet resultSet = stmt.executeQuery(queryStmt)) {
                crs.populate(resultSet);
            }
            return crs;
        } catch   (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Problem occurred at executeQuery operation : " + e);
            }
        }
    }

    //3.2 DB Execute Update (For Update/Insert/Delete) Operation
    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        //Declare statement as null
        Statement stmt = null;
        try {
            //Connect to DB
            dbConnect();
            //Create Statement
            stmt = conn.createStatement();
            //Run executeUpdate operation with given sql statement
            stmt.executeUpdate(sqlStmt);
            System.out.println("Update statement: " + sqlStmt + "\n"); // helpful: print select statement in console
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e;
        } finally {
            if (stmt != null) {
                //Close statement
                stmt.close();
            }
            //Close connection
            dbDisconnect();
        }
    }

}
