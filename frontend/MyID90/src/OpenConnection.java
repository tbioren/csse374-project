public class OpenConnection implements State {
    public void handleConnection() {
        DbConnectionService.connect();
    }
}
