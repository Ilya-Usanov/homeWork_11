package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import com.demoqa.data.TestData;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultModalComponent;
import com.demoqa.pages.components.StateAndCityComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final ResultModalComponent resultTableComponent = new ResultModalComponent();
    private final StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();
    private final static String TITLE_TEXT_REGISTRATION_FORM = "Student Registration Form";

    // declaring locators
    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement email = $("#userEmail");
    private final SelenideElement gender = $("#genterWrapper");
    private final SelenideElement mobile = $("#userNumber");
    private final SelenideElement subjects = $("#subjectsInput");
    private final SelenideElement hobbies = $("#hobbiesWrapper");
    private final SelenideElement picture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement submit = $("#submit");
    private final SelenideElement getStudentName = $(".modal-body").find(new ByText("Student Name")).parent().lastChild();
    private final SelenideElement getEmail = $(".modal-body").find(new ByText("Student Email")).parent().lastChild();
    private final SelenideElement getGender = $(".modal-body").find(new ByText("Gender")).parent().lastChild();
    private final SelenideElement getMobile = $(".modal-body").find(new ByText("Mobile")).parent().lastChild();
    private final SelenideElement getDateOfBirth = $(".modal-body").find(new ByText("Date of Birth")).parent().lastChild();
    private final SelenideElement getSubjects = $(".modal-body").find(new ByText("Subjects")).parent().lastChild();
    private final SelenideElement getHobbies = $(".modal-body").find(new ByText("Hobbies")).parent().lastChild();
    private final SelenideElement getPicture = $(".modal-body").find(new ByText("Picture")).parent().lastChild();
    private final SelenideElement getCurrentAddress = $(".modal-body").find(new ByText("Address")).parent().lastChild();
    private final SelenideElement getStateAndCity = $(".modal-body").find(new ByText("State and City")).parent().lastChild();

    // open and checking title text
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT_REGISTRATION_FORM));
        return this;
    }

    public void fillsFirstName(TestData testData) {
        firstName.setValue(testData.firstName);
    }

    public void fillsLastName(TestData testData) {
        lastName.setValue(testData.lastName);
    }

    public void fillsEmail(TestData testData) {
        email.setValue(testData.email);
    }

    public void fillsGender(TestData testData) {
        gender.find(new ByText(testData.gender)).click();
    }

    public void fillsMobile(TestData testData) {
        mobile.setValue(testData.mobile);
    }

    public void fillsDateOfBirth(TestData testData) {
        calendarComponent.setDate(String.valueOf(testData.updateDateOfBirth));
    }

    public void fillsSubjects(TestData testData) {
        subjects.setValue(testData.subjects).pressEnter();
    }

    public void fillsHobbies(TestData testData) {
        for (String h : testData.hobbies) {
            hobbies.find(new ByText(h)).click();
        }
    }

    public void fillsPicture(TestData testData) {
        picture.uploadFile(new File("src/test/resources/" + testData.picture));
    }

    public void fillsCurrentAddress(TestData testData) {
        currentAddress.setValue(testData.currentAddress);
    }

    public void fillsStateAndCity(TestData testData) {
        stateAndCityComponent.setStateAndCity(testData.state, testData.city);
    }

    // checking the header
    public void checkResultsTableVisible() {
        resultTableComponent.checkVisible();
    }

    // fills form registration
    public void fillsElements(TestData testData) {
        fillsFirstName(testData);
        fillsLastName(testData);
        fillsEmail(testData);
        fillsGender(testData);
        fillsMobile(testData);
        fillsDateOfBirth(testData);
        fillsSubjects(testData);
        fillsHobbies(testData);
        fillsPicture(testData);
        fillsCurrentAddress(testData);
        fillsStateAndCity(testData);
        submit.click();
    }

    // checking that the fields are filled in
    public void checkFillsForm(TestData testData) {
        getStudentName.shouldHave(text(testData.firstName + " " + testData.lastName));
        getEmail.shouldHave(text(testData.email));
        getGender.shouldHave(text(testData.gender));
        getMobile.shouldHave(text(testData.mobile));
        getDateOfBirth.shouldHave(text(testData.updateDateOfBirth));
        getSubjects.shouldHave(text(testData.subjects));
        getHobbies.shouldHave(text(testData.strHobbies));
        getPicture.shouldHave(text(testData.picture));
        getCurrentAddress.shouldHave(text(testData.currentAddress));
        getStateAndCity.shouldHave(text(testData.state + " " + testData.city));
        checkResultsTableVisible();
    }
}
