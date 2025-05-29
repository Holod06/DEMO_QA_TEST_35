package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            selectHobbies = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAdressInput = $("#currentAddress"),
            stateDropdown = $("#state"),
            cityDropdown = $("#city"),
            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTable = new ResultTableComponent();

    public RegistrationPage openPage() {
        open("automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genterWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }


    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        selectHobbies.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPhoto() {
        uploadPicture.uploadFromClasspath("retouch.jpg");
        return this;
    }

    public RegistrationPage setAdress(String value) {
        currentAdressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String state) {
        $("#state").click();
        $(byText(state)).click();

        return this;
    }

    public RegistrationPage setCity(String city) {
        $("#city").click();
        $(byText(city)).click();

        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    public ResultTableComponent checkResult(String key, String value){
        return resultTable.checkResult(key, value);
    }

    public void checkUnsubmitedForm() {
        resultTable.checkUnsubmitedForm();
    }
}