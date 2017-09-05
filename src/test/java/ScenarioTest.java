import org.junit.Test;
import org.nt67.selenide.sf.SFEnv;
import org.nt67.selenide.sf.scenario.PageTransition;
import org.nt67.selenide.sf.scenario.OperationResult;
import org.nt67.selenide.sf.scenario.Scenario;
import org.nt67.selenide.sf.user.SFUser;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ScenarioTest {

    @Test
    public void pageTransition_has_many_operation() {
        PageTransition m = new PageTransition(new DummyPage());
        m.add(new DummyOperation("Dummy"));
        m.add(new DummyOperation("Dummy"));
        m.run().stream().map(r -> r.message()).forEach(t -> assertThat(t, is("Dummy")));
    }

    @Test
    public void scenario_has_many_transition() {
        PageTransition p1 = new PageTransition(new DummyPage());
        p1.add(new DummyOperation("P1-O1"));
        p1.add(new DummyOperation("P1-O2"));

        PageTransition p2 = new PageTransition(new DummyPage());
        p2.add(new DummyOperation("P2-O1"));
        p2.add(new DummyOperation("P2-O2"));

        List<String> expectedList = Arrays.asList("P1-O1", "P1-O2", "P2-O1", "P2-O2");

        Scenario s = new Scenario(new SFUser("dummy", "dummy", SFEnv.DEV));
        s.add(p1);
        s.add(p2);

        List<OperationResult> actualList = s.run();
        for(int i=0 ; i < actualList.size(); i++) {
            assertThat(expectedList.get(i), is(actualList.get(i).message()));
        }
    }
}
