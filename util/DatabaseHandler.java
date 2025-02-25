package Test.util;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class DatabaseHandler {
    private static DatabaseHandler handler;
    private static JdbcRowSet rowset;

    public static JdbcRowSet getHandler() {
        if (handler == null) {
            handler = new DatabaseHandler();
        }
        return rowset;
    }

    private DatabaseHandler() {
        try {
            Class.forName("org.postgresql.Driver");
            rowset = RowSetProvider.newFactory().createJdbcRowSet();
            rowset.setUrl("jdbc:postgresql://localhost:5432/cardb");
            rowset.setUsername("postgres");
            rowset.setPassword("tiger");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
