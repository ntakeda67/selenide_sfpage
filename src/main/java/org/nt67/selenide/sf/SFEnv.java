package org.nt67.selenide.sf;

public enum SFEnv {
     PRD("https://login.salesforce.com")
    ,DEV("https://login.salesforce.com")
    ,SAND("https://test.salesforce.com")
    ;//,CUSTOM;

    private String baseURL;
    SFEnv(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getBaseURL() { return baseURL; }
}
