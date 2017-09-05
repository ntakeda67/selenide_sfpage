import org.nt67.selenide.sf.scenario.OperationResult;

public class DummyOperationResult implements OperationResult {

    private String message;

    public DummyOperationResult(String message) {
        this.message = message;
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public String message() {
        return this.message;
    }
}
