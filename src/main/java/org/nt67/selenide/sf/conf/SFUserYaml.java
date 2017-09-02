package org.nt67.selenide.sf.conf;

import org.nt67.selenide.sf.SFEnv;
import org.nt67.selenide.sf.user.SFUser;

public class SFUserYaml {
    public String userName;
    public String password;
    public SFEnv env;
    public SFUser to(){
        return new SFUser(userName, password, env);
    }
}
