import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
Facade:
This is a facade for the ManageDependentsScreen class.

Proxy: I turned this into a proxy by only having it grab new data when it needs to.
 */

public class ManageDependentsHelper {
    private DependentsIterator di = null;
    private int lastID = -1;
    private boolean valid = false;

    public void unRemove(int userID, String dep) {
        valid = false;
        try {
            final String sproc = "EXEC UnRemoveDependent @UserID = ?, @Dep = ?";
            CallableStatement smt = DbConnectionService.getConnection().prepareCall(sproc);
            smt.setInt(1, userID);
            smt.setString(2, dep);
            smt.execute();
        }
        catch(SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Un-Deletion Unsuccessful");
        }
    }

    /*
    I'm using my iterator here. It's really hacky but this is the best place I could find to kind of shove one in.
    I'm returning an iterator object that I created; the ManageDependentsScreen will iterate through it.
     */
    public DependentsIterator getDependents(int employeeID) {
        if(valid && di != null && lastID == employeeID) {
            return di;
        }
        try {
            final String sproc = "EXEC GetDependents @EmployeeID = ?";
            CallableStatement smt = DbConnectionService.getConnection().prepareCall(sproc);
            smt.setInt(1, employeeID);
            ResultSet rs = smt.executeQuery();
            ArrayList<String> output = new ArrayList<String>();
            while (rs.next()) {
                String name = rs.getString(1);
                output.add(name);
            }
            di = new DependentsIterator(output);
            lastID = employeeID;
            valid = true;
            return di;
        } catch(Exception e) {}
        return new DependentsIterator(new ArrayList<>());
    }

    public void deleteDependent(String dependent) {
        valid = false;
        try {
            final String sproc = "EXEC RemoveDependent @Username = ?";
            CallableStatement smt = DbConnectionService.getConnection().prepareCall(sproc);
            smt.setString(1, dependent);
            smt.executeQuery();
        } catch(Exception e) {}
    }
}