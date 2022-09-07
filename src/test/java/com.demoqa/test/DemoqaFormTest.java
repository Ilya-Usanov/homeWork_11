package com.demoqa.test;

import com.codeborne.selenide.Configuration;
import com.demoqa.data.TestData;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class DemoqaFormTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData = new TestData();

    public DemoqaFormTest() {
    }

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @Test
    void formTest() {
        step("Opening the registration form and filling in the fields", () -> registrationFormPage
                .openPage()
                .fillsElements(testData));
        step("Checking the registration form", () -> registrationFormPage.checkFillsForm(testData));
    }
}
