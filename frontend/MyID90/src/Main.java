import com.formdev.flatlaf.FlatLightLaf;

import java.awt.*;

public class Main {

	public static void main(String[] args) {
		FlatLightLaf.setup();
		StateManager.setState(new OpenConnection());
		StateManager.executeCommand();
		System.out.println(DbConnectionService.getConnection());
		ScreenController.getInstance().switchScreen("Login Screen");
		ScreenController.getInstance().showColor("Register Screen", Color.PINK);
		StateManager.setState(new CloseConnection());
	}
}
