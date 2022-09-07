package com.demoqa.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TestData {
    Faker faker = new Faker();
    public String firstNameFaker = faker.address().firstName();
    public String lastNameFaker = faker.address().lastName();
    public String emailFaker = faker.internet().emailAddress();
    public String mobileFaker = faker.phoneNumber().subscriberNumber(10);
    public String currentAddressFaker = faker.address().fullAddress();
    public String firstName = firstNameFaker;
    public String lastName = lastNameFaker;
    public String email = emailFaker;
    public String gender = "Male";
    public String mobile = mobileFaker;
    public String dateOfBirth = "01.09.1988";
    public String subjects = "Maths";
    public String picture = "test.txt";
    public String currentAddress = currentAddressFaker;
    public String state = "NCR";
    public String city = "Noida";
    public String[] hobbies = {"Sports", "Reading", "Music"};
    public String strHobbies = String.join(", ", hobbies);
    LocalDate date = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("MM.dd.yyyy"));
    public String updateDateOfBirth = date.format(DateTimeFormatter.ofPattern("dd MMMM,yyyy", new Locale("en")));

    public TestData() {
    }
}
