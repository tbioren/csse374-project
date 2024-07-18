public class CloseConnection implements State {
    public void handleConnection() {
        try {
            DbConnectionService.close();
            System.exit(0);
        } catch (Exception e) {}
    }
}