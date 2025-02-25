package Test.DaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

import Test.models.Type;
import Test.repository.TypeRepo;
import Test.util.DatabaseHandler;

public class TypeDaoImpl implements TypeRepo {
    private static JdbcRowSet rowset = DatabaseHandler.getHandler();

    public List<Type> getAllTypes() {
        List<Type> types = new ArrayList<Type>();
        try {
            rowset.setCommand("select * from type");
            rowset.execute();
            rowset.beforeFirst();
            while (rowset.next()) {
                Type type = new Type();
                type.setTypeName(rowset.getString("type_name"));
                types.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }

    public Boolean addType(Type type) {
        try {
            rowset.moveToInsertRow();
            rowset.updateString("type_name", type.getTypeName());
            rowset.insertRow();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
