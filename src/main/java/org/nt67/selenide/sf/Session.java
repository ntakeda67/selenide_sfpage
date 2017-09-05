package org.nt67.selenide.sf;

import org.nt67.selenide.sf.page.Page;

public interface Session {
    Page getCurrentPage();
    void move(Page p);
}
