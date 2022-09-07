package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultModalComponent {

    private final static String TITLE_TEXT_DONE_FORM = "Thanks for submitting the form";

    public void checkVisible() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT_DONE_FORM));
    }
}
