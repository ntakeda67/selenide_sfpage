package org.nt67.selenide.sf.page;

import static com.codeborne.selenide.Selenide.*;
public interface Page {
    boolean needsLogin();
    String getBaseURL();
    default void go() { open(getBaseURL()); }
}
