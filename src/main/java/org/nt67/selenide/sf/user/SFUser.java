package org.nt67.selenide.sf.user;

import org.nt67.selenide.sf.SFEnv;

public class SFUser {
    public final String userName;
    public final String password;
    public final SFEnv env;

    public SFUser(String userName, String password, SFEnv env) {
        this.userName = userName;
        this.password = password;
        this.env = env;
    }

    @Override
    public String toString() {
        return String.format("username: %1$s, env: %2$s", this.userName, this.env);
    }
}
