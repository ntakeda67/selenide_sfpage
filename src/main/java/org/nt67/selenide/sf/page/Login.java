package org.nt67.selenide.sf.page;

import static com.codeborne.selenide.Selenide.*;

import org.nt67.selenide.sf.page.dom.Button;
import org.nt67.selenide.sf.page.dom.TextBox;
import org.nt67.selenide.sf.user.SFUser;

public class Login implements Page {
    private SFUser user;

    public Login(SFUser user) {
        this.user = user;
    }

    public TextBox userName = new TextBox("input#username");
    public TextBox password = new TextBox("input#password");
    public Button login = new Button("input#Login");

    @Override
    public boolean needsLogin() { return false; }

    @Override
    public String getBaseURL() {
        return user.env.getBaseURL();
    }

    public boolean doLogin() {
        go();
        userName.setText(user.userName);
        password.setText(user.password);
        login.click();
        return false;
    }
}
