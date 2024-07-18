/*
This is my state manager. It's the heart of my state pattern.
 */

public class StateManager {
    private static State currentState;

    public static void setState(State newState) {
        currentState = newState;
    }

    public static void executeCommand() {
        currentState.handleConnection();
    }
}
