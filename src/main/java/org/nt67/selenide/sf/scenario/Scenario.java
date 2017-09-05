package org.nt67.selenide.sf.scenario;

import org.nt67.selenide.sf.user.SFUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scenario extends ArrayList<PageTransition> {

    private SFUser user;

    public Scenario(SFUser user) {
        this.user = user;
    }

    public List<OperationResult> run() {
        return super.stream().map(PageTransition::run).flatMap(List::stream).collect(Collectors.toList());
    }
}
