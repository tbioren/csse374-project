import javax.swing.*;

/*
This is my concrete implementation of the ComponentBuilder template. It builds a ScreenController, a complicated task.
 */
public class ScreenControllerBuilder extends ComponentBuilder {
    
    @Override
    public void createComponent() {}

    @Override
    public void addSubcomponents() {
        JPanel loginScreen = new LoginScreen();
        ScreenController.mainPanel.add(loginScreen, "Login Screen");
        ScreenController.panelMap.put("Login Screen", loginScreen);

        JPanel registerScreen = new RegisterScreen();
        ScreenController.mainPanel.add(registerScreen, "Register Screen");
        ScreenController.panelMap.put("Register Screen", registerScreen);

        JPanel welcomeScreen = new WelcomeScreen();
        ScreenController.mainPanel.add(welcomeScreen, "Welcome Screen");
        WelcomeScreen welScreen = (WelcomeScreen) welcomeScreen;
        ScreenController.panelMap.put("Welcome Screen", welcomeScreen);

        JPanel manageRequestScreen = new ManageRequestScreen();
        ScreenController.mainPanel.add(manageRequestScreen, "Manage Request Screen");
        ScreenController.panelMap.put("Manage Request Screen", manageRequestScreen);

        JPanel submitRequestScreen = new SubmitRequestScreen( );
        ScreenController.mainPanel.add(submitRequestScreen, "Submit Request Screen");
        ScreenController.panelMap.put("Submit Request Screen", submitRequestScreen);

        JPanel fulfillRequest = new FulfillRequest();
        ScreenController.mainPanel.add(fulfillRequest, "Fulfill Request");
        FulfillRequest fulfillScreen = (FulfillRequest) fulfillRequest;
        ScreenController.panelMap.put("Fulfill Request", fulfillScreen);

        JPanel manageDependentsScreen = new ManageDependentsScreen();
        ScreenController.mainPanel.add(manageDependentsScreen, "Manage Dependents Screen");
        ScreenController.panelMap.put("Manage Dependents Screen", manageDependentsScreen);

        JPanel fulfillRequestInput = new FulfillRequestInput();
        ScreenController.mainPanel.add(fulfillRequestInput, "Fulfill Request Input");
        FulfillRequestInput fulfillInputScreen = (FulfillRequestInput) fulfillRequestInput;
        ScreenController.panelMap.put("Fulfill Request Input", fulfillInputScreen);

        JPanel createFlightScreen = new CreateFlightsPage();
        ScreenController.mainPanel.add(createFlightScreen, "Create Flight Screen");
        CreateFlightsPage createFlightsPage = (CreateFlightsPage) createFlightScreen;
        ScreenController.panelMap.put("Create Flight Screen", createFlightScreen);

        JPanel deleteFlightScreen = new DeleteFlight();
        ScreenController.mainPanel.add(deleteFlightScreen, "Delete Flight Screen");
        ScreenController.panelMap.put("Delete Flight Screen", deleteFlightScreen);

        JPanel updateFlightSelect = new UpdateFlightSelect();
        ScreenController.mainPanel.add(updateFlightSelect, "Update Flight Select");
        ScreenController.panelMap.put("Update Flight Select", updateFlightSelect);

        JPanel updateFlightInput = new UpdateFlightInput();
        ScreenController.mainPanel.add(updateFlightInput, "Update Flight Input");
        UpdateFlightInput updateFlightInputPage = (UpdateFlightInput) updateFlightInput;
        ScreenController.panelMap.put("Update Flight Input", updateFlightInput);

        JPanel createDestinationScreen = new CreateDestinationPage();
        ScreenController.mainPanel.add(createDestinationScreen, "Create Destination Screen");
        CreateDestinationPage createDestinationPage = (CreateDestinationPage) createDestinationScreen;
        ScreenController.panelMap.put("Create Destination Screen", createDestinationScreen);

        JPanel deleteDestinationScreen = new DeleteDestinationPage();
        ScreenController.mainPanel.add(deleteDestinationScreen, "Delete Destination Screen");
        ScreenController.panelMap.put("Delete Destination Screen", deleteDestinationScreen);

        JPanel viewFlightScreen = new ViewFlightPage();
        ScreenController.mainPanel.add(viewFlightScreen, "View Flight Screen");
        ScreenController.panelMap.put("View Flight Screen", viewFlightScreen);

        JPanel parsingScreen = new ParsingScreen();
        ScreenController.mainPanel.add(parsingScreen, "Parsing Screen");
        ScreenController.panelMap.put("Parsing Screen", parsingScreen);

        JPanel planScreen = new PlanPage();
        ScreenController.mainPanel.add(planScreen, "Plan Screen");
        ScreenController.panelMap.put("Plan Screen", planScreen);

        JPanel addPlanScreen = new AddPlanPage();
        ScreenController.mainPanel.add(addPlanScreen, "Add Plan Screen");
        ScreenController.panelMap.put("Add Plan Screen", addPlanScreen);

        JPanel addFlightToPlanScreen = new AddFlightToPlanPage();
        ScreenController.mainPanel.add(addFlightToPlanScreen, "Add Flight To Plan Screen");
        AddFlightToPlanPage addFlightToPlanPage = (AddFlightToPlanPage) addFlightToPlanScreen;
        ScreenController.panelMap.put("Add Flight To Plan Screen", addFlightToPlanScreen);
    }

    @Override
    public void display() {
        frame.add(ScreenController.mainPanel);
        frame.setVisible(true);
    }
}
