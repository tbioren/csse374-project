//import required classes and packages
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//create NewPage class to create a new page on which user will navigate
class EmployeesPage extends JPanel
{
    //constructor
    EmployeesPage()
    {
        JButton showEmployeesButton = new JButton("Show Employees");
        add(showEmployeesButton);
        showEmployeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String airlineQuery = "SELECT AirlineID FROM Employee WHERE ID = " + ScreenController.getInstance().getUser().id;
                    Statement airlineSmt = DbConnectionService.getConnection().createStatement();
                    ResultSet airlineRs = airlineSmt.executeQuery(airlineQuery);
                    airlineRs.next();
                    String airlineID = airlineRs.getString("AirlineID");
                    String employees = "";
                    String query = "SELECT FirstName FROM Employee WHERE AirlineID = '" + airlineID + "'";
                    System.out.println(query);
                    Statement smt = DbConnectionService.getConnection().createStatement();
                    ResultSet rs = smt.executeQuery(query);
                    while(rs.next()) {
                        employees += rs.getString("FirstName") + ", ";
                    }
                    System.out.println(employees);
                    JLabel employeesList = new JLabel(employees);
                    add(employeesList);
                    revalidate();
                    repaint();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}