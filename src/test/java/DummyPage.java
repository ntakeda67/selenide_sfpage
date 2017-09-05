import org.nt67.selenide.sf.page.Page;

public class DummyPage implements Page {
    @Override
    public boolean needsLogin() {
        return false;
    }

    @Override
    public String getBaseURL() {
        return "dummyURL";
    }

    @Override public void go(){
        // dummy page go is NOOPS
    }
}
