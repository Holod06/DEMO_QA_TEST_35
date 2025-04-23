package src.test.java;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Sleeper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.SPACE;

public class SimpleJunitTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.pageLoadStrategy ="eager";
    }

    @AfterEach
    void closeWebDriver(){
        Selenide.closeWebDriver();
    }

    @Test
    void fillFormTest() {
        open("automation-practice-form");
        $("#firstName").setValue("Илья");
        $("#lastName").setValue("Холодилов");
        $("#userEmail").setValue("holod06@yandex.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9958332203");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("January")).click();
        $(".react-datepicker__year-select").$(byText("1999")).click();
        $(".react-datepicker__month").$(byText("6")).click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("retouch.jpg");
        $("#currentAddress").setValue("Moscow, м. Потапово").pressEnter();
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Agra").pressEnter();
        $("#submit").click();


        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Илья Холодилов"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("holod06@yandex.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9958332203"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("06 January,1999"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Arts"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("retouch.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Moscow, м. Потапово"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Agra"));
    }
}