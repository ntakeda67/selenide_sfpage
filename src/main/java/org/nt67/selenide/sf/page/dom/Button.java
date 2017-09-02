package org.nt67.selenide.sf.page.dom;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Button implements Dom {

    private String selector;

    public Button(String selector) { this.selector = selector; }

    @Override
    public SelenideElement get() {
        return $(selector);
    }

    public void click() { get().click(); }
}
