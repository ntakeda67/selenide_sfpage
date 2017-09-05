import org.nt67.selenide.sf.scenario.Operation;
import org.nt67.selenide.sf.scenario.OperationResult;

public class DummyOperation implements Operation {

    public String operationID;

    public DummyOperation(String operationID) {
        this.operationID = operationID;
    }

    @Override
    public OperationResult run() {
        return new DummyOperationResult(this.operationID);
    }
}
