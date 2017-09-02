package org.nt67.selenide.sf.page;

import static com.codeborne.selenide.Selenide.*;
import org.nt67.selenide.sf.user.SFUser;

public class Login implements Page {
    private SFUser user;

    public Login(SFUser user) {
        this.user = user;
    }

    @Override
    public boolean needsLogin() { return false; }

    @Override
    public String getBaseURL() {
        return user.env.getBaseURL();
    }

    public boolean doLogin() {
        go();
        // TODO page objects composition
        $("input#username").setValue(user.userName);
        $("input#password").setValue(user.password);
        $("input#Login").click();
        return false;
    }
}
