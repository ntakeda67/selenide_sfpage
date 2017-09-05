package org.nt67.selenide.sf.page;

public class SetupHome implements Page {
    @Override
    public boolean needsLogin() {
        return true;
    }

    @Override
    public String getBaseURL() {
        return "#/setup/home?setupApp=all";
    }
}
