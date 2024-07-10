import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageDependentsScreen extends JPanel {
    private JScrollPane scrollPane;
    private final GridBagConstraints gbc;
    private JList<String> dependentList;
    private final ManageDependentsHelper manager;

    // Panel components
    JPanel mainPanel;

    public ManageDependentsScreen() {
        mainPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        manager = new ManageDependentsHelper();

        // Header
        JLabel header = new JLabel("<html><h1>Manage Your Dependents</h1></html>");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        mainPanel.add(header, gbc);

        // Current dependents label
        JLabel currentDependentsLabel = new JLabel("<html><h2>Current Dependents</h2></html>");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(currentDependentsLabel, gbc);

        // Your add code label
        JLabel yourCodeLabel = new JLabel("<html><h2>Your Add Code</h2></html>");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(yourCodeLabel, gbc);

        JLabel yourCode = new JLabel("<html><h3>" + getCode() + "</h2></html>");
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        mainPanel.add(yourCode, gbc);

        createScrollPane();

        // Delete Selected User
        JButton deleteButton = new JButton("Remove Selected Dependent");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        mainPanel.add(deleteButton, gbc);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = dependentList.getSelectedIndex();
                if(index == -1) return;
                mainPanel.remove(scrollPane);
                deleteDependent(dependentList.getSelectedValue());
                createScrollPane();
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        JLabel unDeleteDependent = new JLabel("<html><h3>Un-remove a dependent</h3></html>");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        mainPanel.add(unDeleteDependent, gbc);

        JTextField codeField = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        mainPanel.add(codeField, gbc);

        JButton unDeleteButton = new JButton("Un-remove Selected Dependent");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        mainPanel.add(unDeleteButton, gbc);

        unDeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                manager.unRemove(ScreenController.getInstance().getUser().id, codeField.getText());
                mainPanel.remove(scrollPane);
                createScrollPane();
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        JButton homeButton = new JButton("Home");
        gbc.gridx = 2;
        gbc.gridy = 3;
        mainPanel.add(homeButton, gbc);

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ScreenController.getInstance().switchScreen("Welcome Screen");
            }
        });
        add(mainPanel);
    }

    private String getCode() {
        try {
            return Integer.toString(ScreenController.getInstance().getUser().id);
        } catch(Exception e) {
            return "Error. Contact Developers.";
        }

    }

    private void createScrollPane() {
        // Dependents List
        ArrayList<String> dependentAL = new ArrayList<String>();
        DependentsIterator di = getDependents();
        while(di.hasNext()) {
            dependentAL.add(di.next());
        }
        dependentList = new JList<String>(dependentAL.toArray(new String[dependentAL.size()]));
        scrollPane = new JScrollPane(dependentList);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        mainPanel.add(scrollPane, gbc);
    }
    
    private DependentsIterator getDependents() {
        return manager.getDependents(ScreenController.getInstance().getUser().id);
    }

    private void deleteDependent(String dependent) {
       manager.deleteDependent(dependent);
    }
}
