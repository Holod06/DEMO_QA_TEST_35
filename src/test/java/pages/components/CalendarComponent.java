package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
    public void setDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText(month)).click(); // Используем переданный параметр month
        $(".react-datepicker__year-select").$(byText(year)).click(); // Используем переданный параметр year
        $(".react-datepicker__month").$(byText(day)).click(); // Используем переданный параметр day
    }
}
