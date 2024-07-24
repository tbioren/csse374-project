//import required classes and packages
import javax.swing.*;

//create NewPage class to create a new page on which user will navigate
class AirlinePage extends JPanel
{
    //constructor
    AirlinePage()
    {
        JButton employeesPage = new JButton("View Employees");
        this.add(employeesPage);
        employeesPage.addActionListener(e -> {
            ScreenController.getInstance().switchScreen("Employees Page");
        });
    }
}