package com.demoqa.test;

import com.codeborne.selenide.Configuration;
import com.demoqa.data.TestData;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DemoqaFormTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData = new TestData();

    public DemoqaFormTest() {
    }

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterAll
    static void tearDown() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void formTest() {
        registrationFormPage
                .openPage()
                .fillsElements(testData);
        registrationFormPage.checkFillsForm(testData);
    }
}
