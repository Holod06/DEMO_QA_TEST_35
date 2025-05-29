package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    private SelenideElement table = $(".table-responsive");

    public ResultTableComponent checkResult(String key, String value) {
        table.$(byText(key)).parent()
                .shouldHave(Condition.text(value));
        return this;
    }

    public ResultTableComponent checkUnsubmitedForm() {
        $("#app").shouldNotHave(Condition.text("Thanks for submitting the form"));
        return this;
    }
}