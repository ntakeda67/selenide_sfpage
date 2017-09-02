package org.nt67.selenide.sf.page.dom;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TextBox implements Dom {

    private String selector;

    public TextBox(String selector) { this.selector = selector; }

    @Override
    public SelenideElement get() {
        return $(selector);
    }

    public void setText(String text) {
        get().setValue(text);
    }
}
