package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.ElementShould;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleJunitTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName("Test")
                .setLastName("Testov")
                .setEmail("holod06@yandex.ru")
                .setGender("Other")
                .setUserNumber("7958332203")
                .setDateOfBirth("6", "January", "1999")
                .setSubject("Arts")
                .setHobbies("Sports")
                .uploadPhoto()
                .setAdress("Moscow")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .submitForm();

        registrationPage.checkResult("Student Name", "Test Testov")
                .checkResult("Student Email", "holod06@yandex.ru")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "7958332203")
                .checkResult("Date of Birth", "06 January,1999")
                .checkResult("Subjects", "Arts")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "retouch.jpg")
                .checkResult("Address", "Moscow")
                .checkResult("State and City", "Uttar Pradesh Agra");
    }


    @Test
    void minimalDataTest() {
        registrationPage.openPage()
                .setFirstName("Yan")
                .setLastName("Eagr")
                .setGender("Male")
                .setUserNumber("7958332203")
                .submitForm();

        registrationPage.checkResult("Student Name", "Yan Eagr")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7958332203");

    }


    @Test
    void negativeTest() {
        registrationPage.openPage()
                .setFirstName("Draco")
                .setLastName("Malfoy")
                .submitForm();

        registrationPage.checkUnsubmitedForm();
    }
}