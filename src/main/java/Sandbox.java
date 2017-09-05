import com.codeborne.selenide.WebDriverRunner;
import org.nt67.selenide.sf.AppLog;
import org.nt67.selenide.sf.conf.UserConfiguration;
import org.nt67.selenide.sf.page.Login;
import org.nt67.selenide.sf.page.SetupHome;
import org.nt67.selenide.sf.user.SFUser;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.util.Properties;

public class Sandbox {

    private static final String SELENIDE_PROPS_FILE = "selenide.properties";

    public static void main(String[] args) {
        loadProperty();
        WebDriverRunner.setWebDriver(new FirefoxDriver(new FirefoxOptions().addArguments("-connect-existing").addPreference("-marionette-port", 57501)));
        SFUser user = new UserConfiguration("./user/admin.yml").get();
        new SetupHome().go();
        new Login(user).doLogin();

    }

    private static void loadProperty(){
        try {
            Properties ps = new Properties();
            // TODO
            ps.load(Sandbox.class.getClassLoader().getResourceAsStream(SELENIDE_PROPS_FILE));
            System.setProperty("webdriver.gecko.driver", ps.getProperty("webdriver.gecko.driver"));
        } catch (IOException e) {
            AppLog.out.error("Property file could not load. file: {}", SELENIDE_PROPS_FILE ,e);
        }
    }
}
