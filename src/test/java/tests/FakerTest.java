package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.DataFaker;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    DataFaker faker = new DataFaker();

    String firstName = faker.getRandomFirstName();
    String lastName = faker.getRandomLastName();
    String email = faker.getRandomEmail();
    String gender = faker.getRandomGender();
    String phoneNubmer = faker.getRandomPhoneNumber();
    String day = faker.getRandomBirthDay();
    String month = faker.getRandomBirthMonth();
    String year = faker.getRandomBirthYear();
    String subject = faker.getRandomSubject();
    String hobbies = faker.getRandomHobbies();
    String photo = faker.getRandomPhoto();
    String address = faker.getRandomAddress();
    String states = faker.getRandomState();
    String city = faker.getRandomCity(states);



    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNubmer)
                .setDateOfBirth(day, month, year)
                .setSubject(subject)
                .setHobbies(hobbies)
                .uploadPhoto(photo)
                .setAdress(address)
                .setState(states)
                .setCity(city)
                .submitForm();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNubmer)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", photo)
                .checkResult("Address", address)
                .checkResult("State and City", states + " " + city);
    }


    @Test
    void minimalDataTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNubmer)
                .submitForm();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNubmer);

    }


    @Test
    void negativeTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .submitForm();

        registrationPage.checkUnsubmitedForm();
    }
}