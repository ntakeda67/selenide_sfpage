package org.nt67.selenide.sf.scenario;

import org.nt67.selenide.sf.page.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PageTransition extends ArrayList<Operation> {
    private Page page;

    public PageTransition(Page p) {
        this.page = p;
    }

    public List<OperationResult> run() {
        this.page.go();
        return super.stream().map(Operation::run).collect(Collectors.toList());
    }
}
